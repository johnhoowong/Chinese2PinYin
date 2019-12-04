package com.johnhoo.main;

import com.johnhoo.utils.PinYinUtil;

/**
 * 汉字转换成拼音
 */
public class PinYinMain {

    public static void main(String[] args) {
        PinYinUtil pinYinUtil = new PinYinUtil();
        String result = pinYinUtil.getPinYin("非汉字不进行转换，直接添加");
        System.out.println(result);
    }
}
