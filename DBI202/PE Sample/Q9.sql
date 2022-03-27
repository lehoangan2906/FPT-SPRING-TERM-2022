-- question 9
create trigger InsertSubCategory
on SubCategory after insert 
as
begin
	select i.SubCategoryName, c.CategoryName from inserted i, Category c
	where c.ID = i.CategoryID
end