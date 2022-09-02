package com.github.lsj8367;

import java.lang.reflect.Field;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void name() {
        //given
        final Person name = new Person("name", 22);

        //when
        final Field[] declaredFields = name.getClass().getDeclaredFields();

        final Field declaredField = declaredFields[0];

        //then
        Assertions.assertThat(declaredFields[0].getName()).isEqualTo("name");
    }

}