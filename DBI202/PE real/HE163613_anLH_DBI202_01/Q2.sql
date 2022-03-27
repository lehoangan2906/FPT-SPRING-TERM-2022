USE PE_DBI202_Sp2022

-- question 2: Display SupplierID, SupplierName, SupplierCategoryID, DeliveryMethod, DeliveryCity 
-- of all supliers belonging to the category 2 as in the following figure

select SupplierID,SupplierName, SupplierCategoryID,
DeliveryMethod, DeliveryCity from Suppliers
where SupplierCategoryID = 2
