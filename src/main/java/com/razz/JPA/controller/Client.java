package com.razz.JPA.controller;

import com.razz.JPA.domain.Book;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(Client.class);

       //1. get the session factory
        //used in hibernate
        //SessionFactory sf = SessionFactoryConfiguration.getSessionFactory();

        //1. JPA way to get the entityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookstore");


        //2. get the session    //hibernate way
       // Session session = sf.openSession();

        //2. get the session    //JPA way
        EntityManager em = emf.createEntityManager();

        //3.Start the transaction //hibernate way
       // Transaction transaction = session.beginTransaction();

        //3.get the transaction //JPA way
        EntityTransaction transaction = em.getTransaction();

        try{
         //4.start the transaction //JPA way
            transaction.begin();

            //4.write the logic for db operation
            Book book1 = new Book("ISBN8888", "anybook", "anyauthor", 100);
            em.persist(book1);

            //5. commit the transaction
            transaction.commit();

        }catch(Exception e){
            log.info("{}",e.getMessage());
            transaction.rollback();
        }


        TypedQuery<Book> listOfBook = em.createQuery("select b from Book b", Book.class);
        log.info("Get all book ->{}",listOfBook.getResultList());

        Book book = em.find(Book.class, 1);
        log.info(" get single book {}",book);


        //6. close the entityManager and sessionManagerfactory
        em.close();
        emf.close();

    }
}
