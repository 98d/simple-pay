/*
Navicat MySQL Data Transfer

Source Server         : server
Source Server Version : 50616
Source Host           : rm-8vbxf7vu3j0f771s9ao.mysql.zhangbei.rds.aliyuncs.com:3306
Source Database       : cyt_carfriend

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2021-02-10 17:24:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wechat_pay_config
-- ----------------------------
DROP TABLE IF EXISTS `wechat_pay_config`;
CREATE TABLE `wechat_pay_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL,
  `wpp_app_id` varchar(32) DEFAULT NULL COMMENT '公众平台appid',
  `wpp_secret` varchar(64) DEFAULT NULL COMMENT '公众平台凭证',
  `woa_app_id` varchar(32) DEFAULT NULL COMMENT '开放平台appid',
  `woa_secret` varchar(64) DEFAULT NULL COMMENT '开放平台凭证',
  `sign_key` varchar(64) DEFAULT NULL COMMENT '签名key',
  `mchid` varchar(32) DEFAULT NULL COMMENT '商户号',
  `pk12_path` varchar(64) DEFAULT NULL COMMENT '退款证书路径',
  `refund_notify_url` varchar(256) DEFAULT NULL COMMENT '退款通知地址',
  `redirect_url` varchar(256) DEFAULT NULL COMMENT 'h5重定向地址',
  `notify_url` varchar(256) DEFAULT NULL COMMENT '回调url',
  `state` tinyint(1) DEFAULT '1' COMMENT '状态 0:禁用 1:使用',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除 0:否 1:是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
