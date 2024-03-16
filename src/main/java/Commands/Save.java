package Commands;

import MainClasses.ProductCollection;
import MainClasses.CollectionSaver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * Класс команды, сохраняющий файл в заранее заданный файл (Data/FileToSaveCollection.json)
 */

public class Save implements Command {
    public static final Save SAVE = new Save();

    private Save() {
    }
    /**
     * метод, который с использованием objectMapper from jackson.datatype сериализующий коллекцию и записывающий ее в файл
     */
    @Override
    public void execute() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            CollectionSaver saver = new CollectionSaver(ProductCollection.PRODUCT_COLLECTION.getProducts());
            String json = objectMapper.writeValueAsString(saver);
            Path path = Paths.get("src","main","resources","Data", "FileToSaveCollection.json");
            FileWriter writer = new FileWriter(path.toFile());
            json = json.replace("}},", "}},\n");
            writer.write(json);
            writer.flush();
            //for (int i = 0; i<splitedJson.length; i++){
            //    if(i!=splitedJson.length-1)
            //        writer.write(splitedJson[i]+"}},");
            //    else
            //        writer.write(splitedJson[i]);
            //    writer.newLine();
            //    writer.flush();
            //}
//
            System.out.println("файл успешно сохранен!");
        } catch (IOException e) {
                System.out.println("ошибка записи файла");
        }
     }
}

