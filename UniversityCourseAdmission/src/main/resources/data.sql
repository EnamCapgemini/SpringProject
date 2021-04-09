insert into course values(100,"B.com","3 years",LocalDate.now(),LocalDate.now().plus(3, ChronoUnit.YEARS),"300000");
insert into course values(200,"B.Sc Math","3 years",LocalDate.now(),LocalDate.now().plus(3, ChronoUnit.YEARS),"350000");
insert into course values(210,"B.Sc Physics","3 years",LocalDate.now(),LocalDate.now().plus(3, ChronoUnit.YEARS),"350000");
insert into course values(220,"B.Sc Chemistry","3 years",LocalDate.now(),LocalDate.now().plus(3, ChronoUnit.YEARS),"350000");
insert into course values(310,"B.Tech ME","4 years",LocalDate.now(),LocalDate.now().plus(4, ChronoUnit.YEARS),"700000");
insert into course values(330,"B.Tech CSE","4 years",LocalDate.now(),LocalDate.now().plus(4, ChronoUnit.YEARS),"700000");
insert into course values(320,"B.Tech ECE","4 years",LocalDate.now(),LocalDate.now().plus(4, ChronoUnit.YEARS),"700000");
insert into course values(400,"B.A.","3 years",LocalDate.now(),LocalDate.now().plus(3, ChronoUnit.YEARS),"200000");
insert into course values(500,"B.Ed","2 years",LocalDate.now(),LocalDate.now().plus(2, ChronoUnit.YEARS),"175000");

insert into AdmissionCommiteeMember values(100, "Nagraj", "123@gmail.com");
insert into AdmissionCommiteeMember values(400, "Dhruv", "765@gmail.com");
insert into AdmissionCommiteeMember values(200, "Doga", "001@hotmail.com");
insert into AdmissionCommiteeMember values(600, "Parmanu", "888@yandex.com");
insert into AdmissionCommiteeMember values(300, "Gangadhar", "1580@gmail.com");


insert into UniversityStaffs values(10023,"Abc54tc_98","Coordinator");
insert into UniversityStaffs values(10024,"a_ctBG6709","Head");
insert into UniversityStaffs values(10025,"Admission_21","Admission Committee");
insert into UniversityStaffs values(10026,"committeeM_2M","Admission Committee");
insert into UniversityStaffs values(10027,"Faculty_56","Admission Committee");
insert into UniversityStaffs values(10026,"committee35_g","Admission Committee");
insert into UniversityStaffs values(10026,"com56_rteu78","Admission Committee");

insert into StaffCredentials values(101,"pass@123");
insert into StaffCredentials values(105,"pass@456");

insert into Applicant values(100,"pritam","das","903384727","b.tech",76,(10,310,100,LocalDate.now(),AdmissionStatus.PENDING),310,Gender.MALE,"nabapally durgapur west bengal-721322","jkk@gmail.com");
insert into Applicant values(200,"priyam","dan","90378527","b.tech",66,(20,320,200,LocalDate.now(),AdmissionStatus.PENDING),320,Gender.FEMALE,"nabapally durgapur maharashtra-214322","tyrui@gmail.com");

insert into Admission values(10,310,100,LocalDate.now(),AdmissionStatus.PENDING);
insert into Admission values(20,320,200,LocalDate.now(),AdmissionStatus.PENDING);