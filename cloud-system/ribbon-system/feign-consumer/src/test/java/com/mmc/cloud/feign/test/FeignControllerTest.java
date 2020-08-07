package com.mmc.cloud.feign.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmc.cloud.feign.vo.CutPayRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @packageName：com.mmc.cloud.feign.test
 * @desrciption:
 * @author: GW
 * @date： 2020-08-03 14:36
 * @history: (version) author date desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FeignControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        String uri = "/cutPay";
        ObjectMapper mapper = new ObjectMapper();
        CutPayRequest request = new CutPayRequest();
        request.setAccountNo("37000001001");
        request.setCutPayNo("m-pay-202008031447000001");
        request.setMoney(100000);
        request.setPassword("absc123");
        request.setTradeNo("m-trade-202008031447000002");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(request)).accept(MediaType.ALL)).andReturn();

        MockHttpServletResponse response = result.getResponse();
        System.out.println("status -> " + response.getStatus());
        System.out.println("content-length -> " + response.getContentLength());
        System.out.println("headers -> " + response.getHeaderNames());
        System.out.println("content-type -> " + response.getContentType());
        System.out.println("body -> " + response.getContentAsString());
    }
}
