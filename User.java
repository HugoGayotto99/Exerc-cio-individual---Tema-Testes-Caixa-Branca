package login;

// Importação de bibliotecas necessárias para trabalhar com JDBC e banco de dados MySQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados
 * e a verificação de usuários em uma aplicação de login.
 */
public class User {

    /**
     * Método que realiza a conexão com o banco de dados MySQL.
     * 
     * @return Objeto Connection para interagir com o banco de dados.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.Driver").newInstance();

            // URL de conexão com o banco de dados
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            // Estabelece a conexão
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Caso ocorra um erro, a conexão será nula
        }
        return conn;
    }

    /**
     * Nome do usuário que será recuperado do banco de dados.
     */
    public String nome = "";

    /**
     * Resultado da verificação de login (verdadeiro para sucesso, falso para falha).
     */
    public boolean result = false;

    /**
     * Método responsável por verificar se o login e a senha fornecidos existem no banco de dados.
     * 
     * @param login Nome de usuário fornecido para autenticação.
     * @param senha Senha fornecida para autenticação.
     * @return True se o login e senha forem válidos, false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = ""; // String SQL que será usada para consulta
        Connection conn = conectarBD();

        // Construção da consulta SQL para verificar login e senha
        sql = "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            // Cria o statement para executar a consulta
            Statement st = conn.createStatement();

            // Executa a consulta SQL
            ResultSet rs = st.executeQuery(sql);

            // Verifica se a consulta retornou algum resultado
            if (rs.next()) {
                result = true; // Login e senha válidos
                nome = rs.getString("nome"); // Recupera o nome do usuário
            }
        } catch (Exception e) {
            // Caso ocorra um erro, a verificação falha
        }
        return result;
    }
}
