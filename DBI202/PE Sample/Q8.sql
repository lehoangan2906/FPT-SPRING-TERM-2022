-- question 8
create proc TotalAmount @OrderID nvarchar(255), @TotalAmount float output
as
begin
	declare @total float
	select @total = (o.SalePrice*o.Quantity*(1-o.Discount)) from OrderDetails o
	where o.OrderID = @OrderID
	set @TotalAmount = @total
end
