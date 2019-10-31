/*
Navicat MySQL Data Transfer

Source Server         : S2
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : word_write

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-10-31 09:00:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '分数序号',
  `stuid` varchar(500) DEFAULT NULL COMMENT '学生id',
  `stuclass` int(11) DEFAULT NULL COMMENT '学生班级id',
  `mark` double DEFAULT NULL COMMENT '学生分数',
  `markdate` date DEFAULT NULL COMMENT '分数日期',
  `isflag` int(11) DEFAULT NULL COMMENT '是否发送给家长',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `pnum` varchar(500) DEFAULT NULL COMMENT '试卷号',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目号',
  `pnum` varchar(500) DEFAULT NULL COMMENT '试卷号',
  `wordid` int(11) DEFAULT NULL COMMENT '单词序号',
  `pdate` date DEFAULT NULL COMMENT '试卷日期',
  `classid` int(11) DEFAULT NULL COMMENT '考试班级',
  `username` varchar(500) DEFAULT NULL COMMENT '出题人',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `url` varchar(128) DEFAULT NULL COMMENT '接口路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `description` varchar(64) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stuclass
-- ----------------------------
DROP TABLE IF EXISTS `stuclass`;
CREATE TABLE `stuclass` (
  `classid` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(500) NOT NULL,
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuid` varchar(200) NOT NULL COMMENT '学生id',
  `stuclass` int(255) NOT NULL COMMENT '学生班级id',
  `stuname` varchar(500) NOT NULL COMMENT '学生姓名',
  `stupwd` varchar(100) NOT NULL,
  `stuphone` varchar(16) DEFAULT NULL COMMENT '学生手机号',
  `parphone` varchar(16) DEFAULT NULL COMMENT '家长手机号',
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `stuclass` int(255) DEFAULT NULL COMMENT '班级id',
  `tname` varchar(500) NOT NULL COMMENT '教师姓名',
  `tpwd` varchar(100) NOT NULL,
  `tphone` varchar(16) DEFAULT NULL COMMENT '教师手机号',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(128) DEFAULT NULL COMMENT '用户名',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL,
  `salt` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `remarks` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for worda
-- ----------------------------
DROP TABLE IF EXISTS `worda`;
CREATE TABLE `worda` (
  `wordid` int(11) NOT NULL AUTO_INCREMENT COMMENT '单词序号',
  `wordmeaning` varchar(500) DEFAULT NULL COMMENT '汉语意思',
  `word` varchar(500) DEFAULT NULL COMMENT '单词',
  PRIMARY KEY (`wordid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for writea
-- ----------------------------
DROP TABLE IF EXISTS `writea`;
CREATE TABLE `writea` (
  `writeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '题目号',
  `writeword` varchar(500) DEFAULT NULL COMMENT '默写单词',
  `isyes` int(11) DEFAULT NULL COMMENT '默写是否正确',
  `writedate` date DEFAULT NULL COMMENT '默写日期',
  `stuid` varchar(500) DEFAULT NULL COMMENT '学生ID',
  `stuclass` int(11) DEFAULT NULL COMMENT '学生班级id',
  `pnum` varchar(500) DEFAULT NULL COMMENT '试卷号',
  PRIMARY KEY (`writeid`)
) ENGINE=InnoDB AUTO_INCREMENT=8879 DEFAULT CHARSET=utf8;
