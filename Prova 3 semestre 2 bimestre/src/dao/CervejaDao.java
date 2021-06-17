package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import classes.*;


public class CervejaDao {

	private Connection con = null; 
	
	public String salvar(Cerveja cerveja) throws Exception {
		//String retorno;
		try {
			EntityManager em = Conexao.getEntityManager();			
			em.getTransaction().begin();
			em.persist(cerveja);
			em.getTransaction().commit();			
			return "Ok";
		} catch(Exception e) {
			throw new Exception("Erro gravando Cerveja: "+e.getMessage());
		} 
				
	}
	// alterar
		public String alterar(Cerveja cerveja) throws Exception {
			try {			
				EntityManager em = Conexao.getEntityManager();			
				em.getTransaction().begin();
				em.merge(cerveja);
				em.getTransaction().commit();			
				return "Ok";			
			} catch(Exception e) {
				throw new Exception("Erro gravando Cerveja: "+e.getMessage());
			}		
		}
		
		// excluir
		public String deletar(Cerveja cerveja) throws Exception {
			try {
				EntityManager em = Conexao.getEntityManager();
				Cerveja c = em.find(Cerveja.class, cerveja.getId());
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();			
				return "Ok";
			}catch(Exception e) {
				throw new Exception("Erro gravando  Cerveja: " + e.getMessage());
			}		
		}	
		
		// consultar
		public List<Cerveja> consultar() throws Exception{
			// criar uma var para lista
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Cerveja");
			return q.getResultList();				
		}
		
		
		public Cerveja getCerveja(String nome) {

			 EntityManager em = Conexao.getEntityManager();
		      try {
		        Cerveja cerveja = (Cerveja) em.createQuery("SELECT c from Cerveja c where c.nome = :nome").setParameter("nome", nome).getSingleResult();
		      

		        return cerveja;
		      } catch (NoResultException e) {
		            return null;
		      }
		    }
		
			
		public int numeroCervejas() {
			EntityManager em = Conexao.getEntityManager();
			Query q = em.createQuery("from Cerveja");
			List <Cerveja> lista = q.getResultList();
			int i = lista.size();
			return i;
		}
		
		public void favoritar(Cerveja cerveja, Usuario usuario) throws Exception {
			try {
	            Connection con = null;
	            String url = "jdbc:sqlserver://localhost;databaseName=prova3_2;";
	            
	            String username = "Teste";
	   		 	String password = "barth2006";
	   		 	
	            con = DriverManager.getConnection(url,username,password);
	            System.out.println("marcador");
	            String cSql = "select * from TB_USUARIO_CERVEJA where usuario_id = (?) and cerveja_id = (?)";

	            PreparedStatement pstnt = con.prepareStatement(cSql);
	            pstnt.setInt(1, usuario.getId());
	            pstnt.setInt(2, cerveja.getId());

	            ResultSet rs = pstnt.executeQuery();
	            int numLinhas = 0;
	            while (rs.next()) {
	                numLinhas++;
	            }
	            if (numLinhas == 0) {
	                System.out.println("Conectou favorito");

	                cSql = "insert into TB_USUARIO_CERVEJA (usuario_id, cerveja_id) " + "values (?, ?)";
	                pstnt = con.prepareStatement(cSql);
	                pstnt.setInt(1, usuario.getId());
	                pstnt.setInt(2, cerveja.getId());
	                pstnt.execute();
	                JOptionPane.showMessageDialog(null, "Cerveja favoritada");
	                //System.out.println("favoritada");
	            } else {
	                JOptionPane.showMessageDialog(null, "Voce ja favoritou essa cerveja");
	            	//System.out.println("ja favoritou");
	            }

	            pstnt.close();
	            con.close();

	        } catch (Exception ex) {
	            //JOptionPane.showMessageDialog(null, ex.getMessage());
	        	System.out.println(ex);
	        }
					
		}
		
		public List<Cerveja> pesquisaPerso(String nome, Integer idtipo) throws Exception{        
	        EntityManager em = Conexao.getEntityManager();
	        String cSql = "select g from Cerveja g";
	        String cWhere = "";
	        Query q = null;
	        if (nome.equals("")) {
	        }
	        else {
	            cWhere = "  nome = :nome";
	        }        
	        if (idtipo != 0) {
	            if (cWhere.equals("")) {
	                cWhere = cWhere + " tipo_id = :tipo_id";
	            }
	            else {
	                cWhere = cWhere + " and tipo_id = :tipo_id";
	            }            
	        }
	        
	        
	        q = em.createQuery(cSql + " where " + cWhere);        
	        
	        if (nome.equals("")) {
	        	
	        }
	        else {
	            q.setParameter("nome", nome);
	        }        
	        if (idtipo != 0) {
	            q.setParameter("tipo_id", idtipo);
	        }
	        
	        System.out.println(cSql + " WHERE " + cWhere);
	        
	        return q.getResultList();        
	    } 
		
}

