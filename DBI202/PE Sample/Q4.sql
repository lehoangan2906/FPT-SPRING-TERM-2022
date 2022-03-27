-- question 4
select p.SubCategoryID, s.SubCategoryName, count(s.SubCategoryName) as NumberOfProducts
from Product p, SubCategory s
where p.SubCategoryID = s.id
group by p.SubCategoryID, s.SubCategoryName
having count(s.SubCategoryName) >100
order by NumberOfProducts DESC