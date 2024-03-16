package Commands;

import MainClasses.Product;
import MainClasses.ProductCollection;

/**
 * Класс, команды добавляющий новый элемент в коллекцию
 */
public class Add implements Command{
    public static final Add ADD = new Add();
    private Add(){};
    /**
     * метод, создающий объект с помощью метода класса Product и записывающий его в коллекцию
     */
    @Override
    public void execute() {
        Product product = Product.createProduct(null);
        if(product!=null){
            ProductCollection.PRODUCT_COLLECTION.addProduct(product);
        }
    }
}
