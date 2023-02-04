
package entities;

public class Quarto {
    private String nome;
    private String email;
    private int numQuarto;

    public Quarto(String nome, String Email, int numQuarto) {
        this.nome = nome;
        this.email = Email;
        this.numQuarto = numQuarto;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    @Override
    public String toString() {
        return (numQuarto + ": " + nome + ", " + email);
    }
    
    
}
