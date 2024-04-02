package com.razz.hibernate.controller;

import com.razz.hibernate.domain.Book;
import com.razz.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(Client.class);

       //1. get the session factory
        SessionFactory sf = SessionFactoryConfiguration.getSessionFactory();

        //2. get the session
        Session session = sf.openSession();

        //3.Start the transaction
        Transaction transaction = session.beginTransaction();

        //4.write the logic for db operation
        Book book1 = new Book("ISBN8888", "SunMicroSystem", "Eclipse", 5000);
        session.persist(book1);

        //5. commit the transaction
        transaction.commit();

        Query<Book> selectBFromBookB = session.createQuery("select b from Book b", Book.class);
        log.info("Get all book ->{}",selectBFromBookB.getResultList());

        Book book = session.get(Book.class, 1);
        log.info(" get single book {}",book);


        //6. close the session and session factory
        session.close();
        sf.close();

    }
}
