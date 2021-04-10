INSERT INTO UNIVERSITYSTAFFS VALUES (100,'suKK90_Sark','faculty');
INSERT INTO UNIVERSITYSTAFFS VALUES (200,'supA56_ark','admission committee');
INSERT INTO UNIVERSITYSTAFFS VALUES (300,'sup9ft_tSark','head');
INSERT INTO UNIVERSITYSTAFFS VALUES (400,'sup9fs_Sark','coordinator');
INSERT INTO UNIVERSITYSTAFFS VALUES (500,'sup99@Sark','admission committee');


INSERT INTO ADMISSION_COMMITEE_MEMBER VALUES ('asd@gmail.com',1000,'heheufiwfner',200);
INSERT INTO ADMISSION_COMMITEE_MEMBER VALUES ('akd@gmail.com',2000,'jrjrufiwfner',500);

INSERT INTO COURSE VALUES(100,'3 YEARS',DATEADD(YEAR,3,SYSDATE()),'300000','B.A.',SYSDATE());
INSERT INTO COURSE VALUES(200,'3 YEARS',DATEADD(YEAR,3,SYSDATE()),'400000','B.Sc Maths',SYSDATE());
INSERT INTO COURSE VALUES(210,'3 YEARS',DATEADD(YEAR,3,SYSDATE()),'400000','B.Sc Chemistry',SYSDATE());
INSERT INTO COURSE VALUES(220,'3 YEARS',DATEADD(YEAR,3,SYSDATE()),'400000','B.Sc Physics',SYSDATE());
INSERT INTO COURSE VALUES(300,'4 YEARS',DATEADD(YEAR,4,SYSDATE()),'800000','B.TECH ME',SYSDATE());
INSERT INTO COURSE VALUES(310,'4 YEARS',DATEADD(YEAR,4,SYSDATE()),'800000','B.TECH CE',SYSDATE());
INSERT INTO COURSE VALUES(320,'4 YEARS',DATEADD(YEAR,4,SYSDATE()),'800000','B.TECH CSE',SYSDATE());
INSERT INTO COURSE VALUES(500,'2 YEARS',DATEADD(YEAR,2,SYSDATE()),'200000','B.ED',SYSDATE());


INSERT INTO ADMISSION (ADMISSION_ID,ADMISSION_DATE,APPLICANT_ID,COURSE_ID,STATUS,ADMISSION_COMMITEE_STAFF_ID) VALUES(10,SYSDATE(),4500,100,'PENDING',200);
INSERT INTO ADMISSION (ADMISSION_ID,ADMISSION_DATE,APPLICANT_ID,COURSE_ID,STATUS,ADMISSION_COMMITEE_STAFF_ID) VALUES(20,SYSDATE(),4501,200,'PENDING',500);

INSERT INTO APPLICANT(APPLICANT_ID,ADDRESS,DEGREE,APPLICANT_FIRSTNAME,GRAD_PER,APPLICANT_LASTNAME,COURSE_ID,EMAIL_ID,GENDER,PH_NO,ADMISSION_ID) VALUES(4500,'durgapur','12th pass','priyam',88,'garg',320,'ss34@gmail.com','MALE','1234567890',NULL);

INSERT INTO APPLICANT(APPLICANT_ID,ADDRESS,DEGREE,APPLICANT_FIRSTNAME,GRAD_PER,APPLICANT_LASTNAME,COURSE_ID,EMAIL_ID,GENDER,PH_NO,ADMISSION_ID) VALUES(4501,'kharagpur','10th pass','pritam',80,'das',310,'pp34@gmail.com','FEMALE','9934567890',NULL);

