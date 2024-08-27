CREATE TABLE `Post` (
	`post_id`	bigint(20)	NOT NULL,
	`title`	varchar(255)	NOT NULL,
	`created_at`	timestamp	NOT NULL,
	`views`	timestamp	NOT NULL,
	`description`	varchar(255)	NOT NULL,
	`main_image_url`	varchar(255)	NULL,
	`video_url`	varchar(255)	NULL,
	`serving`	int	NULL,
	`cook_time`	int	NULL,
	`difficulty`	decimal(2,1)	NOT NULL,
	`tip`	varchar(255)	NULL,
	`user_id`	bigint(20)	NOT NULL
);

CREATE TABLE `Category` (
	`category_id`	bigint(20)	NOT NULL,
	`type`	varchar(255)	NOT NULL,
	`value`	varchar(255)	NOT NULL,
	`post_id`	bigint(20)	NOT NULL
);

CREATE TABLE `Ingredient` (
	`ingredient_id`	bigint(20)	NOT NULL,
	`name`	varchar(255)	NOT NULL,
	`type`	varchar(255)	NOT NULL,
	`quantity`	int	NOT NULL,
	`unit`	int	NOT NULL,
	`post_id`	bigint(20)	NOT NULL
);

CREATE TABLE `Recipe` (
	`recipe_id`	bigint(20)	NOT NULL,
	`step`	int	NOT NULL,
	`image_url`	varchar(255)	NULL,
	`description`	varchar(255)	NOT NULL,
	`post_id`	bigint(20)	NOT NULL
);

CREATE TABLE `CookingTag` (
	`tag_id`	bigint(20)	NOT NULL,
	`name`	varchar(255)	NOT NULL,
	`post_id`	bigint(20)	NOT NULL
);

CREATE TABLE `CookingImage` (
	`image_id`	bigint(20)	NOT NULL,
	`image_url`	varchar(255)	NOT NULL,
	`post_id`	bigint(20)	NOT NULL
);

CREATE TABLE `User` (
	`user_id`	bigint(20)	NOT NULL,
	`login_id`	bigint(20)	NOT NULL,
	`username`	varchar(255)	NOT NULL,
	`password`	varchar(255)	NOT NULL,
	`status`	varchar(255)	NOT NULL,
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL,
	`role`	varchar(100)	NOT NULL
);

CREATE TABLE `Comment` (
	`comment_id`	bigint(20)	NOT NULL,
	`content`	varchar(255)	NOT NULL,
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NOT NULL,
	`post_id`	bigint(20)	NOT NULL,
	`user_id`	bigint(20)	NOT NULL
);

ALTER TABLE `Post` ADD CONSTRAINT `PK_POST` PRIMARY KEY (
	`post_id`
);

ALTER TABLE `Category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`category_id`
);

ALTER TABLE `Ingredient` ADD CONSTRAINT `PK_INGREDIENT` PRIMARY KEY (
	`ingredient_id`
);

ALTER TABLE `Recipe` ADD CONSTRAINT `PK_RECIPE` PRIMARY KEY (
	`recipe_id`
);

ALTER TABLE `CookingTag` ADD CONSTRAINT `PK_COOKINGTAG` PRIMARY KEY (
	`tag_id`
);

ALTER TABLE `CookingImage` ADD CONSTRAINT `PK_COOKINGIMAGE` PRIMARY KEY (
	`image_id`
);

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `Comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`comment_id`
);

