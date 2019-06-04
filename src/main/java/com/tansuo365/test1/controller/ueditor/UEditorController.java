package com.tansuo365.test1.controller.ueditor;

import com.tansuo365.test1.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequestMapping("")
@Controller
public class UEditorController {

    /*官方demo*/
    @RequestMapping("/ueditor")
    private String ueditor() {
        return "/news/index";
    }


    @RequestMapping("/ueditorDemo")
    private String ueditorDemo() {
        return "/news/demo";
    }

    @RequestMapping(value = "/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO
    @ResponseBody
    @RequestMapping("editorData")
    public Integer testEditor(@RequestParam("content") String content) {
        System.out.println("content:" + content);
        return 1;
    }
}
