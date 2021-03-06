﻿CREATE TABLE MEMBER(
	ID NUMBER(10),
	NAME VARCHAR2(20) CONSTRAINT MEMEBER_NAME_NN NOT NULL,
	JOIN_DATE DATE,
	ADDRESS VARCHAR2(30),
	CITY VARCHAR2(10),
	PHONE NUMBER(11),
	CONSTRAINT MEMBER_ID_PK PRIMARY KEY(ID)
);

CREATE TABLE TITLE(
	ID NUMBER(7),
	TITLE VARCHAR2(20) CONSTRAINT TITLE_TITLE_NN NOT NULL,
	DESCRIPTION VARCHAR(600),
	PRICE NUMBER(6,2) CONSTRAINT TITLE_PRICE_NN NOT NULL,
	RATING NUMBER(2,1),
	CATEGORY VARCHAR2(10),
	RELEASE_DATE DATE,
	CONSTRAINT TITLE_ID_PK PRIMARY KEY(ID)
);

CREATE TABLE TITLECOPY(
	TITLE_ID NUMBER(7),
	ID NUMBER(5),
	STATUS VARCHAR2(15) CONSTRAINT TITLECOPY_STATUS_NN NOT NULL,
	CONSTRAINT TITLECOPY_ID_TITLE_ID_PK PRIMARY KEY(ID,TITLE_ID),
	CONSTRAINT TITLECOPY_TITLE_ID_FK FOREIGN KEY(TITLE_ID) REFERENCES TITLE(ID)
);

CREATE TABLE RESERVATION(
	MEMBER_ID NUMBER(10),
	TITLE_ID NUMBER(7),
	RES_DATE DATE,
	CONSTRAINT RESERVATION_TITLE_ID_FK FOREIGN KEY(TITLE_ID) REFERENCES TITLE(ID),
	CONSTRAINT RESERVATION_MEMBER_ID_FK FOREIGN KEY(MEMBER_ID) REFERENCES MEMBER(ID)
);

CREATE TABLE RENTAL(
	MEMBER_ID NUMBER(10),
	TITLE_ID NUMBER(7),
	TITLECOPY_ID NUMBER(5),
	BOOK_DATE DATE DEFAULT SYSDATE CONSTRAINT RENTAL_BOOK_DATE_NN NOT NULL,
	EXP_RET_DATE DATE DEFAULT SYSDATE+21,
	ACT_RES_DATE DATE,
	CONSTRAINT RENTAL_TITLECOPY_TITLE_ID_FK FOREIGN KEY(TITLECOPY_ID,TITLE_ID) REFERENCES TITLECOPY(ID,TITLE_ID),
	CONSTRAINT RENTAL_MEMBER_ID_FK FOREIGN KEY(MEMBER_ID) REFERENCES MEMBER(ID)
);



INSERT INTO MEMBER VALUES(1,'QIFEI',SYSDATE,'PINGGUOYUAN','KAIFENG',13526655610);

INSERT INTO TITLE VALUES(1,'MATRIX','A REALLY GOOD FILM',3.99,9.8,'SCI-FI',SYSDATE);
INSERT INTO TITLE VALUES(2,'PHANTOM','A KOREAN TV SERIES FILM',8.99,9.6,'SPY',SYSDATE);

INSERT INTO TITLECOPY VALUES(1,1,'AVAILABLE');

INSERT INTO RESERVATION VALUES(1,1,SYSDATE);

INSERT INTO RENTAL VALUES(1,1,1,SYSDATE,SYSDATE+21,NULL);



SELECT MEMBER.ID,NAME,TITLE,BOOK_DATE
FROM MEMBER,TITLE,RENTAL
WHERE MEMBER.ID(+)=RENTAL.MEMBER_ID AND TITLE_ID=TITLE.ID;

SELECT MEMBER.ID,NAME,TITLE,BOOK_DATE
FROM MEMBER,TITLE,RENTAL
WHERE MEMBER.ID=RENTAL.MEMBER_ID AND TITLE_ID=TITLE.ID AND BOOK_DATE>=SYSDATE-7;

SELECT TITLE,NAME,ADDRESS
FROM MEMBER,TITLE,RENTAL
WHERE EXP_RET_DATE<=NEXT_DAY(SYSDATE,1) AND ACT_RES_DATE IS NULL AND MEMBER.ID=RENTAL.MEMBER_ID AND TITLE_ID=TITLE.ID;

SELECT TITLE,NAME,ADDRESS
FROM MEMBER,TITLE,RENTAL
WHERE EXP_RET_DATE<SYSDATE AND ACT_RES_DATE IS NULL AND MEMBER.ID=RENTAL.MEMBER_ID AND TITLE_ID=TITLE.ID;

SELECT TITLE
FROM TITLE
WHERE ID=(
	SELECT TITLE_ID
	FROM RENTAL
	GROUP BY TITLE_ID
	HAVING TITLE_ID=(
			SELECT TITLE_ID
			FROM RENTAL
			WHERE BOOK_DATE>=TRUNC(SYSDATE,'MM')/* AND ROWNUM<=1*/
			GROUP BY TITLE_ID
			HAVING COUNT(TITLE_ID)=MAX(COUNT(TITLE_ID))
		)
	)
);

SELECT TITLE
FROM TITLE
WHERE ID^=(
	SELECT DISTINCT TITLE_ID
	FROM TITLECOPY
);

SELECT TITLE
FROM TITLE
WHERE ID=(
	SELECT TITLE_ID
	FROM RESERVATION
	GROUP BY TITLE_ID
	HAVING COUNT(TITLE_ID)>=(
		SELECT MAX(COUNT(TITLE_ID)) C
		FROM RESERVATION
		WHERE RES_DATE>=NEXT_DAY(SYSDATE,1)-7 AND ROWNUM<=1
		/*ORDER BY C*/
	)
);