package com.yafan.demo.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;


@Service
public class Producer {

    /**
     * 生产者的组名
     */
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;

    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    public void defaultMQProducer(String topic){
        // 生产者的组名
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);

        // 指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);   //关闭vip 管道

        /**
         * Producer对象在使用之前必须要调用start初始化，初始化一次即可 注意：切记不可以在每次发送消息时，都调用start方法
         */
        try {
            producer.start();


        // 创建一个消息实例，包含 topic、tag 和 消息体
        // 如下：topic 为 "TopicTest"，tag 为 "push"
        Message message = new Message(topic, "push", "发送消息----测试-----".getBytes());

        StopWatch stop = new StopWatch();
        stop.start();
        for (int i = 0; i < 10; i++) {
            SendResult result = producer.send(message, new MessageQueueSelector() {

                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, 1);
            System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
        }
        stop.stop();
        System.out.println("----------------发送十条消息耗时：" + stop.getTotalTimeMillis());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
