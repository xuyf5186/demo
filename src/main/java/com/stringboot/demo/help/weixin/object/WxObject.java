package com.stringboot.demo.help.weixin.object;

import com.stringboot.demo.utils.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.binary.Hex;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA
 * Created by xuyf
 * Date 2017/12/19
 * Time 19:12
 */
public class WxObject {
    private static Logger logger = LoggerFactory.getLogger(WxObject.class);
    /**
     * 对自己进行签名
     * @return String
     */
    public String sign(String prefix, String suffix, String separator,
                       boolean ignoreEmptyValue, String[] ignoreKeys)
    {
        TreeMap<String,String> treeMap= SignUtil.object2Map(this);
        String mapString=SignUtil.MapToString(new TreeMap<String,Object>(treeMap),prefix,suffix,separator,ignoreEmptyValue,ignoreKeys);
        logger.info("微信加密签名串："+mapString);
        String result=DigestUtils.sha1Hex(mapString);//sha1加密
        logger.debug("签名结果:"+result);
        return result;
    }

    /**
     * 重载,方便使用
     * @return String
     */
    public String sign() {
        return sign(null,null,"&",false,null);
    }
    /**
     * 重载,方便使用
     * @return String
     */
    public String sign(String [] ignoreKeys) {
        return sign(null,null,"&",false,ignoreKeys);
    }
    /**
     * 重载,方便使用
     * @return String
     */
    public String MapToString(boolean ignoreEmptyValue) {
        return sign(null,null,"&",ignoreEmptyValue,null);
    }
    /**
     * 重载,方便使用
     * @return String
     */
    public String MapToString(String prefix) {
        return sign(prefix,null,"&",false,null);
    }
    /**
     * 重载,方便使用
     * @return String
     */
    public String MapToString(String prefix,String suffix) {
        return sign(prefix,suffix,"&",false,null);
    }
}
