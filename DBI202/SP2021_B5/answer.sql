-- question 2
select * from Employees e
where e.Salary > 9000
-- question 3
select j.JobID, j.JobTitle, j.min_salary from Jobs j
where j.min_salary > 5000 and j.JobTitle like '%Manager%'
order by j.min_salary DESC, j.JobTitle ASC
-- question 4
select e.EmployeeID, e.FirstName, e.LastName, e.Salary, d.DepartmentName, l.StateProvince, l.CountryID
from Employees e, Departments d, Locations l
where e.DepartmentID = d.DepartmentID and d.LocationID = l.LocationID
and l.StateProvince = 'Washington' and e.Salary > 3000
-- question 5
select l.LocationID, l.StreetAddress, l.City, l.StateProvince, l.CountryID, count(d.LocationID) as NumberOfDepartments
from Departments d
right join Locations l
on d.LocationID = l.LocationID
group by l.LocationID, l.StreetAddress, l.City, l.StateProvince, l.CountryID
order by NumberOfDepartments DESC, l.LocationID ASC
-- question 6
select e.JobID,j.JobTitle ,count(e.JobID) as NumberOfEmployees from Employees e, Jobs j
where j.JobID = e.JobID
group by e.JobID,j.JobTitle
having count(e.JobID) = (select max(c.count1) from (select count(e.JobID) as count1 from Employees e, Jobs j
where j.JobID = e.JobID
group by e.JobID) as c)
-- question 7
select * from(select v.EmployeeID,v.FirstName, v.LastName, v.Salary, v.DepartmentID, v.DepartmentName, count(a.ManagerID) as NumberOfSubordinates from
(select e.EmployeeID, e.FirstName, e.LastName, e.Salary,d.DepartmentID, d.DepartmentName from Employees e, Departments d where d.DepartmentID = e.DepartmentID) as v
inner join (select e.EmployeeID, e.FirstName, e.LastName, e.Salary, e.ManagerID from Employees e) as a
on v.EmployeeID = a.ManagerID 
group by v.EmployeeID,v.FirstName, v.LastName, v.Salary, v.DepartmentID, v.DepartmentName) as f
union
select * from(select v.EmployeeID,v.FirstName, v.LastName, v.Salary, v.DepartmentID, v.DepartmentName, count(a.ManagerID) as NumberOfSubordinates from
(select e.EmployeeID, e.FirstName, e.LastName, e.Salary,d.DepartmentID, d.DepartmentName from Employees e, Departments d where d.DepartmentID = e.DepartmentID and e.Salary>10000) as v
left join (select e.EmployeeID, e.ManagerID from Employees e) as a
on v.EmployeeID = a.ManagerID 
group by v.EmployeeID,v.FirstName, v.LastName, v.Salary, v.DepartmentID, v.DepartmentName) as g
order by NumberOfSubordinates DESC
-- question 8
drop proc pr1
create proc pr1 @countryID varchar(10), @numberOfDepartments int output
as
begin
	declare @num int
	select @num = count(*) from Departments d, Locations l
	where l.CountryID=@countryID and l.LocationID = d.LocationID
	set @numberOfDepartments = @num
end

declare @x int
exec pr1 'US', @x output
select @x as NumberOfDepartments
-- question 9
drop trigger Tr1
create trigger Tr1 
on Employees after insert
as 
begin
	select i.EmployeeID, i.FirstName, i.LastName, d.DepartmentID, d.DepartmentName  
	from inserted i, Departments d where i.DepartmentID = d.DepartmentID
end

insert into Employees(EmployeeID,FirstName,LastName,Email,JobID,DepartmentID) values
(1003,'Alain','Boucher','alain.boucher@gmail.com','SH_CLERK',50),
(1004,'Muriel','Visani','muriel.visani@gmail.com','SA_REP',null)
-- question 10
delete from Departments 
where ManagerID = NULL


