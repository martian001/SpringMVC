package com.et.student.service.impl;

import java.util.List;

import com.et.student.bean.Student;
import com.et.student.dao.StudentDao;
import com.et.student.dao.impl.StudentDaoImpl;
import com.et.student.service.StudentService;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月26日 下午8:18:51      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class StudentServiceImpl implements StudentService {
   private StudentDao studentDao = new StudentDaoImpl();

   @Override
   public void saveOrUpdate(Student t) {
      studentDao.saveOrUpdate(t);
   }

   @Override
   public void delete(Student t) {
      studentDao.delete(t);
   }

   @Override
   public List<Student> getAll() {
      // TODO Auto-generated method stub
      return studentDao.getAll();
   }

   @Override
   public Student getById(Long id) {
      // TODO Auto-generated method stub
      return studentDao.getById(id);
   }

}
