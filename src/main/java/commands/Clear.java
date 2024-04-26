package commands;

import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Класс, команды очищающей коллекцию
 */

public class Clear implements Command{
    /**
     * метод, очищающий коллекцию
     */
    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        productCollection.clearCollection();
        System.out.println("Коллекция очищена");
    }
}
