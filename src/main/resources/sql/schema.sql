drop database if exists ultimatePc;

create database if not exists ultimatePc;

use ultimatePc;

create table employee (
                          empID varchar(30)primary key,
                          name varchar(30),
                          address varchar(30),
                          email varchar(30),
                          mobile Int(10),
                          position varchar(30)
);

create table attendence(
                           attendenceID varchar(30)primary key,
                           date Date,
                           inTime Int(5),
                           outTime Int(5),
                           otHours Int(5),
                           empID varchar(30),
                           constraint foreign key (empID) references
                               employee(empID)on delete  cascade on update cascade

);

create table salary(
                       salaryID varchar(30)primary key,
                       amount Int(10),
                       date Date,
                       empID varchar(30),
                       constraint foreign key (empID) references
                           employee(empID)on delete  cascade on update cascade

);

create table user(
                     userID varchar(30)primary key,
                     userName varchar(30),
                     empID varchar(30),
                     constraint foreign key (empID) references
                         employee(empID)on delete  cascade on update cascade

);

create table supplier(
                         supID varchar(30)primary key,
                         name varchar(30),
                         address varchar(30),
                         email varchar(30),
                         mobile Int(10)
);

create table buyingOrder(
                            boID varchar(30)primary key,
                            date Date,
                            supID varchar(30),
                            constraint foreign key (supID) references
                                supplier(supID)on delete  cascade on update cascade

);

create table item(
                     itemID varchar(30)primary key,
                     name varchar(30),
                     buyingPrice Int(10),
                     sellingPrice Int(10),
                     qty Int(10)
);

create table buyingOrderDetails(
                                   boID varchar(30),
                                   itemID varchar(30),
                                   constraint foreign key (boID) references
                                       buyingOrder(boID)on delete  cascade on update cascade,
                                   constraint foreign key (itemID) references
                                       item(itemID)on delete  cascade on update cascade

);

create table payment(
                        paymentID varchar(30)primary key,
                        amount int(10)
);


create table customer(
                         cusID varchar(30)primary key,
                         name varchar(30),
                         address varchar(30),
                         email varchar(30),
                         mobile Int(10)
);

create table service(
                        serviceID varchar(30)primary key,
                        date Date,
                        discription text,
                        paymentID varchar(30),
                        cusID varchar(30),
                        constraint foreign key (paymentID) references
                            payment(paymentID)on delete  cascade on update cascade,
                        constraint foreign key (cusID) references
                            customer(cusID)on delete  cascade on update cascade


);

create table sellingOrder(
                             soID varchar(30)primary key,
                             date Date,
                             userID varchar(30),
                             cusID varchar(30),
                             paymentID varchar(30),

                             constraint foreign key (userID) references
                                 user(userID)on delete  cascade on update cascade,

                             constraint foreign key (cusID) references
                                 customer(cusID)on delete  cascade on update cascade,

                             constraint foreign key (paymentID) references
                                 payment(paymentID)on delete  cascade on update cascade

);

create table sellingOrderDetails(
                                    soID varchar(30),
                                    itemID varchar(30),

                                    constraint foreign key (soID) references
                                        sellingOrder(soID)on delete  cascade on update cascade,

                                    constraint foreign key (itemID) references
                                        item(itemID)on delete  cascade on update cascade
);
