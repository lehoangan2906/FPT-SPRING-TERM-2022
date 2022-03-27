-- question 2
select c.ID, c.CustomerName, c.Segment,c.Country,c.City,c.State,c.PostalCode,c.Region
from Customer c
where c.City='Arlington' and c.Segment='Consumer'