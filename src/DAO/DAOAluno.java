package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import java.util.Date;

/**
 * Classe responsável por realizar as operações de acesso e manipulação de dados
 * da tabela {@code Aluno} no banco de dados.
 * 
 * @author Paulo
 * @version 1.0
 */
public class DAOAluno {

    /**
     * Insere um novo aluno no banco de dados.
     *
     * @param aluno objeto {@link Aluno} contendo os dados a serem salvos
     */
    public void salvar(Aluno aluno) {

        // Comando SQL com os campos e valores (os ? serão substituídos pelos dados)
        String sql = "INSERT INTO Aluno (nome, email, telefone, data_nasc) VALUES (?, ?, ?, ?)";

        // Abre a conexão e prepara o comando SQL
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Envia os valores do aluno para os parâmetros do SQL
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getDataNasc());

            // Executa o comando no banco
            stmt.executeUpdate();

            System.out.println("Aluno cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    /**
     * Marca um aluno como inativo no banco de dados (exclusão lógica).
     *
     * @param id_aluno usado para definir o aluno exato como inativo
     */
    public void excluir(int id_aluno) {

        // Atualiza o campo "ativo" para false, desativando o aluno
        String sql = "UPDATE Aluno SET ativo = false WHERE id_aluno = ?";

        // Abre a conexão e prepara o comando SQL
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Define o ID do aluno a ser inativado
            stmt.setInt(1, id_aluno);

            // Executa o comando no banco
            stmt.executeUpdate();

            System.out.println("Aluno marcado como inativo!");

        } catch (Exception e) {
            System.out.println("Erro ao definir aluno como inativo: " + e.getMessage());
        }
        
        
    }

    /**
     * Lista todos os alunos ativos cadastrados no banco de dados.
     *
     * @return uma lista de objetos {@link Aluno} ativos
     */
    public List<Aluno> listar() {

        // Cria uma lista para armazenar os alunos encontrados
        List<Aluno> lista = new ArrayList<>();

        // Comando SQL que busca todos os alunos ativos
        String sql = "SELECT * FROM Aluno WHERE ativo = true";

        // Tenta conectar ao banco e executar o comando SQL
        try (Connection con = Conexao.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Percorre cada linha do resultado
            while (rs.next()) {
                Aluno a = new Aluno();

                // Pega os dados de cada coluna e define no objeto
                a.setAtivo(rs.getBoolean("ativo"));
                a.setId_aluno(rs.getInt("id_aluno"));
                a.setNome(rs.getString("nome"));
                a.setEmail(rs.getString("email"));
                a.setTelefone(rs.getString("telefone"));
                a.setDataNasc(rs.getString("data_nasc"));

                // Adiciona o aluno à lista
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
        
        // Retorna a lista com todos os alunos encontrados
        return lista;
    }
}
