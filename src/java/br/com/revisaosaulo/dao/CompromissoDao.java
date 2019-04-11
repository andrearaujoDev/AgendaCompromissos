package br.com.revisaosaulo.dao;

import br.com.revisaosaulo.domain.Compromisso;
import br.com.revisaosaulo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public class CompromissoDao {
     public List<Compromisso> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Compromisso> compromissos = session.createQuery("from Compromisso order by descricao asc").list();
            session.getTransaction().commit();
            return compromissos;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    public Boolean inserir(Compromisso compromissos){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(compromissos);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        
    }
    
    public Boolean alterar(Compromisso compromissos){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(compromissos);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    public Boolean excluir(Compromisso compromissos){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(compromissos);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    } 
}
