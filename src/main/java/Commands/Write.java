package Commands;

public class Write implements Command{
    public static final Write WRITE = new Write();
    /**
     * приватный конструктор для единственности команды
     */
    private Write(){};
    @Override
    public void executeWithParameters(String[] p) {
        System.out.println(p[0]);
    }
}
