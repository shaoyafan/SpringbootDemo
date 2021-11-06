package com.yafan.demo.datasource;

/**
 * @Author：shaoyafan
 * @Data: 2021/11/05/20:51
 * @Description: 设置路由的目的为了方便查找对应的数据源，我们可以用ThreadLocal保存数据源的信息到每个线程中，方便我们需要时获取
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> DYNAMIC_DATASOURCE_CONTEXT = new ThreadLocal<>();
    public static void set(String datasourceType) {
        DYNAMIC_DATASOURCE_CONTEXT.set(datasourceType);
    }
    public static String get() {
        return DYNAMIC_DATASOURCE_CONTEXT.get();
    }
    public static void clear() {
        DYNAMIC_DATASOURCE_CONTEXT.remove();
    }

}
