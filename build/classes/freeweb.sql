CREATE USER 'freeweb'@'localhost';
SET PASSWORD FOR 'freeweb'@'localhost' = PASSWORD('freeweb');

GRANT SELECT ON freeweb.* TO 'freeweb'@'localhost';
GRANT ALL on freeweb TO 'freeweb'@'localhost';

CREATE SCHEMA `freeweb` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `freeweb`.`user_info` (
	id int(11) not null AUTO_INCREMENT COMMENT '自增id',
	login_name varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci not null COMMENT '登录用户名',
	login_pwd varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci not null COMMENT '登陆密码',
    nick_name varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci not null COMMENT '用户昵称',
	user_status int(1) not null default 0 COMMENT '0:正常, 1:冻结, 2:删除',
    primary key (id)
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表';

INSERT INTO `freeweb`.`user_info` VALUES (null, 'admin', 'admin', 'admin', 0);
INSERT INTO `freeweb`.`user_info` VALUES (null, '测试用户', '测试密码', '测试用户', default);

CREATE TABLE `freeweb`.`index_info` (
	id int(11) not null AUTO_INCREMENT COMMENT '自增id',
    class_id int(1) not null COMMENT '首页列表栏目id',
	img_url varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci not null COMMENT '图片url',
	link_url varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci not null COMMENT '链接目标url',
    img_priority int(1) not null default 3 COMMENT '图片优先级, 大则优先显示',
    primary key (id)
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '首页图片信息表';

INSERT INTO `freeweb`.`index_info` VALUES (null, 1, 'images/1.jpg', '1.do', default);
INSERT INTO `freeweb`.`index_info` VALUES (null, 1, 'images/2.jpg', '2.do', 4);
INSERT INTO `freeweb`.`index_info` VALUES (null, 1, 'images/3.jpg', '3.do', 2);
INSERT INTO `freeweb`.`index_info` VALUES (null, 2, 'images/4.jpg', '4.do', default);
INSERT INTO `freeweb`.`index_info` VALUES (null, 3, 'images/5.jpg', '5.do', default);
INSERT INTO `freeweb`.`index_info` VALUES (null, 3, 'images/6.jpg', '6.do', 0);

CREATE TABLE `freeweb`.`index_config` (
	id int(11) not null AUTO_INCREMENT COMMENT '自增id',
	conf_key varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci not null COMMENT '配置项名称',
	conf_value varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci not null COMMENT '配置项内容',
    conf_desc varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '配置项描述',
    primary key (id)
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '首页配置表';

INSERT INTO `freeweb`.`index_config` VALUES (null, 'class_img_order_1', 'sort', 'sort: 按照优先级排序, rnd: 随机选取');
INSERT INTO `freeweb`.`index_config` VALUES (null, 'class_img_num_1', '3', '每个栏目显示的图片数量');
