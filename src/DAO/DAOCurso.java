package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

/**
 * Classe responsável por realizar operações no banco de dados relacionadas
 * à tabela {@code Curso}.
 * 
 * @author Paulo
 * @version 1.0
 */
public class DAOCurso {

    /**
     * Insere um novo curso no banco de dados.
     *
     * @param curso objeto {@link Curso} contendo os dados a serem salvos
     */
    public void salvar(Curso curso) {

        // Comando SQL com os campos e valores (os ? serão substituídos pelos dados)
        String sql = "INSERT INTO Curso (nome_curso, carga_horaria) VALUES (?, ?)";

        // Abre a conexão e prepara o comando SQL
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Define os valores do curso nos parâmetros do SQL
            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getCargaHoraria());

            // Executa o comando no banco
            stmt.executeUpdate();

            System.out.println("Curso cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar curso: " + e.getMessage());
        }
    }

    /**
     * Marca um curso como inativo no banco de dados (exclusão lógica).
     *
     * @param curso objeto {@link Curso} que será definido como inativo
     */
    public void excluir(Curso curso) {

        // Atualiza o campo "ativo" para false, desativando o curso
        String sql = "UPDATE Curso SET ativo = false WHERE id_curso = ?";

        // Abre a conexão e prepara o comando SQL
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Define o ID do curso a ser inativado
            stmt.setInt(1, curso.getId_curso());

            // Executa o comando no banco
            stmt.executeUpdate();

            System.out.println("Curso marcado como inativo!");

        } catch (Exception e) {
            System.out.println("Erro ao definir curso como inativo: " + e.getMessage());
        }
    }

    /**
     * Lista todos os cursos cadastrados no banco de dados.
     *
     * @return uma lista de objetos {@link Curso}
     */
    public List<Curso> listar() {

        // Cria uma lista para armazenar os cursos encontrados
        List<Curso> lista = new ArrayList<>();

        // Comando SQL que busca todos os registros da tabela Curso
        String sql = "SELECT * FROM Curso";

        // Tenta conectar ao banco e executar o comando SQL
        try (Connection con = Conexao.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Percorre cada linha do resultado do banco
            while (rs.next()) {
                Curso c = new Curso();

                // Atribui os dados de cada coluna ao objeto Curso
                c.setId_curso(rs.getInt("id_curso"));
                c.setNomeCurso(rs.getString("nome_curso"));
                c.setCargaHoraria(rs.getInt("carga_horaria"));

                // Adiciona o curso na lista
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar cursos: " + e.getMessage());
        }

        // Retorna a lista com todos os cursos encontrados
        return lista;
    }
}
