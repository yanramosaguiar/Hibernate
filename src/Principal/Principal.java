/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;
import java.util.Iterator;
import pacote.Pessoa;
import pacote.PessoaHelper;

/**
 *
 * @author Yan
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // loads configuration and mappings
/*
  StandardServiceRegistry standardRegistry = 
       new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();

        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Pessoa category = new Pessoa();
        category.setCpf("123");
        category.setEmail("anderson");
        category.setIndice(50);
        category.setNome("anderson2");
        category.setTelefone("1231312312");

        session.save(category);

        session.getTransaction().commit();
        session.close();
        session.getSessionFactory().close();*/

        System.out.println("======");
        PessoaHelper banco = new PessoaHelper();
        ArrayList pessoas = (ArrayList) banco.getList(0, 1000);
        Iterator proximo = pessoas.iterator();

        while (proximo.hasNext()) {
            Pessoa p = (Pessoa) proximo.next();
            System.out.println(p.getNome());
        }
        System.out.println("======");
        banco = new PessoaHelper();
        Pessoa p = new Pessoa();
        p.setNome("Anderson F P Santos");
        p.setTelefone("27317319837182937");
        banco.inserir(p);
        System.out.println("======");
        banco = new PessoaHelper();
        pessoas = (ArrayList) banco.getList(0, 1000);
        proximo = pessoas.iterator();
        while (proximo.hasNext()) {
            p = (Pessoa) proximo.next();
            System.out.println(p.getNome());
        }

        banco = new PessoaHelper();
        p = new Pessoa();
        p.setNome("anderson2");
        banco.remover(p);

        System.out.println("======");
        banco = new PessoaHelper();
        pessoas = (ArrayList) banco.getList(0, 1000);
        proximo = pessoas.iterator();

        while (proximo.hasNext()) {
            p = (Pessoa) proximo.next();
            System.out.println(p.getNome());
        }
        
        banco = new PessoaHelper();
        p = new Pessoa();
        p.setNome("Anderson F P Santos");
        banco.remover(p);

        System.out.println("======");
        banco = new PessoaHelper();
        pessoas = (ArrayList) banco.getList(0, 1000);
        proximo = pessoas.iterator();

        while (proximo.hasNext()) {
            p = (Pessoa) proximo.next();
            System.out.println(p.getNome());
        }
        
        banco = new PessoaHelper();
        p = new Pessoa();
        p.setNome("Anderson Santos");
        banco.remover(p);

        System.out.println("======");
        banco = new PessoaHelper();
        pessoas = (ArrayList) banco.getList(0, 1000);
        proximo = pessoas.iterator();

        while (proximo.hasNext()) {
            p = (Pessoa) proximo.next();
            System.out.println(p.getNome());
        }
        
        System.out.println("======");
        banco = new PessoaHelper();
        p = new Pessoa();
        p.setNome("Anderson F P Santos");
        p.setTelefone("27317319837182937");
        banco.inserir(p);
        System.out.println("======");
        banco = new PessoaHelper();
        pessoas = (ArrayList) banco.getList(0, 1000);
        proximo = pessoas.iterator();

        while (proximo.hasNext()) {
            p = (Pessoa) proximo.next();
            System.out.println(p.getNome());
        }
        
        System.out.println("======");
        banco = new PessoaHelper();

        p.setTelefone("1111111");
        banco.atualizar(p);
        System.out.println("======");
        banco = new PessoaHelper();
        pessoas = (ArrayList) banco.getList(0, 1000);
        proximo = pessoas.iterator();

        while (proximo.hasNext()) {
            p = (Pessoa) proximo.next();
            System.out.println(p.getNome());
        }
    }

}
