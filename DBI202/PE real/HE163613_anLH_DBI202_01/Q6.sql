USE PE_DBI202_Sp2022

-- question 6: Write a query to display SupplierID, SupplierName, NumberOfProducts of the suppliers
-- who provides the highest number of distinct products (NumberOfProducts) as follows

select s.SupplierID, s.SupplierName,
count(p.ProductID) [NumberOfProduct]
from
Products p join Suppliers s 
on p.SupplierID = s.SupplierID
group by s.SupplierID, s.SupplierName
having count(p.ProductID) >= 
all (select 
count(p.ProductID) 
from Products p join Suppliers s 
on p.SupplierID = s.SupplierID
group by s.SupplierID, s.SupplierName) 
