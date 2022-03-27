-- 1 Write a SELECT query to display all active staffs, order by staff_id as ascending:
select s.staff_id, s.first_name, s.last_name from staff s
order by s.staff_id ASC
-- 2 Write a SELECT query to display all films which type is 
-- “Documentary” and have length greater than
-- or equals to 170, order by film_id
select f1.film_id, f1.title, f1.length, f1.rating from film_category f, film f1
where f1.film_id = f.film_id and f.category_id = 6
and f1.length >=170
-- 3 Write a query to display number of films for each category, 
-- Order by number of films as ascending
select c.name, count(*) as 'Number of films' from category c, film_category f
where c.category_id = f.category_id
group by c.name
order by [Number of films] ASC
-- 4. Write a query to display the category which have maximum number of 
-- films in it. Order by category name as ascending.
select * from 
(select c.name, count(*) as 'Number of films' from category c, film_category f
where c.category_id = f.category_id
group by c.name) as c1
where c1.[Number of films] = (select max(a.c1) from 
(select count(c.category_id) as c1  from category c, film_category f
where c.category_id = f.category_id
group by c.name) as a)

select top(1) c.name, count(*) as 'Number of films' from category c, film_category f
where c.category_id = f.category_id
group by c.name
order by [Number of films] DESC
-- 5. Write a query to display number of films for each actor whose joined 
-- more than 90 films, order by number of films as ascending.
select a.first_name, count(f.film_id) as 'Number of films' from film_actor f, actor a
where a.actor_id = f.actor_id
group by a.first_name
having count(f.film_id) >= 90
-- 6. Write a query to display information of films which 
-- have length >= the length of film “THEORY MERMAID” and have
-- same rating as rating of film “THEORY MERMAID”
select f.film_id, f.title,f.rating, f.length from film f
where f.length >= (select film.length from film
where film.title = 'THEORY MERMAID')
and f.rating = (select film.rating from film
where film.title = 'THEORY MERMAID')
and f.title != 'THEORY MERMAID'
-- 7. Write a store NumberOfFilm(@catName varchar(25), @count int output), 
-- the store is used to count number of films of given category name, 
-- the result must be set to @count
drop proc NumberOfFilm
create proc NumberOfFilm @catName varchar(25), @count int output
as
begin
	set @count = (select count(*) from film_category f, category c
	where c.category_id = f.category_id and c.name = @catName)
end

declare @count int
exec NumberOfFilm 'Documentary', @count output
select @count

-- 8. Write a trigger to make sure that whenever users insert 
-- a new film to Film table, the title of film cannot be duplicated.
drop trigger checkTitle
create trigger checkTitle
on Film instead of insert 
as
begin 
	declare @count int
	select @count = count(*) from inserted i, film f
	where i.title = f.title
	if(@count >0)
	begin
		print 'the title of film cannot be duplicated.'
		return
	end
	insert into film
	select * from inserted
end