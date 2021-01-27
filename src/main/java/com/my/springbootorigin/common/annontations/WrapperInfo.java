package com.my.springbootorigin.common.annontations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WrapperInfo {

    /**
     * 查询条件类型
     * @return
     */
    int value();

    /**
     * 数据库字段
     * 当实体字段与数据库字段不一致时使用此注解
     */
    String field() default "";

    /**
     * 所属表格
     * 当多表联查时，用此注解标明该字段属于哪个表格，单表查询无需此注解
     */
    String table() default "";
}
