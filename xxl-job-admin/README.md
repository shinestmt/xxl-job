# 自定义构建 xxl-job-admin
采用类似于 Eureka 的模式, 自定义构建 xxl-job-admin
1. 极简构建, 开箱即用
2. 支持 spring-boot profile 多环境配置
3. 支持代码开发, 实现各类警报

## 1. 添加依赖

```xml
<dependency>
    <groupId>com.xuxueli</groupId>
    <artifactId>xxl-job-spring-boot-starter-admin</artifactId>
    <version>${xxl-job.version}</version>
</dependency>
```

## 2. 配置启动类
采用类似 Eureka 的模式, 使用 @EnableXxlJobAdmin
```java
@EnableXxlJobAdmin               // 启用 xxl-job-admin
@SpringBootApplication
public class XxlJobAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobAdminApplication.class, args);
    }
}
```

## 3. 自定义配置
自带【默认配置】: xxl-job-spring-boot-starter-admin # cfg/xxl-job-base.properties


自定义配置文件, 覆盖【默认配置】
```yaml
# 采用 spring-boot 配置体系

# 端口和前缀
server.port=8083
server.servlet.context-path=/

# 数据库配置
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=root_pwd
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# 数据库连接池
spring.datasource.type=com.zaxxer.hikari.HikariDataSource
spring.datasource.hikari.minimum-idle=10
spring.datasource.hikari.maximum-pool-size=30
spring.datasource.hikari.auto-commit=true

# xxl-job 应用配置
xxl.job.accessToken=abcdefghijklmn123456

# 自定义通知 (例如: 供飞书警告通知, 自行获取此类参数)
alarm.feishu.appId=13572468
alarm.feishu.secret=qwertyuiop123456
```

## 4. 添加多环境配置
采用原生 spring-boot 配置体系, 支持 profile 分环境配置, 比如：
```
application-dev.properties    开发环境
application-test.properties   测试环境
application-prod.properties   生产环境
```

## 5. 开发警告通知
自定义代码实现警告通知, 比如: 飞书/钉钉/短信/邮件

参考 CustomAlarm.java
```java
@Component      // 标识为 spring bean
public class CustomAlarm implements JobAlarm {
    private static final Logger log = LoggerFactory.getLogger(CustomAlarm.class);

    @Override
    public boolean doAlarm(XxlJobInfo info, XxlJobLog jobLog) {
//        restTemplate.post(.......)      // 执行发送
        log.info("发送[{}]通知: {}", "飞书", info.getJobDesc());
        return true;
    }
}
```
