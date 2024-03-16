package MainClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class CollectionSaver {
    private LinkedHashSet<Product> products = new LinkedHashSet<>();

    //public CollectionSaver(Collection<Product> products){
    //    this.products.addAll(products);
    //}
    public CollectionSaver(){}

    public CollectionSaver(LinkedHashSet<Product> products) {
        this.products = products;
    }


    public void add(Product product){
        this.products.add(product);
    }

    public LinkedHashSet<Product> getProducts() {
        return products;
    }
}
