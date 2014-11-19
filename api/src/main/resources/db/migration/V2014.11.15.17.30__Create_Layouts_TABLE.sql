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
    regionType INT,
    categoryIds VARCHAR(1024) NOT NULL,
    brandIds VARCHAR(1024) NOT NULL,
    PRIMARY KEY(regionId)
);

INSERT INTO `LayoutRegions` (`regionName`, `layoutId`,`regionType`, `categoryIds`, `brandIds`)
VALUES ('顶部广告区', '1', '0', '1,2', '1,2,3,3');
INSERT INTO `LayoutRegions` (`regionName`, `layoutId`,`regionType`, `categoryIds`, `brandIds`)
VALUES ('食品饮料', '1', '1', '6,7', '1,2,3,3');
INSERT INTO `LayoutRegions` (`regionName`, `layoutId`,`regionType`, `categoryIds`, `brandIds`)
VALUES ('日美化妆', '1', '1', '8,9', '1,2,3,3');


CREATE TABLE layoutContents (
    contentId INT NOT NULL auto_increment,
    layoutId INT,
    regionId INT NOT NULL,
    contentType INT,
    keyword VARCHAR(100) NOT NULL,
    url VARCHAR(1024) NOT NULL,
    imagePath VARCHAR(1024),
    PRIMARY KEY(contentId)
);

INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '1', '0', '薯片', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '1', '0', '奥利奥', '/products?keyword=奥利奥');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '2', '0', '香飘飘奶茶', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/images/20141023/qingyang.jpg');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '2', '0', '香飘飘奶茶', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/yilou_jiaozi_20141114.jpg');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '2', '0', '香飘飘奶茶', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/yilou_you_20141114.jpg');

INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '2', '1', '脉动', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '2', '1', '薯片', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '2', '1', '好丽友', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '2', '1', '奥利奥', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '2', '1', '香飘飘', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '2', '1', '饼干', '/products?keyword=薯片');

INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`,`imagePath`)
VALUES ('1', '2', '2', '防晒', '/products?keyword=奥利奥','http://img.shequ001.com/images/20141023/anqi.jpg');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`,`imagePath`)
VALUES ('1', '2', '2', '防晒', '/products?keyword=奥利奥','http://img.shequ001.com/images/20141023/maidong.jpg');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`,`imagePath`)
VALUES ('1', '2', '2', '防晒', '/products?keyword=奥利奥','http://img.shequ001.com/images/20141023/oliweilan.jpg');




INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '3', '0', '香飘飘奶茶', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/images/20141023/maile.jpg');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '3', '0', '香飘飘奶茶', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/sanlou_jiece_20141114.jpg');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '3', '0', '香飘飘奶茶', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/yilou_you_20141114.jpg');

INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '3', '1', '纸巾', '/products?keyword=薯片');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`)
VALUES ('1', '3', '1', '沐浴露', '/products?keyword=奥利奥');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '3', '2', '描洁保鲜袋', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/yilou_xppiao_20141114.jpg');
INSERT INTO `layoutContents` (`layoutId`, `regionId`, `contentType`, `keyword`, `url`, `imagePath`)
VALUES ('1', '3', '2', '消毒液', '/products?keyword=香飘飘奶茶', 'http://img.shequ001.com/shop/images/pc/shenghuo/20141114/sanlou_mjie_20141114.jpg');



CREATE TABLE SpecialProducts (
    id INT NOT NULL auto_increment,
    regionId INT NOT NULL,
    productId INT NOT NULL,
    layoutId INT,
    PRIMARY KEY(id)
);

INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '1', '1');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1','1',  '2');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '1', '1');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1','1',  '2');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '1', '1');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1','1',  '2');

INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '1', '7');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1','1',  '7');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '1', '7');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1','1',  '7');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '1', '7');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1','1',  '7');


INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '3');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '4');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '3');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '4');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '3');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '4');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '3');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '4');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '3');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '4');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '3');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '4');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '3');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '4');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '3');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '2', '4');

INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '3', '5');
INSERT INTO `SpecialProducts` (`layoutId`, `regionId`, `productId`) VALUES ('1', '3', '6');


