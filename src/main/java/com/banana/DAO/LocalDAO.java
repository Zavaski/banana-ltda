package com.banana.DAO;

import com.banana.Model.Local;
import com.banana.Model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LocalDAO {

    public void criarLocal(Local local) {
        System.out.println("Cadastrar Local DAO");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(local);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Local> listarLocais(){
        System.out.println("Listar Local DAO");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List <Local> locais = session.createQuery("from Local ", Local.class).list();
            return locais;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public void deletarLocal(Local local) {
        System.out.println("Deletar Local DAO");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(local);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editarLocal(Local local) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(local);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Local searchLocal(int ID){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Local local =  (Local) session.get(Local.class, ID);
            transaction.commit();
            return local;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
