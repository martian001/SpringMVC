package com.et.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.et.bean.Teacher;
import com.et.student.bean.Student;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月26日 下午5:44:24      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
@Controller
// @SessionAttributes:表示如果ModelMap保存了一个key为teacher的值，则会把该属性存在session中，也就是request和session各一份
@SessionAttributes({ "teacher" })
public class TeacherAction {
   // 通过ModelMap把值放到request的域中
   @RequestMapping("/teacherAction/testModelMap.do")
   public String testModelMap(ModelMap map) {
      map.put("teacher", new Teacher(12, "梁衍君"));
      return "/teacherAction/teacher";
   }

   /**
    * ModelAndView:可以把值保存到request中，并且可以包含返回的视图
    * @return
    */
   @RequestMapping("/teacherAction/testModelView.do")
   public ModelAndView testModelView() {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.addObject("teacher", new Teacher(3, "martian"));
      modelAndView.setViewName("/teacherAction/teacher");
      return modelAndView;
   }

   /**
    * 测试通过ajax返回string
    * @return
    */
   @RequestMapping("/teacherAction/testAjaxString.do")
   public @ResponseBody String testAjaxString() {
      return "martian";
   }

   /**
    * 测试返回list到ajax
    * @return
    */
   @RequestMapping("/teacherAction/testAjaxJson.do")
   public @ResponseBody List testAjaxJson() {
      List<Student> students = new ArrayList<Student>();
      students.add(new Student((long) 1, "martian1", 21));
      students.add(new Student((long) 2, "martian2", 21));
      students.add(new Student((long) 3, "martian3", 21));
      return students;
   }
}
