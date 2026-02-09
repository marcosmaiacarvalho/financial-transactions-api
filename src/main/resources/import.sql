-- Inserindo Categorias (tb_category)
INSERT INTO tb_category (id, name) VALUES (1, 'Alimentação');
INSERT INTO tb_category (id, name) VALUES (2, 'Transporte');
INSERT INTO tb_category (id, name) VALUES (3, 'Salário');
INSERT INTO tb_category (id, name) VALUES (4, 'Lazer');
INSERT INTO tb_category (id, name) VALUES (5, 'Educação');
INSERT INTO tb_category (id, name) VALUES (6, 'Saúde');

-- Inserindo Transações (tb_transaction)
-- --- FEVEREIRO 2026 ---

-- Receitas
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (6500.00, '2026-02-05', 'Salário Mensal - Dimensa', 'REVENUE', 3);
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (800.00, '2026-02-15', 'Freelance Desenvolvimento', 'REVENUE', 3);

-- Despesas
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (450.50, '2026-02-02', 'Compra do Mês - Carrefour', 'EXPENSE', 1);
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (35.90, '2026-02-10', 'Ifood Hamburguer', 'EXPENSE', 1);
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (120.00, '2026-02-14', 'Jantar Dia dos Namorados', 'EXPENSE', 1);

INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (24.90, '2026-02-03', 'Uber p/ Trabalho', 'EXPENSE', 2);
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (350.00, '2026-02-20', 'Manutenção Carro', 'EXPENSE', 2);

INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (55.90, '2026-02-10', 'Assinatura Netflix', 'EXPENSE', 4);
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (49.90, '2026-02-05', 'Spotify Premium', 'EXPENSE', 4);
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (299.00, '2026-02-01', 'Curso Spring Boot Expert', 'EXPENSE', 5);

-- --- JANEIRO 2026 ---

INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (6500.00, '2026-01-05', 'Salário Janeiro', 'REVENUE', 3);
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (1500.00, '2026-01-10', 'Troca de Pneus', 'EXPENSE', 2);
INSERT INTO tb_transaction (amount, date, description, type, category_id) VALUES (200.00, '2026-01-20', 'Churrasco Família', 'EXPENSE', 1);

-- Reset da sequência do H2
ALTER TABLE tb_transaction ALTER COLUMN id RESTART WITH 100;
ALTER TABLE tb_category ALTER COLUMN id RESTART WITH 100;