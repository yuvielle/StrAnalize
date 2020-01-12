package com.home;

import java.math.BigDecimal;
import java.util.*;

public class SearchProcessor {

    public static TreeMap process(){
        if(!Validator.searchStringValidate(SearchContext.init().getSearchString())){
            System.out.println(Messages.searchStringUnvalid);
            return null;
        }
        if(!Validator.pathValidate(SearchContext.init().getPath())) {
            System.out.println(Messages.pathUnvalid);
            return null;
        }
        FilesUtil fu=new FilesUtil();
        Map<String,String> a = fu.getFiles(SearchContext.init().getPath(), SearchContext.init().getEncoding());
        SearchMatcher matcher = new SearchMatcher();
        TreeMap<BigDecimal, List<String>> result = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, String> ab : a.entrySet()){
            String[] bb = matcher.prepareStr(SearchContext.init().getSearchString());
            BigDecimal cc = matcher.getMatchSimpl(bb, ab.getValue());
            List<String> files;
            if(!result.containsKey(cc)){
                files = new ArrayList<>();
                result.put(cc, files);
            }else files = result.get(cc);
            files.add(ab.getKey());
            //System.out.println(ab.getKey() + "=" + cc + "%");
        }
        return result;
    }
}
