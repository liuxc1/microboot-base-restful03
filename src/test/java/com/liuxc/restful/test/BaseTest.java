package com.liuxc.restful.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = com.liuxc.restful.StartSpringBootMain.class)
@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BaseTest {

}
