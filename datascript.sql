DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(16) NULL DEFAULT NULL,
  `last_name` VARCHAR(16) NULL DEFAULT NULL,
  `phone` VARCHAR(16) NULL DEFAULT NULL,
  `email` VARCHAR(36) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `BookingJournal`;

CREATE TABLE `BookingJournal` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NULL DEFAULT NULL,
  `room_id` BIGINT NULL DEFAULT NULL,
  `date_from` DATE(36) NULL DEFAULT NULL,
  `date_to` DATE(36) NULL DEFAULT NULL,
  `total_price` DOUBLE(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `Room`;

CREATE TABLE `Room` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `category_id` BIGINT NULL DEFAULT NULL,
  `number` VARCHAR(6) NULL DEFAULT NULL,
  `price` DOUBLE(6) NULL DEFAULT NULL,
  `available` INTEGER(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `Features`;

CREATE TABLE `Features` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(36) NULL DEFAULT NULL,
  `price` DOUBLE(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `journal2features`;

CREATE TABLE `journal2features` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `BookingJournal_id` INTEGER NULL DEFAULT NULL,
  `features_id` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `Category`;

CREATE TABLE `Category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `category_room` VARCHAR(16) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


ALTER TABLE `BookingJournal` ADD FOREIGN KEY (user_id) REFERENCES `User` (`id`);
ALTER TABLE `BookingJournal` ADD FOREIGN KEY (room_id) REFERENCES `Room` (`id`);
ALTER TABLE `Room` ADD FOREIGN KEY (category_id) REFERENCES `Category` (`id`);
ALTER TABLE `journal2features` ADD FOREIGN KEY (bookingJournal_id) REFERENCES `BookingJournal` (`id`);
ALTER TABLE `journal2features` ADD FOREIGN KEY (features_id) REFERENCES `Features` (`id`);

SELECT * FROM USER;
INSERT INTO `User` (`id`,`first_name`,`last_name`,`phone`,`email`) VALUES ('1','Sasha1','Bogush1','1969601256','sashabogush1@ukr.sfg');
INSERT INTO `User` (`id`,`first_name`,`last_name`,`phone`,`email`) VALUES ('2','Sasha2','Bogush2','2969601256','sashabogush2@ukr.sfg');
INSERT INTO `User` (`id`,`first_name`,`last_name`,`phone`,`email`) VALUES ('3','Sasha3','Bogush3','2969601256','sashabogush3@ukr.sfg');
INSERT INTO `User` (`id`,`first_name`,`last_name`,`phone`,`email`) VALUES ('4','Sasha4','Bogush4','2969601256','sashabogush4@ukr.sfg');
SELECT * FROM USER;

SELECT * FROM CATEGORY ;
INSERT INTO `CATEGORY` (`id`,`category_room`) VALUES ('1','KINGROOM');
INSERT INTO `CATEGORY` (`id`,`category_room`) VALUES ('2','LOSERROOM');
INSERT INTO `CATEGORY` (`id`,`category_room`) VALUES ('3','LUXROOM');
SELECT * FROM CATEGORY ;

SELECT * FROM FEATURES  ;
INSERT INTO `Features` (`id`,`name`,`price`) VALUES ('1','ZAVTRAK','65.33');
INSERT INTO `Features` (`id`,`name`,`price`) VALUES ('2','DINER','656.32');
INSERT INTO `Features` (`id`,`name`,`price`) VALUES ('3','UBORKA','150.96');
INSERT INTO `Features` (`id`,`name`,`price`) VALUES ('4','BAR','500.03');
SELECT * FROM FEATURES  ;

SELECT * FROM ROOM;
INSERT INTO `ROOM` (`id`,`category_id`,`number`,`price`,`available`) VALUES ('1','1','1A','32.56','1');
INSERT INTO `ROOM` (`id`,`category_id`,`number`,`price`,`available`) VALUES ('2','2','2A','362.56','0');
INSERT INTO `ROOM` (`id`,`category_id`,`number`,`price`,`available`) VALUES ('3','3','3A','2.56','1');
INSERT INTO `ROOM` (`id`,`category_id`,`number`,`price`,`available`) VALUES ('4','1','1B','62.56','0');
INSERT INTO `ROOM` (`id`,`category_id`,`number`,`price`,`available`) VALUES ('5','2','2B','32.56','1');
SELECT * FROM ROOM;

SELECT * FROM BOOKINGJOURNAL;
INSERT INTO `BOOKINGJOURNAL` (`id`,`user_id`,`room_id`,`date_from`,`date_to`,`total_price`) VALUES ('1','1','1','2019-2-1','2022-1-1','9200.01');
INSERT INTO `BOOKINGJOURNAL` (`id`,`user_id`,`room_id`,`date_from`,`date_to`,`total_price`) VALUES ('2','2','2','2019-12-1','2020-1-1','9000.01');
INSERT INTO `BOOKINGJOURNAL` (`id`,`user_id`,`room_id`,`date_from`,`date_to`,`total_price`) VALUES ('3','3','3','2018-12-1','2020-1-1','3600.01');

SELECT * FROM BOOKINGJOURNAL ;

SELECT * FROM JOURNAL2FEATURES ;
INSERT INTO `JOURNAL2FEATURES` (`id`,`bookingJournal_id`,`features_id`) VALUES ('1','1','1');
INSERT INTO `JOURNAL2FEATURES` (`id`,`bookingJournal_id`,`features_id`) VALUES ('2','2','2');
INSERT INTO `JOURNAL2FEATURES` (`id`,`bookingJournal_id`,`features_id`) VALUES ('3','3','3');
SELECT * FROM JOURNAL2FEATURES ;

select room.id, category_room, number, price, available from room
  join category
    on category.id = category_id;

select room.id, category_room, number, price, available from room
  join category
    on category.id = category_id;

select user_id, sum(total_price) from bookingjournal
group by user_id;
