package com.github.lsj8367.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 이 어노테이션이 런타임에도 유지되어야 한다는 표시
// 생략하면 테스트 도구는 @Test를 인식할 수 없다.
@Retention(RetentionPolicy.RUNTIME)
// @Test가 반드시 메소드 선언에서만 사용되어야 한다고 알려줌
@Target(ElementType.METHOD)
public @interface Test {

}
