package com.example.demoSpringBoot;

import com.qch.controller.CustomerController;
import com.qch.service.Task;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringBootApplicationTests {
	private MockMvc mvc;




	@Before
	public void setUp() throws Exception {
		/*
		* MockMvcBuilder/MockMvcBuilders
		* MockMvcBuilder是用来构造MockMvc的构造器，
		* 其主要有两个实现：StandaloneMockMvcBuilder和DefaultMockMvcBuilder，分别对应之前的两种测试方式。
		* 对于我们来说直接使用静态工厂MockMvcBuilders创建即可：
		* MockMvcBuilders.webAppContextSetup(WebApplicationContext context)：指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
		* MockMvcBuilders.standaloneSetup(Object... controllers)：通过参数指定一组控制器，这样就不需要从上下文获取了；
		* */
		mvc = MockMvcBuilders.standaloneSetup(new CustomerController()).build();
	}
	@Test
	public void contextLoads() {
	}
	@Test
	public void getHello() throws Exception {

		/*
		* 1、mockMvc.perform执行一个请求；
		* 2、MockMvcRequestBuilders.get("/user/1")构造一个请求
		* 3、ResultActions.andExpect添加执行完成后的断言
		* 4、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
		* 5、ResultActions.andReturn表示执行完成后返回相应的结果。
		*/



		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}


}
