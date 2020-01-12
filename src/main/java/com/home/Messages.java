package com.home;

public class Messages {
    public static  String begin =
            "Консольное приложение осуществляет поиск в текстовых файлах слов введённых пользователем.\n" +
            "Для вызова справки наберите help.";
    public static String help = "Для работы задайте параметры в консоли приложения и введите команоду do.\n" +
            "Список команд (ввод параметров):\n" +
            "help - вызов этой справки\n" +
            "-encoding - установка кодировки напр. ( -encoding UTF-8) установит UTF-8, по умолчанию задана UTF-8\n" +
            "-search - ввод строки поиска\n" +
            "-path - ввод пути поиска напр. (-path c:\\mypath)\n"+
            "do - запуск поиска\n"+
            "exit - вызод из приложения";
    public static String addPath = "путь не задан, но его можно задать при помощи команды -path c:\\mypath в консоли приложения";
    public static String updatePath = "путь к директории - s% но его можно поменять при помощи команды -path c:\\mypath в консоли приложения";
    public static String searchStringUnvalid = "Строка поиска отсутствует или не валидна, повторите ввод";
    public static String pathUnvalid = "Путь к директории отсутствует, или такая директория не существует, повторите ввод";
}
