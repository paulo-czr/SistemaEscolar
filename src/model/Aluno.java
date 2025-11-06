package model;

/**
 * Representa um aluno cadastrado no sistema.
 * <p>
 * Contém as informações principais de um aluno, como nome, e-mail, telefone e status ativo.
 * Essa classe é usada para transferir dados entre as camadas da aplicação.
 * </p>
 * 
 * @author Paulo
 * @version 1.0
 */
public class Aluno {

    // Atributos 
    private int id_aluno;
    private String nome;
    private String email;
    private String telefone;
    private boolean ativo;
    private String dataNasc;

    // Construtores 
    /**
     * Construtor padrão (utilizado para instanciar um aluno vazio).
     */
    public Aluno() {
    }

    /**
     * Construtor completo (usado quando todos os dados do aluno já estão disponíveis).
     */
    public Aluno(int id_aluno, String nome, String email, String telefone, String dataNasc) {
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;   
        this.ativo = true;
    }
    
    // Getters e Setters 
    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    // Métodos auxiliares
    /**
     * Retorna o nome do aluno como representação textual do objeto.
     */
    @Override
    public String toString() {
        return nome;
    }
}
