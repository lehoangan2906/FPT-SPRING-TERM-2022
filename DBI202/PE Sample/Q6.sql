-- question 6
select o.CustomerID, c.CustomerName, count(*) as NumberOfOrders from Customer c, Orders o
where o.CustomerID = c.ID
group by o.CustomerID, c.CustomerName
having count(c.CustomerName) = (select top(1) count(*) NumberOfOrders from Customer c, Orders o
where o.CustomerID = c.ID
group by o.CustomerID
order by NumberOfOrders DESC)