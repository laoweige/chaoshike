CREATE TABLE ShoppingCart (
    id INT NOT NULL auto_increment,
    userId INT,
    featureCode VARCHAR(1000) NOT NULL,
    productId INT NOT NULL,
    needNum INT NOT NULL,
    status INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(id)
);

CREATE TABLE Orders (
    orderId INT NOT NULL auto_increment,
    userId INT NOT NULL,
    couponId INT,
    integral INT,
    status INT NOT NULL,
    createTime DATE,
    totalPrice FLOAT,
    actualPrice FLOAT NOT NULL,
    deliverAddress VARCHAR(1000) NOT NULL,
    deliverTime INT NOT NULL,
    deliverCosts FLOAT NOT NULL,
    contactMobile VARCHAR(20) NOT NULL,
    orderRemark VARCHAR(1000) NOT NULL,
    paymentMode INT NOT NULL,
    invoiceId INT,
    PRIMARY KEY(orderId)
);

CREATE TABLE invoices(
    invoiceId INT NOT NULL auto_increment,
    invoiceType INT,
    invoiceValue FLOAT,
    companyName VARCHAR(1000) NOT NULL,
    userName  VARCHAR(10) NOT NULL,
    createTime DATE,
    PRIMARY KEY(invoiceId)
);

CREATE TABLE OrderProducts (
    orderId INT NOT NULL,
    productId INT NOT NULL,
    salePrice FLOAT NOT NULL,
    num INT NOT NULL,
    userId INT NOT NULL,
    PRIMARY KEY(orderId,productId)
);

CREATE TABLE Coupons(
    couponId INT NOT NULL auto_increment,
    userId INT NOT NULL,
    couponNumber VARCHAR(20) NOT NULL,
    summary VARCHAR(100) NOT NULL,
    useLimit VARCHAR(200) NOT NULL,
    status INT NOT NULL,
    createTime DATE,
    PRIMARY KEY(couponId)
)
