package com.yafan.demo.meiju;

import lombok.Getter;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/20:20
 * @Description:
 */
@Getter
public enum DynamicDataSourceEnum {

    MASTER("master"),
    SLAVE("slave");
    private String dataSourceName;
    DynamicDataSourceEnum(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
}
