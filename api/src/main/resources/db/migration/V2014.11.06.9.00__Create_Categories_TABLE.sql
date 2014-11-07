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









