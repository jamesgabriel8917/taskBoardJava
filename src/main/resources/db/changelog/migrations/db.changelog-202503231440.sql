--liquibase formatted sql
--changeset james:202503231440
--comment: boards table create

CREATE TABLE BOARDS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),

) ENGINE=InnoDB;

--rollback DROP TABLE BOARDS

