package com.yafan.demo.xxljob.jobHandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/10:44
 * @Description:
 */
@Component
public class myjob {
    private static Logger logger = LoggerFactory.getLogger(myjob.class);

    @XxlJob("yfJobHandler")
    public void execute(){
        System.out.println("带的哈夫卡");
        //控制台输出日志
        logger.info("myXxlJobHandler execute...");

        //写日志到调度中心日志中
        XxlJobHelper.log("myXxlJobHandler execute...");

        // 设置任务结果
        XxlJobHelper.handleSuccess();
    }
}
