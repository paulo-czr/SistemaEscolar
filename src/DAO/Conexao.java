package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por criar a conexão com o banco de dados MySQL.
 * 
 * @author Paulo
 * @version 1.0
 */
public class Conexao {

    /**
     * Estabelece uma conexão com o banco de dados MySQL.
     *
     * @return objeto {@link Connection} representando a conexão ativa
     */
    public static Connection conectar() {
        Connection conexao = null; // Objeto que armazenará a conexão ativa

        try {
            // Pega as credenciais do sistema usando variáveis de ambiente
            String url = System.getenv("DB_URL");
            String usuario = System.getenv("DB_USER");
            String senha = System.getenv("DB_PASSWORD");
            
            if (url == null || usuario == null || senha == null) {
                throw new SQLException("Variáveis de ambiente do banco não configuradas!");
            }
            
            // Estabelece a conexão com o banco utilizando o DriverManager
            conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão realizada com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao conectar com o banco: " + erro.getMessage());
        }

        return conexao;
    }
}
