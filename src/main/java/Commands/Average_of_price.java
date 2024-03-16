package Commands;

import MainClasses.Product;
import MainClasses.ProductCollection;

/**
 * Класс, команды возвращающей среднее значение цены у всех элементов коллекции
 */

public class Average_of_price implements Command{
    public final static Average_of_price AVERAGE_OF_PRICE = new Average_of_price();

    private Average_of_price(){}
    /**
     * метод, выводящий в консоль среднее значение цены у всех элементов коллекции
     */

    @Override
    public void execute() {
        if(ProductCollection.PRODUCT_COLLECTION.getLen()==0)
            System.out.println("В коллекции нет ни одного продукта, пожалуйста, добавьте их");
        else {
            System.out.print("Cреднее значение цены по всем продуктам: ");
            System.out.println(Math.round(ProductCollection.PRODUCT_COLLECTION.getProducts().stream()
                    .map(Product::getPrice).reduce(Float::sum).get() /
                    ProductCollection.PRODUCT_COLLECTION.getLen() * 100000) / 100000);
        }
    }
}
