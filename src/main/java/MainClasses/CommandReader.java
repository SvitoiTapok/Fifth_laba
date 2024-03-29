package MainClasses;

import Commands.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CommandReader {
    public static final HashMap<String, Command> commands = new HashMap<>();
    public static Scanner MainScanner = new Scanner(System.in);
    public static boolean isFileReading = false;
    //для подпрограмм
    public static Scanner[] previousScanners = new Scanner[10];
    public static int nesting=0;
    static {
        previousScanners[0] = new Scanner(System.in);
    }
    public static void readCommands(){
        //MainScanner = sc;

        commands.put("help", Help.HELP);
        commands.put("info", Info.INFO);
        commands.put("show", Show.SHOW);
        commands.put("add", Add.ADD);
        commands.put("update", Update.UPDATE);
        commands.put("remove_by_id", Remove_By_ID.REMOVE);
        commands.put("clear", Clear.CLEAR);
        commands.put("save", Save.SAVE);
        commands.put("execute_script", Execute_script.EXECUTE_SCRIPT);
        commands.put("exit", Exit.EXIT);
        commands.put("add_if_min", Add_if_min.ADD_IF_MIN);
        commands.put("remove_greater", Remove_greater.REMOVE_GREATER);
        commands.put("remove_lower", Remove_lower.REMOVE_LOWER);
        commands.put("average_of_price", Average_of_price.AVERAGE_OF_PRICE);
        commands.put("filter_starts_with_name", Filter_starts_with_name.FILTER_STARTS_WITH_NAME);
        commands.put("filter_less_than_owner", Filter_less_than_owner.FILTER_LESS_THAN_OWNER);
        commands.put("write", Write.WRITE);


        while (MainScanner.hasNextLine()){
            //String input = sc.nextLine();
            String[] splitedInput = MainScanner.nextLine().split(" ");
            //если команда есть в списке вызываем ее без параметров или с параметрами в зависимости от инпута
            if (commands.containsKey(splitedInput[0])){
                if(splitedInput.length==1) {
                    commands.get(splitedInput[0]).execute();
                }else {
                    commands.get(splitedInput[0]).executeWithParameters(Arrays.copyOfRange(splitedInput, 1, splitedInput.length));
                }
            }else {
                System.out.println("команды " + splitedInput[0] + " не было найдено. Пожалуйста, введите help для получения доступного списка команд");
            }
        }
        if(isFileReading){
            MainScanner = previousScanners[nesting-1];

            //System.out.println(MainScanner.nextLine() +"cr");
        }
    }
}
