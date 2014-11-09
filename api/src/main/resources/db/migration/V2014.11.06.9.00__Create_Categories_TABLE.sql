CREATE TABLE Shops (
    shopId INT NOT NULL auto_increment,
    shopName VARCHAR(50) NOT NULL,
    status INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(shopId)
);

CREATE TABLE Channels (
    channelId INT NOT NULL auto_increment,
    channelName VARCHAR(50) NOT NULL,
    alias VARCHAR(50),
    status INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(channelId)
);

INSERT INTO `Channels` (`channelId`, `channelName`, `alias`, `status`, `createTime`)
VALUES ('3', '粮油、副食、酒水', 'channel1', '0', '2014-11-09');
INSERT INTO `Channels` (`channelId`, `channelName`, `alias`, `status`, `createTime`)
VALUES ('4', '母婴、玩具', 'channel2', '0', '2014-11-09');


CREATE TABLE Brands (
    brandId INT NOT NULL auto_increment,
    brandName VARCHAR(50) NOT NULL,
    alias VARCHAR(50),
    status INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(brandId)
);

CREATE TABLE Categories (
    categoryId INT NOT NULL auto_increment,
    channelId INT NOT NULL,
    categoryName VARCHAR(50) NOT NULL,
    alias VARCHAR(50),
    status INT NOT NULL,
    parentId INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(categoryId)
);

INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('1', '饮料冲调', '0', '0', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('1', '粮油调味', '0', '0', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('2', '休闲食品', '0', '0', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('2', '茗茶', '0', '0', '2014-11-9');


--INSERT INTO Categories (categoryName,alias,status,createTime)
--VALUES('食用油','shiyongyou',0,'2014-10-6');
--
--INSERT INTO Categories (categoryName,alias,status,createTime)
--VALUES('牛奶','niunai',0,'2014-10-6');

CREATE TABLE Products (
    productId INT NOT NULL auto_increment,
    shopId INT NOT NULL,
    channelId INT NOT NULL,
    categoryId INT NOT NULL,
    brandId INT NOT NULL,
    productName VARCHAR(50) NOT NULL,
    summary VARCHAR(500) NOT NULL,
    description VARCHAR(4000) NOT NULL,
    imagePath VARCHAR(200) NOT NULL,
    costPrice FLOAT,
    salePrice FLOAT,
    marketPrice FLOAT,
    repertory   INT,
    status INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(productId)
);









