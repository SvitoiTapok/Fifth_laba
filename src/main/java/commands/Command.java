package commands;

import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Интерфейс всех для команд
 */

public interface Command {
    /**
    * метод, вызываемый у команд без передаваемых параметров(или параметров, передаваемых не в одной строке с командой)
    */
    default void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading){
        System.out.println("у этой команды нет реализации выполнения без параметров");
    }
    /**
     * метод, вызываемый у команд с передаваемыми параметрами
     * */
    default void executeWithParameters(Scanner sc, ProductCollection productCollection, String[] p, boolean isFileReading){
        System.out.println("у этой команды нет реализации выполнения c параметрами");
    }
}
