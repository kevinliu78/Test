package com.kevin.http;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-07-12 16:40:36
 **/
public class Test {

    public static void main(String[] args) {
        String url = "http://192.168.135.215:15672/api/queues";
        String userName = "admin";
        String password = "admin";
        String result = httpGet(url, userName, password);
        System.out.println(result);
    }

    public static String httpGet(String url, String username, String password) {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpGet get = new HttpGet(url);
            get.addHeader("Content-Type", "application/json");
            get.addHeader("Accept", "application/json");
            get.addHeader("Authorization", "Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes("utf-8"))));
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(10000).setSocketTimeout(10000).setConnectTimeout(10000).build();
            get.setConfig(requestConfig);
            response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String respStr;
                try {
                    respStr = EntityUtils.toString(entity, "UTF-8");
                } catch (Exception e) {
                    respStr = null;
                }
                return respStr;
            }
        } catch (ConnectTimeoutException ex) {
            ex.printStackTrace();
        } catch (ClientProtocolException | UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (response != null)
                    response.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
