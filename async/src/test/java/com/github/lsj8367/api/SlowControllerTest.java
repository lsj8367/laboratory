package com.github.lsj8367.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StopWatch;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class SlowControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
            .defaultResponseCharacterEncoding(StandardCharsets.UTF_8)
            .alwaysExpect(status().isOk())
            .alwaysDo(print())
            .build();
    }

    @Test
    @DisplayName("동기로 공통자원 first를 얻어와 나머지 call 2,3,4를 실행후 시간을 체크한다.")
    void syncSlowData() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        mockMvc.perform(get("/sync/slow-test"));
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
    }

    @Test
    @DisplayName("비동기로 공통자원 first를 얻어와 나머지 call 2,3,4를 실행후 시간을 체크한다.")
    void asyncSlowData() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        mockMvc.perform(get("/async/slow-test"));
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
    }
}
