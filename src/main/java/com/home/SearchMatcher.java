package com.home;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class SearchMatcher {

    /*
   * метод разбирает строку на массив слов для поиска по словам
   * @param String string - исходная строка
   * @return String[] массив слов
   * */
    public String[] prepareStr(String string){
        String r1 = "[^A-Za-zА-ЯЁа-яё]";
        String r2 = "\\s{2,}";
        String r3 = "\\s";
        string = string.replaceAll(r1, " ").replaceAll(r2, " ");
        Pattern pattern = Pattern.compile(r3);
        return pattern.split(string);
    }

    /*
    * метод осуществляет простейший поиск слов в содержимом файла до 1-го совпадения
    * @param String source - содержимое текстового файла
    * @param String[] массив слов для поиска
    * @return BigDecimal процент совпвдений
    * */
    public BigDecimal getMatchSimpl(String[] string, String source){
        Integer count = 0;

        for(String s:string){
            if(source.toLowerCase().contains(s.toLowerCase())){
                count = count + 1;
            }
        }
        return BigDecimal.valueOf(count * 100).divide(BigDecimal.valueOf(string.length), 1, BigDecimal.ROUND_HALF_UP);
    }
    /*
    public Integer getMatchExp(String[] string){

    }*/
}
