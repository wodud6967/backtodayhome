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

-- 시몬스 침대 - 라텍스 퀸사이즈 (post_id = 4)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 퀸 매트리스', 500000, 4);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 퀸 프레임', 700000, 4);

-- 에이스 침대 - 프리미엄 킹사이즈 (post_id = 5)
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 킹 매트리스', 600000, 5);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 킹 프레임', 800000, 5);

-- 한샘 침대 - 더블사이즈 (post_id = 6)
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 더블사이즈 매트리스', 400000, 6);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 더블사이즈 프레임', 600000, 6);

-- 시몬스 침대 - 프리미엄 킹사이즈 (post_id = 7)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 프리미엄 킹 매트리스', 800000, 7);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 프리미엄 킹 프레임', 1000000, 7);

-- 에이스 침대 - 프리미엄 퀸사이즈 (post_id = 8)
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 퀸 매트리스', 500000, 8);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 퀸 프레임', 700000, 8);

-- 한샘 침대 - 킹사이즈 라텍스 (post_id = 9)
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 킹사이즈 라텍스 매트리스', 900000, 9);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 킹사이즈 라텍스 프레임', 1100000, 9);

-- 시몬스 침대 - 더블사이즈 (post_id = 10)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 더블사이즈 매트리스', 550000, 10);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 더블사이즈 프레임', 750000, 10);

-- 에이스 침대 - 싱글사이즈 (post_id = 11)
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 싱글사이즈 매트리스', 300000, 11);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 싱글사이즈 프레임', 500000, 11);

-- 한샘 침대 - 프리미엄 퀸사이즈 (post_id = 12)
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 프리미엄 퀸 매트리스', 600000, 12);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 프리미엄 퀸 프레임', 800000, 12);

-- 시몬스 침대 - 라텍스 더블사이즈 (post_id = 13)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 더블 매트리스', 650000, 13);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 더블 프레임', 850000, 13);

-- 시몬스 침대 - 라텍스 더블사이즈 (post_id = 13)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 더블 매트리스', 650000, 13);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 더블 프레임', 850000, 13);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 더블 베개', 120000, 13);

-- 에이스 침대 - 프리미엄 킹사이즈 (post_id = 14)
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 킹 매트리스', 1200000, 14);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 킹 프레임', 1300000, 14);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 킹 베개', 150000, 14);

-- 한샘 침대 - 더블사이즈 (post_id = 15)
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 더블 매트리스', 850000, 15);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 더블 프레임', 950000, 15);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 더블 베개', 110000, 15);

-- 시몬스 침대 - 프리미엄 킹사이즈 (post_id = 16)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 프리미엄 킹 매트리스', 1500000, 16);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 프리미엄 킹 프레임', 1600000, 16);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 프리미엄 킹 베개', 180000, 16);

-- 에이스 침대 - 프리미엄 퀸사이즈 (post_id = 17)
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 퀸 매트리스', 1100000, 17);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 퀸 프레임', 1200000, 17);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 퀸 베개', 140000, 17);

-- 한샘 침대 - 킹사이즈 라텍스 (post_id = 18)
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 킹사이즈 라텍스 매트리스', 1700000, 18);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 킹사이즈 라텍스 프레임', 1800000, 18);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 킹사이즈 라텍스 베개', 200000, 18);

-- 시몬스 침대 - 더블사이즈 (post_id = 19)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 더블 매트리스', 1100000, 19);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 더블 프레임', 1200000, 19);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 더블 베개', 130000, 19);

-- 에이스 침대 - 싱글사이즈 (post_id = 20)
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 싱글 매트리스', 700000, 20);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 싱글 프레임', 800000, 20);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 싱글 베개', 90000, 20);

-- 한샘 침대 - 프리미엄 퀸사이즈 (post_id = 21)
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 프리미엄 퀸 매트리스', 1400000, 21);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 프리미엄 퀸 프레임', 1500000, 21);
INSERT INTO product_tb (name, price, post_id)
VALUES ('한샘 프리미엄 퀸 베개', 160000, 21);

-- 시몬스 침대 - 라텍스 더블사이즈 (post_id = 22)
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 더블 매트리스', 1200000, 22);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 더블 프레임', 1300000, 22);
INSERT INTO product_tb (name, price, post_id)
VALUES ('시몬스 라텍스 더블 베개', 140000, 22);

-- 에이스 침대 - 프리미엄 싱글사이즈 (post_id = 23)
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 싱글 매트리스', 900000, 23);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 싱글 프레임', 1000000, 23);
INSERT INTO product_tb (name, price, post_id)
VALUES ('에이스 프리미엄 싱글 베개', 110000, 23);

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

-- 시몬스 침대에 컬러 옵션 추가 (product_id = 13)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 13, 2);  -- 기본 가격
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 13, 2);  -- 기본 가격 + 5000원

-- 에이스 침대에 사이즈 옵션 추가 (product_id = 14)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('싱글', 5000, 14, 1);  -- 기본 가격 + 5000원
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('퀸', 10000, 14, 1);  -- 기본 가격 + 10000원
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 15000, 14, 1);  -- 기본 가격 + 15000원

-- 한샘 침대에 컬러 옵션 추가 (product_id = 15)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 15, 2);  -- 기본 가격
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 15, 2);  -- 기본 가격 + 5000원

-- 시몬스 침대에 컬러 옵션 추가 (product_id = 16)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 16, 2);  -- 기본 가격
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 16, 2);  -- 기본 가격 + 5000원

-- 에이스 침대에 사이즈 옵션 추가 (product_id = 17)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('싱글', 5000, 17, 1);  -- 기본 가격 + 5000원
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('퀸', 10000, 17, 1);  -- 기본 가격 + 10000원
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 15000, 17, 1);  -- 기본 가격 + 15000원

-- 한샘 침대에 컬러 옵션 추가 (product_id = 18)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 18, 2);  -- 기본 가격
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 18, 2);  -- 기본 가격 + 5000원

-- 시몬스 침대에 컬러 옵션 추가 (product_id = 19)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 19, 2);  -- 기본 가격
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 19, 2);  -- 기본 가격 + 5000원

-- 에이스 침대에 사이즈 옵션 추가 (product_id = 20)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('싱글', 5000, 20, 1);  -- 기본 가격 + 5000원
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('퀸', 10000, 20, 1);  -- 기본 가격 + 10000원
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 15000, 20, 1);  -- 기본 가격 + 15000원

-- 한샘 침대에 컬러 옵션 추가 (product_id = 21)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 21, 2);  -- 기본 가격
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 21, 2);  -- 기본 가격 + 5000원

-- 시몬스 침대에 컬러 옵션 추가 (product_id = 22)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 22, 2);  -- 기본 가격
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 22, 2);  -- 기본 가격 + 5000원

-- 에이스 침대에 사이즈 옵션 추가 (product_id = 23)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('싱글', 5000, 23, 1);  -- 기본 가격 + 5000원
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('퀸', 10000, 23, 1);  -- 기본 가격 + 10000원
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 15000, 23, 1);  -- 기본 가격 + 15000원
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
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity)
VALUES (1, 'merchant_001', 1000000,2);

-- user_id = 2 사용자가 주문한 경우
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity)
VALUES (2, 'merchant_002', 450000,1);

-- user_id = 3 사용자가 주문한 경우
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity)
VALUES (3, 'merchant_003', 1800000,3);

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



-- user_id = 1 ~ 3의 사용자가 다양한 주문을 한 경우
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (1, 'merchant_004', 450000, 1);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (2, 'merchant_005', 900000, 2);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (3, 'merchant_006', 1800000, 3);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (1, 'merchant_007', 300000, 1);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (2, 'merchant_008', 150000, 1);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (3, 'merchant_009', 500000, 2);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (1, 'merchant_010', 900000, 2);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (2, 'merchant_011', 450000, 1);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (3, 'merchant_012', 600000, 1);
INSERT INTO order_tb (user_id, partner_order_id, total_amount, quantity) VALUES (1, 'merchant_013', 900000, 3);


-- 결제 내역에 대한 더미 데이터 (각 주문별 결제 내역)
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (4, 'imp_004', 'abcdefg', 450000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (5, 'imp_005', 'abcdefg', 900000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (6, 'imp_006', 'abcdefg', 1800000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (7, 'imp_007', 'abcdefg', 300000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (8, 'imp_008', 'abcdefg', 150000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (9, 'imp_009', 'abcdefg', 500000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (10, 'imp_010', 'abcdefg', 900000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (11, 'imp_011', 'abcdefg', 450000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (12, 'imp_012', 'abcdefg', 600000);
INSERT INTO payment_tb (order_id, tid, pg_token, total_amount) VALUES (13, 'imp_013', 'abcdefg', 900000);

-- 주문 상세 내역 (각 주문에 대한 상품 수량과 가격 정보)
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (4, 1, 1, 450000, 450000);  -- 주문 4: 시몬스 침대 매트리스 싱글 1개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (5, 2, 2, 450000, 900000);  -- 주문 5: 에이스 침대 매트리스 퀸 2개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (6, 3, 3, 600000, 1800000);  -- 주문 6: 한샘 킹사이즈 침대 3개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (7, 4, 1, 300000, 300000);  -- 주문 7: 시디즈 사무용 의자 1개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (8, 5, 1, 150000, 150000);  -- 주문 8: 듀오백 학생용 의자 1개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (9, 6, 2, 250000, 500000);  -- 주문 9: 퍼시스 사무용 의자 2개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (10, 1, 2, 450000, 900000);  -- 주문 10: 시몬스 침대 매트리스 싱글 2개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (11, 2, 1, 450000, 450000);  -- 주문 11: 에이스 침대 매트리스 퀸 1개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (12, 3, 1, 600000, 600000);  -- 주문 12: 한샘 킹사이즈 침대 1개
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (13, 4, 3, 300000, 900000);  -- 주문 13: 시디즈 사무용 의자 3개


-- 장바구니에 상품이 추가된 더미 데이터
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (1, 1, 1, 450000, 450000);  -- user_id = 1이 시몬스 침대 매트리스 싱글 1개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (2, 2, 2, 450000, 900000);  -- user_id = 2가 에이스 침대 매트리스 퀸 2개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (3, 3, 3, 600000, 1800000);  -- user_id = 3이 한샘 킹사이즈 침대 3개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (1, 4, 1, 300000, 300000);  -- user_id = 1이 시디즈 사무용 의자 1개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (2, 5, 1, 150000, 150000);  -- user_id = 2가 듀오백 학생용 의자 1개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (3, 6, 2, 250000, 500000);  -- user_id = 3이 퍼시스 사무용 의자 2개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (1, 1, 2, 450000, 900000);  -- user_id = 1이 시몬스 침대 매트리스 싱글 2개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (2, 2, 1, 450000, 450000);  -- user_id = 2가 에이스 침대 매트리스 퀸 1개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (3, 3, 1, 600000, 600000);  -- user_id = 3이 한샘 킹사이즈 침대 1개를 장바구니에 추가
INSERT INTO cart_tb (user_id, product_id, count, price, total_price)
VALUES (1, 4, 3, 300000, 900000);  -- user_id = 1이 시디즈 사무용 의자 3개를 장바구니에 추가

INSERT INTO ready_tb (cid, tax_free_amount, approval_url, cancel_url, fail_url)
VALUES ('TC0ONETIME',0,'http://125.134.184.240:8080/pay/success','http://125.134.184.240:8080/pay/cancel','http://125.134.184.240:8080/pay/fail');

-- 주문 4 (order_id = 4)에서 시몬스 침대 매트리스 퀸을 3개 구매
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (4, 1, 3, 500000, 1500000);

-- 주문 5 (order_id = 5)에서 에이스 침대 매트리스 킹을 2개 구매
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (5, 3, 2, 1200000, 2400000);

-- 주문 6 (order_id = 6)에서 한샘 침대 킹사이즈를 1개 구매
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (6, 2, 1, 800000, 800000);

-- 추가 침대 관련 주문 7~10
INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (7, 1, 2, 500000, 1000000);

INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (8, 2, 1, 800000, 800000);

INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (9, 3, 3, 1200000, 3600000);

INSERT INTO orderdetail_tb (order_id, product_id, count, price, total_price)
VALUES (10, 1, 2, 450000, 900000);


-- 시몬스 침대 관련 옵션 추가 (사이즈 및 컬러)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('싱글', 5000, 1, 1);  -- 시몬스 침대 - 싱글 사이즈
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('퀸', 10000, 1, 1);  -- 시몬스 침대 - 퀸 사이즈
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 15000, 1, 1);  -- 시몬스 침대 - 킹 사이즈

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 1, 2);  -- 시몬스 침대 - 화이트 컬러
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 1, 2);  -- 시몬스 침대 - 블랙 컬러

-- 에이스 침대 관련 옵션 추가 (사이즈 및 컬러)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('싱글', 5000, 2, 1);  -- 에이스 침대 - 싱글 사이즈
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('퀸', 10000, 2, 1);  -- 에이스 침대 - 퀸 사이즈
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 15000, 2, 1);  -- 에이스 침대 - 킹 사이즈

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 2, 2);  -- 에이스 침대 - 화이트 컬러
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 2, 2);  -- 에이스 침대 - 블랙 컬러

-- 한샘 침대 관련 옵션 추가 (사이즈 및 컬러)
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('킹', 20000, 3, 1);  -- 한샘 침대 - 킹 사이즈
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('더블', 10000, 3, 1);  -- 한샘 침대 - 더블 사이즈

INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('화이트', 0, 3, 2);  -- 한샘 침대 - 화이트 컬러
INSERT INTO option_tb (content, price, product_id, option_type_id)
VALUES ('블랙', 5000, 3, 2);  -- 한샘 침대 - 블랙 컬러

-- 시몬스 침대 게시물에 대한 추가 사진 (detail)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/simmons_king_main.jpg', 'main', 1);
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/simmons_king_thumb.jpg', 'thumbnail', 1);
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/simmons_king_detail1.jpg', 'detail', 1);

-- 에이스 침대 게시물에 대한 추가 사진 (detail)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/ace_single_main.jpg', 'main', 2);
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/ace_single_thumb.jpg', 'thumbnail', 2);
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/ace_single_detail1.jpg', 'detail', 2);

-- 한샘 침대 게시물에 대한 추가 사진 (detail)
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/hanssem_king_main.jpg', 'main', 3);
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/hanssem_king_thumb.jpg', 'thumbnail', 3);
INSERT INTO photo_tb (url, type, post_id)
VALUES ('https://example.com/hanssem_king_detail1.jpg', 'detail', 3);

