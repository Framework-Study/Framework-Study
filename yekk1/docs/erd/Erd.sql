CREATE TABLE `BOARD` (
                         `BOARD_ID`	BIGINT	NOT NULL,
                         `MEMBER_ID`	BIGINT	NOT NULL,
                         `TITLE`	VARCHAR(255)	NOT NULL,
                         `SUBTITLE`	VARCHAR(255)	NULL,
                         `SERVING`	INT	NOT NULL,
                         `COOKING_TIME`	INT	NOT NULL,
                         `COOKING_LEVEL`	TINYINT(4)	NOT NULL	COMMENT '누구나, 중수, 고수',
                         `TIP`	VARCHAR(255)	NULL,
                         `CREATED_TIME`	TIMESTAMP	NOT NULL,
                         `MODIFIED_TIME`	TIMESTAMP	NOT NULL
);

CREATE TABLE `INGREDIENTS` (
                               `INGREDIENTS_ID`	BIGINT	NOT NULL,
                               `INGREDIENTS_DETAIL_ID`	BIGINT	NOT NULL,
                               `BOARD_ID`	BIGINT	NOT NULL,
                               `CATEGORY`	VARCHAR(255)	NOT NULL,
                               `NAME`	VARCHAR(255)	NOT NULL,
                               `AMOUNT`	INT	NULL,
                               `UNIT`	TINYINT(4)	NULL	COMMENT 'g,스푼, 개, 송이, 근',
                               `LINK`	VARCHAR(255)	NULL
);

CREATE TABLE `ORDER` (
                         `ORDER_ID`	BIGINT	NOT NULL,
                         `BOARD_ID`	BIGINT	NOT NULL,
                         `CONTENT`	LONGTEXT	NOT NULL,
                         `LINK`	VARCHAR(255)	NULL
);

CREATE TABLE `MEMBER` (
                          `MEMBER_ID`	BIGINT	NOT NULL,
                          `NICKNAME`	VARCHAR(30)	NOT NULL,
                          `PASSWORD`	VARCHAR(255)	NOT NULL
);

CREATE TABLE `COMMENT` (
                           `COMMENT_ID`	BIGINT	NOT NULL,
                           `BOARD_ID`	BIGINT	NOT NULL,
                           `MEMBER_ID`	BIGINT	NOT NULL,
                           `STAR`	TINYINT	NOT NULL	COMMENT '1,2,3,4,5',
                           `COMMENT`	TEXT	NOT NULL,
                           `CREATED_TIME`	TIMESTAMP	NOT NULL,
                           `MODIFIED_TIME`	TIMESTAMP	NOT NULL
);

CREATE TABLE `BOARD_ATTACHMENT` (
                                    `BOARD_ATTACHMENT_ID`	BIGINT	NOT NULL,
                                    `BOARD_ID`	BIGINT	NOT NULL,
                                    `UPLOAD_FILE_NAME`	VARCHAR(255)	NOT NULL,
                                    `STORE_FILE_NAME`	VARCHAR(255)	NOT NULL,
                                    `CREATED_TIME`	TIMESTAMP	NOT NULL,
                                    `MODIFIED_TIME`	TIMESTAMP	NOT NULL
);

CREATE TABLE `ORDER_ATTACHMENT` (
                                    `ORDER_ATTACHMENT_ID`	BIGINT	NOT NULL,
                                    `ORDER_ID`	BIGINT	NOT NULL,
                                    `BOARD_ID`	BIGINT	NOT NULL,
                                    `UPLOAD_FILE_NAME`	VARCHAR(255)	NOT NULL,
                                    `STORE_FILE_NAME`	VARCHAR(255)	NOT NULL,
                                    `CREATED_TIME`	TIMESTAMP	NOT NULL,
                                    `MODIFIED_TIME`	TIMESTAMP	NOT NULL
);

CREATE TABLE `COMMENT_ATTACHMENT` (
                                      `COMMENT_ATTACHMENT_ID`	BIGINT	NOT NULL,
                                      `COMMENT_ID`	BIGINT	NOT NULL,
                                      `UPLOAD_FILE_NAME`	VARCHAR(255)	NOT NULL,
                                      `STORE_FILE_NAME`	VARCHAR(255)	NOT NULL,
                                      `CREATED_TIME`	TIMESTAMP	NOT NULL,
                                      `MODIFIED_TIME`	TIMESTAMP	NOT NULL
);

ALTER TABLE `BOARD` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
                                                           `BOARD_ID`
    );

ALTER TABLE `INGREDIENTS` ADD CONSTRAINT `PK_INGREDIENTS` PRIMARY KEY (
                                                                       `INGREDIENTS_ID`,
                                                                       `INGREDIENTS_DETAIL_ID`,
                                                                       `BOARD_ID`
    );

ALTER TABLE `ORDER` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
                                                           `ORDER_ID`,
                                                           `BOARD_ID`
    );

ALTER TABLE `MEMBER` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
                                                             `MEMBER_ID`
    );

ALTER TABLE `COMMENT` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
                                                               `COMMENT_ID`
    );

ALTER TABLE `BOARD_ATTACHMENT` ADD CONSTRAINT `PK_BOARD_ATTACHMENT` PRIMARY KEY (
                                                                                 `BOARD_ATTACHMENT_ID`,
                                                                                 `BOARD_ID`
    );

ALTER TABLE `ORDER_ATTACHMENT` ADD CONSTRAINT `PK_ORDER_ATTACHMENT` PRIMARY KEY (
                                                                                 `ORDER_ATTACHMENT_ID`,
                                                                                 `ORDER_ID`,
                                                                                 `BOARD_ID`
    );

ALTER TABLE `COMMENT_ATTACHMENT` ADD CONSTRAINT `PK_COMMENT_ATTACHMENT` PRIMARY KEY (
                                                                                     `COMMENT_ATTACHMENT_ID`,
                                                                                     `COMMENT_ID`
    );

ALTER TABLE `INGREDIENTS` ADD CONSTRAINT `FK_BOARD_TO_INGREDIENTS_1` FOREIGN KEY (
                                                                                  `BOARD_ID`
    )
    REFERENCES `BOARD` (
                        `BOARD_ID`
        );

ALTER TABLE `ORDER` ADD CONSTRAINT `FK_BOARD_TO_ORDER_1` FOREIGN KEY (
                                                                      `BOARD_ID`
    )
    REFERENCES `BOARD` (
                        `BOARD_ID`
        );

ALTER TABLE `BOARD_ATTACHMENT` ADD CONSTRAINT `FK_BOARD_TO_BOARD_ATTACHMENT_1` FOREIGN KEY (
                                                                                            `BOARD_ID`
    )
    REFERENCES `BOARD` (
                        `BOARD_ID`
        );

ALTER TABLE `ORDER_ATTACHMENT` ADD CONSTRAINT `FK_ORDER_TO_ORDER_ATTACHMENT_1` FOREIGN KEY (
                                                                                            `ORDER_ID`
    )
    REFERENCES `ORDER` (
                        `ORDER_ID`
        );

ALTER TABLE `ORDER_ATTACHMENT` ADD CONSTRAINT `FK_ORDER_TO_ORDER_ATTACHMENT_2` FOREIGN KEY (
                                                                                            `BOARD_ID`
    )
    REFERENCES `ORDER` (
                        `BOARD_ID`
        );

ALTER TABLE `COMMENT_ATTACHMENT` ADD CONSTRAINT `FK_COMMENT_TO_COMMENT_ATTACHMENT_1` FOREIGN KEY (
                                                                                                  `COMMENT_ID`
    )
    REFERENCES `COMMENT` (
                          `COMMENT_ID`
        );

