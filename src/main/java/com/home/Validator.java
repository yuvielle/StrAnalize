package com.home;

import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean pathValidate(String path){
        if(path == null) return false;
        if(!Paths.get(path).toFile().isDirectory()) return false;
        return true;
    }

    public static boolean searchStringValidate(String search){
        if(search == null) return false;
        Pattern pattern = Pattern.compile("[A-Za-zА-ЯЁа-яё]");
        Matcher matcher = pattern.matcher(search);
        if(!matcher.find()) return false;
        return true;
    }
}
