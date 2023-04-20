CREATE DATABASE toyproject;

GRANT ALL PRIVILEGES ON toyproject.* TO 'toyproject'@'localhost' IDENTIFIED BY 'toyprojectpw';

USE toyproject;

CREATE TABLE `account` (
	`id` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL
);

CREATE TABLE `member` (
	`nickname` VARCHAR(255) NOT NULL,
	`id` VARCHAR(255) NOT NULL,
	`mem_id` INT NOT NULL AUTO_INCREMENT,
	`mgr` VARCHAR(255) NULL DEFAULT '0'
);

CREATE TABLE `beverages` (
	`beverage` VARCHAR(255) NOT NULL,
	`type` VARCHAR(255) NOT NULL,
	`brand` VARCHAR(255) NOT NULL,
	`calories` INT NOT NULL,
	`serving_size` INT NOT NULL,
	`caffeine` INT NOT NULL
);

CREATE TABLE `Survey` (
	`beverage` VARCHAR(255) NOT NULL,
	`nickname` VARCHAR(255) NOT NULL,
	`contact` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`drink_type` VARCHAR(255) NOT NULL,
	`rating` INT NOT NULL,
	`comment` TEXT NULL COMMENT 'EX'
);
