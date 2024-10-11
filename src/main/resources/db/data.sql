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

-- 침대 브랜드
INSERT INTO brand_tb (brand_name)
VALUES ('시몬스');

INSERT INTO brand_tb (brand_name)
VALUES ('에이스 침대');

INSERT INTO brand_tb (brand_name)
VALUES ('한샘 침대');

-- 의자 브랜드
INSERT INTO brand_tb (brand_name)
VALUES ('시디즈');

INSERT INTO brand_tb (brand_name)
VALUES ('듀오백');

INSERT INTO brand_tb (brand_name)
VALUES ('퍼시스');
-- 침대 관련 게시물 (subcategory_id = 1: 침대, brand_id = 1: 시몬스, 2: 에이스 침대, 3: 한샘 침대)
INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id)
VALUES ('시몬스 침대 - 퀸사이즈', '시몬스의 퀸사이즈 침대는 편안한 수면을 제공합니다.', 1200000, 'simmons_queen.jpg', 1, 1);

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id)
VALUES ('에이스 침대 - 싱글사이즈', '에이스 침대는 싱글 침대로 최상의 품질을 제공합니다.', 800000, 'ace_single.jpg', 1, 2);

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id)
VALUES ('한샘 침대 - 킹사이즈', '한샘의 킹사이즈 침대는 넉넉한 공간을 제공합니다.', 1500000, 'hanssem_king.jpg', 1, 3);

-- 의자 관련 게시물 (subcategory_id = 2: 의자, brand_id = 4: 시디즈, 5: 듀오백, 6: 퍼시스)
INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id)
VALUES ('시디즈 사무용 의자', '시디즈 사무용 의자는 편안한 자세를 유지할 수 있게 도와줍니다.', 300000, 'sidiz_office.jpg', 2, 4);

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id)
VALUES ('듀오백 학생용 의자', '듀오백 학생용 의자는 장시간 학습에 적합한 편안함을 제공합니다.', 150000, 'duoback_student.jpg', 2, 5);

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id)
VALUES ('퍼시스 사무용 의자', '퍼시스의 사무용 의자는 현대적인 디자인과 편안함을 제공합니다.', 250000, 'percis_office.jpg', 2, 6);



-- 시몬스 침대 상품 등록 (post_id = 1)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 침대 매트리스 싱글', 450000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 침대 매트리스 퀸', 500000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 침대 매트리스 킹', 600000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 침대 프레임 싱글', 550000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 침대 프레임 퀸', 700000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 침대 프레임 킹', 900000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 고급 매트리스 퀸', 800000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 고급 매트리스 킹', 950000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 매트리스', 650000, 1);

INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 프리미엄 매트리스', 1200000, 1);
-- 에이스 침대 상품 등록 (post_id = 2)
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 침대 매트리스 싱글', 400000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 침대 매트리스 퀸', 450000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 침대 매트리스 킹', 550000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 침대 프레임 싱글', 500000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 침대 프레임 퀸', 650000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 침대 프레임 킹', 850000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 라텍스 매트리스 싱글', 600000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 라텍스 매트리스 퀸', 750000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 매트리스 퀸', 1000000, 2);

INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 매트리스 킹', 1200000, 2);
-- 한샘 침대 게시물에 등록할 상품
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 킹사이즈 침대 매트리스', 600000, 3);  -- 한샘 침대 게시물의 ID가 3이라고 가정

INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 킹사이즈 침대 프레임', 900000, 3);  -- 한샘 침대 게시물의 ID가 3이라고 가정

-- 시디즈 의자 게시물에 등록할 상품
INSERT INTO product_tb (name, price, post_id)
VALUES ('시디즈 사무용 의자', 200000, 4);  -- 시디즈 의자 게시물의 ID가 4이라고 가정

-- 듀오백 의자 게시물에 등록할 상품
INSERT INTO product_tb (name, price, post_id)
VALUES ('듀오백 학생용 의자', 150000, 5);  -- 듀오백 의자 게시물의 ID가 5이라고 가정

-- 퍼시스 의자 게시물에 등록할 상품
INSERT INTO product_tb (name, price, post_id)
VALUES ('퍼시스 사무용 의자', 250000, 6);

-- 옵션 타입 (OptionType) 데이터
INSERT INTO optiontype_tb (type)
VALUES ('사이즈');

INSERT INTO optiontype_tb (type)
VALUES ('컬러');

-- 시몬스 침대에 사이즈 옵션 추가
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('싱글', 5000, 1, 1);  -- 기본 가격 + 5000원

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('퀸', 10000, 1, 1);  -- 기본 가격 + 10000원

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 15000, 1, 1);  -- 기본 가격 + 15000원

-- 시몬스 침대에 컬러 옵션 추가
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 1, 2);  -- 기본 가격

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 1, 2);  -- 기본 가격 + 5000원

-- 에이스 침대에 사이즈 옵션 추가
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('싱글', 5000, 2, 1);  -- 기본 가격 + 5000원

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('퀸', 10000, 2, 1);  -- 기본 가격 + 10000원

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 15000, 2, 1);  -- 기본 가격 + 15000원

-- 에이스 침대에 컬러 옵션 추가
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 2, 2);  -- 기본 가격

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 2, 2);  -- 기본 가격 + 5000원

-- 리뷰 더미 데이터

-- 시몬스 침대에 대한 리뷰 (post_id = 1, user_id = 1)
INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
VALUES (1, 1, '시몬스 침대를 구매했는데 정말 편안하고 좋습니다.', 'review1.jpg', 4.5, CURRENT_TIMESTAMP);

INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
VALUES (1, 2, '매트리스가 부드럽고 프레임도 튼튼해서 만족합니다.', 'review2.jpg', 5.0, CURRENT_TIMESTAMP);

-- 에이스 침대에 대한 리뷰 (post_id = 2, user_id = 3)
INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
VALUES (2, 3, '에이스 침대는 가성비가 뛰어납니다.', 'review3.jpg', 4.0, CURRENT_TIMESTAMP);

INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
VALUES (2, 1, '프레임 디자인이 마음에 들고, 수면 품질이 좋아졌습니다.', 'review4.jpg', 4.8, CURRENT_TIMESTAMP);

-- 한샘 침대에 대한 리뷰 (post_id = 3, user_id = 2)
INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
VALUES (3, 2, '킹사이즈 침대 정말 넉넉하고 좋아요!', 'review5.jpg', 5.0, CURRENT_TIMESTAMP);

-- 시디즈 의자에 대한 리뷰 (post_id = 4, user_id = 3)
INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
VALUES (4, 3, '시디즈 의자는 정말 편안합니다.', 'review6.jpg', 4.7, CURRENT_TIMESTAMP);

-- 듀오백 의자에 대한 리뷰 (post_id = 5, user_id = 1)
INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
VALUES (5, 1, '듀오백 의자는 장시간 사용에도 편안함을 유지합니다.', 'review7.jpg', 4.5, CURRENT_TIMESTAMP);

-- 퍼시스 의자에 대한 리뷰 (post_id = 6, user_id = 2)
INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
VALUES (6, 2, '퍼시스 의자는 가격 대비 성능이 훌륭합니다.', 'review8.jpg', 4.3, CURRENT_TIMESTAMP);

-- 장바구니 더미 데이터

-- user_id = 1 사용자가 product_id = 1 (시몬스 침대 싱글)을 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (1, 1, 2, 500000, 1000000);  -- 상품 가격 500,000원, 수량 2개, 총 가격 1,000,000원

-- user_id = 2 사용자가 product_id = 2 (에이스 침대 퀸)을 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (2, 2, 1, 450000, 450000);  -- 상품 가격 450,000원, 수량 1개, 총 가격 450,000원

-- user_id = 3 사용자가 product_id = 3 (한샘 침대 킹)을 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (3, 3, 3, 600000, 1800000);  -- 상품 가격 600,000원, 수량 3개, 총 가격 1,800,000원

-- 주문 테이블 더미 데이터

-- user_id = 1 사용자가 주문한 경우
INSERT INTO order_tb (user_id, merchant_uid)
VALUES (1, 'merchant_001');

-- user_id = 2 사용자가 주문한 경우
INSERT INTO order_tb (user_id, merchant_uid)
VALUES (2, 'merchant_002');

-- user_id = 3 사용자가 주문한 경우
INSERT INTO order_tb (user_id, merchant_uid)
VALUES (3, 'merchant_003');

-- 주문 상세 테이블 더미 데이터

-- 주문 1 (order_id = 1)에서 시몬스 침대 (product_id = 1)를 2개 구매
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (1, 1, 2, 500000, 1000000);  -- 상품 가격 500,000원, 수량 2개, 총 가격 1,000,000원

-- 주문 2 (order_id = 2)에서 에이스 침대 (product_id = 2)를 1개 구매
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (2, 2, 1, 450000, 450000);  -- 상품 가격 450,000원, 수량 1개, 총 가격 450,000원

-- 주문 3 (order_id = 3)에서 한샘 침대 (product_id = 3)를 3개 구매
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (3, 3, 3, 600000, 1800000);  -- 상품 가격 600,000원, 수량 3개, 총 가격 1,800,000원

-- 결제 테이블 더미 데이터

-- 주문 1 (order_id = 1)에 대한 결제 내역
INSERT INTO payment_tb (order_id, imp_uid)
VALUES (1, 'imp_001');

-- 주문 2 (order_id = 2)에 대한 결제 내역
INSERT INTO payment_tb (order_id, imp_uid)
VALUES (2, 'imp_002');

-- 주문 3 (order_id = 3)에 대한 결제 내역
INSERT INTO payment_tb (order_id, imp_uid)
VALUES (3, 'imp_003');


-- 시몬스 침대 게시물의 사진 (post_id = 1)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/simmons_main.jpg', 'main', 1); -- 메인 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/simmons_thumb.jpg', 'thumbnail', 1); -- 썸네일 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/simmons_detail1.jpg', 'detail', 1); -- 상세 사진 1
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/simmons_detail2.jpg', 'detail', 1); -- 상세 사진 2

-- 에이스 침대 게시물의 사진 (post_id = 2)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/ace_main.jpg', 'main', 2); -- 메인 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/ace_thumb.jpg', 'thumbnail', 2); -- 썸네일 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/ace_detail1.jpg', 'detail', 2); -- 상세 사진 1
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/ace_detail2.jpg', 'detail', 2); -- 상세 사진 2

-- 한샘 침대 게시물의 사진 (post_id = 3)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/hanssem_main.jpg', 'main', 3); -- 메인 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/hanssem_thumb.jpg', 'thumbnail', 3); -- 썸네일 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/hanssem_detail1.jpg', 'detail', 3); -- 상세 사진 1
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/hanssem_detail2.jpg', 'detail', 3); -- 상세 사진 2

-- 시디즈 의자 게시물의 사진 (post_id = 4)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/sidiz_main.jpg', 'main', 4); -- 메인 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/sidiz_thumb.jpg', 'thumbnail', 4); -- 썸네일 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/sidiz_detail1.jpg', 'detail', 4); -- 상세 사진 1
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/sidiz_detail2.jpg', 'detail', 4); -- 상세 사진 2

-- 듀오백 의자 게시물의 사진 (post_id = 5)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/duoback_main.jpg', 'main', 5); -- 메인 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/duoback_thumb.jpg', 'thumbnail', 5); -- 썸네일 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/duoback_detail1.jpg', 'detail', 5); -- 상세 사진 1
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/duoback_detail2.jpg', 'detail', 5); -- 상세 사진 2

-- 퍼시스 의자 게시물의 사진 (post_id = 6)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/percis_main.jpg', 'main', 6); -- 메인 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/percis_thumb.jpg', 'thumbnail', 6); -- 썸네일 사진
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/percis_detail1.jpg', 'detail', 6); -- 상세 사진 1
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/percis_detail2.jpg', 'detail', 6); -- 상세 사진 2