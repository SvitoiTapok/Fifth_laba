package MainClasses;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class ProductCollection {
    public final static ProductCollection PRODUCT_COLLECTION = new ProductCollection();
    private final LinkedHashSet<Product> products = new LinkedHashSet<>();
    private final Date Creation_date;

    private ProductCollection(){
        Creation_date = new Date();
        //чтение из файла
        try {
            System.out.println(System.getProperty("user.dir"));
            Path path = Paths.get("Data","ProductsData.json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            System.out.println("Создание коллекции на основе файла "+ path);
            CollectionSaver collectionSaver = objectMapper.readValue(path.toFile(), CollectionSaver.class);
            LinkedHashSet<Product> products1 = collectionSaver.getProducts();
            //System.out.println(products1);

            for (Product product : products1) {
                if (Collections.frequency(Product.ID, product.getId()) > 1 || product.getId() < 1) {
                    //System.out.println(Collections.frequency(Product.ID, product.getId()) + " " + product.getId());
                    System.out.println("Некорректный ID в файле Data\\ProductsData.json");
                    Product.ID.remove(product.getId());
                } else {
                    if (!Product.checkProduct(product))
                        System.out.println("Некорректное поле в продукте с ID: " + product.getId());
                    else{
                        product.ID.add(product.getId());
                        products.add(product);
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Некорректный файл с изначальными данными");
        }

    }

    public LinkedHashSet<Product> getProducts() {
        return products;
    }


    public void addProduct(Collection<Product> p){
        products.addAll(p);
        for(Product product: p){
            Product.ID.add(product.getId());
        }
    }

    public void addProduct(Product p){
        products.removeIf(x -> x.getId() == p.getId() && Product.ID.contains(x.getId()));
        products.add(p);
        //Product.ID.add(p.getId());
    }
    public void removeProduct(long id){
        products.removeIf(x -> x.getId() == id && Product.ID.contains(x.getId()));
        Product.ID.remove(id);
    }
    public void removeProducts(Collection<Product> product){
        products.removeAll(product);
        for(Product p: product)
            Product.ID.remove(p.getId());
    }

    public Date getData() {
        return Creation_date;
    }
    public int getLen(){
        return products.size();
    }


    public void clearCollection(){
        products.clear();
        Product.ID.clear();
    }

    public Product getMinProduct(){
        return products.stream().sorted().toList().get(0);
    }

}


