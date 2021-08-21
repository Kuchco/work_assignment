import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Choose reader: \nFile: 1 \nInput: 2");
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true){
            input = scanner.next();
            if(input.equals("1")){
                System.out.println("Input file path: ");
                input = scanner.next();
                FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();
                try {
                    findPathInputReaderFile.readFile(input); //"./src/main/resources/inputMaze.txt"
                }catch (FileNotFoundException fnfe) {
                    System.out.println("File was not found");
                    break;
                }
                List<Path> shortestPath =  findPathInputReaderFile.findShortestPath();
                break;
            }else if(input.equals("2")){
                System.out.println("Input maze by rows. When done input 'exit'.");
                FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn();
                findPathInputReaderStdIn.readInput();
                List<Path> shortestPath =  findPathInputReaderStdIn.findShortestPath();
                break;
            }else{
                System.out.println("Wrong input, please try again");
            }
        }
    }
}
