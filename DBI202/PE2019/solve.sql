-- 1 Write a query to display all customers who are 
-- ‘Consumer’ and are from Arlington city as follows:

select * from Customer c
where c.Segment = 'Consumer' and c.City = 'Arlington'

-- 3. Write a query to display all customers having CustomerName 
-- starting with B and placed orders in December 2017. 
-- Display the result by descending order of Segment and then by ascending order of CustomerName.

select c.ID, c.CustomerName, c.Segment, c.Country, c.City,
c.State, c.PostalCode, c.Region
from Customer c, Orders o
where c.CustomerName like 'B%'
and c.ID = o.CustomerID and o.OrderDate between '2017/12/1' and '2017/12/31'
order by c.Segment DESC, c.CustomerName ASC

-- 4. Write a query to display SubCategoryID, SubCategoryName and the corresponding 
-- number of products (NumberOfProducts) in each sub-category 
-- having the number of products greater than 100, by descending order of NumberOfProducts.

select p.SubCategoryID, s.SubCategoryName, count(*) as NumberOfProducts from Product p, SubCategory s
where s.ID = p.SubCategoryID
group by p.SubCategoryID, s.SubCategoryName
having count(p.SubCategoryID) >100
order by NumberOfProducts DESC

-- 5. Write a query to display ProductID, ProductName, Quantity 
-- of all products which have the highest Quantity in one order.

select o.ProductID, p.ProductName, o.Quantity from OrderDetails o, Product p
where o.ProductID = p.ID and o.Quantity = (select max(o.Quantity) from OrderDetails o)

-- Question 6: Write a query to display CustomerID, CustomerName and 
-- the number of orders (NumberOfOrders) of customers who have the highest number of orders.

select o.CustomerID, c.CustomerName, count(*) as NumberOfOrders from Orders o, Customer c
where c.ID = o.CustomerID
group by o.CustomerID, c.CustomerName
having count(o.CustomerID) = (select top(1) count(*) as s from Orders o, Customer c
where c.ID = o.CustomerID
group by o.CustomerID
order by s DESC)

-- Question 7: Display 5 products with the highest unit prices and 
-- 5 products with the smallest unit prices as follows:

select * from 
(select top(5) * from Product p
order by p.UnitPrice desc) as s
union 
select * from (
select top(5) * from Product p
order by p.UnitPrice) as s1

-- Question 8: Write a stored procedure named CountProduct to 
-- calculate the number of different products in an order with OrderID (nvarchar(255))
-- is input parameter and the NbProducts (int) is the output parameter of the procedure.

drop proc CountProduct
create proc CountProduct @OrderID nvarchar(255), @NbProducts int output
as
begin
	declare @count int
	select count(*) from OrderDetails o
	where o.OrderID = @OrderID
	group by o.OrderID
	set @NbProducts = @count
end

declare @t int
exec CountProduct 'CA-2014-100391', @t output 
print @t

-- 9. Create a trigger InsertProduct which will be activated by an 
-- insert statement into the Product table. The trigger will display 
-- the ProductName and the SubCategoryName of the products which have just been
-- inserted by the insert statement.
drop trigger InsertProduct
create trigger InsertProduct 
on Product instead of insert 
as
begin
	select i.ProductName, i.SubCategoryID from inserted i
end

insert into Product(ProductName, UnitPrice, SubCategoryID)
values ('Craft paper', 0.5, 3)





