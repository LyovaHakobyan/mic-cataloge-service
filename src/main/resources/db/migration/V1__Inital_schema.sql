CREATE TABLE book
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    author             VARCHAR(255) NOT NULL,
    isbn               VARCHAR(255) NOT NULL,
    price              FLOAT        NOT NULL,
    title              VARCHAR(255) NOT NULL,
    created_date       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version            INT          NOT NULL
);