package com.stringboot.demo.service;

import com.stringboot.demo.help.weixin.WxConfig;
import com.stringboot.demo.help.weixin.object.WxVerifyObject;
import com.stringboot.demo.utils.WebUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/19
 * Time 18:46
 */
@Service
public class WeixinService {
    private static final Logger logger  = LoggerFactory.getLogger(WeixinService.class);
    public boolean verifyNotify(WxVerifyObject verifyObject){
        String [] arr=new String[]{verifyObject.getNonce(),verifyObject.getTimestamp(), WxConfig.TOKEN};
        Arrays.sort(arr);
        String s= StringUtils.join(arr);
        logger.info("拼接字符串:"+s);
        String sign= DigestUtils.sha1Hex(s);
        logger.info("加密后:"+sign);
        return Objects.equals(sign, verifyObject.getSignature());
    }
    public String getAccessToken() throws JSONException {
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("appid",WxConfig.APPID);
        params.put("secret",WxConfig.APPSECRET);
        JSONObject res=WebUtils.get(WxConfig.ACCESS_TOKEN_URL,params);
        return res.getString("access_token");
    }
}
