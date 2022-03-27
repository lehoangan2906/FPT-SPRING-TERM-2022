USE PE_DBI202_Sp2022

-- question 5: write a query to display SupplierID, SupplierName, NumberOfPurchaseOrders, TotalOrderedQuantity 
-- corresponding to each supplier where NumberOfPurchaseOrders is the number of purchase orders of the supplier,
-- and TotalOrderedQuantity is the total quantity of all products purchased in all orders of the corresponding supplier;
-- display the results by descending order of NumberOfPurchaseOrders then by ascending order of SupplierName for suppliers
-- having the same NumberOfPurchaseOrders.

SELECT s.SupplierID, s.SupplierName FROM dbo.Suppliers AS s, dbo.PurchaseOrders AS p
WHERE s.SupplierID = p.SupplierID
