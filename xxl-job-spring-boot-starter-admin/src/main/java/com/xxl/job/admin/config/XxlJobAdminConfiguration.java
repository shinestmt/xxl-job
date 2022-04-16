package com.xxl.job.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Role;

/**
 * @author fanhang
 */
@Configuration(proxyBeanMethods = false)
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
@ComponentScan(basePackages = {"com.xxl.job.admin"})
@MapperScan(basePackages = {"com.xxl.job.admin.dao"})
@PropertySource(value = "classpath:cfg/xxl-job-base.properties", ignoreResourceNotFound = false)
public class XxlJobAdminConfiguration {
}
