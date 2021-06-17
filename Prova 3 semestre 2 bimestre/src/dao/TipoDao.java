package dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.*;


public class TipoDao {

	private Connection con = null; 
	
	public String salvar(Tipo tipo) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(tipo);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Tipo: "+e.getMessage());
		} 
					
	}
	// alterar
		public String alterar(Tipo tipo) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(tipo);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Tipo: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Tipo tipo) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Tipo c = em.find(Tipo.class, tipo.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Tipo: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Tipo> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Tipo");
			return q.getResultList();				
		}
		
		public Tipo getTipo(String nome) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		        Tipo tipo = (Tipo) em.createQuery("SELECT c from Tipo c where c.nome = :nome").setParameter("nome", nome).getSingleResult();
		      

		        return tipo;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
