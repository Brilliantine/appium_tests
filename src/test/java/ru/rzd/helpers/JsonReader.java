package ru.rzd.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JsonReader {

    public static <T> T read(String resourcePath, Class<T> clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(resourcePath)){
            if(inputStream == null){
                throw new RuntimeException("Файл не найден в ресурсах");
            }
            return objectMapper.readValue(inputStream,clazz);
        }
        catch (IOException e){
            throw new RuntimeException("Ошибка чтения файла "+e.getMessage());
        }
    }
}
