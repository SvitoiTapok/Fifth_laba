package commands;

import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Класс команды, заканчивающий выполнение программы
 */

public class Exit implements Command{
    /**
     * метод, заканчивающий выполнение программы
     */
    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        System.out.println("Программа была завершена");
        System.exit(0);
    }
}
