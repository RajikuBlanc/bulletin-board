CREATE TABLE IF NOT EXISTS USER_COMMENT (
    ID NUMBER(10) AUTO_INCREMENT,
    NAME VARCHAR2(20),
    EMAIL VARCHAR2(100),
    TEXT VARCHAR2(400) NOT NULL,
    CREATED_AT DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT ID_PKC PRIMARY KEY(ID)
);
