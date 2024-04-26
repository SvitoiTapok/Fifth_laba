package mainClasses;

import commands.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CommandReader {
    //private final HashMap<String, Command> commands = new HashMap<>();
    //private Scanner MainScanner = new Scanner(System.in);
    private boolean isFileReading = false;
    private final static HashMap<String, Command> commands = new HashMap<>();
    //для подпрограмм
    //public static Scanner[] previousScanners = new Scanner[10];
    //static {
    //    previousScanners[0] = new Scanner(System.in);
    //}
    static {
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("add", new Add());
        commands.put("update", new Update());
        commands.put("remove_by_id", new RemoveByID());
        commands.put("clear", new Clear());
        commands.put("save", new Save());
        commands.put("execute_script", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("add_if_min", new AddIfMin());
        commands.put("remove_greater", new Remove_greater());
        commands.put("remove_lower", new Remove_lower());
        commands.put("average_of_price", new AverageOfPrice());
        commands.put("filter_starts_with_name", new FilterStartsWithName());
        commands.put("filter_less_than_owner", new FilterLessThanOwner());
        commands.put("write", new Write());
    }
    public static void readCommands(Scanner mainScanner, ProductCollection productCollection, boolean isFileReading){
        //MainScanner = sc;
        while (mainScanner.hasNextLine()){
            //String input = sc.nextLine();
            String[] splitedInput = mainScanner.nextLine().split(" ");
            //если команда есть в списке вызываем ее без параметров или с параметрами в зависимости от инпута
            if (commands.containsKey(splitedInput[0])){
                if(splitedInput.length==1) {
                    commands.get(splitedInput[0]).execute(mainScanner, productCollection, isFileReading);
                }else {
                    commands.get(splitedInput[0]).executeWithParameters(mainScanner, productCollection, Arrays.copyOfRange(splitedInput, 1, splitedInput.length), isFileReading);
                }
            }else {
                System.out.println("команды " + splitedInput[0] + " не было найдено. Пожалуйста, введите help для получения доступного списка команд");
            }
        }
        //if(isFileReading){
        //    MainScanner = previousScanners[nesting-1];

            //System.out.println(MainScanner.nextLine() +"cr");
        }
    }
