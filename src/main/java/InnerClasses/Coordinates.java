package InnerClasses;

/**
 * Класс содержащий координаты продукта
 */

public class Coordinates {
    /**
     * Значение поля должно быть больше -627
     */
    private double x;
    /**
     * Максимальное значение поля: 677, Поле не может быть null
     */
    private Float y; //

    public Coordinates(double x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {}

    /**
     * устанавливает данное значение x и возвращает true если переданное значение удовлетворяет ОДЗ
     */
    public boolean setX(double x) {
        if(x<=-627)
            return false;
        this.x = x;
        return true;
    }
    public boolean setY(Float y) {
        if(y>677 || y==null)
            return false;
        this.y = y;
        return true;
    }

    public double getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
