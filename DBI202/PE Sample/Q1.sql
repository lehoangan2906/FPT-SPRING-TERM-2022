create table Teachers(
TeacherID int primary key,
Name nvarchar(50),
Address nvarchar(200),
Gender char(1)
)

create table Classes(
ClassID int Primary Key,
GroupID char(6),
coueseID char(6),
NoCredits int,
Semester char(10),
year int,
TeacherID int
constraint fk_Classes_Teachers FOREIGN KEY(TeacherID) references Teachers(TeacherID)
)

create table Students(
StudentID int Primary Key,
Name nvarchar(50),
Address nvarchar(200),
Gender char(1),
)

create table Attend(
Date date,
Slot int,
Attend bit,
StudentID int,
ClassID int,
primary key(Date, Slot, StudentID, ClassID),
constraint fk_Attend_Students FOREIGN KEY(StudentID) references Students(StudentID),
constraint fk_Attend_Classes FOREIGN KEY(ClassID) references Classes(ClassID)
)