package com.home;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println(Messages.begin);
        if (args.length == 0) {
            System.out.println(Messages.addPath);
        } else {
            SearchContext.init().add("path", args[0]);
            System.out.println(String.format(Messages.updatePath, args[0]));
        }

        Scanner scan = new Scanner(System.in);
        String input;
        do {
            input = scan.nextLine();
            //System.out.println("i=" + input);
            if(input.equals("help")){
                System.out.println(Messages.help);
            }
            if(input.equals("do"))
            {
                TreeMap<BigDecimal, List<String>> result = SearchProcessor.process();
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

    /*
    * метод осуществляет простейший парсинг комманд
    * @param String s - строка комманды
    * */
    public static void parse(String s){
        if( s==null || s.length() == 0 || s.charAt(0) != '-') return;
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
