package mainClasses;

import innerClasses.Coordinates;
import innerClasses.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.UnitOfMeasure;

import java.time.ZonedDateTime;
import java.util.*;

public class Product implements Comparable<Product> {
    //public static long countOfProducts = 1;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле не может быть null, Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Person owner; //Поле не может быть null


    //public Product(String name, Coordinates coordinates, Float price, UnitOfMeasure unitOfMeasure, Person owner) {
    //    long i = 1;
    //    while (ID.contains(i))
    //        i++;
    //    this.id = i;
    //    ID.add(id);
    //    this.name = name;
    //    this.coordinates = coordinates;
    //    this.creationDate = ZonedDateTime.now();
    //    this.price = price;
    //    this.unitOfMeasure = unitOfMeasure;
    //    this.owner = owner;
    //}

    public Product(long id) {
        this.id = id;
        this.creationDate = ZonedDateTime.now();
    }

    //важно проверить это в productCollection
    public Product(@JsonProperty("id") Long id) {
        this.id = id;
        this.creationDate = ZonedDateTime.now();
    }

    public Product() {
        this.creationDate = ZonedDateTime.now();
    }

    @Override
    public int compareTo(Product p) {
        return this.getName().toLowerCase().compareTo(p.getName().toLowerCase());
    }

    @Override
    public String toString() {
        return "Product{" + "\n" +
                "\t" + "id=" + id + ",\n" +
                "\t" + "name='" + name + '\'' + ",\n" +
                "\t" + "coordinates=" + coordinates + ",\n" +
                "\t" + "creationDate=" + creationDate + ",\n" +
                "\t" + "price=" + price + ",\n" +
                "\t" + "UnitOfMeasure=" + unitOfMeasure + ",\n" +
                "\t" + "owner=" + owner + "\n" +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean checkName(String name) {
        return !(name == null || name.isEmpty());
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static boolean checkPrice(Float price) {
        return price > 0;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    //public ZonedDateTime getCreationDate() {
    //    return creationDate;
    //}
//
    //public static long getCountOfProducts() {
    //    return ID.size();
    //}
//
    //public UnitOfMeasure getUnitOfMeasure() {
    //    return unitOfMeasure;
    //}
//
    //public Coordinates getCoordinates() {
    //    return coordinates;
    //}
//
    //public static ArrayList<Long> getID() {
    //    return ID;
    //}

    public Float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    //если мы создаем продукт с не заданным id, передаем null
    public static Product createProduct(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        Product addedProduct = new Product();
        addedProduct.setId(productCollection.MakeId());

        Coordinates productCoordinates = new Coordinates();
        int step = 0;
        List<String> messages = new ArrayList<>();
        messages.add("Введите наименование продукта(ввод не может быть пустым)");
        messages.add("Введите координаты объекта(координаты могут быть не целыми, они вводятся через пробел, значение x должно быть больше -627, y не должен превышать 677, оба они должны существовать");
        messages.add("Введите цену продукта(она может быть не целой, но обязательно положительной)");
        messages.add("Введите единицу измерения продукта(введите одно из 3-х слов: kilograms, grams, square_meters)");
        messages.add("");

        if (!isFileReading)
            System.out.println("Пожалуйста, следуйте указаниям по вводу, чтобы создать новый продукт. Если вы хотите прервать ввод и вернуться к другим командам, введите stop. \nТакже вы можете вернуться к предыдущему параметру, введя z(но будьте осторожны! предыдущее значение будет стерто. Для введения в поле значения null просто введите пустую строку");
        String input = "";
        while (step != -1 && step != 4) {
            if (!isFileReading) {
                System.out.println(messages.get(step));
            }
            try {
                input = sc.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("файл кончился, процесс создания продукта не завершен");
                return null;
            }
            //System.out.println(input);
            if (input.equals("stop")) {
                step = -1;
                break;
            }
            if (input.equals("z")) {
                step--;
                continue;
            }
            switch (step) {
                //product name
                case (0) -> {
                    if (!Product.checkName(input)) {
                        System.out.println("Некорректное имя продукта! Пожалуйста, следуйте указаниям по вводу");
                        break;
                    }
                    addedProduct.setName(input);
                    step++;
                }
                //product coordinates
                case (1) -> {
                    String[] separatedInput = input.split(" ");
                    if (!(separatedInput.length == 2)) {
                        System.out.println("Введите 2 числа через пробел");
                        break;
                    }
                    try {
                        Double.parseDouble(separatedInput[0]);
                    } catch (Exception e) {
                        System.out.println("Введите корректное первое число");
                        break;
                    }
                    try {
                        Float.parseFloat(separatedInput[1]);
                    } catch (Exception e) {
                        System.out.println("Введите корректное второе число");
                        break;
                    }
                    double x = Double.parseDouble(separatedInput[0]);
                    Float y = Float.parseFloat(separatedInput[1]);
                    if (!Coordinates.checkX(x) || !Coordinates.checkY(y)) {
                        System.out.println("Некорректные координаты! Пожалуйста, следуйте указаниям по вводу");
                        break;
                    }
                    productCoordinates.setY(y);
                    productCoordinates.setX(x);
                    addedProduct.setCoordinates(productCoordinates);
                    step++;
                }
                case (2) -> {
                    try {
                        Float.parseFloat(input);
                    } catch (Exception e) {
                        System.out.println("Введите корректное число");
                        break;
                    }
                    Float price = Float.parseFloat(input);
                    if (!Product.checkPrice(price)) {
                        System.out.println("Некорректные координаты! Пожалуйста, следуйте указаниям по вводу");
                        break;
                    }
                    addedProduct.setPrice(price);
                    step++;
                }
                case (3) -> {
                    try {
                        addedProduct.setUnitOfMeasure(UnitOfMeasure.valueOf(input.toUpperCase()));
                    } catch (Exception e) {
                        System.out.println("Некорректные единицы измерения! Пожалуйста, следуйте указаниям по вводу");
                        break;
                    }
                    Person productOwner = Person.createPerson(sc, isFileReading);
                    if (productOwner==null){
                        step=-1;
                    }else {
                        addedProduct.setOwner(productOwner);
                        step++;
                    }
                }
            }
        }
        if (step == -1) {
            System.out.println("Процесс добавления был прерван, вы вернулись к вводу команд");
            return null;
        } else {
            System.out.println("Продукт успешно создан");
            return addedProduct;
        }
    }

    public static boolean checkProduct(Product product) {
        return checkName(product.name) && Coordinates.checkY(product.coordinates.getY()) &&
                Coordinates.checkX(product.coordinates.getX()) && Product.checkPrice(product.price) &&
                product.unitOfMeasure != null && Person.checkName(product.owner.getName()) &&
                Person.checkPassportId(product.owner.getPassportID()) && product.owner.getNationality()!=null;
    }
}
