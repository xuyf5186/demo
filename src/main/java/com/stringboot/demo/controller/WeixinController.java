package com.stringboot.demo.controller;

import com.stringboot.demo.help.weixin.object.WxVerifyObject;
import com.stringboot.demo.service.WeixinService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/19
 * Time 18:45
 */
@RestController
public class WeixinController {
    @Autowired
    private WeixinService weixinService;

    /**
     * 用于微信接口校验
     * @param wxObject
     * @return String
     */
    @RequestMapping("/wechat")
    public String verifyNotify(WxVerifyObject wxObject){
        if(wxObject.getNonce()!=null && wxObject.getTimestamp()!=null && weixinService.verifyNotify(wxObject))
        {
            return wxObject.getEchostr();
        }
        return "";
    }

    public String getAccess() throws JSONException {
        return weixinService.getAccessToken();
    }
}
