create database javaProjects;
use javaProjects;
create table if not exists foods
(
    ID            int auto_increment,
    name          varchar(500)  not null,
    price         double        not null,
    `price point` int default 1 null,
    constraint foods_ID_uindex
        unique (ID)
);

alter table foods
    add primary key (ID);

create table if not exists restaurants
(
    ID             int auto_increment,
    season         varchar(75)   null,
    episode        int           null,
    `episode name` varchar(128)  null,
    name           varchar(100)  not null,
    country        varchar(50)   null,
    city           varchar(100)  null,
    notes          varchar(1000) null,
    constraint restaurant_ID_uindex
        unique (ID)
);

alter table restaurants
    add primary key (ID);


create table if not exists foodsToRestaurants
(
    foodID       int not null,
    RestaurantID int not null,
    constraint foodsToRestaurants_foods_ID_fk
        foreign key (foodID) references foods (ID)
            on update cascade on delete cascade,
    constraint foodsToRestaurants_restaurants_ID_fk
        foreign key (RestaurantID) references restaurants (ID)
            on update cascade on delete cascade
);