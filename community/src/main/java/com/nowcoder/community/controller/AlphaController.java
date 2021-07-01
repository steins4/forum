package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/sayhello")
    @ResponseBody
    public String sayHello() {
        return "hello spring boot"+ (1+2);
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + ":" + value);
        }

        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<h1>问那个伯伟</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // students?current=2&limit = 20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current", required = false, defaultValue = "1") int current,
                              @RequestParam(name = "limit", required = false, defaultValue = "10")int limit) {
        System.out.println("current:"+current+"limit:"+limit);
        return "some students";
     }


    // student/{id}
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
     public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "student:"+id;
    }

    //post请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, String age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应html数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView model = new ModelAndView();
        model.addObject("name", "ZHANGSAN");
        model.addObject("age", 30);
        model.setViewName("/demo/view");
        return model;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "ZHANGSAN");
        model.addAttribute("age", 30);

        return "/demo/view";
    }

    //响应JSON数据，异步请求
    // Java对象-》JSon对象-》js对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 23);
        map.put("salary", 32000);
        return map;
    }




}
