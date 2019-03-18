/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3306
 Source Schema         : kp

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 18/03/2019 20:55:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `permisssionId` int(4) NOT NULL,
  `permissionName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permissionDegree` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`permisssionId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
