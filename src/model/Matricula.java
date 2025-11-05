package model;

import java.util.Date;

/**
 * Representa a matrícula de um aluno em um curso.
 * <p>
 * Contém as informações principais sobre a matrícula, como o aluno, o curso e a data
 * em que foi realizada. Essa classe é usada para transferir dados entre as camadas
 * da aplicação.
 * </p>
 * 
 * @author Paulo
 * @version 1.0
 */
public class Matricula {

    // Atributos
    private int id_matricula;
    private int id_aluno;
    private int id_curso;
    private Aluno aluno;
    private Curso curso;
    private Date dataCurso;
    private String nomeAluno;   // Nome do aluno (usado em consultas)
    private String nomeCurso;   // Nome do curso (usado em consultas)
    private boolean ativa;

    // Construtores
    /**
     * Construtor padrão (utilizado para instanciar uma matrícula vazia).
     */
    public Matricula() {
    }

    /**
     * Construtor completo (usado quando todos os dados da matrícula já estão disponíveis).
     */
    public Matricula(int id_matricula, int id_aluno, int id_curso, Aluno aluno, Curso curso, Date dataCurso) {
        this.id_matricula = id_matricula;
        this.id_aluno = id_aluno;
        this.id_curso = id_curso;
        this.aluno = aluno;
        this.curso = curso;
        this.dataCurso = dataCurso;
        this.ativa = true;
    }

    // Getters e Setters
    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getDataCurso() {
        return dataCurso;
    }

    public void setDataCurso(Date dataCurso) {
        this.dataCurso = dataCurso;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    
}
