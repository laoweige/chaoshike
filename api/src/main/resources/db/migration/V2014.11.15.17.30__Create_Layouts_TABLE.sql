CREATE TABLE Layouts (
    layoutId INT NOT NULL auto_increment,
    shopId INT NOT NULL,
    layoutName VARCHAR(200) NOT NULL,
    layoutType INT,
    platform INT,
    createTime DATE,
    PRIMARY KEY(layoutId)
);

INSERT INTO `Layouts` (`shopId`, `layoutName`, `layoutType`, `platform`,`createTime`)
VALUES ('1', '黔西首页布局', '1', '1','2014-11-15');


CREATE TABLE LayoutRegions (
    regionId INT NOT NULL auto_increment,
    regionName VARCHAR(200) NOT NULL,
    layoutId INT,
    categoryIds VARCHAR(1024) NOT NULL,
    brandIds VARCHAR(1024) NOT NULL,
    PRIMARY KEY(regionId)
);

INSERT INTO `LayoutRegions` (`regionName`, `layoutId`, `categoryIds`, `brandIds`)
VALUES ('顶部广告区', '1', '4,5,6,7,8,9', '1,2,3,3');
INSERT INTO `LayoutRegions` (`regionName`, `layoutId`, `categoryIds`, `brandIds`)
VALUES ('食品饮料', '1', '4,5,6,7,8,9', '1,2,3,3');
INSERT INTO `LayoutRegions` (`regionName`, `layoutId`, `categoryIds`, `brandIds`)
VALUES ('日美化妆', '1', '4,5,6,7,8,9', '1,2,3,3');
INSERT INTO `LayoutRegions` (`regionName`, `layoutId`, `categoryIds`, `brandIds`)
VALUES ('家居生活', '1', '4,5,6,7,8,9', '1,2,3,3');


CREATE TABLE layoutContents (
    contentId INT NOT NULL auto_increment,
    regionId INT NOT NULL,
    contentType INT,
    keyword VARCHAR(100) NOT NULL,
    url VARCHAR(1024) NOT NULL,
    imagePath VARCHAR(1024),
    PRIMARY KEY(contentId)
);

INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '1', '薯片', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '1', '奥利奥', '/products?keyword=奥利奥');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '2', '香飘飘奶茶', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/yilou_xppiao_20141114.jpg');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`)
VALUES ('2', '1', '洁面', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`)
VALUES ('2', '1', '防晒', '/products?keyword=奥利奥');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('2', '2', '让肌肤健康清爽', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/yilou_xppiao_20141114.jpg');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`)
VALUES ('3', '1', '纸巾', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`)
VALUES ('3', '1', '沐浴露', '/products?keyword=奥利奥');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('3', '2', '描洁保鲜袋', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/yilou_xppiao_20141114.jpg');
INSERT INTO `layoutContents` (`regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('3', '2', '消毒液', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/sanlou_mjie_20141114.jpg');




CREATE TABLE AdPositions (
    positionId INT NOT NULL auto_increment,
    regionId INT NOT NULL,
    AdName VARCHAR(200) NOT NULL,
    url VARCHAR(1024) NOT NULL,
    imagePath VARCHAR(1024) NOT NULL,
    PRIMARY KEY(positionId)
);

INSERT INTO `AdPositions` (`regionId`, `AdName`, `url`, `imagePath`) VALUES ('1', 'guanggao1', '/products', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/jiaodian_dabao_20141114.jpg');
INSERT INTO `AdPositions` (`regionId`, `AdName`, `url`, `imagePath`) VALUES ('1', 'guanggao2', '/products', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/jiaodian_dabao_20141114.jpg');
INSERT INTO `AdPositions` (`regionId`, `AdName`, `url`, `imagePath`) VALUES ('2', 'guanggao3', '/products', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/jiaodian_dabao_20141114.jpg');
INSERT INTO `AdPositions` (`regionId`, `AdName`, `url`, `imagePath`) VALUES ('3', 'guanggao4', '/products', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/jiaodian_dabao_20141114.jpg');
INSERT INTO `AdPositions` (`regionId`, `AdName`, `url`, `imagePath`) VALUES ('3', 'guanggao5', '/products', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/jiaodian_dabao_20141114.jpg');
INSERT INTO `AdPositions` (`regionId`, `AdName`, `url`, `imagePath`) VALUES ('4', 'guanggao6', '/products', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/jiaodian_dabao_20141114.jpg');


CREATE TABLE SpecialProducts (
    regionId INT NOT NULL,
    productId INT NOT NULL,
    PRIMARY KEY(regionId,productId)
);

INSERT INTO `SpecialProducts` (`regionId`, `productId`) VALUES ('1', '1');
INSERT INTO `SpecialProducts` (`regionId`, `productId`) VALUES ('1', '2');
INSERT INTO `SpecialProducts` (`regionId`, `productId`) VALUES ('1', '3');
INSERT INTO `SpecialProducts` (`regionId`, `productId`) VALUES ('2', '1');
INSERT INTO `SpecialProducts` (`regionId`, `productId`) VALUES ('3', '1');
INSERT INTO `SpecialProducts` (`regionId`, `productId`) VALUES ('4', '1');


