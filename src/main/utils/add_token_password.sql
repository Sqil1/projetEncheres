USE
ENCHERES;
GO

CREATE TABLE TOKEN_PASSWORD
(
    no_token        INTEGER IDENTITY(1,1) NOT NULL,
    no_utilisateur  INTEGER     NOT NULL,
    token           VARCHAR(40) NOT NULL,
    token_used      boolean     NOT NULL,
    date_creation   DATETIME    NOT NULL,
    date_expiration DATETIME    NOT NULL,
)