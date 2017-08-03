package com.jose.controller.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetWeather {

     public static String json() throws Exception{

        String city = java.net.URLEncoder.encode("上海", "utf-8");
        //此处获取的是xml格式的数据,如果想获取json格式的数据直接将下面url的xml改成json 因为xml格式获取的数据比较全,所以这里自己解析了
        String apiUrl = String.format("http://www.sojson.com/open/api/weather/xml.shtml?city=%s",city);
        URL url= new URL(apiUrl);
        URLConnection open = url.openConnection();
        InputStream input = open.getInputStream();
        String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");

        return result;

     }
}
