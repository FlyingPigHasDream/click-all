package com.click.clickall;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author rainyday
 * @createTime 2018/8/30.
 */
public class TestLambda3 {

    @Test
    public void test1() {
        happy(10000, 100, (m) -> System.out.println("你们喜欢、、=" + m ));
    }

    public void happy(double money, Integer a, Consumer<Double> con) {
        con.accept(money);
    }
}
