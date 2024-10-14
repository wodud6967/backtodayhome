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

INSERT INTO maincategory_tb (name)
VALUES ('식품');

INSERT INTO maincategory_tb (name)
VALUES ('데코·식물');

INSERT INTO maincategory_tb (name)
VALUES ('조명');

INSERT INTO maincategory_tb (name)
VALUES ('수납·정리');
INSERT INTO maincategory_tb (name)
VALUES ('생활용품');
INSERT INTO maincategory_tb (name)
VALUES ('생필품');
INSERT INTO maincategory_tb (name)
VALUES ('유아·아동');
INSERT INTO maincategory_tb (name)
VALUES ('반려동물');
INSERT INTO maincategory_tb (name)
VALUES ('캠핑·레저');
INSERT INTO maincategory_tb (name)
VALUES ('공구·DIY');
INSERT INTO maincategory_tb (name)
VALUES ('인테리어시공');
INSERT INTO maincategory_tb (name)
VALUES ('렌탈·구독');



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

INSERT INTO brand_tb (brand_name)
VALUES ('템퍼');

INSERT INTO brand_tb (brand_name)
VALUES ('슬로우베드');

-- 의자 브랜드
INSERT INTO brand_tb (brand_name)
VALUES ('시디즈');

INSERT INTO brand_tb (brand_name)
VALUES ('듀오백');

INSERT INTO brand_tb (brand_name)
VALUES ('퍼시스');

-- 침대 관련 게시물 추가 (브랜드명 변경)
INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('편안한침대 시몬스', '편안한 시몬스 침대는 최고의 편안함을 제공합니다.', 1200000, 'simmons_comfort.jpg', 1, 1, TIMESTAMPADD(HOUR, -1, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('최고의침대 에이스', '에이스 침대는 편안한 수면을 위한 최고의 선택입니다.', 800000, 'ace_best.jpg', 1, 2, TIMESTAMPADD(HOUR, -2, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('안락한침대 한샘', '한샘의 안락한 침대는 넉넉한 공간을 제공합니다.', 1500000, 'hanssem_relax.jpg', 1, 3, TIMESTAMPADD(HOUR, -3, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('편안한침대 라텍스 시몬스', '시몬스의 라텍스 침대는 최고의 지지력을 제공합니다.', 1300000, 'simmons_latex_comfort.jpg', 1, 1, TIMESTAMPADD(HOUR, -4, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('고급침대 에이스', '에이스 프리미엄 침대는 최상의 품질을 자랑합니다.', 1400000, 'ace_premium_best.jpg', 1, 2, TIMESTAMPADD(HOUR, -5, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('모던한침대 한샘', '한샘의 모던한 침대는 경제적인 선택입니다.', 850000, 'hanssem_modern.jpg', 1, 3, TIMESTAMPADD(HOUR, -6, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('럭셔리침대 시몬스', '시몬스 프리미엄 침대는 넉넉한 공간과 편안함을 제공합니다.', 1600000, 'simmons_luxury.jpg', 1, 1, TIMESTAMPADD(HOUR, -7, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('편안한수면 에이스', '에이스 프리미엄 침대는 편안한 수면을 보장합니다.', 1200000, 'ace_sleep_comfort.jpg', 1, 2, TIMESTAMPADD(HOUR, -8, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('클래식침대 한샘', '한샘 클래식 침대는 최고의 편안함을 제공합니다.', 1700000, 'hanssem_classic.jpg', 1, 3, TIMESTAMPADD(HOUR, -9, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('편리한침대 시몬스', '시몬스의 침대는 합리적인 가격에 넉넉한 공간을 제공합니다.', 1100000, 'simmons_convenient.jpg', 1, 1, TIMESTAMPADD(HOUR, -10, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('경제적인침대 에이스', '에이스 침대는 가성비가 뛰어납니다.', 700000, 'ace_economical.jpg', 1, 2, TIMESTAMPADD(HOUR, -11, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('프리미엄침대 한샘', '한샘 프리미엄 침대는 넓고 편안한 수면을 제공합니다.', 1400000, 'hanssem_premium.jpg', 1, 3, TIMESTAMPADD(HOUR, -12, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('지지력좋은침대 시몬스', '시몬스의 라텍스 침대는 최고의 지지력을 제공합니다.', 1200000, 'simmons_supportive.jpg', 1, 1, TIMESTAMPADD(HOUR, -13, CURRENT_TIMESTAMP));

-- 침대 관련 게시물 추가 (브랜드명 변경)
INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('편안한침대 시몬스', '편안한 시몬스 침대는 최고의 편안함을 제공합니다.', 1200000, 'simmons_comfort.jpg', 1, 1, TIMESTAMPADD(HOUR, -1, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('최고의침대 에이스', '에이스 침대는 편안한 수면을 위한 최고의 선택입니다.', 800000, 'ace_best.jpg', 1, 2, TIMESTAMPADD(HOUR, -2, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('안락한침대 한샘', '한샘의 안락한 침대는 넉넉한 공간을 제공합니다.', 1500000, 'hanssem_relax.jpg', 1, 3, TIMESTAMPADD(HOUR, -3, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('편안한침대 템퍼', '템퍼의 편안한 침대는 편안한 수면을 보장합니다.', 1400000, 'tempur_comfort.jpg', 1, 4, TIMESTAMPADD(HOUR, -4, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('럭셔리침대 슬로우베드', '슬로우베드의 럭셔리 침대는 프리미엄 수면을 제공합니다.', 1700000, 'slowbed_luxury.jpg', 1, 5, TIMESTAMPADD(HOUR, -5, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('편안한침대 시몬스', '시몬스의 최신형 편안한 침대는 지지력과 편안함을 제공합니다.', 1600000, 'simmons_latest.jpg', 1, 1, TIMESTAMPADD(HOUR, -6, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('최고의침대 에이스', '에이스의 프리미엄 침대는 깊은 수면을 위한 최고의 제품입니다.', 1800000, 'ace_premium.jpg', 1, 2, TIMESTAMPADD(HOUR, -7, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('안락한침대 한샘', '한샘의 안락한 침대는 편안한 수면을 제공합니다.', 1300000, 'hanssem_relax2.jpg', 1, 3, TIMESTAMPADD(HOUR, -8, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('편안한침대 템퍼', '템퍼의 프리미엄 침대는 지지력과 편안함을 극대화합니다.', 1500000, 'tempur_premium.jpg', 1, 4, TIMESTAMPADD(HOUR, -9, CURRENT_TIMESTAMP));

INSERT INTO post_tb (title, content, price, main_photo, sub_category_id, brand_id, created_at)
VALUES ('럭셔리침대 슬로우베드', '슬로우베드의 최고급 침대는 고객의 만족을 보장합니다.', 1900000, 'slowbed_deluxe.jpg', 1, 5, TIMESTAMPADD(HOUR, -10, CURRENT_TIMESTAMP));

-- 시몬스 침대 세트 등록 (기본 가격은 예시)
INSERT INTO product_tb (name, price, post_id) VALUES ('시몬스 침대 세트', 450000, 1); -- ID 1
INSERT INTO product_tb (name, price, post_id) VALUES ('시몬스 침대 프레임 ', 350000, 1); -- ID 2
INSERT INTO product_tb (name, price, post_id) VALUES ('시몬스 침대 커버 ', 355000, 1); -- ID 3

-- 옵션 유형 등록
INSERT INTO optiontype_tb (type) VALUES ('사이즈');
INSERT INTO optiontype_tb (type) VALUES ('색상');

-- 사이즈 옵션 등록
INSERT INTO option_tb (content, price, option_type_id) VALUES ('싱글', 0, 1); -- 사이즈: 싱글, ID 1
INSERT INTO option_tb (content, price, option_type_id) VALUES ('퀸', 50000, 1); -- 사이즈: 퀸, ID 2
INSERT INTO option_tb (content, price, option_type_id) VALUES ('킹', 150000, 1); -- 사이즈: 킹, ID 3

-- 색상 옵션 등록
INSERT INTO option_tb (content, price, option_type_id) VALUES ('화이트', 0, 2); -- 색상: 화이트, ID 4
INSERT INTO option_tb (content, price, option_type_id) VALUES ('블랙', 5000, 2); -- 색상: 블랙, ID 5

-- 시몬스 침대 세트에 옵션 등록 (ID 1)
-- 사이즈 등록 (우선순위 1)
INSERT INTO product_option_tb (product_id, option_id, priority) VALUES (1, 1, 1); -- 싱글
INSERT INTO product_option_tb (product_id, option_id, priority) VALUES (1, 2, 1); -- 퀸
INSERT INTO product_option_tb (product_id, option_id, priority) VALUES (1, 3, 1); -- 킹

-- 색상 등록 (우선순위 2)
INSERT INTO product_option_tb (product_id, option_id, priority) VALUES (1, 4, 2); -- 화이트
INSERT INTO product_option_tb (product_id, option_id, priority) VALUES (1, 5, 2); -- 블랙



-- 시몬스 침대 세트에 대한 재고 등록
INSERT INTO inventory_tb (product_id, option1_id, option2_id, stock)
VALUES (1, 1, 4, 10); -- 싱글, 화이트 재고 10개
INSERT INTO inventory_tb (product_id, option1_id, option2_id, stock)
VALUES (1, 1, 5, 5);  -- 싱글, 블랙 재고 5개
INSERT INTO inventory_tb (product_id, option1_id, option2_id, stock)
VALUES (1, 2, 4, 8);  -- 퀸, 화이트 재고 8개
INSERT INTO inventory_tb (product_id, option1_id, option2_id, stock)
VALUES (1, 2, 5, 3);  -- 퀸, 블랙 재고 3개
INSERT INTO inventory_tb (product_id, option1_id, option2_id, stock)
VALUES (1, 3, 4, 6);  -- 킹, 화이트 재고 6개
INSERT INTO inventory_tb (product_id, option1_id, option2_id, stock)
VALUES (1, 3, 5, 4);  -- 킹, 블랙 재고 4개

-- 추가 상품 (프레임) 재고 등록
INSERT INTO inventory_tb (product_id, stock)
VALUES (2, 20); -- 화이트 프레임
INSERT INTO inventory_tb (product_id, stock)
VALUES (3, 15); -- 블랙 프레임

-- 시몬스 침대에 대한 리뷰 (post_id = 1, user_id = 1)
INSERT INTO review_tb (post_id, user_id, content, img_url, star, created_at)
VALUES (1, 1, '시몬스 침대를 구매했는데 정말 편안하고 좋습니다.', 'review1.jpg', 4.5, CURRENT_TIMESTAMP);

INSERT INTO review_tb (post_id, user_id, content, img_url, star, created_at)
VALUES (1, 2, '매트리스가 부드럽고 프레임도 튼튼해서 만족합니다.', 'review2.jpg', 5.0, CURRENT_TIMESTAMP);

-- 에이스 침대에 대한 리뷰 (post_id = 2, user_id = 3)
INSERT INTO review_tb (post_id, user_id, content, img_url, star, created_at)
VALUES (2, 3, '에이스 침대는 가성비가 뛰어납니다.', 'review3.jpg', 4.0, CURRENT_TIMESTAMP);

INSERT INTO review_tb (post_id, user_id, content, img_url, star, created_at)
VALUES (2, 1, '프레임 디자인이 마음에 들고, 수면 품질이 좋아졌습니다.', 'review4.jpg', 4.8, CURRENT_TIMESTAMP);

-- 한샘 침대에 대한 리뷰 (post_id = 3, user_id = 2)
INSERT INTO review_tb (post_id, user_id, content, img_url, star, created_at)
VALUES (3, 2, '킹사이즈 침대 정말 넉넉하고 좋아요!', 'review5.jpg', 5.0, CURRENT_TIMESTAMP);







-- user_id = 1 사용자가 inventory_id = 1 (시몬스 침대 싱글 화이트)을 장바구니에 추가
INSERT INTO cart_tb (user_id, inventory_id, count, price, total_price)
VALUES (1, 1, 2, 500000, 1000000);  -- 상품 가격 500,000원, 수량 2개, 총 가격 1,000,000원

-- user_id = 2 사용자가 inventory_id = 2 (시몬스 침대 싱글 블랙)을 장바구니에 추가
INSERT INTO cart_tb (user_id, inventory_id, count, price, total_price)
VALUES (2, 2, 1, 450000, 450000);  -- 상품 가격 450,000원, 수량 1개, 총 가격 450,000원

-- user_id = 3 사용자가 inventory_id = 3 (시몬스 침대 퀸 화이트)을 장바구니에 추가
INSERT INTO cart_tb (user_id, inventory_id, count, price, total_price)
VALUES (3, 3, 3, 600000, 1800000);  -- 상품 가격 600,000원, 수량 3개, 총 가격 1,800,000원

-- 주문 테이블 더미 데이터


-- user_id = 1 사용자가 주문한 경우
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity)
VALUES (1, 'merchant_001', 1000000, 2);

-- user_id = 2 사용자가 주문한 경우
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity)
VALUES (2, 'merchant_002', 450000, 1);

-- user_id = 3 사용자가 주문한 경우
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity)
VALUES (3, 'merchant_003', 1800000, 3);

-- 주문 상세 테이블 더미 데이터

-- 주문 1 (order_id = 1)에서 시몬스 침대 (inventory_id = 1)를 2개 구매
INSERT INTO orderdetail_tb (order_id, inventory_id, count, price, total_price)
VALUES (1, 1, 2, 500000, 1000000);  -- 상품 가격 500,000원, 수량 2개, 총 가격 1,000,000원

-- 주문 2 (order_id = 2)에서 에이스 침대 (inventory_id = 2)를 1개 구매
INSERT INTO orderdetail_tb (order_id, inventory_id, count, price, total_price)
VALUES (2, 2, 1, 450000, 450000);  -- 상품 가격 450,000원, 수량 1개, 총 가격 450,000원

-- 주문 3 (order_id = 3)에서 한샘 침대 (inventory_id = 3)를 3개 구매
INSERT INTO orderdetail_tb (order_id, inventory_id, count, price, total_price)
VALUES (3, 3, 3, 600000, 1800000);  -- 상품 가격 600,000원, 수량 3개, 총 가격 1,800,000원

-- 결제 테이블 더미 데이터

-- 주문 1 (order_id = 1)에 대한 결제 내역
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount)
VALUES (1, 'T70bcd41058063936fda', 'abcdefg', 1000000);

-- 주문 2 (order_id = 2)에 대한 결제 내역
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount)
VALUES (2, 'imp_002', 'abcdefg', 450000);


-- 주문 3 (order_id = 3)에 대한 결제 내역
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount)
VALUES (3, 'imp_003', 'abcdefg', 1800000);



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












