-- question 1
select * from titles t where t.title like 'S%' 
-- question 2
select t.title_id, t.title, t.type, t.advance from titles t
where t.advance > (select AVG(t.advance)*2 from titles t)
-- question 3
select cast(YEAR(t.pubdate) as varchar) as Year, count(t.pubdate) as noTitles from titles t
group by YEAR(t.pubdate)
union
select 'TOTALS', sum(d.noTitles) from (select count(t.pubdate) as noTitles from titles t
group by YEAR(t.pubdate)) as d
-- question 4
select s.stor_id, s.stor_name, t.title_id, t.title, t.price, s1.qty, (t.price*s1.qty) as TotalAmount
from stores s, sales s1, titles t
where s.stor_id=s1.stor_id and s1.title_id = t.title_id
order by s1.title_id
-- question 5
select e.fname+' '+e.lname as 'Full name' from employee e where e.fname like '__A%'
-- question 6
select YEAR(t.pubdate) as Year from titles t
group by YEAR(t.pubdate)
having count(t.pubdate) = (select max(a.c) from 
(select count(*) as c from titles t group by YEAR(t.pubdate)) as a)
-- question 7
select t.title_id, t.title, t.type from titles t
where t.ytd_sales > (select t.ytd_sales from titles t
where t.title = 'Silicon Valley Gastronomic Treats')
-- question 8
select (e.fname+' '+e.lname) as 'Full name' from publishers p, employee e
where p.pub_name = 'Binnet & Hardley' and e.pub_id = p.pub_id
and YEAR(e.hire_date) between 1990 and 1992 
-- question 9
select ROW_NUMBER() over(order by (dd.Quantity)) as Row,dd.title,dd.Quantity
from
(select t.title, sum(s.qty) as Quantity from titles t, sales s
where s.title_id = t.title_id
group by t.title
union
select 'TOTAL OF TITLES', sum(d.Quantity) from
(select sum(s.qty) as Quantity from titles t, sales s
where s.title_id = t.title_id
group by t.title) as d) as dd
-- question 10
select ROW_NUMBER() over(order by (select null)) as Row,dd.[Full name of author], dd.[Number of Titles]
from
(select a.au_fname+' '+a.au_lname as 'Full name of author', 
count(*) as 'Number of Titles' from authors a, titleauthor t
where t.au_id = a.au_id
group by a.au_fname+' '+a.au_lname
UNION
select 'TOTAL OF TITLES',sum(ab.[Number of Titles]) from
(select count(*) as 'Number of Titles' from authors a, titleauthor t
where t.au_id = a.au_id
group by a.au_fname+' '+a.au_lname) as ab) as dd