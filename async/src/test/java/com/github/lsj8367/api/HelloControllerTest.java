package com.github.lsj8367.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.github.lsj8367.application.HelloService;
import java.util.concurrent.RejectedExecutionException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HelloService helloService;

    @Test
    void test() throws Exception {
        Assertions.assertThatExceptionOfType(NestedServletException.class)
            .isThrownBy(() -> mockMvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("data").value("success")));
    }

}
