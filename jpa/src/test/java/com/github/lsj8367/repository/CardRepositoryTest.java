package com.github.lsj8367.repository;

import com.github.lsj8367.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(TestConfig.class)
class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    void test() {
        cardRepository.getCardSummary();
    }
}
