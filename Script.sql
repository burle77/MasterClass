CREATE DATABASE IF NOT EXISTS super_pecas;
USE super_pecas;

CREATE TABLE IF NOT EXISTS carros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(255) NOT NULL,
    codigo VARCHAR(255) NOT NULL,
    fabricante VARCHAR(255) NOT NULL,
    UNIQUE (modelo),
    UNIQUE (codigo)
);

CREATE TABLE IF NOT EXISTS pecas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    numero_serie VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    fabricante VARCHAR(255) NOT NULL,
    modelo_carro VARCHAR(255) NOT NULL,
    carro_id INT NOT NULL,
    UNIQUE (nome),
    UNIQUE (numero_serie),
    FOREIGN KEY (carro_id) REFERENCES carros(id) ON DELETE CASCADE
);

INSERT INTO carros (modelo, codigo, fabricante)
VALUES ('KA', 'CODKA001', 'Ford')
ON DUPLICATE KEY UPDATE fabricante = VALUES(fabricante);

INSERT INTO pecas (nome, numero_serie, descricao, fabricante, modelo_carro, carro_id)
VALUES ('Farol dianteiro direito', 'FASER001', 'Farol dianteiro para Ford KA SE 1.0 2015', 'Ford', 'Ford KA SE 1.0 2015', (SELECT id FROM carros WHERE modelo = 'KA'))
ON DUPLICATE KEY UPDATE descricao = VALUES(descricao), fabricante = VALUES(fabricante), modelo_carro = VALUES(modelo_carro);

SELECT 
    p.id AS peca_id,
    p.nome AS peca_nome,
    p.descricao AS descricao_peca,
    p.fabricante AS fabricante_peca,
    p.modelo_carro AS modelo_peca,
    c.modelo AS modelo_carro,
    c.fabricante AS fabricante_carro
FROM pecas AS p 
INNER JOIN carros AS c ON p.carro_id = c.id;
