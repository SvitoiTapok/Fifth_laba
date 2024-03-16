package Commands;

import MainClasses.Product;
import MainClasses.ProductCollection;

import java.util.LinkedHashSet;

/**
 * Класс команды, удаляющей из коллекции все элементы большие заданного(сортировка выполняется в лексикографическом порядке по именам продуктов)
 */

public class Remove_greater implements Command{
    public static final Remove_greater REMOVE_GREATER = new Remove_greater();
    private Remove_greater(){};
    /**
     * метод, создающий элемент и удаляющий из коллекции все элементы большие заданного
     */
    @Override
    public void execute() {
        Product product = Product.createProduct(null);
        if(product!=null) {
            // ProductCollection.PRODUCT_COLLECTION.addProduct(product);
            LinkedHashSet<Product> prods = ProductCollection.PRODUCT_COLLECTION.getProducts();
            LinkedHashSet<Product> removedProds = new LinkedHashSet<>();
            for(Product prod: prods){
                if(prod.compareTo(product)>0)
                    removedProds.add(prod);
            }
            ProductCollection.PRODUCT_COLLECTION.removeProducts(removedProds);
        }
    }
}
