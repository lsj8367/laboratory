package com.github.lsj8367.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.FixedLocaleResolver
import java.util.*


@Configuration
class ModuleConfig {

    @Bean
    fun localeResolver(): LocaleResolver {
        return FixedLocaleResolver(Locale.KOREA)
    }

}