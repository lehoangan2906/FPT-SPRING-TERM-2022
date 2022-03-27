USE PE_DBI202_Sp2022

-- Question 3: Write a query to select PurchaseOrderID, SupplierID, OrderDate, DeliveryMethod, ExpectedDeliveryDate
-- of all purchase orders made from 15 may 2013 to 31 may 2013; Display the results by ascending order of SupplierID as follows
select PurchaseOrderID, SupplierID,
OrderDate, DeliveryMethod, ExpectedDeliveryDate
from PurchaseOrders
where OrderDate between '2013/05/15' and '2013/05/31'
order by SupplierID ASC