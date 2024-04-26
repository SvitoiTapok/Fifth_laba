package commands;

import mainClasses.Product;
import mainClasses.ProductCollection;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды, удаляющей из коллекции все элементы меньше заданного(сортировка выполняется в лексикографическом порядке по именам продуктов)
 */

public class Remove_lower implements Command{
    /**
     * метод, создающий элемент и удаляющий из коллекции все элементы меньше заданного
     */
    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        Product product = Product.createProduct(sc, productCollection, isFileReading);
        if(product!=null) {
            //ProductCollection.PRODUCT_COLLECTION.addProduct(product);
            LinkedHashSet<Product> prods = productCollection.getProducts();
            LinkedHashSet<Product> removedProds = new LinkedHashSet<>();
            for(Product prod: prods){
                if(prod.compareTo(product)<0)
                    removedProds.add(prod);
            }
            productCollection.removeProducts(removedProds);
        }
    }
}
