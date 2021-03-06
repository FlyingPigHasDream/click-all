package com.click.clickall.limitip;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.click.clickall.pinganVote.pinganVote;
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
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 注册平安号
 * @author LiaoYangJun
 * @createTime 2018/5/2.
 */
public class qqEmail {

    public static final String[] ipArrays = {
            "66.102.251.", "112.211.0.", "141.8.225.","159.106.121.",
            "216.58.221.", "61.244.148.", "59.125.39.", "58.30.15.", "114.80.166.",
            "202.96.134.", "58.19.24.", "119.39.23.", "58.195.128.", "124.236.223.",
            "183.221.217.", "222.182.90.", "58.194.96.", "211.138.161.",
            "112.112.13.", "219.159.82.", "202.98.226.", " 61.128.101.",
            "130.039.000.", "130.039.255.", "131.230.000.","131.230.255.",
            "144.092.000.", "144.092.255.", "151.000.000.", "152.255.255.",
            "161.058.000.", "161.058.255.", "169.208.000.", "169.223.255.",
            "171.208.000.", "171.220.255.", "195.010.040.", "195.010.040.",
            "195.010.062.", "195.010.063.", "195.010.194.", "195.010.194.",
            "195.063.159.", "195.063.159.", "195.090.044.", "195.090.046.",
            "195.090.047.", "195.090.048.", "195.090.049.", "195.090.051.",
            "195.090.052.", "195.090.053.", "195.100.066.", "195.112.164.",
            "195.112.172.", "195.112.173."};

    public static void main(String[] args) throws Exception{
        String sendEmialUrl = "http://pacx.51ideal.com/index.php/api/sendVerificationMail";
        String regUrl = "http://pacx.51ideal.com/index.php/api/reg";
        String voteUrl = "http://pacx.51ideal.com/index.php/api/vote2";
        String loginUrl = "http://pacx.51ideal.com/index.php/api/login";

        String emailUsAll =
                "huasi207515@sina.com----wPmAZS7V#" +
                        "bini93962325@sina.com----pYm74Zez#" +
                        "lingjia18622345@sina.com----qRW06z5J#" +
                        "jinyao22444@sina.com----D8H474am#" +
                        "linxuan109293@sina.com----CQWtBEQD#" +
                        "zhoulin94082@sina.com----bws5r39r#" +
                        "wangqing219020@sina.com----DeQ0tZi3#" +
                        "xisan382894@sina.com----5Wc3lBGJ#" +
                        "yuzi30609@sina.com----Mp6G7NE5#" +
                        "yaqi821319@sina.com----25zuOT6v#" +
                        "guobu93418487@sina.com----cb923w5e#" +
                        "liyi6654486@sina.com----3VhcMxMN#" +
                        "ningwei87972347@sina.com----E7qGun0M#" +
                        "linjing46058@sina.com----1mXd8132#" +
                        "yueyan15771@sina.com----DdOGc26J#" +
                        "zhizhao974389@sina.com----JgzA8ZWG#" +
                        "weixin10048@sina.com----uDlKO5q9#" +
                        "shixuan298098@sina.com----Qdgzt2vR#" +
                        "baoqi04920491@sina.com----0zmHl5yw#" +
                        "yihai08526@sina.com----9I6Z5Jm8#" +
                        "bohan92522211@sina.com----0S8B80mQ#" +
                        "mourui68943@sina.com----Wa7fZD70#" +
                        "leijing649758@sina.com----s8JLqH20#" +
                        "hongjia17662@sina.com----s6IZ6622#" +
                        "xinyuan4524182@sina.com----10DMCUHe#" +
                        "jingran00976498@sina.com----s56R2W0q#" +
                        "liulei64484@sina.com----zdq7h08k#" +
                        "menglan5088895@sina.com----iPw31y46#" +
                        "rongzhong449871@sina.com----D3fCbjU8#" +
                        "huihe38503418@sina.com----kK686r7L#" +
                        "ningxin977650@sina.com----2135IYh3#" +
                        "yucong2040019@sina.com----3FKFiZmq#" +
                        "yanwen336421@sina.com----ef04ba3L#" +
                        "dianqi88310@sina.com----JkGsA16r#" +
                        "huahan49600306@sina.com----9FPyAT8z#" +
                        "dingai53393609@sina.com----CjG5B9ZE#" +
                        "yangjun15700657@sina.com----2t0Jknmj#" +
                        "zhixi89339@sina.com----9T75TPWE#" +
                        "lunzuo62985@sina.com----B344H3Ai#" +
                        "qigen47458552@sina.com----zjB4p2Ry#" +
                        "hongwen6907134@sina.com----YS4Xlj4X#" +
                        "kuihan5122158@sina.com----Q1sdfD2V#" +
                        "moumi97571@sina.com----G8vg0P4h#" +
                        "linfeng8978849@sina.com----UmZ0wYLY#" +
                        "yizi6212609@sina.com----Lbj7rY6r#" +
                        "dingyang4385503@sina.com----6t66z9X3#" +
                        "niaozi11927052@sina.com----1vUU0nOd#" +
                        "yingding81508173@sina.com----96Nj1Q1U#" +
                        "xiangzhen228503@sina.com----h4jo1gc7#" +
                        "liaolei43933@sina.com----F2xlpBUn#" +
                        "qihui0832403@sina.com----b552W1Py#" +
                        "longhong72731077@sina.com----dX2i2BvM#" +
                        "lurui1043234@sina.com----14KpP9c9#" +
                        "xuelin5121516@sina.com----2J20VFTy#" +
                        "ningni058634@sina.com----oGaLh0kA#" +
                        "yangqi42814@sina.com----fh2rq01n#" +
                        "yanyao39697@sina.com----Kt457ca2#" +
                        "yingxiao159217@sina.com----p2NRhwl1#" +
                        "shihuai955904@sina.com----mR3GY81O#" +
                        "miaoniao9040559@sina.com----Uk94C4Vh#" +
                        "mingde2908696@sina.com----80OJ930g#" +
                        "yuangen20427@sina.com----i6472vTB#" +
                        "haiyan2239015@sina.com----fH3tV10X#" +
                        "lixia1808414@sina.com----91E7kW3P#" +
                        "binjun078670@sina.com----2kG8clo7#" +
                        "kuikang48930202@sina.com----dtlbofEg#" +
                        "jinxin45180@sina.com----KAlF5i0A#" +
                        "zema02739@sina.com----417Pb3JJ#" +
                        "kaiwei78193@sina.com----3nwz4syn#" +
                        "miyou4911897@sina.com----L84pvqU2#" +
                        "youli86906@sina.com----W4aS8hD0#" +
                        "shuaishan785858@sina.com----W0V1184B#" +
                        "qinni0036693@sina.com----kQK9yiNT#" +
                        "yuanxuan4619704@sina.com----m8IF14P9#" +
                        "xuanran15149@sina.com----cJ1Kdr3G#" +
                        "dingdian70214@sina.com----8k7R078W#" +
                        "hongyun70378@sina.com----PNS4bq2O#" +
                        "anfei91134107@sina.com----hA64AFGF#" +
                        "linyu45282932@sina.com----SoZ3H70Z#" +
                        "xuezi2836064@sina.com----20UVmCS3#" +
                        "dingni5893837@sina.com----Oaf7k4bd#" +
                        "jiawei98397591@sina.com----OEw8jhQ4#" +
                        "dixin278562@sina.com----HR66vbbp#" +
                        "yuanjin841195@sina.com----1I3tqc7A#" +
                        "liaozhi1147107@sina.com----GvLGi58e#" +
                        "fengwo70244@sina.com----rGOHA5S8#" +
                        "hailin659208@sina.com----pj8fD4g3#" +
                        "hanban402979@sina.com----j72d56IF#" +
                        "yingxiao04408@sina.com----MV78f2ve#" +
                        "yuding361565@sina.com----q1rt751p#" +
                        "zhenwo76515@sina.com----eMA7Anv4#" +
                        "mingjuan4340604@sina.com----C3B73i0P#" +
                        "huishang65944149@sina.com----3hXZchQt#" +
                        "jiankui3457907@sina.com----CJw0jakw#" +
                        "biaoqin53040@sina.com----AfI7dsxC#" +
                        "yening81753922@sina.com----D7m14681#" +
                        "xiqin973135@sina.com----YCqYvQ2A#" +
                        "xiaoqi70435270@sina.com----Hr6HUNZm#" +
                        "yuejing4539485@sina.com----X4nlqmXY#" +
                        "zhangya32258@sina.com----ssIev10S#" ;

        String names = "赵婧文,赵竹林,赵威皓,赵冬梅,赵中锴,赵山川,赵吾光,赵璇海,赵学海,赵午光,赵绚海,赵玉,赵吾行,赵晓珲,赵吾航,赵鳕海,赵腾,赵宵蕙,赵雾瑕,赵紫豪,赵涛,赵俊英,赵敏,赵轩海,赵家豪,赵鹃,赵文兵,赵海洲,赵玉凤,赵容,赵礼义,赵义,赵华良,赵宇,赵汝杰,赵萸艳,赵子峰,赵天宇,赵慧,赵艳,赵德霞,赵小瑞,赵玉芝,赵家宝,赵林,赵健民,赵立民,赵妍,赵大宇,赵彪," +
                "李丽颖,李启菁,李娉婷,李婷,李娉,李梓发,李冠英,李辉煌,李萍,李新萍,李莉颖,李小萍,李沛雯,李丽,李抒萍,李书萍,李昭欣,李坊,李舒萍,李坊颖,李嘉城,李淑萍,李姝萍,李慕雪,李双秆,李斌,李琳,李炯泽,李林,李玲,李林颖,李昀泽,李建刚,李鹏,李菁,李徊,李琳颖,李丹,李今颖,李娜,李金颖,李金泽,李世斌,李丽茵,李思禅,李世安,李勇,李思霖,李洪义,李钰," +
                "王本强,王唯依,王婷婷,王玲娟,王鹏宇,王巍娟,王佁函,王帼玮,王天琦,王明涛,王鹏云,王婧懿,王凡卜,王世杰,王崇楦,王伟,王飞,王鲑埔,王凡玄,王蓦瑶,王英,王民琦,王琦逸,王艳娇,王琪逸,王瑛,王云霞,王海英,王龠曦,王江,王佛兰,王誉玲,王昊,王溪蕾,王佛瑶,王厚哲,王敦强,王凤娇,王嘉骐,王嘉琪,王华,王华英,王亚军,王嘉畦,王文志,王畦芎,王畦山,王畦嵘,王宁,王宏," +
                "吴诗琪,吴美兴,吴春芗,吴易奚,吴九花,吴静,吴县平,吴宜杰,吴军,吴振翰,吴振峰,吴萍兰,吴昊,吴宦颉,吴敏,吴巍东,吴那,吴今,吴国立,吴汉明,吴佳锴,吴彦翰,吴洁丽,吴彦谦,吴金根,吴洁立,吴洁力,吴洁莉,吴彦霖,吴彦泓,吴佳颖,吴彦锦,吴彦瑾,吴宣萱,吴彦琛,吴彦憬,吴彦捷,吴恒,吴子萱,吴耀锋,吴东弟,吴彬,吴坤贤,吴斯怡,吴楠,吴晨号,吴晨豪,吴浩瀚,吴瀚浩,吴伊晗";
        String[] nameArray = names.split(",");
        int namelength = nameArray.length;
        String[] all = emailUsAll.split("#");
        String name = "";
        // 0账号 1密码
        // 2账号 3密码
        int phone = 177;
        Random rand =new Random();
        for (int i = 0; i < 1; i++) {

        /*    String emailUs = all[i].split("----")[0];
            String emailPs = all[i].split("----")[1];*/

            String emailUs =  "2250612799@qq.com";
            String emailPs = "510mwjui";
            String checkcode = "1dglk                                                                                      ";



            CloseableHttpClient httpclient = HttpClients.createDefault();
            for (int e = 0; e < 8; e++) {
                phone += rand.nextInt(10);
            }


            for (int k = 0; k < 8; k++) {
                phone +=  rand.nextInt(10);
            }

             name = nameArray[rand.nextInt(namelength)];

            //注册
            String regParms = "email=" + emailUs +  "&phone="+  phone + "&name=" +  name +"&pass=liao894779&checkcode="+ checkcode;
           // String regParms = "email=" + emailUs +  "&phone=15521396837&name=黎霞&pass=lixia960307&checkcode="+ checkcode;
            post(regUrl,regParms);
            Thread.sleep(3000);

            // 登陆
            String returmStr = "";
            //CloseableHttpClient httpclient1 = HttpClients.createDefault();
            List<NameValuePair> parameters1 = new ArrayList<NameValuePair>(0);
            parameters1.add(new BasicNameValuePair("email", emailUs));
            parameters1.add(new BasicNameValuePair("pass", "liao894779"));
            returmStr = pinganVote.postClick(httpclient, "http://pacx.51ideal.com/index.php/api/login", parameters1);
   String loginParm = "email=" + emailUs + "&pass" + emailPs;
            post(loginUrl, loginParm);


            System.out.println("data = " + returmStr);
            JSONObject obj = JSON.parseObject(returmStr);
            JSONObject tokenObj = JSON.parseObject(obj.getString("data"));
            System.out.println(tokenObj.getString("token"));
            String token = tokenObj.getString("token");
            System.out.println("returmStr=" + returmStr);
            Thread.sleep(2000);

            // 投票
            for (int j = 0; j < 3; j++) {
                List<NameValuePair> parameters2 = new ArrayList<NameValuePair>(0);
                parameters2.add(new BasicNameValuePair("work_id", "11319"));
                parameters2.add(new BasicNameValuePair("1131911319", token));
                returmStr = pinganVote.postClick(httpclient, "http://pacx.51ideal.com/index.php/api/vote2", parameters2);
                System.out.println("returmStr=" + returmStr);
                String voteParm = "work_id=11319&token=" + token;
                post(voteUrl, voteParm);
                Thread.sleep(1000);
            }


        }

/*
        CloseableHttpClient httpclient = HttpClients.createDefault();

      //  postClick(httpclient, "http://pacx.51ideal.com/index.php/api/reg", parameters);
       *//* String emailUs = "huibu021812@sina.com";
        String emailPs = "0C7YiW9E";*//*

*//*

        List<NameValuePair> parameters1 = new ArrayList<NameValuePair>(0);
        parameters1.add(new BasicNameValuePair("email", emailUs));
        postClick(httpclient, sendEmialUrl, parameters1);
*//*

        // 发送邮箱
        String emailParam = "email=" + emailUs;
        post(sendEmialUrl,emailParam);

        // 获取验证码
        String  msg = ShowMail.getAllEmail(emailUs, emailPs);
        System.out.println("msg=" + msg);
        String checkcode = msg.split("验证码：")[1].split("  半小时内有效")[0];
        System.out.println("-------------------");
        System.out.println("checkcode =" + checkcode);
        System.out.println("checkcode length = " + checkcode.length());

        //注册
        String regParms = "email=" + emailUs +  "&phone=18966662533&name=张斌&pass=liao894779&checkcode="+ checkcode;
        post(regUrl,regParms);*/


/*        for(int i=0; i<20; i++){
            Runnable runn = new Runnable() {
                @Override
                public void run() {
                    try {





                        post(url);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(runn).run();
            Thread.sleep(2000);
        }*/
    }

    public static void post(String urStr, String parms ) throws Exception{
        /*URL url = new URL("http://pacx.51ideal.com/index.php/api/reg");*/
        URL url = new URL(urStr);
        URLConnection con = url.openConnection();

        con.setDoOutput(true);
        con.setDoInput(true);

        Random r = new Random();
        Integer counter = r.nextInt(255);

        int index = r.nextInt(34);
        String ip = ipArrays[index];

        con.setRequestProperty("X-Forwarded-For", ip + counter);
        System.out.println(ip+counter);
        con.setRequestProperty("cache-control","max-age=0");
        if(r.nextInt(10) % 2 == 0)
            con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.142 Safari/535.19");
        else
            con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0");

        con.setUseCaches(false);
/*        String emial = "jieke5164@sina.com";
        String checkcode = "wwmhe";*/
        OutputStream out = con.getOutputStream();
  /*      out.write(("email=" + emial +  "&phone=18966662533&name=张斌&pass=liao894779&checkcode="+ checkcode).getBytes());*/
        out.write(parms.getBytes());
        out.flush();
        out.close();
        con.getInputStream();
        System.out.println("msg = "  + con.getInputStream().read());
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
