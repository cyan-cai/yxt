package com.java.yxt.util;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提供通过HTTP协议获取内容的方法 <br/>
 * 所有提供方法中的params参数在内部不会进行自动的url encode，如果提交参数需要进行url encode，请调用方自行处理
 *
 * @author Ailos
 * @Description: HTTP请求代理工具
 * @date 2019-7-9 16:17:34
 */
@Log4j2
public class HttpUtil {
    public static String get(String url) {
        return get(url, null, null);
    }

    public static String get(String url, Map<String, String> params) {
        return get(url, params, null);
    }

    public static String get(String url, Map<String, String> params, Map<String, String> headers) {
        //1.创建http客户端对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = "";
        try {
            //2.构建一个URI对象,根据url及参数
            URIBuilder uriBuilder = new URIBuilder(url);
            //2.1请求参数
            if (params != null && params.size() > 0) {
                for (String key : params.keySet()) {
                    uriBuilder.addParameter(key, params.get(key));
                }
            }
            URI uri = uriBuilder.build();
            //3.创建一个get请求
            HttpGet httpGet = new HttpGet(uri);
            //3.1请求头
            if (headers != null && headers.size() > 0) {
                for (String key : headers.keySet()) {
                    httpGet.addHeader(key, headers.get(key));
                }
            }
            //4.执行get请求,得到响应
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.从响应对象中获取响应数据
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            org.apache.http.client.utils.HttpClientUtils.closeQuietly(response);
            org.apache.http.client.utils.HttpClientUtils.closeQuietly(httpClient);
        }

        return result;
    }

    public static String post(String url) {
        return post(url, null);
    }

    public static String post(String url, Map<String, String> params) {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //封装post请求参数
        int size = params.size();
        if (params != null && size > 0) {
            List<NameValuePair> pairList = new ArrayList<>(size);
            for (String key : params.keySet()) {
                pairList.add(new BasicNameValuePair(key, params.get(key)));
            }
            try {
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(pairList);
                httpPost.setEntity(formEntity);
                //执行post请求
                CloseableHttpResponse response = null;
                try {
                    response = httpClient.execute(httpPost);
                    result = EntityUtils.toString(response.getEntity(), "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    org.apache.http.client.utils.HttpClientUtils.closeQuietly(response);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        org.apache.http.client.utils.HttpClientUtils.closeQuietly(httpClient);

        return result;
    }

    public static String postWithJson(String url, String jsonParams) {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(jsonParams, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            org.apache.http.client.utils.HttpClientUtils.closeQuietly(response);
        }

        org.apache.http.client.utils.HttpClientUtils.closeQuietly(httpClient);
        return result;
    }
}