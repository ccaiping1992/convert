package com.sys

import org.apache.commons.lang.RandomStringUtils

import javax.servlet.http.HttpServletRequest

class SystemService {

    /**
     * 获取随机数字
     * @param bit
     * @return
     */
    String getRandomNumber(int bit=6){
        String str = RandomStringUtils.random(bit,"0123456789")
        log.debug("noncestr in getRandomStr:${str}")
        return str
    }
    /**
     * 获取随机字符串，字符串中只包含大小写字母和数字
     * @param bit：字符串的位数
     * @return
     */
    String getRandomStr(int bit=16){
        String str = RandomStringUtils.random(bit,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890")
        log.debug("noncestr in getRandomStr:${str}")
        return str
    }
    /**
     * 获取以秒为单位的时间戳
     * @param d
     * @return
     */
    Long getTimestamp(Date d=new Date()){
//        以秒为单位
        Long l = d.getTime()/1000
        log.debug("getTimestamp:${l}")
        return l
    }

    /**
     * 获取订单编号的计算方法
     * @return
     */
    String getOrderCode(){
        return new Date().getTime() + RandomStringUtils.random(5, "1234567890")
    }

    /**
     * 获取客户端ip地址
     * @param request
     * @return
     */
    def getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
