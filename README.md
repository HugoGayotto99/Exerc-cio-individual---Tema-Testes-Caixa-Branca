Nome do driver: Linha 10 tinha com.mysql.Driver.Manager, mas deve ser com.mysql.cj.jdbc.Driver.

URL de conexão: Embora a URL esteja correta, ela pode precisar de ajustes dependendo da configuração do MySQL.

Tratamento de exceções: Adicionei e.printStackTrace() dentro dos blocos catch para exibir os erros.

SQL Injection: O uso de PreparedStatement é recomendado para evitar SQL Injection em vez de concatenar strings diretamente na instrução SQL.

Fechamento da conexão: Adicionado um bloco finally para garantir que a conexão seja fechada, evitando vazamentos de recursos.
