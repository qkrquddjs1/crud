package com.ohgiraffers.crud.menu.controller;


import com.ohgiraffers.crud.configuration.CrudApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@ContextConfiguration(classes = {CrudApplication.class})
public class CarControllerTests {

    @Autowired
    private CarController carController;
    private MockMvc mockMvc;


    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void 전체_자동차_조회용_컨트롤러_테스트() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/car/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("car/list"))
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    @Transactional
    public void 신규_자동차_등록용_컨트롤러_테스트() throws Exception {

        //given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("carCompany", "컨트롤러테스트");
        params.add("carName", "테스트");
        params.add("carNumber", "11더1111");

        // when & then
        mockMvc.perform(MockMvcRequestBuilders.post("/car/regist").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/car/list"))
                .andDo(MockMvcResultHandlers.print());
    }
}
