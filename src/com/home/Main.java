package com.home;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.out.println("путь не задан, но его можно задать при помощи команды -path c:\\mypath в консоли приложения");
        } else {
            SearchContext.init().add("path", args[0]);
            System.out.println("путь к директории - " + args[0]+ " но его можно поменять при помощи команды -path c:\\mypath в консоли приложения");
        }

        Scanner scan = new Scanner(System.in);
        String input;
        do {
            input = scan.nextLine();
            //System.out.println("i=" + input);
            if(input.equals("do"))
            {
                TreeMap<BigDecimal, List<String>> result = process();
                if(result ==  null) continue;
                for (Map.Entry<BigDecimal, List<String>> entry : result.entrySet()) {
                    List<String> value = entry.getValue();
                    BigDecimal key = entry.getKey();
                    System.out.println(value + "=" + key + "%");
                }
            }
            else parse(input);
        } while (!input.equals("exit"));
    }

    public static TreeMap process(){
        if(SearchContext.init().getSearchString() == null || SearchContext.init().getPath() == null){
            System.out.println("Не все параметры заданы");
            return null;
        }
        FilesUtil fu=new FilesUtil();
        //"c:\\test"
        Map<String,String> a = fu.getFiles(SearchContext.init().getPath(), "UTF-8");
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

    public static void parse(String s){
        if(s.charAt(0) != '-') return;
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(s);
        //while (matcher.find()) {
            if(matcher.find()){
                int start=matcher.start();
                int end=matcher.end();
                String command = s.substring(1, start);
                String param = s.substring(end);
                SearchContext.init().add(command, param);
                System.out.println(SearchContext.init().toString());
            }
        //}
    }

}
