INSERT INTO user_tb(username, password, name, age, email, phone, address, oauth)
VALUES ('ssar', '1234', 'John', 25, 'ssar@nate.com', '01048086967', 'Seoul, South Korea', 'none');

INSERT INTO user_tb(username, password, name, age, email, phone, address, oauth)
VALUES ('cos', '1234', 'Chris', 30, 'cos@nate.com', '01048086967', 'Busan, South Korea', 'none');

INSERT INTO user_tb(username, password, name, age, email, phone, address, oauth)
VALUES ('love', '1234', 'Lily', 28, 'love@nate.com', '01048086967', 'Incheon, South Korea', 'none');


INSERT INTO maincategory_tb (name)
VALUES ('가구');

INSERT INTO maincategory_tb (name)
VALUES ('패브릭');

INSERT INTO maincategory_tb (name)
VALUES ('가전·디지털');

-- 침대 카테고리의 서브 카테고리 (싱글, 퀸, 킹)
INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('침대', 1);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('의자', 1);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('테이블', 1);

-- 의자 카테고리의 서브 카테고리 (사무용, 학생용, 어린이용)
INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('서랍', 1);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('거실장', 1);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('선반', 1);

-- 조명 카테고리의 서브 카테고리 (천장 조명, 스탠드, 벽등)
INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('진열장', 1);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('이불세트', 2);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('커튼·부자재', 2);

