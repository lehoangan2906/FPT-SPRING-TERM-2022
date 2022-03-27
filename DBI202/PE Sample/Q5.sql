-- question 5
select o.ProductID, p.ProductName, o.Quantity from Product p, OrderDetails o
where p.ID = o.ProductID
and o.Quantity = (select max(o1.Quantity) from OrderDetails o1)
