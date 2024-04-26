package mainClasses;


import java.util.Scanner;

public class Main {
    /**
     * This is a Javadoc comment for the myMethod method.
     * @param args Description of param1adfasdfasdfadsfadfasdfasdfasdf
     */
    public static void main(String[] args) {

        ProductCollection productCollection = new ProductCollection();
        CommandReader.readCommands(new Scanner(System.in), productCollection, false);



    }

}
