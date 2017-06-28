/*
Navicat MySQL Data Transfer

Source Server         : 172.10.3.13
Source Server Version : 50522
Source Host           : 172.10.3.13:3306
Source Database       : sys_izc_dev

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-06-14 11:33:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_ucenter_user_main
-- ----------------------------
DROP TABLE IF EXISTS `sys_ucenter_user_main`;
CREATE TABLE `sys_ucenter_user_main` (
  `id` bigint(13) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '个人电子账号',
  `user_type` int(1) NOT NULL COMMENT '用户类型 （1-注册用户；2-游客用户；3-其他）',
  `user_name` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `user_mobile` bigint(11) DEFAULT NULL COMMENT '用户手机号码',
  `user_idcard` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证号码',
  `user_paypassword` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '支付密码 MD5',
  `user_password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码 md5',
  `user_realname` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `user_nick` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `user_stauts` int(1) NOT NULL DEFAULT '1' COMMENT '当前状态 (1-有效；2-无效；3-锁定；)',
  `user_images` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户头像地址',
  `user_qrcode` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户二维码地址',
  `user_token` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户手机token',
  `user_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `from_type` int(1) NOT NULL COMMENT '来源类型( 1-安卓；2-ios；3-pc；4-其他)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后一次修改时间',
  `update_by` bigint(13) DEFAULT NULL COMMENT '最后一次修改的用户id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_code_re` (`user_code`)
) ENGINE=InnoDB AUTO_INCREMENT=132686 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户信息表';
