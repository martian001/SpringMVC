package com.et.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadAction {

   @RequestMapping(value = "/upload.do")
   public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

      System.out.println("开始");
      String path = request.getSession().getServletContext().getRealPath("upload");
      String fileName = file.getOriginalFilename();
      // String fileName = new Date().getTime()+".jpg";
      System.out.println(path);
      File targetFile = new File(path, fileName);
      if (!targetFile.exists()) {
         targetFile.mkdirs();
      }

      // 保存
      try {
         file.transferTo(targetFile);
      } catch (Exception e) {
         e.printStackTrace();
      }
      model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);

      return "/upload/uploadResult";
   }

}