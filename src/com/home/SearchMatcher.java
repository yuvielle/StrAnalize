package com.home;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class SearchMatcher {

    public String[] prepareStr(String string){
        String r1 = "[^A-Za-zА-ЯЁа-яё]";
        String r2 = "\\s{2,}";
        String r3 = "\\s";
        string = string.replaceAll(r1, " ").replaceAll(r2, " ");
        Pattern pattern = Pattern.compile(r3);
        return pattern.split(string);
    }

    public BigDecimal getMatchSimpl(String[] string, String source){
        Integer count = 0;

        for(String s:string){
            if(source.contains(s)){
                count = count + 1;
            }
        }
        return BigDecimal.valueOf(count * 100).divide(BigDecimal.valueOf(string.length), 1, BigDecimal.ROUND_HALF_UP);
    }
    /*
    public Integer getMatchExp(String[] string){

    }*/
}
