INSERT INTO USER VALUES(NULL,TRUE,'pass@123','staffMember','root');
INSERT INTO USER VALUES(NULL,TRUE,'pass@654','staffMember','boot');

INSERT INTO UNIVERSITYSTAFFS VALUES (100,'suKK90_Sark','faculty');
INSERT INTO UNIVERSITYSTAFFS VALUES (200,'supA56_ark','admission committee');
INSERT INTO UNIVERSITYSTAFFS VALUES (300,'sup9ft_tSark','head');
INSERT INTO UNIVERSITYSTAFFS VALUES (400,'sup9fs_Sark','coordinator');
INSERT INTO UNIVERSITYSTAFFS VALUES (500,'sup99@Sark','admission committee');
INSERT INTO UNIVERSITYSTAFFS VALUES (600,'string@78G','admission committee');
INSERT INTO UNIVERSITYSTAFFS VALUES (700,'Password_98','admission committee');
INSERT INTO UNIVERSITYSTAFFS VALUES (800,'Supratim_36','admission committee');


INSERT INTO ADMISSION_COMMITEE_MEMBER VALUES ('sashank.roy@gcapgemini.com',1000,'Sashank',200);
INSERT INTO ADMISSION_COMMITEE_MEMBER VALUES ('durgeshD2@gmail.com',2000,'Durgesh',500);
INSERT INTO ADMISSION_COMMITEE_MEMBER VALUES ('md.salim4capgemini.com',3000,'Md.Salim',600);
INSERT INTO ADMISSION_COMMITEE_MEMBER VALUES ('fred@yahoo.com',4000,'Freddy',700);
INSERT INTO ADMISSION_COMMITEE_MEMBER VALUES ('reddy67@gmail.com',5000,'Reddy',800);

INSERT INTO COURSE VALUES(220,'3 YEARS',DATEADD(YEAR,3,SYSDATE()),'400000','B.Sc Math',SYSDATE(),100);
INSERT INTO COURSE VALUES(210,'3 YEARS',DATEADD(YEAR,3,SYSDATE()),'400000','B.Sc Chemistry',SYSDATE(),100);
INSERT INTO COURSE VALUES(230,'3 YEARS',DATEADD(YEAR,3,SYSDATE()),'400000','B.Sc Physics',SYSDATE(),100);
INSERT INTO COURSE VALUES(330,'4 YEARS',DATEADD(YEAR,4,SYSDATE()),'800000','B.TECH ME',SYSDATE(),300);
INSERT INTO COURSE VALUES(310,'4 YEARS',DATEADD(YEAR,4,SYSDATE()),'800000','B.TECH IT',SYSDATE(),400);
INSERT INTO COURSE VALUES(320,'4 YEARS',DATEADD(YEAR,4,SYSDATE()),'800000','B.TECH CSE',SYSDATE(),400);
INSERT INTO COURSE VALUES(510,'4 YEARS',DATEADD(YEAR,4,SYSDATE()),'800000','B.TECH ECE',SYSDATE(),300);
INSERT INTO COURSE VALUES(110,'2 YEARS',DATEADD(YEAR,2,SYSDATE()),'300000','M.TECH CSE',SYSDATE(),400);



INSERT INTO ADMISSION (ADMISSION_ID,ADMISSION_DATE,APPLICANT_ID,COURSE_ID,STATUS,ADMISSION_COMMITEE_STAFF_ID) VALUES(10,DATEADD(YEAR,2,SYSDATE()),4500,220,'PENDING',200);
INSERT INTO ADMISSION (ADMISSION_ID,ADMISSION_DATE,APPLICANT_ID,COURSE_ID,STATUS,ADMISSION_COMMITEE_STAFF_ID) VALUES(20,DATEADD(YEAR,3,SYSDATE()),4501,210,'PENDING',500);
INSERT INTO ADMISSION (ADMISSION_ID,ADMISSION_DATE,APPLICANT_ID,COURSE_ID,STATUS,ADMISSION_COMMITEE_STAFF_ID) VALUES(30,DATEADD(YEAR,4,SYSDATE()),4502,110,'PENDING',700);
INSERT INTO ADMISSION (ADMISSION_ID,ADMISSION_DATE,APPLICANT_ID,COURSE_ID,STATUS,ADMISSION_COMMITEE_STAFF_ID) VALUES(40,DATEADD(YEAR,5,SYSDATE()),4503,320,'PENDING',600);
INSERT INTO ADMISSION (ADMISSION_ID,ADMISSION_DATE,APPLICANT_ID,COURSE_ID,STATUS,ADMISSION_COMMITEE_STAFF_ID) VALUES(50,DATEADD(YEAR,6,SYSDATE()),4504,510,'PENDING',800);


INSERT INTO APPLICANT(APPLICANT_ID,ADDRESS,DEGREE,APPLICANT_FIRSTNAME,GRAD_PER,APPLICANT_LASTNAME,COURSE_ID,EMAIL_ID,GENDER,PH_NO,ADMISSION_ID) VALUES(4500,'durgapur','12th pass','Sunil',88,'Sharma',220,'sunil.sharma@gmail.com','MALE','9903726272',10);
INSERT INTO APPLICANT(APPLICANT_ID,ADDRESS,DEGREE,APPLICANT_FIRSTNAME,GRAD_PER,APPLICANT_LASTNAME,COURSE_ID,EMAIL_ID,GENDER,PH_NO,ADMISSION_ID) VALUES(4501,'kharagpur','10th pass','Karishma',58,'Agarwal',210,'karishma.agarwal@rediff.com','FEMALE','9934567890',20);
INSERT INTO APPLICANT(APPLICANT_ID,ADDRESS,DEGREE,APPLICANT_FIRSTNAME,GRAD_PER,APPLICANT_LASTNAME,COURSE_ID,EMAIL_ID,GENDER,PH_NO,ADMISSION_ID) VALUES(4502,'medinipur','B.Tech CSE pass','Priyam',68,'Garg',110,'priyam.garg@gmail.com','MALE','9874132526',30);
INSERT INTO APPLICANT(APPLICANT_ID,ADDRESS,DEGREE,APPLICANT_FIRSTNAME,GRAD_PER,APPLICANT_LASTNAME,COURSE_ID,EMAIL_ID,GENDER,PH_NO,ADMISSION_ID) VALUES(4504,'howrah','12th pass','Suzan',44,'Arora',510,'suzan.arora@amazon.com','FEMALE','8930266363',50);
INSERT INTO APPLICANT(APPLICANT_ID,ADDRESS,DEGREE,APPLICANT_FIRSTNAME,GRAD_PER,APPLICANT_LASTNAME,COURSE_ID,EMAIL_ID,GENDER,PH_NO,ADMISSION_ID) VALUES(4503,'durgapur','12th pass','Ayush',90,'Banik',320,'ayush.banik@yahoo.com','MALE','7980263737',40);

