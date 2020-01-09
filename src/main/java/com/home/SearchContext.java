package com.home;

public class SearchContext {

    private static SearchContext context;

    private String searchString;
    private String path;

    public String getSearchString() {
        return searchString;
    }

    public String getPath() {
        return path;
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
    }

    @Override
    public String toString(){
        return "Search path = " + getPath() + ", search string = " + getSearchString();
    }
}
