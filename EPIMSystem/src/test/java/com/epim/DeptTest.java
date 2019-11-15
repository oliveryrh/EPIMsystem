package com.epim;

import com.alibaba.druid.support.json.JSONUtils;
import com.epim.entity.Department;
import com.epim.service.DepartmentService;
import com.epim.service.impl.DepartmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//
//@RunWith(SpringJUnit4ClassRunner.class)
////@SpringBootTest
////@AutoConfigureMockMvc
//@WebAppConfiguration
//@ContextConfiguration
public class DeptTest {
//    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setup() {
//       // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();  //初始化MockMvc对象
//        mockMvc = MockMvcBuilders.standaloneSetup(webApplicationContext).build();//两种方式都可以初始化mockMvc，推荐用这种，上面的会自动跳转地址status判断方法无效
//    }

    @Autowired
    DepartmentService departmentService;
    @Test
    public void getDeptList()throws Exception{
//        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/department/get-dept")
//                .content(JSONUtils.toJSONString("2001"))
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result=mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
//
//        String content=result.getResponse().getContentAsString();
//        System.out.println(content);
//        String xmlPath="spring/spring.xml";
//        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
//        DepartmentService service = (DepartmentService) context.getBean("DepartmentService");
//        Department department = service.findById("2001");
//        System.out.println(department.getName());
        Connection connection;
        String driver="com.mysql.jdbc.Driver";
        //这里我的数据库是qcl
        String url="jdbc:mysql://localhost:3306/epim";
        String user="root";
        String password="epim";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = connection.createStatement();
            String sql="select * from user";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(resultSet);
            String name;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                System.out.println("姓名：" + name);
            }
            resultSet.close();
            connection.close();
        }catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }

    }
}
