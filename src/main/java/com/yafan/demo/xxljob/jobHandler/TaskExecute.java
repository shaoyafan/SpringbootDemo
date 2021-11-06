package com.yafan.demo.xxljob.jobHandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/11:23
 * @Description:
 */
@Component
public class TaskExecute {
    private final static Logger logger = LoggerFactory.getLogger(TaskExecute.class);

    @XxlJob("myJobHandler")
    public void execute() {
        // 获取参数
        String param = XxlJobHelper.getJobParam();

        //控制台输出日志
        logger.info("myXxlJobHandler execute...");

        //写日志到调度中心日志中
        XxlJobHelper.log("myXxlJobHandler execute...");

        // 设置任务结果
        XxlJobHelper.handleSuccess();
    }

}
