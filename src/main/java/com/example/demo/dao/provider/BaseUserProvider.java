package com.example.demo.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

public class BaseUserProvider {

    public String queryUserInfoAll(){
      return  new SQL(){{
          SELECT("*").FROM("sys_user").ORDER_BY("createtime desc");
      }}.toString();
    }

    /**
     * 查询用户基本信息
     *
     * @param paramMap
     * @return
     */
    public String queryUserInfo(Map<String, Object> paramMap) {
        final String account = paramMap.get("account").toString();
        final String userPhone = paramMap.get("userPhone").toString();
        return new SQL() {{
            SELECT("*").FROM("sys_user");
            if (StringUtils.isEmpty(account)) {
                WHERE("account=#{account}");
            }
            if (StringUtils.isEmpty(userPhone)) {
                WHERE("userPhone=#{userPhone}");
            }
            ORDER_BY("createtime");
        }}.toString();
    }

}
