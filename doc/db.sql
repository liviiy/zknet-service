/*
 Navicat Premium Data Transfer

 Source Server         : 172_17_1_3
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 172.17.1.3:3306
 Source Schema         : zk_net

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 05/05/2022 21:07:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zknet_l2_token
-- ----------------------------
DROP TABLE IF EXISTS `zknet_l2_token`;
CREATE TABLE `zknet_l2_token`  (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                   `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token name',
                                   `full_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'full name',
                                   `contract_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token contract address',
                                   `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token type',
                                   `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
                                   `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
                                   PRIMARY KEY (`id`) USING BTREE,
                                   UNIQUE INDEX `idx_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
