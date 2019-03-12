/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : ssm-demo

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 12/03/2019 17:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sy_company
-- ----------------------------
DROP TABLE IF EXISTS `sy_company`;
CREATE TABLE `sy_company`  (
  `companyId` bigint(20) UNSIGNED NOT NULL COMMENT '用户ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆用户名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
  `companyName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `companyType` tinyint(4) NOT NULL COMMENT '用户类型：1、管理员；2、生产商；3、出口商、4、进口商；5、代理商、6、经销商；',
  `companyContactsName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `companyContactsTel` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人电话',
  `companyContactsEmail` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人邮箱',
  `companyContactsMobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人手机',
  `companyWorkAddress` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业办公地址',
  `companyRegisterAddress` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业注册地址',
  `companyLegal` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业法人',
  `companyLegalTel` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业法人手机',
  `companyLicenseImg` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照',
  `companyComment` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastOpTime` datetime(0) NULL DEFAULT NULL COMMENT '最后一次操作时间',
  `companyStatus` tinyint(4) NULL DEFAULT 1 COMMENT '企业状态：1-未激活；2-正常；3-禁用',
  PRIMARY KEY (`companyId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sy_company
-- ----------------------------
INSERT INTO `sy_company` VALUES (96824775296417832, 'admin', '202CB962AC59075B964B07152D234B70', '成都贸易', 4, '张三', '', '13666160551@qq.com', '13666160556', '123', '123', '123', '13666160556', NULL, NULL, '2016-10-21 16:51:53', '2016-12-14 16:05:28', 0);

SET FOREIGN_KEY_CHECKS = 1;
