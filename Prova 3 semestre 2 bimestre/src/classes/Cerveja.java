package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cerveja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private String nome;
	
		
	
	
	@ManyToOne
	private Tipo tipo;
	


	@ManyToMany(mappedBy="cervejas", cascade=CascadeType.ALL)
	private List<Usuario> usuarios;
	public List<Usuario> getUsuario() {
		return usuarios;
	}
	
	public void adicionaUsuario(Usuario p) {
		usuarios.add(p);
	}
	public void removeUsuario(Usuario p) {
		usuarios.remove(p);
	}
	public Usuario getUsuario(int posicao) {
		return usuarios.get(posicao);
	}
	
	public Cerveja() {
		
		usuarios = new ArrayList<Usuario>();
	}

	public Cerveja(int id, String descricao, String nome, Tipo tipo) {
		
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.tipo = tipo;
		usuarios = new ArrayList<Usuario>();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	
	public List<Usuario> getApreciadores() {
		return usuarios;
	}



	public void setApreciadores(List<Usuario> apreciadores) {
		this.usuarios = apreciadores;
	}

	@Override
	public String toString() {
		return "Cerveja [id=" + id + ", descricao=" + descricao + ", nome=" + nome + ", tipo=" + tipo
				+ ", apreciadores=" + usuarios + "]";
	}


	
	

	

}
