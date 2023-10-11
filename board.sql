CREATE DATABASE BOARD;
USE BOARD;

CREATE TABLE User (
	user_email VARCHAR(50) PRIMARY KEY,
    user_password VARCHAR(20) NOT NULL,
    user_nickname VARCHAR(30) NOT NULL,
    user_phone_number VARCHAR(15) NOT NULL,
    user_address TEXT NOT NULL,
    user_profile TEXT
);

CREATE TABLE Board(
	board_number INT PRIMARY KEY AUTO_INCREMENT,
    board_title VARCHAR(200) NOT NULL,
    board_nickname TEXT NOT NULL,
    board_image TEXT,
    board_video TEXT,
    board_file TEXT,
    board_writer_email VARCHAR(50) NOT NULL,
    board_writer_profile TEXT,
    board_writer_nickname VARCHAR(30) NOT NULL,
    board_writer_date DATE NOT NULL,
    board_click_count INT DEFAULT 0,
    board_like_count INT DEFAULT 0,
    board_comment_count INT DEFAULT 0
);

CREATE TABLE PopularSearch (
	popular_term VARCHAR(200) PRIMARY KEY,
    popular_search_count INT DEFAULT 1
);

CREATE TABLE Liky (
	board_number INT NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    like_user_profile TEXT,
    like_user_nickname VARCHAR(30) NOT NULL
);

CREATE TABLE Comment (
	board_number INT NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    comment_user_profile TEXT,
    comment_user_nickname VARCHAR(30) NOT NULL,
    comment_write_data Date NOT NULL,
    comment_content TEXT NOT NULL
) 




















