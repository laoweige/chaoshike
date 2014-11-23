CREATE TABLE Shops (
    shopId INT NOT NULL auto_increment,
    shopName VARCHAR(50) NOT NULL,
    status INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(shopId)
);


CREATE TABLE Products (
    productId INT NOT NULL auto_increment,
    shopId INT NOT NULL,
    channelId INT NOT NULL,
    classId INT NOT NULL,
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
    saleNum     INT,
    commentNum  INT,
    status INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(productId)
);


INSERT INTO `Products` (`shopId`, `channelId`, `classId`, `categoryId`, `brandId`,
`productName`, `summary`, `description`, `imagePath`,
`costPrice`, `salePrice`, `marketPrice`, `repertory`, `saleNum`, `commentNum`, `status`)
VALUES ('1', '1', '1', '5', '1',
'古船富强粉5kg', '双11,局限', '11',
'http://beijing.shequ001.com/public/images/ee/ec/c6/cc2037011ce9f0be621411310aaffe98.jpg?1411953639#h',
'5', '5.6', '6', '20', '2', '0', '0');

INSERT INTO `Products` (`shopId`, `channelId`, `classId`, `categoryId`, `brandId`,
`productName`, `summary`, `description`, `imagePath`,
`costPrice`, `salePrice`, `marketPrice`, `repertory`, `saleNum`, `commentNum`, `status`)
VALUES ('1', '1', '1', '5', '1',
'鲁花压榨一级花生油5.436L', '双11,局限', '11',
'http://img.shequ001.com/shop/images/goods/20130703/JLF6916168616233.jpg?0#h',
'5', '5.6', '6', '20', '2', '0', '0');

INSERT INTO `Products` (`shopId`, `channelId`, `classId`, `categoryId`, `brandId`,
`productName`, `summary`, `description`, `imagePath`,
`costPrice`, `salePrice`, `marketPrice`, `repertory`, `saleNum`, `commentNum`, `status`)
VALUES ('1', '1', '1', '6', '1',
'汰渍果香洗衣液2kg', '双11,局限', '11',
'http://img.shequ001.com/shop/beijing/tongzhou/images/goods/20140725/e285c86f8e44ea41.jpg?1406276846#h',
'5', '5.6', '6', '20', '2', '0', '0');

INSERT INTO `Products` (`shopId`, `channelId`, `classId`, `categoryId`, `brandId`,
`productName`, `summary`, `description`, `imagePath`,
`costPrice`, `salePrice`, `marketPrice`, `repertory`, `saleNum`, `commentNum`, `status`)
VALUES ('1', '1', '1', '7', '1',
'7汰渍果香洗衣液2kg', '双11,局限', '11',
'http://img.shequ001.com/shop/images/goods/20140128/JLF6903148181119.jpg?0#h',
'5', '5.6', '6', '20', '2', '0', '0');


INSERT INTO `Products` (`shopId`, `channelId`, `classId`, `categoryId`, `brandId`,
`productName`, `summary`, `description`, `imagePath`,
`costPrice`, `salePrice`, `marketPrice`, `repertory`, `saleNum`, `commentNum`, `status`)
VALUES ('1', '1', '1', '8', '1',
'8,汰渍果香洗衣液2kg', '双11,局限', '11',
'http://img.shequ001.com/shop/images/goods/20140128/JLF6903148181119.jpg?0#h',
'5', '5.6', '6', '20', '2', '0', '0');

INSERT INTO `Products` (`shopId`, `channelId`, `classId`, `categoryId`, `brandId`,
`productName`, `summary`, `description`, `imagePath`,
`costPrice`, `salePrice`, `marketPrice`, `repertory`, `saleNum`, `commentNum`, `status`)
VALUES ('1', '1', '1', '9', '1',
'9,汰渍果香洗衣液2kg', '双11,局限', '11',
'http://img.shequ001.com/shop/images/goods/20140128/JLF6903148181119.jpg?0#h',
'5', '5.6', '6', '20', '2', '0', '0');

INSERT INTO `Products` (`shopId`, `channelId`, `classId`, `categoryId`, `brandId`,
`productName`, `summary`, `description`, `imagePath`,
`costPrice`, `salePrice`, `marketPrice`, `repertory`, `saleNum`, `commentNum`, `status`)
VALUES ('1', '2', '4', '9', '1',
'9,汰渍果香洗衣液2kg', '双11,局限', '11',
'http://beijing.shequ001.com/public/images/ee/ec/c6/cc2037011ce9f0be621411310aaffe98.jpg?1411953639#h',
'5', '5.6', '6', '20', '2', '0', '0');







