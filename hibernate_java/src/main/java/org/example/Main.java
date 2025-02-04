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
        student.setRollNo(2);
        student.setStudentName("Cena");
        student.setAge(25);

        System.out.println(student);

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.example.Student.class);
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
    }
}