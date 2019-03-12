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

 Date: 12/03/2019 17:46:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for task_manage
-- ----------------------------
DROP TABLE IF EXISTS `task_manage`;
CREATE TABLE `task_manage`  (
  `taskId` bigint(20) NOT NULL AUTO_INCREMENT,
  `taskTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `taskContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `taskDegree` int(1) NULL DEFAULT NULL,
  `userId` int(4) NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startTime` datetime(0) NULL DEFAULT NULL,
  `endTime` datetime(0) NULL DEFAULT NULL,
  `sendUserId` int(4) NULL DEFAULT NULL,
  `sendUserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`taskId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_manage
-- ----------------------------
INSERT INTO `task_manage` VALUES (1, '任务1', '任务1', 1, 1, 'zjwzjw', '2019-03-12 15:04:44', '2019-03-14 15:04:49', 1, 'zjwzjw');

SET FOREIGN_KEY_CHECKS = 1;
