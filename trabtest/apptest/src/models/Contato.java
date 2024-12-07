package models;

public class Contato {
    private int id;
    private String nome, email, telefone;

    //CONSTRUCTORS
    public Contato (String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    public Contato (String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    //GETTERS
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
