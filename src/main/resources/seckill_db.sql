/*
Navicat MySQL Data Transfer

Source Server         : seckill_db
Source Server Version : 80013
Source Host           : 127.0.0.1:3306
Source Database       : seckill_db

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-06-15 21:28:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `account` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商家账号',
  `merchant_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '商家名称',
  `password` varchar(70) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `phone` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  `province` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '省份',
  `city` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `area` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `merchant_address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '商家详细地址',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of merchant
-- ----------------------------
INSERT INTO `merchant` VALUES ('1', '17621007255', '一点点', '19490a64487ac43d327c27e95e4dd194', '17621007255', '上海', '上海市', '嘉定区', '上海-上海市-嘉定区-小城街', '0', '2020-05-24 10:41:46', '2020-05-24 10:41:46');

-- ----------------------------
-- Table structure for product_detail
-- ----------------------------
DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `product_id` int(20) DEFAULT NULL COMMENT '商品id',
  `product_palce` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品产地',
  `product_brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品品牌',
  `product_decsrption` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品描述',
  `product_weight` double(20,0) DEFAULT NULL COMMENT '商品重量',
  `product_detail_pciture_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品详情图片地址',
  `specification_pack` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '规格和包装',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of product_detail
-- ----------------------------
INSERT INTO `product_detail` VALUES ('1', '1', '广州', 'Adidas', '儿童精品', '10', 'www.baidu.com', '轻拿轻放', '2020-05-26 21:51:22', '2020-05-26 21:51:22');
INSERT INTO `product_detail` VALUES ('3', '2', '武夷山', '太平盛世', '特级铁观音', '10', 'www.baidu.com', '轻拿轻放', '2020-05-26 21:52:48', '2020-05-26 21:52:48');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `product_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品标题',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品名称',
  `product_picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片地址',
  `product_price` decimal(10,0) DEFAULT NULL COMMENT '商品价格',
  `product_discounts` decimal(10,0) DEFAULT NULL COMMENT '商品优惠价格',
  `mechant_id` int(20) DEFAULT NULL COMMENT '商家id',
  `product_type_id` int(20) DEFAULT NULL COMMENT '商品类型id',
  `product_inventory` bigint(20) DEFAULT NULL COMMENT '商品库存量',
  `shop_id` int(20) DEFAULT NULL COMMENT '商铺id',
  `state` int(11) DEFAULT NULL COMMENT '0申请中1审核通过2退回3上架4下架',
  `approve_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审核时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1', 'Adidas旗舰店', 'Adidas', 'www.baidu.com', '50', '26', '1', '1', '100', '1', '2', '2020-05-24 20:33:31', '2020-05-24 20:33:31', '2020-05-24 22:20:04');
INSERT INTO `product_info` VALUES ('2', '特级铁观音', '特级铁观音', 'www.baidu.com', '200', '109', '1', '2', '1000', '1', '2', '2020-05-26 21:23:59', '2020-05-26 21:23:59', '2020-05-26 21:53:24');
INSERT INTO `product_info` VALUES ('3', '特级龙井', '特级龙井', 'www.baidu.com', '200', '109', '1', '3', '1000', '1', '0', '2020-05-26 21:25:06', '2020-05-26 21:25:06', '2020-05-26 21:25:06');

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '类型名称',
  `product_type_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '类型描述',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级ID',
  `grade` int(11) DEFAULT NULL COMMENT '等级',
  `status` int(11) DEFAULT NULL COMMENT '状态：0正常 1 禁用',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', '儿童服装', '服装', '0', '0', '0', '2020-05-24 18:40:37', '2020-05-24 18:40:37');
INSERT INTO `product_type` VALUES ('2', '铁观音', '茶叶', '0', '0', '0', '2020-05-26 21:20:23', '2020-05-26 21:20:23');
INSERT INTO `product_type` VALUES ('3', '龙井', '茶叶', '0', '0', '0', '2020-05-26 21:20:38', '2020-05-26 21:20:38');
INSERT INTO `product_type` VALUES ('4', '毛尖', '茶叶', '0', '0', '0', '2020-05-26 21:20:54', '2020-05-26 21:20:54');
INSERT INTO `product_type` VALUES ('5', '猴魁', '茶叶', '0', '0', '0', '2020-05-26 21:21:01', '2020-05-26 21:21:01');
INSERT INTO `product_type` VALUES ('6', '普洱', '茶叶', '0', '0', '0', '2020-05-26 21:21:10', '2020-05-26 21:21:10');
INSERT INTO `product_type` VALUES ('7', '碧螺春', '茶叶', '0', '0', '0', '2020-05-26 21:22:02', '2020-05-26 21:22:02');

-- ----------------------------
-- Table structure for seckill_product
-- ----------------------------
DROP TABLE IF EXISTS `seckill_product`;
CREATE TABLE `seckill_product` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `product_id` int(20) DEFAULT NULL COMMENT '商品id',
  `seckill_num` int(20) DEFAULT NULL COMMENT '秒杀数量',
  `seckill_price` decimal(20,2) DEFAULT NULL COMMENT '秒杀价格',
  `seckill_inventory` int(20) DEFAULT NULL COMMENT '秒杀库存',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `shop_id` int(20) DEFAULT NULL COMMENT '商铺id',
  `state` int(11) DEFAULT NULL COMMENT '0申请中1审核通过2退回3上架4下架',
  `product_price` decimal(20,2) DEFAULT NULL COMMENT '商品价格',
  `product_title` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品title',
  `product_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品名称',
  `approve_time` datetime DEFAULT NULL COMMENT '审核时间',
  `seckill_version` int(40) DEFAULT NULL COMMENT '版本号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of seckill_product
-- ----------------------------
INSERT INTO `seckill_product` VALUES ('1', '1', '5', '60.00', '5', '2020-05-28 21:28:13', '2020-05-28 21:28:13', '1', '3', '100.00', '阿迪达斯', '阿迪达斯', '2020-05-28 21:47:31', '6', null, '2020-06-08 22:44:28');
INSERT INTO `seckill_product` VALUES ('2', '1', '2', '60.00', '7', '2020-05-28 00:24:36', '2020-06-01 00:24:36', '1', '0', '100.00', '安踏', '安踏', '2020-05-28 21:36:52', '1', '2020-05-28 21:36:52', '2020-06-08 22:36:42');

-- ----------------------------
-- Table structure for seckill_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `seckill_userinfo`;
CREATE TABLE `seckill_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户真实姓名',
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户密码',
  `id_card` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户身份证号',
  `age` int(11) DEFAULT NULL COMMENT '用户年龄',
  `birthday` datetime DEFAULT NULL COMMENT '用户生日',
  `gender` int(11) DEFAULT NULL COMMENT '用户性别： 0 男 1女',
  `we_chat` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '用户微信号',
  `qq` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '用户qq',
  `phone` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '用户手机号',
  `tel_phone` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '用户备用手机号',
  `home_address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用户详细住址',
  `status` int(11) DEFAULT NULL COMMENT '用户状态：0 正常 2 禁用',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of seckill_userinfo
-- ----------------------------
INSERT INTO `seckill_userinfo` VALUES ('1', '001', '伊羽', '凤凰小哥哥', '21d38c493657d56af373bac6ca793c2a', '411421199308236039', '27', '1993-08-23 00:00:00', '0', '1140867582', '1140867582', '17621007255', '17621007255', '河南省民权县城北关镇', '0', '2020-05-23 14:36:08', '2020-05-23 14:36:08');
INSERT INTO `seckill_userinfo` VALUES ('2', '002', '张洁', '小胖子凹凸曼', '21d38c493657d56af373bac6ca793c2a', '411421199308236039', '27', '1993-08-23 00:00:00', '0', '1140867582', '1140867582', '17621007255', '17621007255', '江苏省盐城市', '0', '2020-05-23 14:36:05', '2020-05-23 14:36:05');
INSERT INTO `seckill_userinfo` VALUES ('3', '003', '张杰', '兔牙妹妹', '21d38c493657d56af373bac6ca793c2a', '411421199308236039', '27', '1993-08-23 00:00:00', '0', '1140867582', '1140867582', '17621007255', '17621007255', '河南沈丘', '0', '2020-05-23 14:35:47', '2020-05-23 14:35:47');
INSERT INTO `seckill_userinfo` VALUES ('4', null, '17621007255', '不知道', '13c8befd9efc6411c340e5fe31b331df', '411421199008236039', '0', '2020-05-23 08:00:00', '0', '17621007255', '17621007255', '17621007255', '17621007255', '河南', null, null, null);

-- ----------------------------
-- Table structure for seckil_user_result
-- ----------------------------
DROP TABLE IF EXISTS `seckil_user_result`;
CREATE TABLE `seckil_user_result` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(20) DEFAULT NULL COMMENT '秒杀用户id',
  `product_id` int(20) DEFAULT NULL COMMENT '秒杀商品id',
  `seckill_id` int(20) DEFAULT NULL COMMENT '秒杀id',
  `result_status` int(2) DEFAULT NULL COMMENT '秒杀结果状态：0成功 1失败 2正在生成订单',
  `result_data` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '秒杀结果',
  `seckil_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀时间',
  `order_id` int(20) DEFAULT NULL COMMENT '秒杀订单号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of seckil_user_result
-- ----------------------------
INSERT INTO `seckil_user_result` VALUES ('1', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-03 22:22:47', null, null, null);
INSERT INTO `seckil_user_result` VALUES ('2', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-03 22:26:27', null, '2020-06-03 22:26:27', '2020-06-03 22:26:27');
INSERT INTO `seckil_user_result` VALUES ('3', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-03 22:26:36', null, '2020-06-03 22:26:36', '2020-06-03 22:26:36');
INSERT INTO `seckil_user_result` VALUES ('4', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-03 22:26:36', null, '2020-06-03 22:26:36', '2020-06-03 22:26:36');
INSERT INTO `seckil_user_result` VALUES ('5', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:36', null, '2020-06-03 22:26:36', '2020-06-03 22:26:36');
INSERT INTO `seckil_user_result` VALUES ('6', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:36', null, '2020-06-03 22:26:36', '2020-06-03 22:26:36');
INSERT INTO `seckil_user_result` VALUES ('7', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:37', null, '2020-06-03 22:26:37', '2020-06-03 22:26:37');
INSERT INTO `seckil_user_result` VALUES ('8', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:37', null, '2020-06-03 22:26:37', '2020-06-03 22:26:37');
INSERT INTO `seckil_user_result` VALUES ('9', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:37', null, '2020-06-03 22:26:37', '2020-06-03 22:26:37');
INSERT INTO `seckil_user_result` VALUES ('10', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:37', null, '2020-06-03 22:26:37', '2020-06-03 22:26:37');
INSERT INTO `seckil_user_result` VALUES ('11', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:37', null, '2020-06-03 22:26:37', '2020-06-03 22:26:37');
INSERT INTO `seckil_user_result` VALUES ('12', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:37', null, '2020-06-03 22:26:37', '2020-06-03 22:26:37');
INSERT INTO `seckil_user_result` VALUES ('13', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:38', null, '2020-06-03 22:26:38', '2020-06-03 22:26:38');
INSERT INTO `seckil_user_result` VALUES ('14', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:38', null, '2020-06-03 22:26:38', '2020-06-03 22:26:38');
INSERT INTO `seckil_user_result` VALUES ('15', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:26:38', null, '2020-06-03 22:26:38', '2020-06-03 22:26:38');
INSERT INTO `seckil_user_result` VALUES ('16', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-03 22:50:53', null, '2020-06-03 22:50:53', '2020-06-03 22:50:53');
INSERT INTO `seckil_user_result` VALUES ('17', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-08 22:43:23', null, '2020-06-08 22:43:23', '2020-06-08 22:43:23');
INSERT INTO `seckil_user_result` VALUES ('18', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-08 22:43:54', null, '2020-06-08 22:43:54', '2020-06-08 22:43:54');
INSERT INTO `seckil_user_result` VALUES ('19', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-08 22:44:06', null, '2020-06-08 22:44:06', '2020-06-08 22:44:06');
INSERT INTO `seckil_user_result` VALUES ('20', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-08 22:44:22', null, '2020-06-08 22:44:22', '2020-06-08 22:44:22');
INSERT INTO `seckil_user_result` VALUES ('21', '1', '1', '1', '0', '用户1秒杀成功！！', '2020-06-08 22:44:28', null, '2020-06-08 22:44:28', '2020-06-08 22:44:28');
INSERT INTO `seckil_user_result` VALUES ('22', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-08 22:44:29', null, '2020-06-08 22:44:29', '2020-06-08 22:44:29');
INSERT INTO `seckil_user_result` VALUES ('23', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-08 22:44:30', null, '2020-06-08 22:44:30', '2020-06-08 22:44:30');
INSERT INTO `seckil_user_result` VALUES ('24', '1', '1', '1', '1', '用户1秒杀失败', '2020-06-08 22:44:30', null, '2020-06-08 22:44:30', '2020-06-08 22:44:30');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) DEFAULT NULL COMMENT '商家id',
  `shop_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺名称',
  `shop_image` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺头像',
  `shop_description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺描述',
  `shop_business_scope` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `province` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '省份',
  `city` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '城市',
  `area` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `business_license` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '营业执照',
  `status` int(11) DEFAULT NULL COMMENT '状态：0申请中 1 申请通过 2 退回 3 商铺下架',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '1', '儿童国际', 'http://www.baidu.com', '上海国际儿童服装', '服装', '上海', '上海市', '静安区', 'wtt521', '0', '2020-05-24 12:12:37', '2020-05-24 12:12:40');
