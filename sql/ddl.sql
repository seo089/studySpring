DROP
TABEL IF EXISTS MEMBER CASCADE;
CREATE
TABEL KEY_MEMBER
(
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    NAME  VARCHAR(255),
    PRIMARY KEY (ID)
);