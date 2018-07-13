/*
Navicat MySQL Data Transfer

Source Server         : 阿Q_75
Source Server Version : 50722
Source Host           : 100.100.100.75:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-13 15:04:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `isCheck` int(11) NOT NULL DEFAULT '1' COMMENT '是否选中 0 未选中, 1选中',
  `goodsId` int(11) NOT NULL COMMENT '商品id',
  `goodsSpacid` varchar(255) NOT NULL COMMENT '商品-规格ID',
  `cartNum` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  PRIMARY KEY (`cartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for configs
-- ----------------------------
DROP TABLE IF EXISTS `configs`;
CREATE TABLE `configs` (
  `configId` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(255) DEFAULT '' COMMENT '字段名称	',
  `itemCode` varchar(255) DEFAULT '' COMMENT '字段代码',
  `itemValue` varchar(255) DEFAULT '' COMMENT '字段值',
  PRIMARY KEY (`configId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of configs
-- ----------------------------

-- ----------------------------
-- Table structure for express
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express` (
  `expressId` int(11) NOT NULL AUTO_INCREMENT,
  `expressName` varchar(255) DEFAULT '' COMMENT '快递名称',
  `dataFlag` int(11) DEFAULT '1' COMMENT '删除标志	1：有效 -1：删除',
  PRIMARY KEY (`expressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of express
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsSn` varchar(255) DEFAULT '' COMMENT '商品编号',
  `productNo` varchar(20) DEFAULT '' COMMENT '商品货号',
  `goodsName` varchar(255) DEFAULT '' COMMENT '商品名称',
  `goodsImg` varchar(255) DEFAULT '' COMMENT '商品图片',
  `warnStock` int(11) DEFAULT '0' COMMENT '预警库存',
  `goodsStock` int(11) DEFAULT '0' COMMENT '商品总库存',
  `goodsUnit` varchar(255) DEFAULT '' COMMENT '单位',
  `goodsTips` varchar(500) DEFAULT '' COMMENT '促销信息',
  `isSale` int(11) DEFAULT '1' COMMENT '是否上架 0 不上架, 1 上架',
  `isBest` int(11) DEFAULT '0' COMMENT '是否精品	0:否 1:是',
  `isHot` int(11) DEFAULT '0' COMMENT '是否热销产品	0:否 1:是',
  `isNew` int(11) DEFAULT '0' COMMENT '是否新品	0:否 1:是',
  `isRecom` int(11) DEFAULT '0' COMMENT '是否推荐',
  `goodsDesc` varchar(500) DEFAULT '' COMMENT '商品描述',
  `goodsStatus` int(11) DEFAULT '0' COMMENT '商品状态	-1:违规 0:未审核 1:已审核',
  `saleNum` int(11) DEFAULT '0' COMMENT '总销售量',
  `saleTime` datetime DEFAULT NULL COMMENT '上架时间',
  `visitNum` int(11) DEFAULT '0' COMMENT '访问数',
  `commentNum` int(11) DEFAULT '0' COMMENT '评价数',
  `isSpec` int(11) DEFAULT '0' COMMENT '是否有规格	0:没有 1:有',
  `gallery` text COMMENT '商品相册',
  `goodsSeoKeywords` varchar(255) DEFAULT '' COMMENT '商品SEO关键字',
  `illegalRemarks` varchar(255) DEFAULT '' COMMENT '状态说明	一般用于说明拒绝原因',
  `dataFlag` int(11) DEFAULT '1' COMMENT '删除标志	-1:删除 1:有效',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for goods_comment
-- ----------------------------
DROP TABLE IF EXISTS `goods_comment`;
CREATE TABLE `goods_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT '0',
  `goodsId` int(11) DEFAULT '0',
  `goodsSpecId` int(11) DEFAULT '0' COMMENT '商品-规格id',
  `userId` int(11) DEFAULT '0',
  `goodsScore` int(11) DEFAULT '0' COMMENT '商品评分',
  `serviceScore` int(11) DEFAULT '0' COMMENT '服务评分',
  `timeScore` int(11) DEFAULT '0' COMMENT '时效评分',
  `content` text COMMENT '点评内容',
  `shopReply` text COMMENT '店铺回复',
  `images` text COMMENT '上传图片',
  `isShow` int(11) DEFAULT '1' COMMENT '是否显示	1:显示 0:隐藏	',
  `dataFlag` int(11) DEFAULT '1' COMMENT '有效状态	1:有效 -1:无效',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `replyTime` datetime DEFAULT NULL COMMENT '商家回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_comment
-- ----------------------------

-- ----------------------------
-- Table structure for goods_specs
-- ----------------------------
DROP TABLE IF EXISTS `goods_specs`;
CREATE TABLE `goods_specs` (
  `id` int(11) NOT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `productNo` varchar(255) DEFAULT NULL,
  `specIds` varchar(255) DEFAULT '' COMMENT '规格id格式specId:specId:specId:specId:specId',
  `marketPrice` decimal(10,2) DEFAULT NULL,
  `specPrice` decimal(10,2) DEFAULT NULL,
  `specStock` int(11) DEFAULT '0' COMMENT '库存',
  `warnStock` int(11) DEFAULT '0' COMMENT '预警值',
  `saleNum` int(11) DEFAULT NULL,
  `isDefault` int(11) DEFAULT '0' COMMENT '默认规格	1：默认规格 0：非默认规格',
  `dataFlag` int(11) DEFAULT '1' COMMENT '有效状态	1:有效 -1:无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_specs
-- ----------------------------

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `imgId` int(11) NOT NULL AUTO_INCREMENT,
  `fromType` int(11) DEFAULT '0' COMMENT '来自哪	0：商家/用户 1：平台管理员',
  `dataId` int(11) DEFAULT '0' COMMENT '对象ID	该图片信息所在表的Id',
  `imgPath` varchar(500) DEFAULT '' COMMENT '图片路径',
  `imgSize` int(11) DEFAULT '0' COMMENT '图片大小	单位：字节',
  `isUse` int(11) DEFAULT '1' COMMENT '是否有使用	1:是 0：否',
  `createTime` datetime DEFAULT NULL,
  `fromTable` varchar(255) DEFAULT '' COMMENT '来自哪张表	该记录所在表',
  `ownId` int(11) DEFAULT '0' COMMENT '上传者Id',
  `dataFlag` int(11) DEFAULT '1' COMMENT '删除标志	-1:删除 1:有效',
  PRIMARY KEY (`imgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of images
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT '-2' COMMENT '订单状态 -3:用户拒收 -2:未付款的订单 -1：用户取消 0:待发货 1:配送中 2:用户确认收货',
  `goodsId` int(11) DEFAULT NULL,
  `goodsMoney` decimal(10,2) DEFAULT '0.00' COMMENT '商品总金额	商品总价格--未进行任何折扣的总价格',
  `deliverType` int(11) DEFAULT '0' COMMENT '收货方式	0:送货上门 1:自提',
  `deliverMoney` decimal(10,2) DEFAULT '0.00' COMMENT '运费	运费规则按照每家店的规则算。',
  `realTotalMoney` decimal(10,2) DEFAULT '0.00' COMMENT '实际订单总金额	进行各种折扣之后的金额',
  `payType` int(11) DEFAULT '1' COMMENT '支付方式	0:货到付款 1:在线支付	',
  `payFrom` int(11) DEFAULT '0' COMMENT '支付来源	1:支付宝，2：微信',
  `isPay` int(11) DEFAULT '0' COMMENT '0:未支付 1:已支付',
  `orderRemarks` varchar(255) DEFAULT '' COMMENT '订单备注',
  `orderSrc` int(11) DEFAULT '1' COMMENT '订单来源	0:商城 1:微信 2:手机版 3:安卓App 4:苹果App',
  `isRefund` int(11) DEFAULT '0' COMMENT '是否退款	0:否 1：是',
  `isComment` int(11) DEFAULT '0' COMMENT '是否点评	0:未点评 1:已点评',
  `isClosed` int(11) DEFAULT '0' COMMENT '是否订单已完结	0：未完结 1:已完结',
  `orderunique` varchar(255) DEFAULT '' COMMENT '订单流水号',
  `receiveTime` datetime DEFAULT NULL COMMENT '收货时间',
  `deliveryTime` datetime DEFAULT NULL COMMENT '发货时间',
  `expressId` int(11) DEFAULT '0' COMMENT '快递公司ID',
  `expressNo` varchar(255) DEFAULT '' COMMENT '快递号',
  `tradeNo` varchar(255) DEFAULT '' COMMENT '在线支付交易流水	',
  `dataFlag` int(11) DEFAULT '1' COMMENT '订单有效标志	-1：删除 1:有效',
  `createTime` datetime DEFAULT NULL COMMENT '下单时间',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT '',
  `name` varchar(50) DEFAULT '',
  `gender` int(11) DEFAULT '1' COMMENT '性别, 1 - 男 0- 女',
  `phone` varchar(255) DEFAULT '' COMMENT '手机号,登录账号',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `avatarUrl` varchar(255) DEFAULT '' COMMENT '头像路径',
  `nickName` varchar(255) DEFAULT '' COMMENT '昵称',
  `createTime` datetime DEFAULT NULL,
  `lastVisitTime` datetime DEFAULT NULL,
  `userStatus` int(11) DEFAULT '1' COMMENT '账号状态	0:停用 1:启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userPhone` varchar(255) DEFAULT NULL,
  `areaIdPath` varchar(255) DEFAULT '' COMMENT '区域id路径 省Id_市Id_县Id 例如:440000_440100_440106_',
  `areaId` varchar(255) DEFAULT NULL COMMENT '最后一级区域id',
  `userAddress` varchar(255) DEFAULT '' COMMENT '详细地址',
  `isDefault` int(11) DEFAULT '0' COMMENT '是否默认地址 0 否 1 是',
  `dataFlag` int(11) DEFAULT '1' COMMENT '有效状态 1 有效 -1 无效',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_address
-- ----------------------------
