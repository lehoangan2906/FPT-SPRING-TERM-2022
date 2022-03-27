-- 1.Write a query to display total value of each order from 1/12/1996 to 31/12/1996 as follows / 
-- Note: Total value = sum of all (UnitPrice * Quantity).

select o.OrderID, YEAR(o.OrderDate) as Year,
MONTH(o.OrderDate) as Month,
DAY(o.OrderDate) as Day,
c.CompanyName,
sum(o1.UnitPrice * o1.Quantity) as TotalValue
from Orders o, [Order Details] o1, Customers c
where o.OrderDate between '1996/12/1' and '1996/12/31'
and o1.OrderID = o.OrderID and o.CustomerID = c.CustomerID
group by o.OrderID, YEAR(o.OrderDate) ,MONTH(o.OrderDate), DAY(o.OrderDate), c.CompanyName

-- 2. An order will be taxed 10% if its freight cost is larger than or equal to $100.Otherwise, an order
-- will be taxed 5% if its freight cost is smaller than $100. Write a query to show the freight with taxes of
-- orders placed between 1/1/1997 and 31/1/1997 as follows, by ascending order of order ID as follows /

select *,
case 
when chec.Freight<100 then '5%'
else '10%'
end as TAX
from
(select o.OrderID, o.OrderDate, e.FirstName, e.LastName, 
o.Freight from Orders o, Employees e
where e.EmployeeID = o.EmployeeID
and o.OrderDate between '1997/1/1' and '1997/1/31') as chec
order by chec.OrderID ASC

-- 3.Write a query to display number of product of each category as follows 

select  c.CategoryID, c.CategoryName, count(*) as TotalProducts from Categories c, Products p
where c.CategoryID = p.CategoryID
group by c.CategoryID, c.CategoryName

-- 4. Write a query to display the list of expensive products from 5th to 10th as follows. 

--c1:
select p.ProductID, p.ProductName, p.UnitPrice 
from Products p
order by p.UnitPrice DESC
offset 4 rows
fetch next 6 rows only

-- c2:
select * from 
(select top(10) p.ProductID, p.ProductName, p.UnitPrice 
from Products p order by p.UnitPrice DESC) as a
EXCEPT
select * from (
select top(4) p1.ProductID, p1.ProductName, p1.UnitPrice from Products p1
order by p1.UnitPrice DESC) as b

-- 5.Write a query to display the categories which has minimum total orders.

select * from 
(select p.CategoryID, c.CategoryName, count(p.CategoryID) as TotalValues
from [Order Details] o1, Products p, Categories c
where p.ProductID = o1.ProductID
and c.CategoryID = p.CategoryID
group by p.CategoryID, c.CategoryName) as b
where b.TotalValues = (select min(c.TotalValues) from 
(select p.CategoryID, c.CategoryName, count(*) as TotalValues
from [Order Details] o1, Products p, Categories c
where p.ProductID = o1.ProductID
and c.CategoryID = p.CategoryID
group by p.CategoryID, c.CategoryName) as c)

-- 6.Write a query to display the customer and their number of orders, 
-- sorted by the number of orders as follows 

select c.CustomerID, c.ContactName, count(o.CustomerID) as NoOrders from Orders o
right join Customers c
on o.CustomerID = c.CustomerID
group by c.CustomerID, c.ContactName
order by NoOrders ASC

-- 7. Write a query to display the 5 most recently recruited new employees as follows

select top(5) e.EmployeeID,e.LastName, e.FirstName, e.HireDate  from Employees e
order by e.EmployeeID DESC

-- 8. Write a query to display 5 most expensive products and 5 cheapest products as follows 

select * from (
select distinct * from 
(select top(5) p.ProductID, p.ProductName, p.UnitPrice from Products p
order by p.UnitPrice ASC) as a
union
select * from
(select top(5) p1.ProductID, p1.ProductName, p1.UnitPrice from Products p1
order by p1.UnitPrice DESC) as b) as c
order by c.UnitPrice ASC

-- 9. Write a query to display all customers that placed orders in December 1996, 
-- by their contact title descending order. 

select distinct (o.CustomerID), c.CompanyName, c.CompanyName, c.ContactTitle from Customers c
inner join Orders o
on c.CustomerID = o.CustomerID
where o.OrderDate between '1996-12-1' and '1996-12-31'
order by c.ContactTitle DESC

-- 10. Write a query to display customers and sum of total values of their orders as below. 

select o.CustomerID, c.ContactName, sum((p.UnitPrice*o1.Quantity)) as TotalValues 
from Customers c, Orders o, [Order Details] o1, Products p
where o.CustomerID = c.CustomerID
and o1.OrderID = o.OrderID
and p.ProductID = o1.ProductID
group by o.CustomerID, c.ContactName
order by TotalValues DESC



