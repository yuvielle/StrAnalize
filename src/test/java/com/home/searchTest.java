package com.home;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class searchTest {

    @Test
    void test1(){
        String path = "c:\\test";
        String search = "test string что то там";
        SearchContext searchContext = SearchContext.init();
        searchContext.add("search", search);
        searchContext.add("path", path);
        TreeMap<BigDecimal, List<String>> result = SearchProcessor.process();
        if(result ==  null) return;
        for (Map.Entry<BigDecimal, List<String>> entry : result.entrySet()) {
            List<String> value = entry.getValue();
            BigDecimal key = entry.getKey();
            System.out.println(value + "=" + key + "%");
        }

    }

}
