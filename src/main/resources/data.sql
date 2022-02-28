INSERT INTO USER_COMMENT(NAME, USER_ID, EMAIL, TEXT) VALUES
('nameA','admin', 'example1@example.com', 'aaa'),
('nameB', 'admin', 'example2@example.com', 'bbb');

INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES ('admin', '{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', true);
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES ('admin', 'ROLE_USER');