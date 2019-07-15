package com.wind.util;

import java.util.UUID;

/**
 * @package com.wind.util
 * @className IdGenUtil
 * @note 封装各种生成唯一性ID算法的工具类.
 * @author wind
 * @date 2018/6/3 15:21
 */
public class IdGenUtil {

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
