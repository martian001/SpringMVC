package com.et.student.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.et.student.bean.Student;
import com.et.student.dao.StudentDao;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： Studenthe One                  ☆★
★☆            @time：2014年11月26日 下午8:16:33      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyStudentime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class StudentDaoImpl implements StudentDao {
   private SessionFactory sessionFactory;

   {
      Configuration configure = new Configuration().configure("hibernate.cfg.xml");
      sessionFactory = configure.buildSessionFactory();
   }

   @Override
   public void saveOrUpdate(Student t) {
      Session currentSession = sessionFactory.openSession();
      Transaction beginTransaction = currentSession.beginTransaction();
      currentSession.saveOrUpdate(t);
      beginTransaction.commit();
      currentSession.close();
   }

   @Override
   public void delete(Student t) {
      Session currentSession = sessionFactory.openSession();
      Transaction beginTransaction = currentSession.beginTransaction();
      currentSession.delete(t);
      beginTransaction.commit();
      currentSession.close();
   }

   @Override
   public List<Student> getAll() {
      return sessionFactory.openSession().createSQLQuery("select * from student").addEntity(Student.class).list();
   }

   @Override
   public Student getById(Long id) {
      if (id == null) {
         return null;
      }
      return (Student) sessionFactory.openSession().get(Student.class, id);
   }

   public static void main(String[] args) {
      StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
      // List<Student> all = studentDaoImpl.getAll();
      // for (Student student : all) {
      // System.out.println(student);
      // }
      studentDaoImpl.saveOrUpdate(new Student(null, "777", 777));
   }
}