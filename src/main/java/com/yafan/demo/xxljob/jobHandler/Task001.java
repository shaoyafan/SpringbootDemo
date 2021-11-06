package com.yafan.demo.xxljob.jobHandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.yafan.demo.pojo.NUser;
import com.yafan.demo.service.NUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/16:00
 * @Description:
 */

@Component
public class Task001 extends IJobHandler {

    @Resource
    private NUserService nUserService;

    @Override
    @XxlJob("Task001")
    public void execute() throws Exception {

        XxlJobHelper.log("查询用户信息开始。。。。。。");
        List<NUser> result = nUserService.getNUser("1");
        if(result == null){
            System.out.println("没有此用户");
        }
        System.out.println(result);
    }
}
