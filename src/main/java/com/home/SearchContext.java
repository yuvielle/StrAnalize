package com.home;

public class SearchContext {

    private static SearchContext context;

    private String searchString;
    private String path;
    private String encoding = "UTF-8";

    public String getSearchString() {
        return searchString;
    }

    public String getPath() {
        return path;
    }

    public String getEncoding() {
        return encoding;
    }

    public static SearchContext init() {
        if(context == null){
            context = new SearchContext();
        }
        return context;
    }

    private SearchContext(){
    }

    public void add(String command, String param){
        if(command.equals("search")) searchString = param;
        if(command.equals("path")) path = param;
        if(command.equals("encoding")) encoding = param;
    }

    @Override
    public String toString(){
        return "Search path = " + getPath() + ", search string = " + getSearchString();
    }
}
