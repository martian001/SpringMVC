package com.et.student.service;

import java.util.List;

import com.et.student.bean.Student;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月26日 下午8:18:03      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public interface StudentService {
   /**
    * 增加后修改一个对象
    * @param t
    */
   void saveOrUpdate(Student t);

   /**
    * 删除对象
    * @param t
    */
   void delete(Student t);

   /**
    * 查询所有对象
    * @return
    */
   List<Student> getAll();

   /**
    * 根据id查询对象
    * @param id
    * @return
    */
   Student getById(Long id);

}
