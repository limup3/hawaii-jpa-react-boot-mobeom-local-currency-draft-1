CREATE TABLE board
(
    `board_id`    INT           NOT NULL    AUTO_INCREMENT,
    `board_name`  VARCHAR(5)    NOT NULL,
    PRIMARY KEY (board_id)
)default character set utf8 collate UTF8_GENERAL_CI;

CREATE TABLE post
(
    `post_id`       INT              NOT NULL    AUTO_INCREMENT,
    `board_id`      INT              NOT NULL,
    `reg_date`      DATETIME         NOT NULL,
    `category`      VARCHAR(10)      NOT NULL,
    `post_title`    VARCHAR(30)      NOT NULL,
    `contents`      VARCHAR(1000)    NOT NULL,
    `read_count`    INT              NOT NULL,
    `modi_date`     DATETIME         NOT NULL,
    `notice_yn`     BOOLEAN          NOT NULL,
    `delete_yn`     BOOLEAN          NOT NULL,
    `star_rating`   INT              NOT NULL,
    `comment`       VARCHAR(500)     NOT NULL,
    `recommend_id`  INT              NOT NULL,
    `user_id`       INT              NOT NULL,
    PRIMARY KEY (post_id)
)default character set utf8 collate UTF8_GENERAL_CI;

CREATE TABLE image
(
    `image_id`     INT             NOT NULL    AUTO_INCREMENT,
    `image_url`    VARCHAR(300)    NOT NULL,
    `update_date`  DATETIME        NOT NULL,
    `image_cate`   VARCHAR(10)     NOT NULL,
    `post_id`      INT             NOT NULL,
    `board_id`     INT             NOT NULL,
    PRIMARY KEY (image_id)
)default character set utf8 collate UTF8_GENERAL_CI;