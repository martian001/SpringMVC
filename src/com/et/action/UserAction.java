package com.et.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月26日 上午10:42:06      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
@Controller
@RequestMapping("/userAction/user.do")
public class UserAction {

   public UserAction() {
      System.out.println("UserAction.UserAction()");
   }

   @RequestMapping
   public String toIndex() {
      System.out.println("UserAction.toIndex()");
      return "/userAction/userIndex";
   }

   // method=RequestMethod.GET 表示只拦截POST请求
   @RequestMapping(method = RequestMethod.POST)
   public String doPost() {
      System.out.println("post请求");
      return "/userAction/userIndex";
   }

   // method=RequestMethod.GET 表示只拦截GET请求
   @RequestMapping(method = RequestMethod.GET)
   public String doGet() {
      System.out.println("GET请求");
      return "/userAction/userIndex";
   }

   // params = "method=getParams" 如果当前请求包含后面的参数,那么就调用下面的方法,注意:这里的参数一般是固定的
   @RequestMapping(params = "method=getParams")
   // 演示了通过形参传值,只要前台声明,在下面方法上面定义就可以拿到
   public String getParams(String name, int age) {
      System.out.println("测试获取参数：name：" + name + "  age:" + age);
      return "/userAction/userIndex";
   }

   @RequestMapping(params = "method=getParams2")
   // 演示了通过形参传值,用来把实际参数parameter转化成方法的形参
   public String getParams2(@RequestParam("name") String userName, int age) {
      System.out.println("通过@RequestParam转换获取参数：name：" + userName + "  age:" + age);
      return "/userAction/userIndex";
   }

   /**测试转发*/
   @RequestMapping(params = "method=forward")
   public String forward(String name, int age) {
      System.out.println("转发  name:" + name + "  age:" + age);
      // return "forward:userIndex.jsp";
      return "forward:user.do?method=getParams2";
   }

   /**测试重定向*/
   @RequestMapping(params = "method=redirect")
   public String Redirect(String name, int age) {
      System.out.println("重定向  name:" + name + "  age:" + age);
      return "redirect:http://www.baidu.com";
   }

   // 测试每一个方法在调用之前都会调用该方法
   @ModelAttribute
   public void testModelAttribute() {
      System.out.println("testModelAttribute:准备数据");
   }

}
