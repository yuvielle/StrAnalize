package com.home;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesUtil {

    /*
    * метод осуществляет считывание файлов в память
    * @param String path - путь
    * @param encoding - кодировка для считывания
    * @return Map<String,String> список файлов, ключ - имя файла, значение - контент
    * */
    public Map<String,String> getFiles(String path, String encoding){

        Map<String,String> fc = new HashMap<>();
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            List<String> results = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            results.forEach(str -> {
                try {
                    fc.put(str, getContent(str, encoding));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fc;
    }

    /*
    * метод осуществляет считывание файла в память
    * @param String path - путь
    * @param encoding - кодировка для считывания
    * @return String контент файла
    * */
    public String getContent(String filePath, String encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, encoding);
    }
}
