package com.hp.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Curtain-call
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    /**后台监控*/
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登录  账号密码配置
        HashMap<String , String> initParameters = new HashMap<>();
        //添加配置   登录的keys是固定的
        initParameters.put("loginUsername","Admin");
        initParameters.put("loginPassword","12345");

        //允许谁可以访问
        initParameters.put("allow","");

        //设置初始化参数
        bean.setInitParameters(initParameters);

        return bean;
    }


    /**filter*/
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        //过滤请求
        HashMap<String, String> initParameters = new HashMap<>();
        //这些不进行统计"*.js,*.css,/druid/**"
        initParameters.put("exclusions", "*.js,*.css,/druid/**");

        bean.setInitParameters(initParameters);
        return bean;
    }
}
