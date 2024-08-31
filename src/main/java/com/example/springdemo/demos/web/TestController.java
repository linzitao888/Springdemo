package com.example.springdemo.demos.web;


import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/hello")
public class TestController {

    /**
     * 添加指派信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @POST
    @Path("/addHumanResourcesBoard")
    @Produces(MediaType.APPLICATION_JSON)
    public void addHumanResourcesBoard(@Context HttpServletRequest request, @Context HttpServletResponse response) throws Exception {
        try{
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))) {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }

            String requestBody = stringBuilder.toString();
            Map<String,Object> mapData= (Map<String, Object>) JSON.parse(requestBody);
            List<Map<String,Object>> list= (List<Map<String, Object>>) mapData.get("data");
            for (Map<String, Object> li : list) {

                String projectName = (String) li.get("projectName");
                int dataId = (int) li.get("dataId");
                String type = (String) li.get("type");
                String projectAmount = (String) li.get("projectAmount");
                String name = (String) li.get("name");
                String level = (String) li.get("level");
                String team = (String) li.get("team");
                int userId = (int) li.get("userId");
                String region = (String) li.get("region");

            }

            // 设置响应内容类型
            response.setContentType("text/plain");
            // 设置响应状态码为200（HTTP OK）
            response.setStatus(HttpServletResponse.SC_OK);

            // 获取输出流，向客户端写入数据
            PrintWriter out = response.getWriter();
            out.println(200);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
            StackTraceElement se= e.getStackTrace()[0];
        }
    }
}
