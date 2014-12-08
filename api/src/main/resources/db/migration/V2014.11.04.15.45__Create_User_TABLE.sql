CREATE TABLE Users (
    id INT NOT NULL auto_increment,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50),
    email VARCHAR(50),
    mobile VARCHAR(50) NOT NULL,
    integral INT NOT NULL,
    status INT NOT NULL,
    createTime DATETIME,
    loginTime DATETIME,
    PRIMARY KEY(id)
);

INSERT INTO Users (name,password,email,mobile,status,integral,createTime,loginTime)
VALUES('weizhigang','123456','laoweige@163.com','13910178445',0,0,'2014-10-4','2014-10-4');
INSERT INTO Users (name,password,email,mobile,status,integral,createTime,loginTime)
VALUES('guoxuewen','123456','gexuewen@163.com','13910171111',0,20,'2014-10-4','2014-10-4');


CREATE TABLE Registers (
    id INT NOT NULL auto_increment,
    mobile VARCHAR(50) NOT NULL,
    verifyCode int NOT NULL,
    expireTime DATE,
    PRIMARY KEY(id)
);

CREATE TABLE LoginToken(
    id INT NOT NULL auto_increment,
    UUID VARCHAR(50) NOT NULL,
    token VARCHAR(50) NOT NULL,
    platform int NOT NULL,
    expireTime DATETIME,
    createTime DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE Addresses (
    id INT NOT NULL auto_increment,
    address VARCHAR(1000) NOT NULL,
    mobile VARCHAR(20) NOT NULL,
    name VARCHAR(10) NOT NULL,
    city INT,
    isDefault bit,
    PRIMARY KEY(id)
);

CREATE TABLE IntegralRate(
    id INT NOT NULL auto_increment,
    num INT,
    money FLOAT,
    city INT,
    isDefault bit,
    createTime DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE IntegralLog(
    id INT NOT NULL auto_increment,
    userName VARCHAR(10) NOT NULL,
    num INT,
    summary VARCHAR(200) NOT NULL,
    createTime DATETIME,
    PRIMARY KEY(id)
);


