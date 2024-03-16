package Commands;

import InnerClasses.Month;
import MainClasses.ProductCollection;

/**
 * Класс команды, выводящей в консоль краткую информацию о коллекции(дата создания, количество и тип элементов)
 */

public class Info implements Command{
    public final static Info INFO = new Info();

    private Info(){}
    /**
     * метод, выводящей в консоль краткую информацию о коллекции(дата создания, количество и тип элементов)
     */
    @Override
    public void execute(){
        String[] data = ProductCollection.PRODUCT_COLLECTION.getData().toString().split(" ");

        System.out.println("Коллекция состоит из элементов типа Product, она была создана " +
                data[2] + " " + Month.getMounthTranslation(data[1]) + " " + data[5] + " года в " + data[3] +
                ". На данный момент она содержит " + ProductCollection.PRODUCT_COLLECTION.getLen() + " различных элементов");
    }
}
