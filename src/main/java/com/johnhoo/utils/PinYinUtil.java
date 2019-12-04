package com.johnhoo.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import org.apache.commons.lang.StringUtils;

public class PinYinUtil {

    /**
     * 获取拼音
     * @param chinese
     * @return
     */
    public String getPinYin(String chinese){
        if(StringUtils.isBlank(chinese)){
            return "";
        }
        char[] t1 = chinese.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);      //大小写（LOWERCASE是小写）
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   //音调
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuilder sb = new StringBuilder();
        for(char c : t1){
            if(Character.toString(c).matches("[\\u4E00-\\u9FA5]")){
                try {
                    sb.append(PinyinHelper.toHanyuPinyinStringArray(c, format)[0]);
                }catch (Exception e){
                    System.out.println("转换汉字拼音错误!");
                }
            }else {
                // 非汉字不进行转换，直接添加
                sb.append(c);
            }
        }
        String result = sb.toString();
        return result;
    }
}
