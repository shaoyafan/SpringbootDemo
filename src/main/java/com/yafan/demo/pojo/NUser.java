package com.yafan.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor  //有参构造器
@NoArgsConstructor  //无参构造器
@Accessors(chain = true) //链式写法
public class NUser implements Serializable {

    // 如果后期用雪花算法生成唯一id，则用String
    private String id;
    private String name;
    private int age;
    private String address;
    private String dbSource;

}
