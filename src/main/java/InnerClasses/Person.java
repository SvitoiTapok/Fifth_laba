package InnerClasses;

import MainClasses.CommandReader;
import MainClasses.Product;
import enums.EyeColor;
import enums.HairColor;
import enums.Country;
import enums.UnitOfMeasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person implements Comparable<Person>{
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Поле не может быть null
    private EyeColor eyeColor; //Поле может быть null
    private HairColor hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null

    public Person(String name, String passportID, EyeColor eyeColor, HairColor hairColor, Country nationality) {
        this.name = name;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }
    public Person(){}

    public boolean setName(String name) {
        if(name == null || name.isEmpty()){
            return false;
        }
        this.name = name;
        return true;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public boolean setPassportID(String passportID) {
        if(passportID == null){
            return false;
        }
        this.passportID = passportID;
        return true;
    }


    public String getName() {
        return name;
    }

    public Country getNationality() {
        return nationality;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public String getPassportID() {
        return passportID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", passportID='" + passportID + '\'' +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return o.getName().toLowerCase().compareTo(this.name.toLowerCase());
    }

    public static Person createPerson(){
        Scanner sc = CommandReader.MainScanner;
        Person productOwner = new Person();
        int step = 0;
        List<String> messages = new ArrayList<>();
        messages.add("Введите имя владельца");
        messages.add("Введите ID паспорта владельца(не может быть пустым)");
        messages.add("Введите цвет глаз владельца(введите одно из 3-х слов: green, white, brown");
        messages.add("Введите цвет волос владельца(введите одно из 4-х слов: green, black, orange, white");
        messages.add("Введите национальность владельца(введите одно из 5 слов: united_kingdom, usa, spain, italy, north_korea");


        System.out.println("Пожалуйста, следуйте указаниям по вводу, чтобы создать нового человека(владельца товара). Если вы хотите прервать ввод и вернуться к другим командам, введите exit. \nТакже вы можете вернуться к предыдущему параметру, введя z(но будьте осторожны! предыдущее значение будет стерто. Для введения в поле значения null просто введите пустую строку");
        String input="";
        while (step != -1 && step != 5) {
            try {
                System.out.println(messages.get(step));
                input = sc.nextLine();
                //System.out.println(input);
                if (input.equals("exit")) {
                    step = -1;
                    break;
                }
                if (input.equals("z")) {
                    step--;
                    continue;
                }
                switch (step) {
                    //product name
                    case (0):
                        if (!productOwner.setName(input))
                            throw new Exception();
                        step++;
                        break;
                    case (1):
                        if (!productOwner.setPassportID(input))
                            throw new Exception();
                        step++;
                        break;
                    case (2):
                        productOwner.setEyeColor(EyeColor.valueOf(input.toUpperCase()));
                        step++;
                        break;
                    case (3):
                        productOwner.setHairColor(HairColor.valueOf(input.toUpperCase()));
                        step++;
                        break;
                    case (4):
                        productOwner.setNationality(Country.valueOf(input.toUpperCase()));
                        step++;
                        //ProductCollection.PRODUCT_COLLECTION.addProducts(addedProduct);

                        break;

                }
            } catch (Exception e) {
                System.out.println("некорректный ввод!");
            }

        }
        if (step == -1) {
            System.out.println("Процесс создания Person был прерван, вы вернулись к вводу команд");
            return null;
        }else {
            System.out.println("человек был успешно создан");
            return productOwner;
        }
    }
}
