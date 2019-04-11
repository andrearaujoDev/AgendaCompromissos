package br.com.revisaosaulo.dao;

import br.com.revisaosaulo.domain.Contato;
import br.com.revisaosaulo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class ContatoDao {
     
    public List<Contato> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Contato> contato = session.createQuery("from Contato order by nome asc").list(); //Nome da Classe, onde está sendo mapeada no hibernate.cfg.xml
            session.getTransaction().commit();
            return contato;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
     public List<String> listarStrings(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<String> contato = session.createQuery("nome from Contato order by nome asc").list(); //Nome da Classe, onde está sendo mapeada no hibernate.cfg.xml
            session.getTransaction().commit();
            return contato;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    public Boolean inserir(Contato contato){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(contato);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        
    }
    
    public Boolean alterar(Contato contato){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(contato);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    public Boolean excluir(Contato contato){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(contato);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    } 
}
