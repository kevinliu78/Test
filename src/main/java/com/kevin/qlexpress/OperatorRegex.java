package com.kevin.qlexpress;

import com.kevin.util.StringRegexpFilterUtil;
import com.ql.util.express.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * 字符串通配符正则匹配
 * 
 * @Author: LWS
 * @Date: 2020/9/16 10:36
 */
public class OperatorRegex extends Operator {

  private static final Logger logger = LoggerFactory.getLogger(OperatorRegex.class);

  public OperatorRegex(String name) {
    this.name = name;
  }

  public OperatorRegex(String aAliasName, String aName, String aErrorInfo) {
    this.name = aName;
    this.aliasName = aAliasName;
    this.errorInfo = aErrorInfo;
  }

  @Override
  public Object executeInner(Object[] list) throws Exception {
    boolean result;
    Object o1 = list[0];
    Object o2 = list[1];
    if (o1 instanceof String && o2 instanceof String) {
      String src = (String) o1;
      String des = (String) o2;
      //去除关键字中的特殊字符
      src = StringRegexpFilterUtil.stringFilter(src);
      des = StringRegexpFilterUtil.stringFilter(des);
      String regex = des.replaceAll("%wildcard%", ".*");
      regex = ".*" + regex + ".*";
      result = Pattern.matches(regex, src);
      logger.info("operator regex  src==={},===des==={},===result=={}", src, des, result);
    } else {
      String msg = "没有定义类型" + o1 + "和" + o2 + " 的 " + this.name + "操作";
      throw new Exception(msg);
    }
    return result;
  }
}
