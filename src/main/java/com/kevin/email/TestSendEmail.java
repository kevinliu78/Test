package com.kevin.email;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.kevin.util.SendMail;

/**
 * @author kevin
 * @version 创建时间: Dec 20, 20184:37:59 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TestSendEmail {
	public static void main(String[] args) {
		String content = "尊敬的 tutu 用户";
		content += "<br/>";
		content += "您的密码已经重置为:123456"
				+ ",请及时登陆修改密码防止个人信息丢失";
		content += "<br/>";
		try {
			String hostName = "smtp.263.net";
			int port = 25;
			String userName = "netwatch@pbn.com.cn";
			String mpassword = "Pbn123123";

			SendMail sendMail = new SendMail(hostName, port);
			sendMail.setNamePass(userName, mpassword);
			sendMail.setNeedAuth(true);
			sendMail.send("重置密码成功", content, "", userName, "kevin.liu@pbn.com.cn", "");
		} catch (Exception e) {
			
		}
	}
	
	
	private static final int timeOut = 10000; //超时应该在3钞以上  
    
    public static boolean isPing(String ip)  
    {  
        boolean status = false;  
        if(ip != null)  
        {  
            try  
            {  
                status = InetAddress.getByName(ip).isReachable(timeOut);  
            }  
            catch(UnknownHostException e)  
            {  
                  
            }  
            catch(IOException e)  
            {  
                  
            }  
        }  
         return status;  
    }  
}
