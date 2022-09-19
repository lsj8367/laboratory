package com.github.lsj8367.item12;

import org.junit.jupiter.api.Test;

class ToStringTest {

    @Test
    void test() {
        ToStringBefore before = new ToStringBefore("이름", "이메일");
        ToStringAfter after = new ToStringAfter("이름", "이메일");
        System.out.println(before);
        System.out.println(after);
    }

}
