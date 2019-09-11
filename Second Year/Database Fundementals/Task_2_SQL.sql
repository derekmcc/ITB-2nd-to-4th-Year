CREATE TABLE Mentoring_Session (
 Session_ID VARCHAR (10) NOT NULL,
 Session_Title VARCHAR (45) NOT NULL,
 Session_Theme VARCHAR (45) NOT NULL,
 PRIMARY KEY (Session_ID)
);

CREATE TABLE Activities (
 Activity_ID VARCHAR (10) NOT NULL,
 Activity VARCHAR (45) NOT NULL,
 Activity_Description VARCHAR (90) NOT NULL,
 Activity_Resource VARCHAR (45) NOT NULL,
 Session_ID VARCHAR (10) NOT NULL,
 PRIMARY KEY (Activity_ID),
 CONSTRAINT Activities_Session_ID_FK FOREIGN KEY (Session_ID) REFERENCES Mentoring_Session(Session_ID)
);

CREATE TABLE Academic_Contact (
 AC_Staff_ID VARCHAR (6) NOT NULL,
 AC_First_Name VARCHAR (45) NOT NULL,
 AC_Last_Name VARCHAR (45) NOT NULL,
 AC_Email VARCHAR (45) NOT NULL,
 AC_Phone_Number TEXT(10) NOT NULL,
 Session_ID VARCHAR (10) NOT NULL,
 PRIMARY KEY (AC_Staff_ID),
 CONSTRAINT Academic_Contact_Session_ID_FK FOREIGN KEY (Session_ID) REFERENCES Mentoring_Session(Session_ID)
);

CREATE TABLE Course (
 Course_Code VARCHAR (5) NOT NULL,
 Course_Title VARCHAR (45) NOT NULL,
 Course_Description VARCHAR (45) NOT NULL,
 Course_Department VARCHAR (45) NOT NULL,
 Course_HETAC_Level INT (2) NOT NULL,
 AC_Staff_ID VARCHAR (6) NOT NULL,
 PRIMARY KEY (Course_Code),
 CONSTRAINT Course_AC_Staff_ID_FK FOREIGN KEY (AC_Staff_ID) REFERENCES Academic_Contact(AC_Staff_ID)
);

CREATE TABLE Mentor (
  Mentor_ID varchar (9) NOT NULL,
  Mentor_First_Name VARCHAR (45) NOT NULL,
  Mentor_Last_Name VARCHAR (45) NOT NULL,
  Mentor_Email VARCHAR (45) NOT NULL,
  Mentor_Year_of_Course INT (2) NOT NULL,
  Mentor_Mobile_Number TEXT (10) NOT NULL,
  Garda_Vetted VARCHAR (3) NOT NULL,
  Course_Code VARCHAR (5) NOT NULL,
  PRIMARY KEY (Mentor_ID),
  CONSTRAINT Mentor_Course_Code_FK FOREIGN KEY (Course_Code) REFERENCES Course(Course_Code)
); 

CREATE TABLE Mentee (
  Mentee_ID VARCHAR (9) NOT NULL,
  Mentee_First_Name VARCHAR (45) NOT NULL,
  Mentee_Last_Name VARCHAR (45) NOT NULL,
  Mentee_Email VARCHAR (45) NOT NULL,
  Mentee_Year_of_Course INT (2) NOT NULL,
  Mentee_Mobile_Number TEXT (10) NOT NULL,
  Course_Code VARCHAR (5) NOT NULL,
  Mentor_ID VARCHAR (9) NOT NULL, 
  PRIMARY KEY (Mentee_ID),
  CONSTRAINT Mentee_Course_Code_FK FOREIGN KEY (Course_Code) REFERENCES Course(Course_Code),
  CONSTRAINT Mentee_Mentor_ID_FK FOREIGN KEY (Mentor_ID) REFERENCES Mentor(Mentor_ID)
);

CREATE TABLE Mentor_Mentoring_Session (
  Mentor_ID varchar (9) NOT NULL,
  Session_ID VARCHAR (10) NOT NULL,
  Mentor_Attendance VARCHAR (3),
  Feedback_Main_Topics VARCHAR (250),
  Feedback_Questions_Raised VARCHAR (250),
  Issues_Remaining VARCHAR (250),
  PRIMARY KEY (Mentor_ID, Session_ID),
  CONSTRAINT Mentor_Mentoring_Session_Mentor_ID_FK FOREIGN KEY (Mentor_ID) REFERENCES Mentor(Mentor_ID),
  CONSTRAINT Mentor_Mentoring_Session_Session_ID_FK FOREIGN KEY (Session_ID) REFERENCES Mentoring_Session(Session_ID)
);

CREATE TABLE Mentee_Attendance (
  Mentee_Attendance_ID VARCHAR (10) NOT NULL,
  Number_In_Attendance INT (5),
  Percentage_Attendance decimal (3,2),
  Number_In_Course INT (5),
  PRIMARY KEY (Mentee_Attendance_ID)
);

CREATE TABLE Mentee_Mentoring_Session (
  Mentee_ID VARCHAR (9) NOT NULL,
  Session_ID VARCHAR (10) NOT NULL,
  Mentee_Attendance VARCHAR (3),
  Mentee_Attendance_ID VARCHAR (10) NOT NULL,
  PRIMARY KEY (Mentee_ID, Session_ID),
  CONSTRAINT Mentee_Mentoring_Session_Mentee_ID_FK FOREIGN KEY (Mentee_ID) REFERENCES Mentee(Mentee_ID),
  CONSTRAINT Mentee_Mentoring_Session_Session_ID_FK FOREIGN KEY (Session_ID) REFERENCES Mentoring_Session(Session_ID),
  CONSTRAINT Mentee_Mentoring_Session_Mentee_Attendance_ID_FK FOREIGN KEY (Mentee_Attendance_ID) REFERENCES Mentee_Attendance(Mentee_Attendance_ID)
);

CREATE TABLE Mentoring_Session_Details (
  MSD_ID VARCHAR (10) NOT NULL,
  Session_ID VARCHAR (10) NOT NULL,
  Session_Date date NOT NULL,
  Course_Code VARCHAR (5) NOT NULL,
  PRIMARY KEY (MSD_ID),
  CONSTRAINT Mentoring_Session_Detail_Session_ID_FK FOREIGN KEY (Session_ID) REFERENCES Mentoring_Session(Session_ID),
  CONSTRAINT Mentoring_Session_Detail_Code_FK FOREIGN KEY (Course_Code) REFERENCES Course(Course_Code)
);

/*******************************************************************
					DML
********************************************************************/
INSERT INTO Mentoring_Session(Session_ID,Session_Title,Session_Theme) VALUES
('S01', 'Support Our Students', 'Student Support Services'),
('S02', 'Become a lean, mean CA machine', 'Time Management');

INSERT INTO Activities(Activity_ID,Activity,Activity_Description, Activity_Resource, Session_ID) VALUES
('A01','Use Face Masks','Use Face masks to in introduce support personnel','Missing', 'S01'),
('A02','Different Scenarios','Outline different scenarios for support services and students determine the service to use','Complete', 'S01'),
('A03','Jigsaw','Jigsaw of the campus and student point out the location of the different services','Complete', 'S01');

INSERT INTO Academic_Contact(AC_Staff_ID,AC_First_Name,AC_Last_Name, AC_Email, AC_Phone_Number, Session_ID) VALUES
('B00001','Joe','Bloggs','bloggs@gmail.com','0876969504','S01'),
('B00002','James','Bond','jb007@gmail.com','0874343542','S01'),
('B00003','Donald','Trump','donald@gmail.com','0864242422','S02');

INSERT INTO Course(Course_Code,Course_Title,Course_Description, Course_Department, Course_HETAC_Level, AC_Staff_ID) VALUES
('BN002','Bachelor of Science (Honours) in Computing','Computer Science','IT',6,'B00001'),
('BN105','Honours in Health Science','Health Science','Science',6,'B00001'),
('BN001','Honours in Business','Business','Finance',5,'B00002');

INSERT INTO Mentor(Mentor_ID, Mentor_First_Name, Mentor_Last_Name, Mentor_Email, Mentor_Year_of_Course, Mentor_Mobile_Number, Garda_Vetted, Course_Code) VALUES
('B00002248','Bart','Simpson','bart@gmail.com', 2,'0861278678','Yes','BN002'),
('B00002250','Jane','Austen','jane-a@gmail.com', 2,'0861247562','Yes','BN002'),
('B00002289','Mary','Magdalene','mary-a@gmail.com', 2,'0851535441','No','BN105');

INSERT INTO Mentee(Mentee_ID, Mentee_First_Name, Mentee_Last_Name, Mentee_Email, Mentee_Year_of_Course, Mentee_Mobile_Number, Course_Code, Mentor_ID) VALUES
('B00000001','John','Doe','john@gmail.com', 1,'0861241851','BN001', 'B00002248'),
('B00000002','Jane','Doe','jane@gmail.com', 1,'0861247572','BN001', 'B00002250'),
('B00000003','Mary','Jones','mary@gmail.com', 1,'0851543141','BN105', 'B00002289');

INSERT INTO Mentor_Mentoring_Session(Mentor_ID, Session_ID, Mentor_Attendance, Feedback_Main_Topics, Feedback_Questions_Raised, Issues_Remaining) VALUES
('B00002248','S01','Yes','N/A','N/A','No'),
('B00002250','S01','No','N/A','N/A','No'),
('B00002289','S01','Yes','N/A','N/A','No');

INSERT INTO Mentee_Attendance(Mentee_Attendance_ID, Number_In_Attendance, Percentage_Attendance, Number_In_Course) VALUES
('M01',45,5.00,90);

INSERT INTO Mentee_Mentoring_Session(Mentee_ID, Session_ID, Mentee_Attendance, Mentee_Attendance_ID) VALUES
('B00000001','S01','Yes','M01'),
('B00000002','S01','No','M01'),
('B00000003','S01','Yes','M01');

INSERT INTO Mentoring_Session_Details(MSD_ID, Session_ID, Session_Date, Course_Code) VALUES
('MS01','S01',24/11/2016,'BN002'),
('MS02','S01',24/11/2016,'BN001'),
('MS03','S02',26/11/2016,'BN001'),
('MS04','S02',26/11/2016,'BN105');

