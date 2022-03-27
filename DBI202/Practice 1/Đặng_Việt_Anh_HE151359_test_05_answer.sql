-- cau 1
select p.ProductID, p.ProductName, p.SupplierID, p.CategoryID, p.QuantityPerUnit, p.UnitPrice,
p.UnitsInStock, p.UnitsOnOrder, p.ReorderLevel, p.Discontinued
from Products p
inner join
(select p.CategoryID, Max(p.UnitPrice) maxPrice from Products p
group by p.CategoryID) as b
on p.CategoryID = b.CategoryID and p.UnitPrice = b.maxPrice
order by p.ProductID
-- cau 2
select *, 
CASE
	when chec.Freight <=100 then '10%'
	else '20%'
end AS TAX
from (
select o.OrderID, o.OrderDate, e.FirstName, e.LastName, 
c.CompanyName, o.Freight
from Orders o, Employees e, Customers c
where o.EmployeeID = e.EmployeeID 
and c.CustomerID = o.CustomerID
and o.OrderDate between '1997/5/1' and '1997/5/15'
) as chec
order by chec.OrderID ASC
-- Cau 3
select * from Employees
where FirstName like 'A%'
order by EmployeeID;
-- Cau 4
select EmployeeID, LastName, FirstName, BirthDate, (2021 - YEAR(BirthDate)) as Age 
from Employees
where EmployeeID in 
(Select top(3) EmployeeID from Employees order by (2021 - YEAR(BirthDate)) 
union (Select top(3) EmployeeID from Employees order by (2021 - YEAR(BirthDate)) desc))
order by Age desc
-- Cau 5
select EmployeeID, LastName, FirstName, HireDate, City, Country
from Employees 
where HireDate > all (Select HireDate from Employees where LastName = 'Peacock' and FirstName = 'Margaret');
-- cau 6
select o.OrderID, YEAR(o.OrderDate) as Year,
Month(o.OrderDate) as Month,
Day(o.OrderDate) as Day,
c.CompanyName, Sum((od.UnitPrice * od.Quantity)) as TotalValue
from Orders o, Customers c, [Order Details] od
where o.CustomerID = c.CustomerID
and o.OrderID = od.OrderID
and o.OrderDate between '1996/12/1' and '1996/12/31'
group by o.OrderID,YEAR(o.OrderDate),Month(o.OrderDate),
Day(o.OrderDate), c.CompanyName
-- cau 7
select s.ShipperID,s.CompanyName, count(o.ShipVia) as NoOrders 
from Shippers s right join Orders o
on o.ShipVia = s.ShipperID
group by s.ShipperID,s.CompanyName
order by NoOrders DESC
-- cau 8
select p.ProductID, p.ProductName, p.SupplierID,
p.CategoryID, p.QuantityPerUnit, p.UnitPrice, p.UnitsOnOrder,
p.ReorderLevel, p.Discontinued
from Products p
inner join
(select p.SupplierID, Max(p.UnitPrice) maxPrice from Products p
group by p.SupplierID) as b
on p.SupplierID = b.SupplierID and p.UnitPrice = b.maxPrice
order by p.ProductID
-- cau 9
select c.CustomerID,c.CompanyName,c.ContactName,
c.ContactTitle from Customers c
where c.ContactName like '_O%'
-- cau 10
-- c1:
select EmployeeID,LastName,FirstName,BirthDate, 
(2021 - year(BirthDate)) as age from Employees
order by age
offset 3 rows
fetch next 5 rows only
-- c2:
select EmployeeID,LastName,FirstName,BirthDate, (2021 - year(BirthDate)) as age 
from Employees
where EmployeeID in (Select top(8) EmployeeID from Employees order by (2021 - YEAR(BirthDate)) 
except 
(Select top(3) EmployeeID from Employees order by (2021 - YEAR(BirthDate))))
