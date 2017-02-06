/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ejb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-02-05 23:02:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carro`
-- ----------------------------
DROP TABLE IF EXISTS `carro`;
CREATE TABLE `carro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(255) DEFAULT NULL,
  `placa` varchar(7) DEFAULT NULL,
  `fk_modelo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4lce1yidaktfg4t9m3eaqqeod` (`fk_modelo`),
  CONSTRAINT `FK4lce1yidaktfg4t9m3eaqqeod` FOREIGN KEY (`fk_modelo`) REFERENCES `modelo` (`id`),
  CONSTRAINT `fk_modelo` FOREIGN KEY (`fk_modelo`) REFERENCES `modelo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carro
-- ----------------------------
INSERT INTO `carro` VALUES ('1', 'TRACKER', 'FJC1090', '1');
INSERT INTO `carro` VALUES ('2', 'GOL', 'GCB6354', '7');
INSERT INTO `carro` VALUES ('3', 'BLAZER', 'KJU3265', '1');
INSERT INTO `carro` VALUES ('4', 'FOCUS', 'KOI2365', '2');
INSERT INTO `carro` VALUES ('5', 'KA', 'KIB3699', '2');
INSERT INTO `carro` VALUES ('6', 'FOCUS', 'NBK3299', '2');

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for `modelo`
-- ----------------------------
DROP TABLE IF EXISTS `modelo`;
CREATE TABLE `modelo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of modelo
-- ----------------------------
INSERT INTO `modelo` VALUES ('1', 'GM');
INSERT INTO `modelo` VALUES ('2', 'FORD');
INSERT INTO `modelo` VALUES ('3', 'HYUMDAI');
INSERT INTO `modelo` VALUES ('4', 'TOYOTA');
INSERT INTO `modelo` VALUES ('5', 'FIAT');
INSERT INTO `modelo` VALUES ('6', 'KIA');
INSERT INTO `modelo` VALUES ('7', 'WOLKSWAGEM');
