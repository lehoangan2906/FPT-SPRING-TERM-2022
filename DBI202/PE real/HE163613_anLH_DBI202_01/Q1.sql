USE PE_DBI202_Sp2022
GO

-- Question 1:
create table Games (
	GameCode varchar(15) primary key,
	[Date] date, [Time] time )
	
create table Teams (
	TeamCode varchar(15) primary key,
	[Name] nvarchar(50),
	[Address] nvarchar(200),
)

create table Players (
	SSN varchar(15) primary key,
	[Name] nvarchar(100),
	[TeamCode] varchar(15) foreign key references teams(teamcode)
)

create table Participate (
	GameCode varchar(15) foreign key references games(gamecode),
	[TeamCode] varchar(15) foreign key references teams(teamcode),
	Result int,
	primary key(TeamCode, GameCode)
)