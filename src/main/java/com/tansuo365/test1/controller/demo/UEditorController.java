//package com.tansuo365.test1.controller.demo;
//
//import com.baidu.ueditor.ActionEnter;
//import org.json.JSONException;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Controller
//@Transactional
//@RequestMapping("/ueditor")
//public class UEditorController {
//
//    @PostMapping("/data")
//    @ResponseBody
//    public void getConfigInfo(HttpServletRequest request, HttpServletResponse response){
//        response.setContentType("application/json");
//        String rootPath = request.getSession().getServletContext().getRealPath("/");
//
//        try {
//            String exec = new ActionEnter(request,rootPath).exec();
//            PrintWriter writer = response.getWriter();
//            writer.write(exec);
//            writer.flush();
//            writer.close();
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//        }
//    }
//}
