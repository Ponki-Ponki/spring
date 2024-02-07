create table TASKS (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description   varchar(255) not null,
    taskStatus        varchar(255) not null,
    date_creation timestamp    not null
);