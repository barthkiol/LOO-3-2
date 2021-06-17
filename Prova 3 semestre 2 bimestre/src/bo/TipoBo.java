package bo;


import java.util.List;

import classes.*;
import dao.*;

public class TipoBo {

	
	public String salvar(Tipo tipo) throws Exception {
		validarDadosGrupo(tipo);

		// Chamar a DAo para inserir o tipo no BD
		TipoDao dao = new TipoDao();
		try {
			return dao.salvar(tipo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Tipo tipo) throws Exception {
		validarDadosGrupo(tipo);

		// Chamar a DAo para alterar o tipo no BD
		TipoDao dao = new TipoDao();
		try {
			return dao.alterar(tipo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	public String deletar(Tipo tipo) throws Exception {
		
		// Chamar a DAo para deletar o tipo no BD
		TipoDao dao = new TipoDao();
		try {
			return dao.deletar(tipo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}	
	
	public List<Tipo> consultar() throws Exception{	
		
		TipoDao dao = new TipoDao();
		try {
			return dao.consultar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosGrupo(Tipo tipo) throws Exception {
		// Validação da regra de negócio
		if (tipo.getNome().equals("")) {
			throw new Exception("Nome não pode ficar em branco!");
		}
		
	}
	
	
	
}
