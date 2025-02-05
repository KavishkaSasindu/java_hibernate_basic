package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

//        create object

        Student student = new Student();
        student.setRollNo(3);
        student.setStudentName("Kapila");
        student.setAge(23);

        System.out.println(student);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction(); // when we manipulate database value create or update it will need transaction

        session.persist(student);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}