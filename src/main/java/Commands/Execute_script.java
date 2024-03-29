package Commands;

import MainClasses.CommandReader;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 * Класс команды, позволяющей вызывать команды из переданного файла
 */
public class Execute_script implements Command{
    /**
     * Поле, показывающее вложенность вызовов скриптов(если его не ограничить, возможно появление бесконечной рекурсии)
     */
    public static int nesting=0;
    public static final Execute_script EXECUTE_SCRIPT = new Execute_script();
    private Execute_script(){};

    /**
     * метод, вызывающий скрипт из файла
     * @param p передается переменная окружения с путем к файлу с исполняемым скриптом
     */
    @Override
    public void executeWithParameters(String[] p) {
        if(p.length>1){
            System.out.println("эта функция принимает только один аргумент");
            return;
        }
        //теперь это аргумент - путь в Data)
        Path path = Paths.get("Data", p[0]);
        //if(path == null){
        //    System.out.println("системной переменной с именем " + p[0] + " не было найдено");
        //    return;
        //}
        try {
            FileReader fileReader = new FileReader(path.toFile());
            int st;
            String json="";
            while ((st = fileReader.read()) != -1)
                json += (char) st;
            System.out.println("скрипт " + path + " начал выполнение");
            CommandReader.MainScanner = new Scanner(json);
            CommandReader.isFileReading = true;
            nesting++;
            if(nesting>=10){
                System.out.println("Достигнута максимальная вложенность скриптов, пожалуйста, избегайте вызова скрипта в скрипте");
            }else
                CommandReader.readCommands(CommandReader.MainScanner);
            nesting--;
            CommandReader.MainScanner = new Scanner(System.in);
            CommandReader.isFileReading = false;
            System.out.println("скрипт выполнен");
        }catch (IOException e){
            System.out.println("некорректный путь к файлу");
        }catch (SecurityException e){
            System.out.println("пользователь не обладает достаточными правами");
        }
    }
}


//execute_script FIFTH_LAB_PATH
//execute_script FIFTH_LAB_PATH2

