USE PE_DBI202_Sp2022

-- question 8: 

create proc Proc1 
@productID int,
@toDate date,
@fromDate date,
@totalOrderedQuantity int output
as begin
select @totalOrderedQuantity = sum(OrderedQuantity) from PurchaseOrderLines a
join PurchaseOrders b
 on a.PurchaseOrderID = b.PurchaseOrderID
where OrderDate >= @toDate and 
OrderDate <= @fromDate and ProductID = @productID
end

