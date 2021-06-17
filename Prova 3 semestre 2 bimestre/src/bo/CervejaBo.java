package bo;


import java.util.List;

import classes.*;
import dao.*;

public class CervejaBo {

	
	public String salvar(Cerveja cerveja) throws Exception {
		validarDadosGrupo(cerveja);

		// Chamar a DAo para inserir o cerveja no BD
		CervejaDao dao = new CervejaDao();
		try {
			return dao.salvar(cerveja);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Cerveja cerveja) throws Exception {
		validarDadosGrupo(cerveja);

		// Chamar a DAo para alterar o cerveja no BD
		CervejaDao dao = new CervejaDao();
		try {
			return dao.alterar(cerveja);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	public String deletar(Cerveja cerveja) throws Exception {
		
		// Chamar a DAo para deletar o cerveja no BD
		CervejaDao dao = new CervejaDao();
		try {
			return dao.deletar(cerveja);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}	
	
	public List<Cerveja> consultar() throws Exception{	
		
		CervejaDao dao = new CervejaDao();
		try {
			return dao.consultar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosGrupo(Cerveja cerveja) throws Exception {
		// Valida��o da regra de neg�cio
		if (cerveja.getNome().equals("")) {
			throw new Exception("Nome n�o pode ficar em branco!");
		}
		if (cerveja.getDescricao().equals("")) {
			throw new Exception("Descri��o n�o pode ficar em branco!");
		}
		if (cerveja.getTipo().equals(null)) {
			throw new Exception("Tipo n�o pode ficar em branco!");
		}
	}
	
	
	
}
