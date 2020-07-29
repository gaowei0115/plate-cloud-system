package com.mmc.cloud.boot.test.Controller;

import com.mmc.cloud.boot.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @packageName：com.mmc.cloud.boot.test.Controller
 * @desrciption:
 * @author: GW
 * @date： 2020-07-27 14:53
 * @history: (version) author date desc
 */
public class IndexControllerTest extends BaseTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testAuto() throws Exception {
        String uri = "/index/auto";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.ALL))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        System.out.println("status -> " + response.getStatus());
        System.out.println("content-length -> " + response.getContentLength());
        System.out.println("headers -> " + response.getHeaderNames());
        System.out.println("content-type -> " + response.getContentType());
        System.out.println("body -> " + response.getContentAsString());
    }
}
