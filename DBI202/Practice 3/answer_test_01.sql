-- question 1
select s.stor_id, s1.stor_id from sales s
join sales s1
on s.qty = s1.qty and s.stor_id<s1.stor_id
-- question 2
select s.stor_id, s1.title_id, s1.ord_date, s1.qty from stores s, sales s1
where s1.stor_id = s.stor_id
and Year(s1.ord_date) = 1994
and s1.qty >= 20
-- question 3
select ROW_NUMBER() over(order by (select null)) as Row, g.title, g.Quantity
from 
(select * from (select b.title, b.Quantity 
from (select t.title, sum(s.qty) as Quantity from titles t, sales s
where t.title_id = s.title_id
group by t.title) as b
union all
select d.title,d.Quantity from (
(select 'TOTAL OF TITLES' as title, sum(c.Quantity) as Quantity from
(select b.Quantity from 
(select t.title, sum(s.qty) as Quantity from titles t, sales s
where t.title_id = s.title_id
group by t.title) as b) as c)) as d) as f) as g
-- question 4
select ROW_NUMBER() over(order by (select null)) as Row, ddd.[Full name of author], ddd.[Number of Titles]
from
(select f.[Full name of author], f.[Number of Titles] from 
(select (a.au_fname+a.au_lname) as 'Full name of author', count(*) as 'Number of Titles' 
from titleauthor t, authors a
where t.au_id = a.au_id
group by a.au_fname+a.au_lname) as f
union 
select dd.[Full name of author], dd.[Number of Titles] from(select 'TOTAL OF TITLES' as 'Full name of author', 
(select sum(bd.[Number of Titles]) as bc from (select f.[Number of Titles] from 
(select count(*) as 'Number of Titles' 
from titleauthor t, authors a
where t.au_id = a.au_id
group by a.au_fname+a.au_lname) as f) as bd) as 'Number of Titles') as dd) as ddd
-- question 5
select top 10 t.title_id, t.title, t.type, t.pubdate from titles t
order by t.pubdate DESC
-- question 6
select e.fname +' '+ e.lname from employee e where e.fname like '__l%'
-- question 7
select e.fname +' '+e.lname from employee e, publishers p
where e.pub_id = p.pub_id and p.pub_name='New Moon Books' and YEAR(e.hire_date) between 1990 and 1993
order by e.fname +' '+e.lname
-- question 8
select p1.pub_id, p2.pub_id from
(select e.pub_id, count(*) as num from employee e
group by e.pub_id) as p1
join (select e.pub_id, count(*) as num from employee e
group by e.pub_id) as p2
on p1.num = p2.num and p1.pub_id<p2.pub_id
-- question 9
select a.au_fname+' '+a.au_lname from authors a
where a.au_fname like '_h%'
-- question 10
select s.stor_id,s1.stor_name, t.title_id, t.title, t.price, s.qty as TotalQty, (t.price * s.qty) as TotalAmount
from sales s, titles t, stores s1
where s1.stor_id = s.stor_id and s.title_id = t.title_id
order by title_id ASC





