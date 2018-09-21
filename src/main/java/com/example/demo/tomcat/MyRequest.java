package com.example.demo.tomcat;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author admin
 * @date 2018-9-21 9:48
 */
public class MyRequest {
    private String url;
    private String method;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * TODO 解析http协议，提取头部信息以及相关的参数和方法名
     *
     * @param inputStream
     * @throws IOException
     */
    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            httpRequest = new String(httpRequestBytes, 0, length);
        }

        if (!StringUtils.isEmpty(httpRequest)) {
            String httpHead = httpRequest.split("\n")[0];
            url = httpHead.split("\\s")[1];
            method = httpHead.split("\\s")[0];
            System.out.println(this);
        }
    }
}
