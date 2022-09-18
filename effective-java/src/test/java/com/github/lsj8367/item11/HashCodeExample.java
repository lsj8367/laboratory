package com.github.lsj8367.item11;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Test;

class HashCodeExample {

//    @Test
//    void notExistHash() {
//        final Map<User, String> map = new HashMap<>();
//        map.put(new User("name", "email"), "테스트");
//
//        final String s = map.get(new User("name", "email"));
//        assertThat(s).isNull();
//    }

    @Test
    void existHash() {
        final Map<User, String> map = new HashMap<>();
        map.put(new User("name", "email"), "테스트");

        final String s = map.get(new User("name", "email"));
        assertThat(s).isEqualTo("테스트");
    }

    private static class User {

        private final String name;
        private final String email;

        public User(final String name, final String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final User user = (User) o;
            return Objects.equals(name, user.name) && Objects.equals(email, user.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, email);
        }

    }

}
