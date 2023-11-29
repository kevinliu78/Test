package com.kevin.util;

/**
 * @desp 解析brocade cli的公共类
 * @author zhanglx
 * @date 2022-11-25
 */
public class BrocadeParseUtils {

  /**
   * 解析端口名称
   */
  public static String getPortName(String portNameFormat, String slot, String port) {
    if (slot == null) {
      slot = "";
    }

    if ("slot#port#".equals(portNameFormat)) {
      return (slot.length() > 0 ? "slot" + slot : "") + "port" + port;
    } else if ("s#p#".equals(portNameFormat)) {
      return (slot.length() > 0 ? "s" + slot : "") + "p" + port;
    } else {
      return "fc" + (slot.length() > 0 ? slot + "/" : "") + port;
    }
  }
}
