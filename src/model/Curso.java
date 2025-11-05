package model;

/**
 * Representa um curso disponível no sistema.
 * <p>
 * Contém as informações principais de um curso, como nome, carga horária e status ativo.
 * Essa classe é usada para transferir dados entre as camadas da aplicação.
 * </p>
 * 
 * @author Paulo
 * @version 1.0
 */
public class Curso {

    // Atributos
    private int id_curso;
    private String nomeCurso;
    private int cargaHoraria;
    private boolean ativo;

    // Construtores
    /**
     * Construtor padrão (utilizado para instanciar um curso vazio).
     */
    public Curso() {
    }

    /**
     * Construtor completo (usado quando todos os dados do curso já estão disponíveis).
     */
    public Curso(int id_curso, String nomeCurso, int cargaHoraria) {
        this.id_curso = id_curso;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.ativo = true;
    }

    // Getters e Setters
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // Métodos auxiliares
    /**
     * Retorna o nome do curso como representação textual do objeto.
     */
    @Override
    public String toString() {
        return nomeCurso;
    }
}
