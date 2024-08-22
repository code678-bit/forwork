/*
 Navicat Premium Data Transfer

 Source Server         : test_user
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : forwork

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 22/08/2024 13:15:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES (1, '部门1');
INSERT INTO `tb_dept` VALUES (2, '部门2');
INSERT INTO `tb_dept` VALUES (3, '部门3');
INSERT INTO `tb_dept` VALUES (4, '部门4');
INSERT INTO `tb_dept` VALUES (5, '部门5');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工单编号',
  `order_type` int(1) NOT NULL COMMENT '工单类型（0交办 1直接答复 3无效工单）',
  `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
  `handle_dept_id` int(11) NULL DEFAULT NULL COMMENT '处理部门id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `fenpai_time` datetime(0) NULL DEFAULT NULL COMMENT '分派时间',
  `is_overdue` int(1) NULL DEFAULT NULL COMMENT '是否超期（0否 1是）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '工单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (1, '12345', 0, '标题1', '正文1', 1, '2024-07-22 12:03:08', NULL, 1);
INSERT INTO `tb_order` VALUES (2, '12346', 0, '标题2', '正文2', 2, '2024-07-22 12:03:20', NULL, 0);
INSERT INTO `tb_order` VALUES (3, '12347', 0, '标题3', '正文3', 1, '2024-07-22 12:03:21', NULL, 1);
INSERT INTO `tb_order` VALUES (4, '12348', 0, '标题4', '正文4', 2, '2024-07-27 12:03:21', NULL, 0);
INSERT INTO `tb_order` VALUES (5, '12349', 0, '标题5', '正文5', 1, '2024-07-27 12:03:21', NULL, 1);
INSERT INTO `tb_order` VALUES (6, '12350', 0, '标题6', '正文6', 2, '2024-07-27 12:03:21', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
