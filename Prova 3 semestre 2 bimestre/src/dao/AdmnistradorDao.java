package dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.*;


public class AdmnistradorDao {

	private Connection con = null; 
	
	public String salvar(Admnistrador admnistrador) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(admnistrador);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Admnistrador: "+e.getMessage());
		} 
					
	}
	// alterar
		public String alterar(Admnistrador admnistrador) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(admnistrador);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Admnistrador: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Admnistrador admnistrador) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Admnistrador c = em.find(Admnistrador.class, admnistrador.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Admnistrador: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Admnistrador> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Admnistrador");
			return q.getResultList();				
		}
		
		 public Admnistrador getAdmnistrador(String user, String senha) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		        Admnistrador admnistrador = (Admnistrador) em.createQuery("SELECT u from Admnistrador u where u.nome = :user and u.senha = :senha").setParameter("user", user).setParameter("senha", senha).getSingleResult();
		      

		        return admnistrador;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
