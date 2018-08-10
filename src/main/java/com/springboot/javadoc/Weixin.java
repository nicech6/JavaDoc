package com.springboot.javadoc;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

public class Weixin {

    @Test
    public void getweixin() {
        String url = "https://qyapi.Weixin.qq.com/cgi-bin/checkin/getcheckindata?ACCESS_TOKEN=accesstoken000001";
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("opencheckindatatype", "3")
                .add("starttime", "1492617600")
                .add("endtime", "1492790400")
                .add("useridlist", "[\"17788569059@163.com\"]")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
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
