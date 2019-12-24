/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 80018
Source Host           : 127.0.0.1:3306
Source Database       : db_cee

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2019-12-24 12:25:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for careers_info
-- ----------------------------
DROP TABLE IF EXISTS `careers_info`;
CREATE TABLE `careers_info` (
  `limit_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业年限',
  `level2_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业大类',
  `special_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业id',
  `degree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业授予学位',
  `rank_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '本科非本科专业标识',
  `view_week` varchar(255) DEFAULT NULL,
  `view_total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业代码',
  `level3_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业小类名称',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业名称',
  `rank_1` varchar(255) DEFAULT NULL,
  `rankall` varchar(255) DEFAULT NULL,
  `id` varchar(255) DEFAULT NULL,
  `level1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '本科非本科专业标识',
  `level3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业小类id',
  `level1_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '本科和非本科',
  `view_month` varchar(255) DEFAULT NULL,
  `level2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业大类id',
  PRIMARY KEY (`special_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for data_like
-- ----------------------------
DROP TABLE IF EXISTS `data_like`;
CREATE TABLE `data_like` (
  `JSESSIONID` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `like` int(4) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`like`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` varchar(255) DEFAULT NULL,
  `school_id` varchar(255) DEFAULT NULL,
  `content` mediumtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pc_career_detail
-- ----------------------------
DROP TABLE IF EXISTS `pc_career_detail`;
CREATE TABLE `pc_career_detail` (
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `rate` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `do_what` varchar(255) DEFAULT NULL,
  `is_what` varchar(255) DEFAULT NULL,
  `learn_what` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pc_impress
-- ----------------------------
DROP TABLE IF EXISTS `pc_impress`;
CREATE TABLE `pc_impress` (
  `id` varchar(255) NOT NULL,
  `special_id` varchar(255) DEFAULT NULL,
  `key_word` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pc_jobdetail_1
-- ----------------------------
DROP TABLE IF EXISTS `pc_jobdetail_1`;
CREATE TABLE `pc_jobdetail_1` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `special_id` varchar(255) DEFAULT NULL,
  `rate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pc_jobdetail_3
-- ----------------------------
DROP TABLE IF EXISTS `pc_jobdetail_3`;
CREATE TABLE `pc_jobdetail_3` (
  `int` varchar(255) NOT NULL,
  `detail_pos` varchar(255) DEFAULT NULL,
  `detail_job` varchar(255) DEFAULT NULL,
  `special_id` varchar(255) DEFAULT NULL,
  `rate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`int`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pc_specials
-- ----------------------------
DROP TABLE IF EXISTS `pc_specials`;
CREATE TABLE `pc_specials` (
  `id` varchar(255) NOT NULL,
  `school_id` varchar(255) DEFAULT NULL,
  `special_name` varchar(255) DEFAULT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for schools
-- ----------------------------
DROP TABLE IF EXISTS `schools`;
CREATE TABLE `schools` (
  `id` varchar(255) NOT NULL,
  `school_id` varchar(255) DEFAULT NULL,
  `school_name` varchar(255) DEFAULT NULL,
  `school_local` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_batch
-- ----------------------------
DROP TABLE IF EXISTS `tb_batch`;
CREATE TABLE `tb_batch` (
  `batch` varchar(255) NOT NULL,
  `data_bin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`batch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_batchs
-- ----------------------------
DROP TABLE IF EXISTS `tb_batchs`;
CREATE TABLE `tb_batchs` (
  `id` varchar(255) NOT NULL,
  `local` varchar(255) DEFAULT NULL,
  `syear` varchar(255) DEFAULT NULL,
  `batch` varchar(255) DEFAULT NULL,
  `wl` varchar(255) DEFAULT NULL,
  `MINscore` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_career
-- ----------------------------
DROP TABLE IF EXISTS `tb_career`;
CREATE TABLE `tb_career` (
  `careerID` varchar(255) NOT NULL,
  `careerName` varchar(255) DEFAULT NULL,
  `careerClasss` varchar(255) DEFAULT NULL,
  `careerClass` varchar(255) DEFAULT NULL,
  `careerClasssID` varchar(255) DEFAULT NULL,
  `careerClassID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`careerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_local
-- ----------------------------
DROP TABLE IF EXISTS `tb_local`;
CREATE TABLE `tb_local` (
  `local` varchar(255) DEFAULT NULL,
  `data_bin` varchar(255) NOT NULL,
  `localArea` varchar(255) DEFAULT NULL,
  `provinces` varchar(255) DEFAULT NULL,
  `localAreaID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`data_bin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_ps
-- ----------------------------
DROP TABLE IF EXISTS `tb_ps`;
CREATE TABLE `tb_ps` (
  `id` varchar(255) DEFAULT NULL,
  `local` varchar(255) DEFAULT NULL,
  `syear` varchar(255) DEFAULT NULL,
  `wl` varchar(255) DEFAULT NULL,
  `point` varchar(255) DEFAULT NULL,
  `sectionPerson` varchar(255) DEFAULT NULL,
  `addUpPerson` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_sc
-- ----------------------------
DROP TABLE IF EXISTS `tb_sc`;
CREATE TABLE `tb_sc` (
  `schoolID` varchar(255) NOT NULL,
  `schoolName` varchar(255) DEFAULT NULL,
  `presentationUrl` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `officialWebsite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_schools
-- ----------------------------
DROP TABLE IF EXISTS `tb_schools`;
CREATE TABLE `tb_schools` (
  `schoolID` varchar(255) NOT NULL,
  `presentationUrl` varchar(255) DEFAULT NULL,
  `schoolName` varchar(255) DEFAULT NULL,
  `officialMicroblog` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `keyDiscipline` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `master` varchar(255) DEFAULT NULL,
  `subjection` varchar(255) DEFAULT NULL,
  `doctor` varchar(255) DEFAULT NULL,
  `rests` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_school_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_school_info`;
CREATE TABLE `tb_school_info` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `belong` varchar(255) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `level_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `province_name` varchar(255) DEFAULT NULL,
  `school_nature_name` varchar(255) DEFAULT NULL,
  `school_type_name` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `school_id` varchar(255) DEFAULT NULL,
  `city_id` varchar(255) DEFAULT NULL,
  `town_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_si
-- ----------------------------
DROP TABLE IF EXISTS `tb_si`;
CREATE TABLE `tb_si` (
  `id` varchar(255) NOT NULL,
  `schoolName` varchar(255) DEFAULT NULL,
  `theTargetarea` varchar(255) DEFAULT NULL,
  `subjects` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `minimum` varchar(255) DEFAULT NULL,
  `highest` varchar(255) DEFAULT NULL,
  `average` varchar(255) DEFAULT NULL,
  `enrollment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_syear
-- ----------------------------
DROP TABLE IF EXISTS `tb_syear`;
CREATE TABLE `tb_syear` (
  `syear` varchar(255) NOT NULL,
  `data_bin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`syear`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_wl
-- ----------------------------
DROP TABLE IF EXISTS `tb_wl`;
CREATE TABLE `tb_wl` (
  `wl` varchar(255) NOT NULL,
  `data_bin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_collectc
-- ----------------------------
DROP TABLE IF EXISTS `user_collectc`;
CREATE TABLE `user_collectc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `career_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_collects
-- ----------------------------
DROP TABLE IF EXISTS `user_collects`;
CREATE TABLE `user_collects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `school_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_id
-- ----------------------------
DROP TABLE IF EXISTS `user_id`;
CREATE TABLE `user_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `useful_life` varchar(255) DEFAULT NULL,
  `begin` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
