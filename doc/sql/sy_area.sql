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

 Date: 12/03/2019 17:46:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sy_area
-- ----------------------------
DROP TABLE IF EXISTS `sy_area`;
CREATE TABLE `sy_area`  (
  `areaId` bigint(20) UNSIGNED NOT NULL COMMENT '国家ID',
  `areaNameCn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '国家中文名称',
  `areaNameEn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '国家英文名称',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`areaId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sy_area
-- ----------------------------
INSERT INTO `sy_area` VALUES (96824775296417791, '中国台湾', 'Chinese TaiWan', '2016-10-19 11:07:19', '2016-10-26 23:45:42');
INSERT INTO `sy_area` VALUES (96824775296417793, '中国', 'Chinese', '2016-10-19 11:09:56', '2016-10-26 23:45:55');
INSERT INTO `sy_area` VALUES (96824775296417794, '日本', 'Jp', '2016-10-19 11:11:21', '2016-10-26 23:52:33');
INSERT INTO `sy_area` VALUES (96824775296417795, '美国', 'En', '2016-10-19 11:11:21', NULL);
INSERT INTO `sy_area` VALUES (96824775296417796, '德国', 'DE', '2016-10-19 11:11:21', '2016-10-26 23:54:52');
INSERT INTO `sy_area` VALUES (96824775296417797, '加拿大', 'JiaNaDa', '2016-10-19 12:49:38', '2016-11-12 15:01:23');
INSERT INTO `sy_area` VALUES (96824775296417799, '123', 'Jia', '2016-10-19 12:50:30', '2016-11-12 14:38:54');
INSERT INTO `sy_area` VALUES (96824775296417817, '印度', 'IND', '2016-10-19 13:15:49', '2016-11-12 14:38:50');
INSERT INTO `sy_area` VALUES (96824775296417818, '荷兰', 'AS', '2016-10-19 16:06:31', '2016-10-28 14:42:32');
INSERT INTO `sy_area` VALUES (96824775296417823, '澳大利亚', 'ASTY', '2016-10-20 15:22:29', '2016-10-28 14:42:40');
INSERT INTO `sy_area` VALUES (96824775296417825, '澳大利亚', 'ASAS', '2016-10-20 15:23:04', '2016-10-28 14:16:47');
INSERT INTO `sy_area` VALUES (96824775296417828, '澳大利亚', 'Australia', '2016-10-20 15:24:56', '2016-10-28 14:17:18');
INSERT INTO `sy_area` VALUES (96824775296417829, '澳大利亚', 'Australia', '2016-10-20 15:25:52', '2016-10-28 14:58:23');
INSERT INTO `sy_area` VALUES (96824775296417967, '印度', 'YinDU', '2016-10-26 23:36:10', '2016-10-28 15:52:48');
INSERT INTO `sy_area` VALUES (96824775296417993, '美国', 'ACC', '2016-10-28 15:54:00', '2016-11-16 08:51:42');
INSERT INTO `sy_area` VALUES (96897123584311296, '', '', '2016-12-01 14:28:43', NULL);
INSERT INTO `sy_area` VALUES (96897123584311298, '', '', '2016-12-01 14:29:04', NULL);
INSERT INTO `sy_area` VALUES (96897123584321321, '', '', '2016-12-01 14:29:17', NULL);
INSERT INTO `sy_area` VALUES (96897123584321322, '96897123584321323', '', '2016-12-01 14:40:12', NULL);
INSERT INTO `sy_area` VALUES (96915984698310658, '', '', '2016-12-14 15:31:35', NULL);

SET FOREIGN_KEY_CHECKS = 1;
