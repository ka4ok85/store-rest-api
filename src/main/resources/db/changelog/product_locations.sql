-- liquibase formatted sql
-- changeset evgeny:9
insert into product_locations (product_id, store_id, store_location_id, quantity) values (1, 1, 1, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (2, 1, 2, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (3, 1, 3, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (4, 1, 4, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (5, 1, 5, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (6, 1, 6, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (7, 1, 7, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (8, 1, 8, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (9, 1, 9, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (10, 1, 10, 10);

insert into store_locations (id, store_id, shelf, slot, barcode) values (61, 1, 3, 3, 'barcode_1_3_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (62, 1, 3, 4, 'barcode_1_3_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (63, 1, 4, 1, 'barcode_1_4_1');
insert into store_locations (id, store_id, shelf, slot, barcode) values (64, 1, 4, 2, 'barcode_1_4_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (65, 1, 4, 3, 'barcode_1_4_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (66, 1, 4, 4, 'barcode_1_4_4');
insert into store_locations (id, store_id, shelf, slot, barcode) values (67, 1, 5, 1, 'barcode_1_5_1');
insert into store_locations (id, store_id, shelf, slot, barcode) values (68, 1, 5, 2, 'barcode_1_5_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (69, 1, 5, 3, 'barcode_1_5_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (70, 1, 5, 4, 'barcode_1_5_4');

insert into product_locations (product_id, store_id, store_location_id, quantity) values (11, 1, 61, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (12, 1, 62, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (13, 1, 63, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (14, 1, 64, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (15, 1, 65, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (16, 1, 66, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (17, 1, 67, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (18, 1, 68, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (19, 1, 69, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (20, 1, 70, 10);


insert into product_locations (product_id, store_id, store_location_id, quantity) values (1, 2, 11, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (2, 2, 12, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (3, 2, 13, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (4, 2, 14, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (5, 2, 15, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (6, 2, 16, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (7, 2, 17, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (8, 2, 18, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (9, 2, 19, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (10, 2, 20, 10);

insert into store_locations (id, store_id, shelf, slot, barcode) values (71, 2, 3, 3, 'barcode_2_3_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (72, 2, 3, 4, 'barcode_2_3_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (73, 2, 4, 1, 'barcode_2_4_1');
insert into store_locations (id, store_id, shelf, slot, barcode) values (74, 2, 4, 2, 'barcode_2_4_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (75, 2, 4, 3, 'barcode_2_4_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (76, 2, 4, 4, 'barcode_2_4_4');
insert into store_locations (id, store_id, shelf, slot, barcode) values (77, 2, 5, 1, 'barcode_2_5_1');
insert into store_locations (id, store_id, shelf, slot, barcode) values (78, 2, 5, 2, 'barcode_2_5_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (79, 2, 5, 3, 'barcode_2_5_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (80, 2, 5, 4, 'barcode_2_5_4');

insert into product_locations (product_id, store_id, store_location_id, quantity) values (11, 2, 71, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (12, 2, 72, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (13, 2, 73, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (14, 2, 74, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (15, 2, 75, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (16, 2, 76, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (17, 2, 77, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (18, 2, 78, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (19, 2, 79, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (20, 2, 80, 10);


insert into product_locations (product_id, store_id, store_location_id, quantity) values (1, 3, 21, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (2, 3, 22, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (3, 3, 23, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (4, 3, 24, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (5, 3, 25, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (6, 3, 26, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (7, 3, 27, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (8, 3, 28, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (9, 3, 29, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (10, 3, 30, 60);

insert into product_locations (product_id, store_id, store_location_id, quantity) values (11, 3, 31, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (12, 3, 32, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (13, 3, 33, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (14, 3, 34, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (15, 3, 35, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (16, 3, 36, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (17, 3, 37, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (18, 3, 38, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (19, 3, 39, 60);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (20, 3, 40, 60);


insert into product_locations (product_id, store_id, store_location_id, quantity) values (1, 4, 41, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (2, 4, 42, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (3, 4, 43, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (4, 4, 44, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (5, 4, 45, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (6, 4, 46, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (7, 4, 47, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (8, 4, 48, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (9, 4, 49, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (10, 4, 50, 10);

insert into store_locations (id, store_id, shelf, slot, barcode) values (81, 4, 3, 3, 'barcode_4_3_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (82, 4, 3, 4, 'barcode_4_3_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (83, 4, 4, 1, 'barcode_4_4_1');
insert into store_locations (id, store_id, shelf, slot, barcode) values (84, 4, 4, 2, 'barcode_4_4_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (85, 4, 4, 3, 'barcode_4_4_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (86, 4, 4, 4, 'barcode_4_4_4');
insert into store_locations (id, store_id, shelf, slot, barcode) values (87, 4, 5, 1, 'barcode_4_5_1');
insert into store_locations (id, store_id, shelf, slot, barcode) values (88, 4, 5, 2, 'barcode_4_5_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (89, 4, 5, 3, 'barcode_4_5_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (90, 4, 5, 4, 'barcode_4_5_4');

insert into product_locations (product_id, store_id, store_location_id, quantity) values (11, 4, 81, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (12, 4, 82, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (13, 4, 83, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (14, 4, 84, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (15, 4, 85, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (16, 4, 86, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (17, 4, 87, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (18, 4, 88, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (19, 4, 89, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (20, 4, 90, 10);


insert into product_locations (product_id, store_id, store_location_id, quantity) values (1, 5, 51, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (2, 5, 52, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (3, 5, 53, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (4, 5, 54, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (5, 5, 55, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (6, 5, 56, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (7, 5, 57, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (8, 5, 58, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (9, 5, 59, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (10, 5, 60, 10);

insert into store_locations (id, store_id, shelf, slot, barcode) values (91, 5, 3, 3, 'barcode_5_3_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (92, 5, 3, 4, 'barcode_5_3_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (93, 5, 4, 1, 'barcode_5_4_1');
insert into store_locations (id, store_id, shelf, slot, barcode) values (94, 5, 4, 2, 'barcode_5_4_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (95, 5, 4, 3, 'barcode_5_4_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (96, 5, 4, 4, 'barcode_5_4_4');
insert into store_locations (id, store_id, shelf, slot, barcode) values (97, 5, 5, 1, 'barcode_5_5_1');
insert into store_locations (id, store_id, shelf, slot, barcode) values (98, 5, 5, 2, 'barcode_5_5_2');
insert into store_locations (id, store_id, shelf, slot, barcode) values (99, 5, 5, 3, 'barcode_5_5_3');
insert into store_locations (id, store_id, shelf, slot, barcode) values (100, 5, 5, 4, 'barcode_5_5_4');

insert into product_locations (product_id, store_id, store_location_id, quantity) values (11, 5, 91, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (12, 5, 92, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (13, 5, 93, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (14, 5, 94, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (15, 5, 95, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (16, 5, 96, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (17, 5, 97, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (18, 5, 98, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (19, 5, 99, 10);
insert into product_locations (product_id, store_id, store_location_id, quantity) values (20, 5, 100, 10);