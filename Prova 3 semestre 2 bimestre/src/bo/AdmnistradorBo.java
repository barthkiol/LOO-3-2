package bo;


import java.util.List;

import classes.*;
import dao.*;

public class AdmnistradorBo {

	
	public String salvar(Admnistrador admnistrador) throws Exception {
		validarDadosGrupo(admnistrador);

		// Chamar a DAo para inserir o admnistrador no BD
		AdmnistradorDao dao = new AdmnistradorDao();
		try {
			return dao.salvar(admnistrador);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Admnistrador admnistrador) throws Exception {
		validarDadosGrupo(admnistrador);

		// Chamar a DAo para alterar o admnistrador no BD
		AdmnistradorDao dao = new AdmnistradorDao();
		try {
			return dao.alterar(admnistrador);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	public String deletar(Admnistrador admnistrador) throws Exception {
		
		// Chamar a DAo para deletar o admnistrador no BD
		AdmnistradorDao dao = new AdmnistradorDao();
		try {
			return dao.deletar(admnistrador);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}	
	
	public List<Admnistrador> consultar() throws Exception{	
		
		AdmnistradorDao dao = new AdmnistradorDao();
		try {
			return dao.consultar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosGrupo(Admnistrador admnistrador) throws Exception {
		// Valida��o da regra de neg�cio
		if (admnistrador.getNome().equals("")) {
			throw new Exception("Nome n�o pode ficar em branco!");
		}
		if (admnistrador.getSenha().equals("")) {
			throw new Exception("Senha n�o pode ficar em branco!");
		}
		
	}
	
	
	
}
