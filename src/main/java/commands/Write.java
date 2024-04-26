package commands;

import mainClasses.ProductCollection;

import java.util.Scanner;

public class Write implements Command{
    @Override
    public void executeWithParameters(Scanner sc, ProductCollection productCollection, String[] p, boolean isFileReading) {
        System.out.println(p[0]);
    }
}
