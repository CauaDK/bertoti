CREATE TABLE IF NOT EXISTS petshop (
                                       id         BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nome       VARCHAR(150) NOT NULL
) ENGINE=InnoDB;

INSERT INTO petshop (nome)
SELECT 'Petshop Amigo Fiel'
WHERE NOT EXISTS (SELECT 1 FROM petshop WHERE nome='Petshop Amigo Fiel');

INSERT INTO petshop (nome)
SELECT 'Petshop Reino Animal'
WHERE NOT EXISTS (SELECT 1 FROM petshop WHERE nome='Petshop Reino Animal');

INSERT INTO petshop (nome)
SELECT 'Petshop Mundo Pet'
WHERE NOT EXISTS (SELECT 1 FROM petshop WHERE nome='Petshop Mundo Pet');

INSERT INTO petshop (nome)
SELECT 'Petshop Patas & Cia'
WHERE NOT EXISTS (SELECT 1 FROM petshop WHERE nome='Petshop Patas & Cia');