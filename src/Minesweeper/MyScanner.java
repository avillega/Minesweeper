package Minesweeper;
import java.util.Scanner;

/**
 * Responsible of read the input types
 * @author caladdd
 *
 */
public class MyScanner {
    private Scanner sc;
    
    /**
     * Create scanner
     */
    public MyScanner() {
        sc = new Scanner(System.in);
    }

    /**
     * Read initial input
     * @return  Array with height and width of the board and amount mines
     */
    public int[] initialInput() {
        boolean rightFormat = false;
        String initialInput = "";; //= sc.nextLine();
        // height, width, mines
        int[] input = new int[3]; 
        String[] inputs = initialInput.split(" ");
        while(inputs.length != 3 || !rightFormat) {
            initialInput = sc.nextLine();
            inputs = initialInput.split(" ");
            if(inputs.length == 3) {
                if(CheckInt(inputs[0]) && CheckInt(inputs[1]) && CheckInt(inputs[2])) {
                    if(getInt(inputs[0])<=0 || getInt(inputs[1])<=0) {
                        System.out.println("You entered an incorrect dimension for the board, try again!");
                    }
                    else {
                        if(getInt(inputs[2]) <= getInt(inputs[0])*getInt(inputs[1]))
                            rightFormat = true;
                        else
                            System.out.println("You entered more mines than the size of the board, try again!");
                    }
                }
                else {
                    System.out.println("wrong format, try again!");
                }
            }
            else{
                System.out.println("wrong input, try again!");
            }
        }
        input[0] = Integer.parseInt(inputs[0]);
        input[1] = Integer.parseInt(inputs[1]);
        input[2] = Integer.parseInt(inputs[2]);	
        return input;
    }
    
    /**
     * Read standard input
     * @return  Array with coordinates X,Y and input type
     */
    public StandardInput standardInput(int xLimit,int yLimit){
        boolean rightFormat = false;
        String standardInput = "";
        StandardInput inpu;
        //x, y, type
        String[] inputs = standardInput.split(" ");
        while(inputs.length != 3 || !rightFormat) {
            standardInput = sc.nextLine();
            inputs = standardInput.split(" ");
            if(inputs.length == 3) {
                if(CheckInt(inputs[0]) && CheckInt(inputs[1]) && CheckChar(inputs[2])) {
                    int x = getInt(inputs[0]);
                    int y = getInt(inputs[1]);
                    if(getChar(inputs[2])=='U' || getChar(inputs[2])=='M')
                        if(x <= 0 || x > xLimit || y <= 0 || y > yLimit ) {
                            System.out.println("You entered a wrong coordinate, try again!");
                        }
                        else {
                            rightFormat = true;
                        }
                    else
                        System.out.println("You entered a wrong type of input, try again!");
                }
                else {
                    System.out.println("wrong format, try again!");
                }
            }
            else{
                System.out.println("wrong input, try again!");
            }
        }
        inpu = new StandardInput(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), inputs[2]); 
        return inpu;
    }
    
    /**
     * Transform string to int
     * @param val  String
     * @return  int value
     */
    private int getInt(String val) {
        return Integer.parseInt(val);
    }
    
    /**
     * Transform string to char
     * @param val  String
     * @return  char value
     */
    private char getChar(String val) {
        return val.charAt(0);
    }
    
    /**
     * Check if val is an Int
     * @param val  String
     * @return  bool
     */
    private boolean CheckInt(String val) {
        try {
            Integer.parseInt(val);
            return true;
        }catch(NumberFormatException e ) {
            return false;
        }
    }
    
    /**
     * Check if val is a Char
     * @param val  String
     * @return  bool
     */
    private boolean CheckChar(String val) {
        if(val.length()==1)
            return true;
        return false;
    }
    
}
