CREATE TABLE tb_fornecedores (
	for_codigo BIGINT PRIMARY KEY,
	for_descricao VARCHAR(45)
);

CREATE TABLE tb_produtos (
	pro_codigo BIGINT PRIMARY KEY,
	pro_descricao VARCHAR(45),
	pro_valor DECIMAL(7,2),
	pro_quantidade INT,
	fornecedor BIGINT REFERENCES tb_fornecedores(for_codigo)
);

CREATE TABLE tb_funcionarios (
	fun_codigo BIGINT PRIMARY KEY,
	fun_nome VARCHAR(45),
	fun_cpf VARCHAR(45),
	fun_senha VARCHAR(50),
	fun_funcao VARCHAR(50)
);

CREATE TABLE tb_vendas (
	ven_codigo BIGINT PRIMARY KEY,
	ven_horario TIMESTAMP,
	ven_valor_total DECIMAL(7,2),
	funcionario BIGINT REFERENCES tb_funcionarios(fun_codigo)
);

CREATE TABLE tb_itens (
	ite_codigo BIGINT PRIMARY KEY,
	ite_quantidade INT,
	ite_valor_parcial DECIMAL(7,2),
	produto BIGINT REFERENCES tb_produtos(pro_codigo),
	venda BIGINT REFERENCES tb_vendas(ven_codigo)
);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 2. Indexação (1,0)
CREATE INDEX IX_codItem ON  tb_produtos (pro_codigo);
CREATE INDEX IX_codVenda on tb_vendas (ven_codigo);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 3. Processamento de Transações e Controle de concorrência (1,0)
--A)
CREATE OR REPLACE FUNCTION zeraEstoqueAll()
RETURNS VOID AS $$
BEGIN  
    
    UPDATE tb_produtos SET pro_quantidade = 0;  
    
EXCEPTION
    -- Em caso de exceção, fazemos rollback da transação
   WHEN OTHERS THEN
    -- Realizar o rollback
    ROLLBACK;
    
    -- Exibir a mensagem de erro
    RAISE EXCEPTION 'Ocorreu um erro: %', SQLERRM;
END;
$$ LANGUAGE plpgsql;

SELECT zeraestoqueall()


--B)

--ABRIR CMD A E EXECUTAR
UPDATE tb_itens SET ite_quantidade = 10;

--ABRIR CMD B E EXECUTAR
UPDATE tb_itens SET ite_quantidade = 5;

--VOLTAR PARA O CMD A E EXECUTAR
COMMIT;

--VOLTAR PARA O CMD B E EXECUTAR 
COMMIT;

/*
Neste ponto, você verá que a transação do Cliente B falhará com um erro, porque o valor do registro já foi modificado pela transação do Cliente A.
Isso ocorre porque o controle de transação garante que as modificações feitas por uma transação só sejam visíveis por outras transações após a confirmação da primeira.
*/

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 4. Recuperação

-- A)

CREATE OR REPLACE PROCEDURE verificarDados() AS $$
DECLARE
    dados_corretos BOOLEAN;
BEGIN
    
    -- Insere um registro na tabela tb_produtos
    INSERT INTO tb_produtos VALUES (9999, 'TESTE', 10, 1, 1);
    
    -- Verifica se os dados estão corretos
    -- Define a variável "dados_corretos" como true ou false com base na verificação
    SELECT COUNT(*) > 0 INTO dados_corretos FROM tb_produtos;
    
    IF dados_corretos THEN
        -- Os dados estão corretos, nenhum COMMIT é necessário aqui, ele é feito assim que finaliza a procedure
    ELSE
        -- Os dados estão incorretos, executa o rollback manualmente
        RAISE EXCEPTION 'Dados incorretos. Executando rollback.';
    END IF;
EXCEPTION
    -- Captura a exceção e executa o rollback manualmente
    WHEN OTHERS THEN
        -- Realiza o rollback manualmente
        ROLLBACK;
        
        -- Exibe a mensagem de erro
        RAISE EXCEPTION 'Ocorreu um erro: %', SQLERRM;
END;
$$ LANGUAGE plpgsql;

call verificarDados()

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--a. Criar alguns usuários:

CREATE USER marcelo PASSWORD 'senha1';
CREATE USER luan PASSWORD 'senha2';


--b. Criar alguns grupos:

CREATE GROUP grupo1;
CREATE GROUP grupo2;


--c. Conceder diferentes privilégios aos grupos:

GRANT SELECT ON tb_fornecedores TO grupo1;
GRANT INSERT, UPDATE, DELETE ON tb_produtos TO grupo2;


--d. Adicionar os usuários aos grupos:

GRANT grupo1 TO marcelo;
GRANT grupo2 TO luan;