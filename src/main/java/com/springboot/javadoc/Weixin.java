package com.springboot.javadoc;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Test;

import java.io.IOException;

public class Weixin {

    @Test
    public void getweixin() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        String url = "https://qyapi.Weixin.qq.com/cgi-bin/checkin/getcheckindata?ACCESS_TOKEN=7gwZ0DNPPUOb2AVw0KdfVllCFtL2vjYEGfE2G9tLEy9XgUpkyHLd7XIlsUMQkSh-OayGEqEhgXAG5CtHC2WmQNQd4wZA2AW8MRShw19Kms0RD6iDulzzfeCYqPCVOt5POd87G0N0T9uNQsRwDa-SwI2ajPpJ2e-YrpH2jAsWpgp04NM6xL4YAr1I7qTbOJbh4vfGFK-zYxpBLYYl6KDLwg";
        String url1="https://icuihai.com/2018/07/19/%E5%85%A8%E7%BD%91%E6%9C%80%E6%B8%85%E6%99%B0%E7%9A%84ConstraintLayout%E6%95%99%E7%A8%8B/";
        OkHttpClient okHttpClient = new OkHttpClient();
//        FormBody formBody = new FormBody.Builder()
//                .add("opencheckindatatype", "3")
//                .add("starttime", "1533081600")
//                .add("endtime", "1535673600")
//                .add("useridlist", "[\"17788569059@163.com\"]")
//                .build();
        Request request = new Request.Builder()
                .url(url1)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
