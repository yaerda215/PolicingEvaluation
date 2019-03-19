package com.zjw.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 定义PO类的主键
 *
 * @author zjw
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ID {

    /**
     * 主键数据类型，默认整数型
     */
    int type() default PUBVALUE.TABLE_ID_TYPE_UUID;

}
