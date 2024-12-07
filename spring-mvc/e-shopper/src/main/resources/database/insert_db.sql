set search_path to eshopperdb;

-- Insert data into table: brand
insert into brand(name, description, is_active) values ('ACNE', 'Shop and view the latest Womenswear, Menswear, Shoes and Accessories Collection from the official Acne website.', true);
insert into brand(name, description, is_active) values ('GRÜNE ERDE', 'Massivholzmöbel, Naturmatratzen, Wohnaccessoires, Öko-Mode und Naturkosmetik aus Österreich.', true);
insert into brand(name, description, is_active) values ('ALBIRO', 'Albiro of Switzerland. Where a handshake is still worth more than any contract.', true);
insert into brand(name, description, is_active) values ('RONHILL', 'Welcome to Ronhill, the Home of British Running Products, Clubs, News and Events.', true);
insert into brand(name, description, is_active) values ('ODDMOLLY', 'Shop Odd Molly clothes online from the official Odd Molly online shop.', true);
insert into brand(name, description, is_active) values ('BOUDESTIJN', 'Rob Boudestijn heeft 10 banen functies op zijn of haar profiel.', true);
insert into brand(name, description, is_active) values ('RÖSCH CREATIVE CULTURE', 'Rosch Creative Culture Women`s Clothing at Sierra Trading Post.', true);

-- Insert data into table: category
insert into category(name, description, is_active, brand_id) values ('SPORTSWEAR', 'See what`s happening with Nike Sportswear at Nike.com.', true, '1');
insert into category(name, description, is_active, brand_id) values ('MENS', 'Shop the best Fendi collections for limited edition designer men`s fashion.', true, '2');
insert into category(name, description, is_active, brand_id) values ('WOMENS', 'The House of Dior invites you to discover the collection.', true, '3');
insert into category(name, description, is_active, brand_id) values ('KIDS', 'Shop kids clothing and baby clothes at H&M.', true, '4');
insert into category(name, description, is_active, brand_id) values ('FASHION', 'Fashion trends & style advice from Elleuk.', true, '5');
insert into category(name, description, is_active, brand_id) values ('HOUSEHOLDS', 'Household expenditure on clothing and footwear.', true, '6');
insert into category(name, description, is_active, brand_id) values ('INTERIORS', 'Furniture and interior designer.', true, '4');
insert into category(name, description, is_active, brand_id) values ('CLOTHING', 'For the well-edited wardrobe, shop Ann Taylor clothing.', true, '5');
insert into category(name, description, is_active, brand_id) values ('BAGS', 'The latest bags for women at ZARA online.', true, '6');
insert into category(name, description, is_active, brand_id) values ('SHOES', 'Boots Heels Sneakers & Athletic Shoes Flats Sandals View all', true, '7');

-- Insert data into table: product
insert into product(name, description, is_active, code, image_url, quanity, sale_off, unit_price, category_id) values ('Easy Polo Black Edition 001', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', true, 'PRD2354477908', 'product1.jpg', 11, 0, 567, 1);
insert into product(name, description, is_active, code, image_url, quanity, sale_off, unit_price, category_id) values ('Easy Polo Black Edition 002', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', true, 'PRD6737483434', 'product2.jpg', 22, 0, 987, 1);
insert into product(name, description, is_active, code, image_url, quanity, sale_off, unit_price, category_id) values ('Easy Polo Black Edition 003', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', true, 'PRD0909847347', 'product3.jpg', 33, 0, 234, 2);
insert into product(name, description, is_active, code, image_url, quanity, sale_off, unit_price, category_id) values ('Easy Polo Black Edition 004', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', true, 'PRD1276332540', 'product4.jpg', 44, 0, 786, 3);
insert into product(name, description, is_active, code, image_url, quanity, sale_off, unit_price, category_id) values ('Easy Polo Black Edition 005', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', true, 'PRD9598950099', 'product5.jpg', 55, 0, 878, 4);
insert into product(name, description, is_active, code, image_url, quanity, sale_off, unit_price, category_id) values ('Easy Polo Black Edition 006', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', true, 'PRD1424424355', 'product6.jpg', 66, 0, 998, 5);












