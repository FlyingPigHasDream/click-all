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
 * 注册
 * @author LiaoYangJun
 * @createTime 2018/5/2.
 */
public class reg {

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
                "jinying801412@sina.com----RuW7Tz53#" +
                        "shenglei873962@sina.com----o5QWPUJO#" +
                        "biaofo453890@sina.com----wqJzU7OI#" +
                        "zeyu448026@sina.com----gB7G02UZ#" +
                        "xinyang5700129@sina.com----ZP58aRvZ#" +
                        "yanzhu10857@sina.com----9PxwHw6B#" +
                        "shuangxin6930924@sina.com----9cCZs7St#" +
                        "zhengai5037995@sina.com----UT937Fq2#" +
                        "pengyu41970@sina.com----0u3qxK29#" +
                        "yingzhong503201@sina.com----lDUW4856#" +
                        "yuwen43463@sina.com----vhyT116t#" +
                        "wenjing564771@sina.com----29yO99BT#" +
                        "xixin15461682@sina.com----U9n44zbr#" +
                        "zeli16859414@sina.com----qrL1ch4y#" +
                        "suxing5452787@sina.com----v54HkM4c#" +
                        "liuhe4189553@sina.com----Vlqi4qq9#" +
                        "linjian67969@sina.com----zv39Jk37#" +
                        "yangke414074@sina.com----NIJMWcu9#" +
                        "junban22371@sina.com----iD72CL9C#" +
                        "linxuan845333@sina.com----qpISxfEs#" +
                        "haixian275682@sina.com----86M0AY31#" +
                        "xiangjie37039@sina.com----U1217pE0#" +
                        "baian72164979@sina.com----JxW256RO#" +
                        "xiapeng2103315@sina.com----zR9i6T9l#" +
                        "dingji18117@sina.com----L7KBUZaG#" +
                        "zezi08212@sina.com----7W02685l#" +
                        "wendun15193@sina.com----yjf62HfL#" +
                        "lunxiao7044728@sina.com----bLXC6QVP#" +
                        "linlong24513466@sina.com----Qo4O5Re6#" +
                        "liqiao65156386@sina.com----YWS9M6IA#" +
                        "yuezi817181@sina.com----0I52qS19#" +
                        "lunran97154@sina.com----GAB8fNFB#" +
                        "lixiang36783609@sina.com----n4wES9gf#" +
                        "zhixia0314405@sina.com----DQ3oQEM6#" +
                        "dingming3206468@sina.com----45s4dVnu#" +
                        "lincong3789652@sina.com----qiWhFI98#" +
                        "yangban24203@sina.com----zfBR658O#" +
                        "pangguo6159815@sina.com----59SQuN9H#" +
                        "libo39891809@sina.com----2x9v8A0a#" +
                        "huizhu1274804@sina.com----v8jnTSka#" +
                        "linrui90878@sina.com----GG1Q8Jxo#" +
                        "xueqing45546@sina.com----t0gVEpnB#" +
                        "nansheng83903@sina.com----0Q42qC7v#" +
                        "junqin533354@sina.com----4R5dmO1R#" +
                        "linlong84653082@sina.com----1W6t61ed#" +
                        "jingman0060800@sina.com----DVniZ5sQ#" +
                        "zhenqing51309@sina.com----84DrpMdZ#" +
                        "pengwei41639@sina.com----rErdDY6x#" +
                        "ganwei8332630@sina.com----hfy0ce5Y#" +
                        "xiean67001@sina.com----8GyjZFR0#" +
                        "zhoubu55996935@sina.com----462rM1xM#" +
                        "mouning6740035@sina.com----xBmi1b67#" +
                        "zhezhi4738012@sina.com----5x5JXO1O#" +
                        "kangyuan4680476@sina.com----D7QJ2SDc#" +
                        "dingyan8983847@sina.com----V6FaSN8T#" +
                        "linxiu57827@sina.com----vj5Y239k#" +
                        "leixi58628750@sina.com----adl117ST#" +
                        "linwei8659355@sina.com----2k96R7A9#" +
                        "niaoxiao6984404@sina.com----C553qJz4#" +
                        "huande5895465@sina.com----lHoKdbuU#" +
                        "yayan565096@sina.com----l36LRBxs#" +
                        "lingshi864748@sina.com----IDNr90V3#" +
                        "longjian68731@sina.com----TqUme86T#" +
                        "linzhi036303@sina.com----vK6FO5B6#" +
                        "licong15198@sina.com----G2Ql3K3i#" +
                        "zhaofan971823@sina.com----sqYGq9Co#" +
                        "dingze9141183@sina.com----VVQ9mtDa#" +
                        "yacong137607@sina.com----I966n1fh#" +
                        "yuzhe12689229@sina.com----ULphVT8j#" +
                        "longzhong51276@sina.com----Uia9xMJN#" +
                        "zhiyue3851523@sina.com----o5U9QMh3#" +
                        "haiming146076@sina.com----lfWpx34N#" +
                        "yuande02680@sina.com----44bVqgVh#" +
                        "huian2636116@sina.com----157GKC4g#" +
                        "yanyuan25931@sina.com----V7xa5D48#" +
                        "yangqiao63199@sina.com----P92q4t9N#" +
                        "mouling69512457@sina.com----2KX6s926#" +
                        "yanglei75238456@sina.com----jxIXdUua#" +
                        "wangzi5535204@sina.com----diLTgHjc#" +
                        "jingguo8047292@sina.com----8I5d1fjC#" +
                        "piantian201307@sina.com----5U192azH#" +
                        "yujing911874@sina.com----6QEXHOrY#" +
                        "qishuo478433@sina.com----Q1BB923O#" +
                        "xuli974480@sina.com----F2ydqsve#" +
                        "chunding3144897@sina.com----r3t5d2Ur#" +
                        "xiangyue98871588@sina.com----91qJb6yV#" +
                        "zhouan49074474@sina.com----zM0xlGe3#" +
                        "weifei31226729@sina.com----J468NHra#" +
                        "linhui442078@sina.com----sTwEd1sm#" +
                        "yuanxi371739@sina.com----DTZn3D24#" +
                        "fujie82077347@sina.com----Hl9v3Tvq#" +
                        "xuanzhan41911@sina.com----32Yg0TrW#" +
                        "xuantian761922@sina.com----13wTnHkl#" +
                        "baosan319386@sina.com----KDPrcrxn#" +
                        "linhua48094@sina.com----h1MKNQn2#" +
                        "zewen840879@sina.com----8ssY340Z#" +
                        "baowei546177@sina.com----Q6WlR87t#" +
                        "panglei854901@sina.com----gwk9qE00#" +
                        "zeqiang3010155@sina.com----6AjsI372#" +
                        "yuyi344528@sina.com----vrQHf50S#" +
                        "jingwei0027535@sina.com----O3uGcv4u#" +
                        "yanlin73700271@sina.com----2nHy6t9A#" +
                        "zeta441573@sina.com----G0J8si0N#" +
                        "zhaohai700005@sina.com----a31qe490#" +
                        "lingnian13128@sina.com----hfKSd8lF#" +
                        "junzhao9184613@sina.com----Jpx0685I#" +
                        "haiyuan32764@sina.com----46b50QK0#" +
                        "pengxie48359219@sina.com----dA232095#" +
                        "linwen83646@sina.com----M2199i25#" +
                        "yaoqi1251883@sina.com----e2M5Ha1m#" +
                        "kaidun483767@sina.com----EQL9S961#" +
                        "yuelan688948@sina.com----rnuLV4Xq#" +
                        "chiling29764954@sina.com----xpHD6BU8#" +
                        "yuyu018429@sina.com----so5W7Ol7#" +
                        "taoyi2085152@sina.com----CqM3140M#" +
                        "mengqin247708@sina.com----m7ap7j3G#" +
                        "jingchun7269762@sina.com----Ox42S2j0#" +
                        "wangqi56590524@sina.com----U68aO8nT#" +
                        "dingbao508727@sina.com----i5HrBe5J#" +
                        "shuofei128947@sina.com----3NbwJiDd#" +
                        "xiangjin387129@sina.com----7FFzDf91#" +
                        "yuedun58136@sina.com----0D5K4Moa#" +
                        "zhidian58576267@sina.com----M4jr299W#" +
                        "xianghai95317013@sina.com----Ko7nstHe#" +
                        "ningjing04533367@sina.com----TapGBl5B#" +
                        "mouyu288384@sina.com----61YZ58vi#" +
                        "mijia694287@sina.com----v90gZ7KV#" +
                        "yide35524822@sina.com----xgp6wQ7b#" +
                        "xiaodai472183@sina.com----8k8rV3NF#" +
                        "miaochao454693@sina.com----d22OPB13#" +
                        "chiyiben0950530@sina.com----Q86CW190#" +
                        "jingpei45661947@sina.com----I99gfcd0#" +
                        "juanzhe9038533@sina.com----YA7uWGHl#" +
                        "yeqiao682388@sina.com----28za2baG#" +
                        "ruiming64054@sina.com----HDlbSxqo#" +
                        "zehuan10006306@sina.com----89kxxHMs#" +
                        "senfan1098525@sina.com----7PKvAzRj#" +
                        "nanhai30119608@sina.com----2RzPr5dU#" +
                        "yingqi8717307@sina.com----94iA6s77#" +
                        "shiji78439@sina.com----4d8X50j0#" +
                        "haidie00030@sina.com----x9Md93Ky#" +
                        "xuxi207336@sina.com----8tfeUjnK#" +
                        "taolan3414207@sina.com----YwaJbXDg#" +
                        "yingxin7600328@sina.com----DPguhkpx#" +
                        "taizhong25065@sina.com----r5O0g7Jg#" +
                        "rongyi396241@sina.com----3HjodI4Q#" +
                        "xiaobin674014@sina.com----r2B0OW7z#" +
                        "zhuai239529@sina.com----09tfGkMb#" +
                        "qingjun88275495@sina.com----YnPtIM46#" +
                        "rongqing608120@sina.com----xHB97w30#" +
                        "dingning52350485@sina.com----v6zcKx6q#" +
                        "xinbin5787549@sina.com----Y9Sg5mpS#" +
                        "liming5247792@sina.com----3o0tKEh6#" +
                        "yangxu0703526@sina.com----yp9xz97c#" +
                        "zeyan612941@sina.com----kpTE2W7A#" +
                        "zhenya48678053@sina.com----g1nZiU41#" +
                        "zezhan23485930@sina.com----K51gto69#" +
                        "chengdi714324@sina.com----F8sxa4QD#" +
                        "jinzui7281123@sina.com----E69xAk9N#" +
                        "linwang82575@sina.com----F3xg3mS7#" +
                        "liaoxi667296@sina.com----aKF9pca2#" +
                        "xiongqian7095907@sina.com----i4sOw59x#" +
                        "yuzhang30385263@sina.com----783ZY4b5#" +
                        "yuqing14882771@sina.com----V391ZCoY#" +
                        "xiehai45546@sina.com----8VpL7e4z#" +
                        "dingyao8048645@sina.com----K0iOHNgS#" +
                        "liuxia6416715@sina.com----QWlv736U#" +
                        "lingzhang74265@sina.com----Qbn5LHzX#" +
                        "haiding238701@sina.com----3mXo326a#" +
                        "yaoyan06350247@sina.com----jHv0Z9Rw#" +
                        "xiafo24100622@sina.com----YQuE5ba2#" +
                        "yahai11929@sina.com----2l9GPcm7#" +
                        "longwen459359@sina.com----Nc525Q8v#" +
                        "leihan420253@sina.com----XR57z90H#" +
                        "zeran91139@sina.com----UAuP8a7U#" +
                        "xuyu720122@sina.com----dlN9Tc70#" +
                        "dinghai58733@sina.com----HuW8lKp6#" +
                        "zhengrui94922@sina.com----7Q9R0Xx1#" +
                        "heran27800@sina.com----bo35Yq8g#" +
                        "qishu8332922@sina.com----jPWJ53ep#" +
                        "yingxue331296@sina.com----0i7sacPU#" +
                        "jingrui403556@sina.com----Si7Z5Jaw#" +
                        "yuanlei227807@sina.com----0ZE0NUfv#" +
                        "xintian52813@sina.com----8gaehMxj#" +
                        "zhiyi83601@sina.com----NLM9xWCS#" +
                        "aiding93765@sina.com----hI27PdF5#" +
                        "yudun6343533@sina.com----v5Erj87K#" +
                        "zhide66369@sina.com----6hguVPKd#" +
                        "yipeng335380@sina.com----v5Brc5B4#" +
                        "xianyiben8958199@sina.com----jcw8qaV2#" +
                        "mouyi8794932@sina.com----7plrQB9a#" +
                        "miaoshuo7963816@sina.com----VpX2G1yG#" +
                        "shuzhe54405757@sina.com----lyS2v96A#" +
                        "weilong67644524@sina.com----P9RA4HOk#" +
                        "leisheng9087486@sina.com----35TsuaFe#" +
                        "lingjing473720@sina.com----7Y8cC47e#" +
                        "xiangma12393@sina.com----7NM0J0u4#" +
                        "diehan6846927@sina.com----XT3kdKq1#" +
                        "chilong29681@sina.com----4aL0OEb1#" +
                        "jingjia7149780@sina.com----P5988eKE#"
                       ;

        String[] all = emailUsAll.split("#");

        // 0账号 1密码
        // 2账号 3密码
        for (int i = 0; i < all.length-1; i++) {

            String emailUs = all[i].split("----")[0];
            String emailPs = all[i].split("----")[1];

            CloseableHttpClient httpclient = HttpClients.createDefault();

            //  postClick(httpclient, "http://pacx.51ideal.com/index.php/api/reg", parameters);
       /* String emailUs = "huibu021812@sina.com";
        String emailPs = "0C7YiW9E";*/

/*

        List<NameValuePair> parameters1 = new ArrayList<NameValuePair>(0);
        parameters1.add(new BasicNameValuePair("email", emailUs));
        postClick(httpclient, sendEmialUrl, parameters1);
*/

            System.out.println("------------------------");
            System.out.println("当前邮箱账号=" + emailUs);
            // 发送邮箱
            String emailParam = "email=" + emailUs;
            post(sendEmialUrl,emailParam);
            Thread.sleep(50000);
            // 获取验证码
            String  msg = ShowMail.getAllEmail(emailUs, emailPs);
            System.out.println("msg=" + msg);
            String checkcode = msg.split("验证码：")[1].split("  半小时内有效")[0];
            System.out.println("-------------------");
            System.out.println("checkcode =" + checkcode);
            System.out.println("checkcode length = " + checkcode.length());

            //注册
            String regParms = "email=" + emailUs +  "&phone=18966662533&name=张斌&pass=liao894779&checkcode="+ checkcode;
            post(regUrl,regParms);

/*
            // 登陆
            String returmStr = "";
            //CloseableHttpClient httpclient1 = HttpClients.createDefault();
            List<NameValuePair> parameters1 = new ArrayList<NameValuePair>(0);
            parameters1.add(new BasicNameValuePair("email", emailUs));
            parameters1.add(new BasicNameValuePair("pass", "liao894779"));
            returmStr = pinganVote.postClick(httpclient, "http://pacx.51ideal.com/index.php/api/login", parameters1);
         *//*   String loginParm = "email=" + emailUs + "&pass" + emailPs;
            post(loginUrl, loginParm);*//*

            System.out.println("data = " + returmStr);
            JSONObject obj = JSON.parseObject(returmStr);
            JSONObject tokenObj = JSON.parseObject(obj.getString("data"));
            System.out.println(tokenObj.getString("token"));
            String token = tokenObj.getString("token");
            System.out.println("returmStr=" + returmStr);


            // 投票
            for (int j = 0; j < 3; j++) {
                List<NameValuePair> parameters2 = new ArrayList<NameValuePair>(0);
                parameters2.add(new BasicNameValuePair("work_id", "11319"));
                parameters2.add(new BasicNameValuePair("1131911319", token));
                returmStr = pinganVote.postClick(httpclient, "http://pacx.51ideal.com/index.php/api/vote2", parameters2);
                System.out.println("returmStr=" + returmStr);
                String voteParm = "work_id=11319&token=" + token;
                post(voteUrl, voteParm);
            }*/


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
