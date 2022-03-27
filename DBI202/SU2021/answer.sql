-- question 2
select * from products p
where p.category_name = 'Cyclocross Bicycles'
-- question 3
select p.product_name, p.model_year, p.list_price, p.brand_name from products p
where p.brand_name = 'Trek' and p.model_year = '2018'
and p.list_price >3000 
order by p.list_price 
-- question 4
select o.order_id, o.order_date, o.customer_id, c.first_name, c.last_name, s.store_name
from orders o, customers c, stores s
where o.customer_id = c.customer_id and s.store_id = o.store_id
and o.order_date between '2016/1/1' and '2016/1/31'
and s.store_name = 'Santa Cruz Bikes'
-- question 5
select o.store_id, s.store_name, count(o.store_id) as NumberOfOrderIn2018 
from orders o, stores s
where s.store_id = o.store_id
and YEAR(o.order_date) = 2018
group by o.store_id, s.store_name
order by NumberOfOrderIn2018 DESC
-- question 6
select s.product_id, p.product_name, p.model_year, sum(s.quantity) as TotalStockQuantity from stocks s, products p
where p.product_id = s.product_id
group by s.product_id, p.product_name, p.model_year
having sum(s.quantity) = (select top 1 sum(s.quantity) as TotalStockQuantity from stocks s, products p
where p.product_id = s.product_id
group by s.product_id, p.product_name, p.model_year
order by TotalStockQuantity DESC)
-- question 7
select * from (
select s.store_name, o.staff_id, st.first_name, st.last_name, count(s.store_name) as NumberOfOrders  from orders o, stores s, staffs st
where st.staff_id = o.staff_id and o.store_id = s.store_id
group by s.store_name, o.staff_id, st.first_name, st.last_name
having count(s.store_name) in
(select max(a.NumberOfOrders) from
(select s.store_name, count(*) as NumberOfOrders  from orders o, stores s
where o.store_id = s.store_id
group by s.store_name, o.staff_id) as a
group by a.store_name)) as c
order by c.store_name ASC
-- question 8
drop proc pr1
create proc pr1 @store_id int, @numberOfStaffs int output 
as
begin
	set @numberOfStaffs = (select count(s.store_id) from staffs s where s.store_id = @store_id group by s.store_id)
end

declare @x int
exec pr1 3, @x output
select @x as NumberOfStaffs
-- question 9
drop trigger Tr2
create trigger Tr2 
on stocks after delete
as
begin
	select d.product_id, p.product_name, d.store_id, s.store_name, d.quantity   
	from deleted d, products p, stores s where p.product_id = d.product_id and s.store_id=d.store_id
end

delete from stocks
where store_id = 1 and product_id in (10,11,12)
--question 10
update stocks 
set quantity = 30
where store_id = 1 and product_id in 
(select p.product_id from stocks s, products p
where p.product_id = s.product_id and 
p.category_name = 'Cruisers Bicycles' and s.store_id = 1)

