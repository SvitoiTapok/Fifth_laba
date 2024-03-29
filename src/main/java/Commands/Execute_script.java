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

    public static final Execute_script EXECUTE_SCRIPT = new Execute_script();

    private Execute_script(){CommandReader.previousScanners[0] = new Scanner(System.in);}

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

            if(CommandReader.nesting>=10){
                System.out.println("Достигнута максимальная вложенность скриптов, пожалуйста, избегайте вызова скрипта в скрипте");
                CommandReader.nesting++;
            }else {
                FileReader fileReader = new FileReader(path.toFile());
                int st;
                String script="";
                while ((st = fileReader.read()) != -1)
                    script += (char) st;
                System.out.println("скрипт " + path + " начал выполнение");
                //сохранение сканера для возврата к нему после выполнение другого скрипта
                String savedScannerData = "";
                if(CommandReader.nesting>0) {
                    while (CommandReader.MainScanner.hasNextLine()) {
                        savedScannerData += CommandReader.MainScanner.nextLine()+"\n";
                        //System.out.println(savedScannerData);
                    }
                    CommandReader.previousScanners[CommandReader.nesting] = new Scanner(savedScannerData);
                    //System.out.println(savedScannerData);
                }
                CommandReader.nesting++;
                CommandReader.MainScanner = new Scanner(script);
                CommandReader.isFileReading = true;
                CommandReader.readCommands();
                System.out.println("скрипт выполнен");//+ текущая вложенность"+ (CommandReader.nesting-1));
            }
            CommandReader.nesting--;
            //System.out.println(CommandReader.MainScanner.nextLine());
            //CommandReader.MainScanner = previousScanners[nesting];
            if(CommandReader.nesting==0) {
                CommandReader.isFileReading = false;
            }

        }catch (IOException e){
            System.out.println("некорректный путь к файлу");
        }catch (SecurityException e){
            System.out.println("пользователь не обладает достаточными правами");
        }
    }
}


//execute_script FIFTH_LAB_PATH
//execute_script FIFTH_LAB_PATH2

