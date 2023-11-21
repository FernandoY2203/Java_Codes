package dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Indicação de que a classe é uma Entidade de Dominio que Correspondera a uma tabela
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id // Indica que o atributo é uma Chave Primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o banco de dados irá gerar a chave automaticamente
	private Integer id;
	private String nome;
	private String email;
	
	public Pessoa() { // Sempre adicionar o contrutor padrão
	}
	
	public Pessoa(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Id: " + id + "\n" +
			   "Nome: " + nome + "\n" +
			   "Email: " + email;
	}
}
