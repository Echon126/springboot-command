package com.example.demo.common;

/**
 * @author admin
 * @date 2018-9-12 10:43
 */
public interface IContext {

    /**
     * 执行get请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public RequestResult get(String url) throws Exception;

    /**
     * 执行带有参数的 get请求
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public RequestResult get(String url, RequestParams params) throws Exception;


}
