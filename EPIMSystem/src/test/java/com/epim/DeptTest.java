package com.epim;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.epim.datatransport.Request;
import com.epim.datatransport.Response;
import com.epim.datatransport.request.UserRequest;
import com.epim.datatransport.response.DepartmentResponse;
import com.epim.entity.Department;
import com.epim.entity.User;
import com.epim.service.DepartmentService;
import com.epim.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
@WebAppConfiguration
@ContextConfiguration(locations = {"/spring/spring.xml"})
public class DeptTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
       mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();  //初始化MockMvc对象
        //mockMvc = MockMvcBuilders.standaloneSetup(webApplicationContext).build();//两种方式都可以初始化mockMvc，推荐用这种，上面的会自动跳转地址status判断方法无效
    }

    @Test
    public void getDeptList()throws Exception{

//        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/user/reset-password")
//                .content(JSONUtils.toJSONString("y001"))
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result=mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
//
//        String content=result.getResponse().getContentAsString();
//
//        DepartmentResponse response= JSONObject.parseObject(content,DepartmentResponse.class);
//        System.out.println(response);

        String xmlPath="/spring/spring.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
//        DepartmentService service = (DepartmentService) context.getBean("DepartmentService");
//        Department user = service.findById("2001");
//        System.out.println(user.getName());

        UserService service = (UserService) context.getBean("UserService");
        User user = service.findById("y001");
        System.out.println(user.getSalt());

    }
}
