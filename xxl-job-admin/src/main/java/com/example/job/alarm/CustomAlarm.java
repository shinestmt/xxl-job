package com.example.job.alarm;

import com.xxl.job.admin.core.alarm.JobAlarm;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.model.XxlJobLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义支持发送各类通知：
 * 自行开发，实现（飞书/钉钉/短信/邮件）的支持
 * @author fanhang
 */
@Component
public class CustomAlarm implements JobAlarm {
    private static final Logger log = LoggerFactory.getLogger(CustomAlarm.class);

    @Override
    public boolean doAlarm(XxlJobInfo info, XxlJobLog jobLog) {
//        restTemplate.post(.......)      // 执行发送
        log.info("发送[{}]通知: {}", "飞书", info.getJobDesc());
        return true;
    }
}
