CREATE TABLE Channels (
    channelId INT NOT NULL auto_increment,
    channelName VARCHAR(50) NOT NULL,
    alias VARCHAR(50),
    status INT NOT NULL,
    createTime DATETIME,
    PRIMARY KEY(channelId)
);

CREATE TABLE Brands (
    brandId INT NOT NULL auto_increment,
    brandName VARCHAR(50) NOT NULL,
    alias VARCHAR(50),
    status INT NOT NULL,
    createTime DATETIME,
    PRIMARY KEY(brandId)
);

CREATE TABLE Categories (
    categoryId INT NOT NULL auto_increment,
    channelId INT NOT NULL,
    categoryName VARCHAR(50) NOT NULL,
    alias VARCHAR(50),
    status INT NOT NULL,
    parentId INT NOT NULL,
    createTime DATETIME,
    PRIMARY KEY(categoryId)
);

--INSERT INTO Categories (categoryName,alias,status,createTime)
--VALUES('食用油','shiyongyou',0,'2014-10-6');
--
--INSERT INTO Categories (categoryName,alias,status,createTime)
--VALUES('牛奶','niunai',0,'2014-10-6');

INSERT INTO `Channels` (`channelId`, `channelName`, `alias`, `status`, `createTime`)
VALUES ('1', '粮油、副食、酒水', 'channel1', '0', '2014-11-09');
INSERT INTO `Channels` (`channelId`, `channelName`, `alias`, `status`, `createTime`)
VALUES ('2', '母婴、玩具', 'channel2', '0', '2014-11-09');

INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('1', '饮料冲调', '0', '0', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('1', '粮油调味', '0', '0', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('2', '尿裤', '0', '0', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('2', '奶粉', '0', '0', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('1', '饮料', '0', '1', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('1', '咖啡/奶茶', '0', '1', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('1', '方便食品', '0', '2', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('1', '调味品', '0', '2', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('2', '婴儿奶粉', '0', '4', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('2', '拉拉裤', '0', '3', '2014-11-9');
INSERT INTO `Categories` (`channelId`, `categoryName`, `status`, `parentId`, `createTime`)
VALUES ('2', '婴儿尿裤', '0', '3', '2014-11-9');






