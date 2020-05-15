/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Yan
 */
public class PessoaHelper {

    Session session = null;

    public PessoaHelper() {
        session = HibernateUtil.getSessionFactory();
    }

    public List getList(int startID, int endID) {
        List<Pessoa> pessoaList = null;
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Pessoa as pessoa");
            pessoaList = (List<Pessoa>) q.list();
            session.clear();
            session.close();
            session.getSessionFactory().close();
        } catch (Exception e) {
            
        }
        return pessoaList;
    }

    public int inserir(Pessoa p) {
        session.beginTransaction();
        int i = (Integer) session.save(p);
        session.getTransaction().commit();
        session.getSessionFactory().close();
        return i;
    }

    public void atualizar(Pessoa p) {
        session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
        session.getSessionFactory().close();
    }

    public void remover(Pessoa p) {
        session.beginTransaction();
        Query q = session.createQuery("delete Pessoa WHERE nome= :nome");
        q.setParameter("nome", p.getNome());
        q.executeUpdate();
        session.getTransaction().commit();
        session.getSessionFactory().close();
    }
}
