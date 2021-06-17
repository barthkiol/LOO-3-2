package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "TB_USUARIO_CERVEJA",  // nome da tabela relacional no BD		
			// lado dominante/lado forte
			joinColumns = {
					@JoinColumn(name = "usuario_id")
					
			},
			//lado dominado/lado fraco
			inverseJoinColumns = {
					@JoinColumn(name = "cerveja_id")
			}	
		)
		
	private List<Cerveja> cervejas;
	
	public List<Cerveja> getCervejas() {
		return cervejas;
	}
	
	public void setCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}
	public void adicionaCerveja(Cerveja c) {
		this.cervejas.add(c);
	}
	public void removeCerveja(Cerveja c) {
		cervejas.remove(c);
	}	
	public Cerveja getCerveja(int posicao) {
		return cervejas.get(posicao);
	}
	
	private String nome;
	private String senha;
	
	


	public Usuario() {
		cervejas = new ArrayList<Cerveja>();
	}

	public Usuario(int id, String nome, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		cervejas = new ArrayList<Cerveja>();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id +  ", nome=" + nome + ", senha=" + senha + "]";
	}

	

}
