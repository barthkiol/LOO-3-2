package bo;


import java.util.List;

import classes.*;
import dao.*;

public class UsuarioBo {

	
	public String salvar(Usuario usuario) throws Exception {
		validarDadosGrupo(usuario);

		// Chamar a DAo para inserir o usuario no BD
		UsuarioDao dao = new UsuarioDao();
		try {
			return dao.salvar(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Usuario usuario) throws Exception {
		validarDadosGrupo(usuario);

		// Chamar a DAo para alterar o usuario no BD
		UsuarioDao dao = new UsuarioDao();
		try {
			return dao.alterar(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	public String deletar(Usuario usuario) throws Exception {
		
		// Chamar a DAo para deletar o usuario no BD
		UsuarioDao dao = new UsuarioDao();
		try {
			return dao.deletar(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}	
	
	public List<Usuario> consultar() throws Exception{	
		
		UsuarioDao dao = new UsuarioDao();
		try {
			return dao.consultar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosGrupo(Usuario usuario) throws Exception {
		// Valida��o da regra de neg�cio
		if (usuario.getNome().equals("")) {
			throw new Exception("Nome n�o pode ficar em branco!");
		}
		if (usuario.getSenha().equals("")) {
			throw new Exception("Senha n�o pode ficar em branco!");
		}
		
	}
	
	
	
}
