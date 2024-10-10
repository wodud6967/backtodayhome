INSERT INTO user_tb(username, password, name, age, email, phone, address, oauth)
VALUES ('ssar', '1234', 'John', 25, 'ssar@nate.com', '01048086967', 'Seoul, South Korea', 'none');

INSERT INTO user_tb(username, password, name, age, email, phone, address, oauth)
VALUES ('cos', '1234', 'Chris', 30, 'cos@nate.com', '01048086967', 'Busan, South Korea', 'none');

INSERT INTO user_tb(username, password, name, age, email, phone, address, oauth)
VALUES ('love', '1234', 'Lily', 28, 'love@nate.com', '01048086967', 'Incheon, South Korea', 'none');


INSERT INTO maincategory_tb (name)
VALUES ('침대');

INSERT INTO maincategory_tb (name)
VALUES ('의자');

INSERT INTO maincategory_tb (name)
VALUES ('조명');

-- 침대 카테고리의 서브 카테고리 (싱글, 퀸, 킹)
INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('싱글', 1);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('퀸', 1);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('킹', 1);

-- 의자 카테고리의 서브 카테고리 (사무용, 학생용, 어린이용)
INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('사무용', 2);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('학생용', 2);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('어린이용', 2);

-- 조명 카테고리의 서브 카테고리 (천장 조명, 스탠드, 벽등)
INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('천장 조명', 3);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('스탠드', 3);

INSERT INTO subcategory_tb (name, main_category_id)
VALUES ('벽등', 3);

INSERT INTO color_tb (color_name)
VALUES ('빨간색');

INSERT INTO color_tb (color_name)
VALUES ('파란색');

INSERT INTO color_tb (color_name)
VALUES ('흰색');

-- 브랜드 더미 데이터
INSERT INTO brand_tb (brand_name)
VALUES ('드레스덴');

INSERT INTO brand_tb (brand_name)
VALUES ('라비타');

INSERT INTO brand_tb (brand_name)
VALUES ('소프시스');

INSERT INTO brand_tb (brand_name)
VALUES ('에몬스');

INSERT INTO brand_tb (brand_name)
VALUES ('일룸');

-- 드레스덴 브랜드 상품
INSERT INTO product_tb (title, content, product_name, brand_id)
VALUES ('드레스덴 정품 조야패브릭 호텔식 침대프레임 SS/Q/K/LK/CK (패널추가)', '상세페이지 사진사진사진', '드레스덴 조야패브릭 침대프레임', 1);

-- 라비타 브랜드 상품
INSERT INTO product_tb (title, content, product_name, brand_id)
VALUES ('라비타 모던 디자인 침대 SS/Q/K', '모던한 디자인의 심플 침대', '라비타 모던 침대', 2);

-- 소프시스 브랜드 상품
INSERT INTO product_tb (title, content, product_name, brand_id)
VALUES ('소프시스 알파 패브릭 침대 SS/Q/K', '튼튼하고 심플한 패브릭 침대', '소프시스 알파 패브릭 침대', 3);

-- 에몬스 브랜드 상품
INSERT INTO product_tb (title, content, product_name, brand_id)
VALUES ('에몬스 클래식 우드 침대 SS/Q/K', '고급스러운 우드 디자인 침대', '에몬스 클래식 우드 침대', 4);

-- 일룸 브랜드 상품
INSERT INTO product_tb (title, content, product_name, brand_id)
VALUES ('일룸 소프트 패브릭 침대 SS/Q/K', '편안한 소프트 패브릭 침대', '일룸 소프트 패브릭 침대', 5);

-- 싱글 침대에 대한 옵션
INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (1, 1, 1, 200000, 50); -- 빨간색 싱글 침대

INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (2, 1, 1, 210000, 50); -- 파란색 싱글 침대

INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (3, 1, 1, 220000, 50); -- 흰색 싱글 침대

-- 퀸 침대에 대한 옵션
INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (1, 2, 2, 300000, 30); -- 빨간색 퀸 침대

INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (2, 2, 2, 310000, 30); -- 파란색 퀸 침대

INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (3, 2, 2, 320000, 30); -- 흰색 퀸 침대

-- 킹 침대에 대한 옵션
INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (1, 3, 3, 400000, 20); -- 빨간색 킹 침대

INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (2, 3, 3, 410000, 20); -- 파란색 킹 침대

INSERT INTO option_tb (color_id, sub_category_id, product_id, price, stock)
VALUES (3, 3, 3, 420000, 20); -- 흰색 킹 침대

-- 싱글 침대에 대한 사진
INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/single_bed_1.jpg', 1);

INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/single_bed_2.jpg', 1);

INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/single_bed_3.jpg', 1);

-- 퀸 침대에 대한 사진
INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/queen_bed_1.jpg', 2);

INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/queen_bed_2.jpg', 2);

INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/queen_bed_3.jpg', 2);

-- 킹 침대에 대한 사진
INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/king_bed_1.jpg', 3);

INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/king_bed_2.jpg', 3);

INSERT INTO photo_tb (url, product_id)
VALUES ('https://example.com/king_bed_3.jpg', 3);

-- 유저 1번 (ssar)의 장바구니 데이터 (싱글 침대 빨간색, 퀸 침대 파란색)
INSERT INTO cart_tb (user_id, option_id, count, price, total_price)
VALUES (1, 1, 1, 200000, 200000);  -- 싱글 침대 빨간색

INSERT INTO cart_tb (user_id, option_id, count, price, total_price)
VALUES (1, 5, 2, 310000, 620000);  -- 퀸 침대 파란색

-- 유저 2번 (cos)의 장바구니 데이터 (킹 침대 흰색, 싱글 침대 파란색)
INSERT INTO cart_tb (user_id, option_id, count, price, total_price)
VALUES (2, 9, 1, 420000, 420000);  -- 킹 침대 흰색

INSERT INTO cart_tb (user_id, option_id, count, price, total_price)
VALUES (2, 2, 1, 210000, 210000);  -- 싱글 침대 파란색

-- 유저 1번의 주문
INSERT INTO order_tb (user_id, merchant_uid)
VALUES (1, 'order_ssar_20241010');

-- 유저 2번의 주문
INSERT INTO order_tb (user_id, merchant_uid)
VALUES (2, 'order_cos_20241010');


-- 유저 1번(ssar)의 주문 상세 데이터 (싱글 침대 빨간색, 퀸 침대 파란색)
INSERT INTO orderdetail_tb (option_id, order_id, price, total_price, count)
VALUES (1, 1, 200000, 200000, 1);  -- 싱글 침대 빨간색

INSERT INTO orderdetail_tb (option_id, order_id, price, total_price, count)
VALUES (5, 1, 310000, 620000, 2);  -- 퀸 침대 파란색

-- 유저 2번(cos)의 주문 상세 데이터 (킹 침대 흰색, 싱글 침대 파란색)
INSERT INTO orderdetail_tb (option_id, order_id, price, total_price, count)
VALUES (9, 2, 420000, 420000, 1);  -- 킹 침대 흰색

INSERT INTO orderdetail_tb (option_id, order_id, price, total_price, count)
VALUES (2, 2, 210000, 210000, 1);  -- 싱글 침대 파란색


-- 유저 1번 주문에 대한 결제
INSERT INTO payment_tb (order_id, imp_uid)
VALUES (1, 'imp_1234567890');

-- 유저 2번 주문에 대한 결제
INSERT INTO payment_tb (order_id, imp_uid)
VALUES (2, 'imp_0987654321');

-- 유저 1번(ssar)이 상품 1번(싱글 침대)에 대한 리뷰 작성
INSERT INTO review_tb (product_id, user_id, content, url, star, created_at)
VALUES (1, 1, '침대가 매우 편안해요!', 'https://example.com/single_bed_review_1.jpg', 4.5, CURRENT_TIMESTAMP);

-- 유저 2번(cos)이 상품 2번(퀸 침대)에 대한 리뷰 작성
INSERT INTO review_tb (product_id, user_id, content, url, star, created_at)
VALUES (2, 2, '퀸 침대 크기가 딱 좋습니다.', 'https://example.com/queen_bed_review_1.jpg', 4.0, CURRENT_TIMESTAMP);

-- 유저 3번(love)이 상품 3번(킹 침대)에 대한 리뷰 작성
INSERT INTO review_tb (product_id, user_id, content, url, star, created_at)
VALUES (3, 3, '킹 침대가 정말 넓어서 만족스러워요.', 'https://example.com/king_bed_review_1.jpg', 5.0, CURRENT_TIMESTAMP);

