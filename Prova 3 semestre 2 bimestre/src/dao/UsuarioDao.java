package dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import classes.*;


public class UsuarioDao {

	private Connection con = null; 
	
	public String salvar(Usuario usuario) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Usuario: "+e.getMessage());
		} 
					
	}
	// alterar
		public String alterar(Usuario usuario) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(usuario);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Usuario: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Usuario usuario) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Usuario c = em.find(Usuario.class, usuario.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Usuario: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Usuario> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Usuario");
			return q.getResultList();				
		}
		
		 public Usuario getUsuario(String user, String senha) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		        Usuario usuario = (Usuario) em.createQuery("SELECT u from Usuario u where u.nome = :user and u.senha = :senha").setParameter("user", user).setParameter("senha", senha).getSingleResult();
		      

		        return usuario;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
}
