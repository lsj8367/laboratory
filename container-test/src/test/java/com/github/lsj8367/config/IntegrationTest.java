package com.github.lsj8367.config;

import com.github.lsj8367.entity.Member;
import com.github.lsj8367.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

//    @Container
//    private static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>()
//        .withInitScript("schema.sql");
    //
    @Container
    private final MySQLContainer<?> mariaDB = new MySQLContainer<>("mysql:8.0.24") // 이미지
        .withUsername("root") // DB 사용자
        .withPassword("123") // 암호
        .withDatabaseName("auth"); // 사용할 데이터베이스

    @Autowired
    private MemberService memberService;

    @Test
    void test() {
        memberService.save();
        final Member member = memberService.get();
        System.out.println(member.getId());
        System.out.println(member.getName());
    }
}
