package com.example.pressure.measurement.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11Nio2Protocol;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by zhangyuhang
 * @Date 2023/12/5 13:57
 */
@Configuration
public class TomcatConfig {
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new
                TomcatServletWebServerFactory(){};
        tomcat.addAdditionalTomcatConnectors(http11Nio2Connector());
        return tomcat;
    }

    public Connector http11Nio2Connector(){
        Connector connector = new
                Connector("org.apache.coyote.http11.Http11Nio2Protocol");
        Http11Nio2Protocol nio2Protocol = (Http11Nio2Protocol)
                connector.getProtocolHandler();
        //等待队列长度
        nio2Protocol.setAcceptCount(500);
        //最大线程数
        nio2Protocol.setMaxThreads(500);
        //最大连接数
        nio2Protocol.setMaxConnections(10000);
        //设置30秒内没有请求则服务端自动断开keepalive链接
        nio2Protocol.setKeepAliveTimeout(30000);
        //当客户端发送超过10000个请求则自动断开keepalive链接
        nio2Protocol.setMaxKeepAliveRequests(500000);
        // 请求方式
        connector.setScheme("http");
        // 监听端口
        connector.setPort(9003);
        // 是否自动转发
        connector.setRedirectPort(8443);
        return connector;
    }


}
