package com.mmc.cloud.boot.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @packageName：com.mmc.cloud.boot.test
 * @desrciption: 测试基类
 * @author: GW
 * @date： 2020-07-27 14:38
 * @history: (version) author date desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BaseTest {
}
