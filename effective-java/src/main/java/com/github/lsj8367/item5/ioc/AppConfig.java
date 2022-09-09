package com.github.lsj8367.item5.ioc;

import com.github.lsj8367.item5.Dictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SpellChecker spellChecker(final Dictionary dictionary) {
        return new SpellChecker(dictionary);
    }

    @Bean
    public Dictionary dictionary() {
        return new SpringDictionary();
    }

}
