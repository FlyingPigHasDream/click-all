package com.click.clickall.pinganVote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 投票线程2
 * @author LiaoYangJun
 * @createTime 2018/4/25.
 */
public class pinganVote2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        String names = "赵婧文,赵竹林,赵威皓,赵冬梅,赵中锴,赵山川,赵吾光,赵璇海,赵学海,赵午光,赵绚海,赵玉,赵吾行,赵晓珲,赵吾航,赵鳕海,赵腾,赵宵蕙,赵雾瑕,赵紫豪,赵涛,赵俊英,赵敏,赵轩海,赵家豪,赵鹃,赵文兵,赵海洲,赵玉凤,赵容,赵礼义,赵义,赵华良,赵宇,赵汝杰,赵萸艳,赵子峰,赵天宇,赵慧,赵艳,赵德霞,赵小瑞,赵玉芝,赵家宝,赵林,赵健民,赵立民,赵妍,赵大宇,赵彪," +
                "李丽颖,李启菁,李娉婷,李婷,李娉,李梓发,李冠英,李辉煌,李萍,李新萍,李莉颖,李小萍,李沛雯,李丽,李抒萍,李书萍,李昭欣,李坊,李舒萍,李坊颖,李嘉城,李淑萍,李姝萍,李慕雪,李双秆,李斌,李琳,李炯泽,李林,李玲,李林颖,李昀泽,李建刚,李鹏,李菁,李徊,李琳颖,李丹,李今颖,李娜,李金颖,李金泽,李世斌,李丽茵,李思禅,李世安,李勇,李思霖,李洪义,李钰," +
                "王本强,王唯依,王婷婷,王玲娟,王鹏宇,王巍娟,王佁函,王帼玮,王天琦,王明涛,王鹏云,王婧懿,王凡卜,王世杰,王崇楦,王伟,王飞,王鲑埔,王凡玄,王蓦瑶,王英,王民琦,王琦逸,王艳娇,王琪逸,王瑛,王云霞,王海英,王龠曦,王江,王佛兰,王誉玲,王昊,王溪蕾,王佛瑶,王厚哲,王敦强,王凤娇,王嘉骐,王嘉琪,王华,王华英,王亚军,王嘉畦,王文志,王畦芎,王畦山,王畦嵘,王宁,王宏," +
                "吴诗琪,吴美兴,吴春芗,吴易奚,吴九花,吴静,吴县平,吴宜杰,吴军,吴振翰,吴振峰,吴萍兰,吴昊,吴宦颉,吴敏,吴巍东,吴那,吴今,吴国立,吴汉明,吴佳锴,吴彦翰,吴洁丽,吴彦谦,吴金根,吴洁立,吴洁力,吴洁莉,吴彦霖,吴彦泓,吴佳颖,吴彦锦,吴彦瑾,吴宣萱,吴彦琛,吴彦憬,吴彦捷,吴恒,吴子萱,吴耀锋,吴东弟,吴彬,吴坤贤,吴斯怡,吴楠,吴晨号,吴晨豪,吴浩瀚,吴瀚浩,吴伊晗";
        String[] nameArray = names.split(",");
        int namelength = nameArray.length;
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        Random rand =new Random();
        for (int j = 0; j < 80; j++) {
            String email = "8";
            String pass = "";
            String name = nameArray[rand.nextInt(namelength)];
            String phone = "188";

            System.out.println("name = " +  name);
            for (int e = 0; e < 8; e++) {
                email += rand.nextInt(10);
            }

            // 密码等于邮箱

            pass = email;
            System.out.println("pass =" + pass);
            email += "@qq.com";
            System.out.println("email = " + email);
            for (int k = 0; k < 8; k++) {
                phone +=  rand.nextInt(10);
            }
            System.out.println("phone=" + phone);
            // 注册
            List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
            parameters.add(new BasicNameValuePair("email", email));
            parameters.add(new BasicNameValuePair("phone", phone));
            parameters.add(new BasicNameValuePair("name", name));
            parameters.add(new BasicNameValuePair("pass", pass));
            String returmStr = "";
            returmStr = pinganVote2.postClick(httpclient, "http://pacx.51ideal.com/index.php/api/reg", parameters);
            System.out.println("returmStr=" + returmStr);
            // 登陆

            //CloseableHttpClient httpclient1 = HttpClients.createDefault();
            List<NameValuePair> parameters1 = new ArrayList<NameValuePair>(0);
            parameters1.add(new BasicNameValuePair("email", email));
            parameters1.add(new BasicNameValuePair("pass", pass));
            returmStr = pinganVote2.postClick(httpclient, "http://pacx.51ideal.com/index.php/api/login", parameters1);

            JSONObject obj = JSON.parseObject(returmStr);
            JSONObject tokenObj = JSON.parseObject(obj.getString("data"));
            System.out.println(tokenObj.getString("token"));
            String token = tokenObj.getString("token");
            System.out.println("returmStr=" + returmStr);


            // 投票
            for (int i = 0; i < 3; i++) {
                List<NameValuePair> parameters2 = new ArrayList<NameValuePair>(0);
                parameters2.add(new BasicNameValuePair("work_id", "63"));
                parameters2.add(new BasicNameValuePair("token", token));
                returmStr = pinganVote2.postClick(httpclient, "http://pacx.51ideal.com/index.php/api/vote2", parameters2);
                System.out.println("returmStr=" + returmStr);

            }

        }

    }


    private static String  postClick(CloseableHttpClient httpclient, String httpPostUrl, List<NameValuePair> parameters) throws IOException, InterruptedException {
        String returnSst = "";
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(httpPostUrl);

        // 设置2个post参数，一个是scope、一个是q

        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "unicode");
                System.out.println(content);
                returnSst =  StringEscapeUtils.unescapeJava(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
          //  httpclient.close();
        }
        return returnSst;
    }
}
