package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Aluno;
import model.Curso;
import model.Matricula;

/**
 * Classe responsável por realizar as operações no banco de dados
 * relacionadas à tabela {@code Matricula}.
 * 
 * @author Paulo
 * @version 1.0
 */
public class DAOMatricula {

    /**
     * Insere uma nova matrícula no banco de dados.
     * 
     * @param matricula objeto {@link Matricula} com os dados a serem salvos
     * @throws SQLException caso ocorra erro ao salvar a matrícula
     */
    public void salvar(Matricula matricula) throws SQLException {

        // Comando SQL com os parâmetros a serem preenchidos
        String sql = "INSERT INTO Matricula (id_aluno, id_curso, data_matricula) VALUES (?, ?, ?)";

        // Abre a conexão e prepara o comando SQL
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Define os valores da matrícula nos parâmetros do SQL
            stmt.setInt(1, matricula.getAluno().getId_aluno());
            stmt.setInt(2, matricula.getCurso().getId_curso());

            // Converte a data do tipo java.util.Date para java.sql.Date
            java.sql.Date dataSql = new java.sql.Date(matricula.getDataCurso().getTime());
            stmt.setDate(3, dataSql);

            // Executa o comando no banco
            stmt.executeUpdate();

        } catch (SQLException e) {
            // Código 1062 = erro de duplicidade (violação de UNIQUE no MySQL)
            if (e.getErrorCode() == 1062) {
                throw new SQLException("Este aluno já está matriculado neste curso!", e);
            } else {
                // Relança outros erros para tratamento externo
                throw e;
            }
        }
    }

        /**
     * Marca uma matricula como inativa no banco de dados (exclusão lógica).
     *
     * @param matricula objeto {@link Matricula} que será definido como inativa
     */
    public void excluir(Matricula matricula) {

        // Atualiza o campo "ativo" para false, desativando a matrícula
        String sql = "UPDATE Matricula SET ativo = false WHERE id_matricula = ?";

        // Abre a conexão e prepara o comando SQL
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Define o ID da matrícula a ser inativada
            stmt.setInt(1, matricula.getId_matricula());

            // Executa o comando no banco
            stmt.executeUpdate();

            System.out.println("Matrícula marcado como inativa!");

        } catch (Exception e) {
            System.out.println("Erro ao definir matrícula como inativa: " + e.getMessage());
        }
    }
    
    /**
     * Lista todas as matrículas ativas no banco de dados.
     * 
     * @return lista de objetos {@link Matricula} encontrados
     */
    public List<Matricula> listar() {

        // Cria uma lista para armazenar as matrículas encontradas
        List<Matricula> lista = new ArrayList<>();

        // Consulta SQL com JOINs para trazer nomes de aluno e curso
        String sql = "SELECT m.id_matricula, a.nome AS nome_aluno, c.nome_curso AS nome_curso, m.data_matricula "
                   + "FROM Matricula m "
                   + "JOIN Aluno a ON m.id_aluno = a.id_aluno "
                   + "JOIN Curso c ON m.id_curso = c.id_curso "
                   + "WHERE m.ativo = TRUE";

        // Conecta ao banco e executa o comando SQL
        try (Connection con = Conexao.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Percorre o resultado e cria objetos Matricula
            while (rs.next()) {
                Matricula m = new Matricula();
                m.setId_matricula(rs.getInt("id_matricula"));
                m.setNomeAluno(rs.getString("nome_aluno"));
                m.setNomeCurso(rs.getString("nome_curso"));
                m.setDataCurso(rs.getDate("data_matricula"));

                // Adiciona o objeto à lista
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar matrículas: " + e.getMessage());
        }
        
        // Retorna a lista preenchida
        return lista;
    }

    /**
     * Insere uma nova matrícula diretamente com aluno, curso e data.
     * 
     * @param aluno objeto {@link Aluno} referente ao aluno matriculado
     * @param curso objeto {@link Curso} referente ao curso escolhido
     * @param data data da matrícula
     */
    public void inserirMatricula(Aluno aluno, Curso curso, Date data) {

        // Comando SQL para inserir uma nova matrícula
        String sql = "INSERT INTO Matricula (id_aluno, id_curso, data_matricula) VALUES (?, ?, ?)";

        // Abre a conexão e prepara o comando
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Define os valores da matrícula
            stmt.setInt(1, aluno.getId_aluno());
            stmt.setInt(2, curso.getId_curso());

            // Converte a data recebida e define no SQL
            stmt.setDate(3, new java.sql.Date(data.getTime()));

            // Executa o comando
            stmt.executeUpdate();

            System.out.println("Matrícula cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar a matrícula: " + e.getMessage());
        }
    }
}
