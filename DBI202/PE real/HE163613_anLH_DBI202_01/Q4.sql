USE PE_DBI202_Sp2022

-- question 4: Write a query to display ProductID, ProductName, SupplierID, SupplierName,
-- TaxRate, UnitPrice, TypicalWeightPerUnit of all products having the TaxRate = 15, the 
-- UnitPrice less than 10 and the TypicalWeightPerUnit less than 0.5; display the results 
-- by ascending order

SELECT p.ProductID, p.ProductName, s.SupplierID, 
s.SupplierName, p.TaxRate, p.UnitPrice, p.TypicalWeightPerUnit 
FROM dbo.Products AS p, dbo.Suppliers AS s
WHERE p.UnitPrice < 10 AND p.TypicalWeightPerUnit < 0.5 
AND s.SupplierID = p.SupplierID AND p.TaxRate = 15
ORDER BY s.SupplierName ASC, p.ProductName ASC

