CREATE TABLE Users (
    id INT NOT NULL auto_increment,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50),
    email VARCHAR(50),
    mobile VARCHAR(50) NOT NULL,
    status INT NOT NULL,
    createTime DATE,
    loginTime DATE,
    PRIMARY KEY(id)
);

INSERT INTO Users (name,password,email,mobile,status,createTime,loginTime)
VALUES('weizhigang','123456','laoweige@163.com','13910178445',0,'2014-10-4','2014-10-4');

INSERT INTO Users (name,password,email,mobile,status,createTime,loginTime)
VALUES('guoxuewen','123456','gexuewen@163.com','13910171111',0,'2014-10-4','2014-10-4');


CREATE TABLE Registers (
    id INT NOT NULL auto_increment,
    mobile VARCHAR(50) NOT NULL,
    verifyCode int NOT NULL,
    expireTime DATE,
    PRIMARY KEY(id)
);

