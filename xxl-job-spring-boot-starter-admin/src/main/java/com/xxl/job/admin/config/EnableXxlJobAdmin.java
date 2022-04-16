package com.xxl.job.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author fanhang
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(XxlJobAdminConfiguration.class)
@Documented
public @interface EnableXxlJobAdmin {
}
