import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * Method for task 2a. It calculates the sum of given numbers.
     * @param numbers - numbers in String to calculate
     * @return sum - sum of all numbers
     */
    public static String sum(String numbers) {
        String[] splitNumbers = numbers.split(" ");
        float sum = 0;

        for (int i = 0; i < splitNumbers.length; i++) {
            try {
                sum += Float.valueOf(splitNumbers[i]);
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format:" + e);
                return "";
            }
        }
        return Float.toString(sum);
    }

    /**
     * Method for task 2b. Combines wird in CamelCase style
     * It is also possible to solve this task with a StringBuilder
     * @param words - String of words
     * @return output - one string of all given words in cc
     */
    public static String camelCase (String words) {
        String[] splitWords = words.split(" ");
        String output = splitWords[0];
        for (int i = 1; i < splitWords.length; i++) {
            output += splitWords[i].substring(0,1).toUpperCase() + splitWords[i].substring(1);
        }
        return output;
    }

    /**
     * Method for task 2c. Reverses a string
     * It is also possible to solve this task with a StringBuilder and its reverse method
     * @param word - String to reverse
     * @return output - revers sring of given word
     */
    public static String reverse (String word) {
        String output = "";
        char temp;
        for (int i = 0; i < word.length(); i++) {
            temp = word.charAt(i);
            output = temp + output;
        }
        return output;
    }

    /**
     * Method for tast 2d. Sorts given words alphabetically
     * It is also possible to solve this with the Array.sort() method
     * @param words - Words to sort
     * @return output - sorted words alphabetically
     */
    public static String order (String words) {
        String[] splitWords = words.split(" ");
        String temp, output = "";
        for (int i = 0; i < splitWords.length; i++) {
            for (int ii = i + 1; ii < splitWords.length; ii++) {
                if (splitWords[i].compareTo(splitWords[ii]) > 0) {
                    temp = splitWords[i];
                    splitWords[i] = splitWords[ii];
                    splitWords[ii] = temp;
                }
            }
        }
        for (int i = 0; i < splitWords.length - 1; i++) {
            output += splitWords[i] + " ";
        }
        return (output += splitWords[splitWords.length-1]);
    }

    /**
     * method to scan a file and get the content
     * it is also possible to solve this with BufferReader
     * @param filePath - path of file
     * @return output - returns all content from file in correct format
     */
    public static String scanFile (String filePath) {
        Scanner scanner = null;
        String input = "";
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("### Couldn't found a file:" + e);
        }
        while (scanner.hasNext()) {
            input += scanner.nextLine() + "\n";
        }
        scanner.close();
        return input;
    }

    /**
     * method for processing the input over the given file
     * @param input - input given from the file
     * @return output - results of the required methods presented legibly
     */
    public static String handleInput (String input) {
        String[] splitInput = input.split("\n");
        String output = "";
        int counter = 1;
        for (int i = 0; i < splitInput.length; i = i+2){
            output += "###################################################################\n";
            output += "### " + counter + ". method is " + splitInput[i] + ". Output for input " + splitInput[i+1] + " is: \n";
            output += "### " + checkMethod(splitInput[i], splitInput[i+1]) + "\n";

            counter++;
        }
        output += "###################################################################";
        return output;
    }

    /**
     * Auxiliary method to choose and apply the right method
     * @param toCheck - String from input with name of algorithm
     * @param parameter - String from input with parameters for the algorithm
     * @return output - returns the output of the choosen algorithm
     */
    public static String checkMethod (String toCheck, String parameter) {
        if (toCheck.equals("SUM")) {
            return sum(parameter);
        } else if (toCheck.equals("CC")) {
            return camelCase(parameter);
        } else if (toCheck.equals("REVERSE")) {
            return reverse(parameter);
        } else if (toCheck.equals("ORDER")) {
            return order(parameter);
        } else {
            return "Invalid algorithm: " + toCheck;
        }
    }

    public static void main(String[] args) {
        System.out.println("###################################################################");
        System.out.println("### Transporeon Coding Tasks - Solution from Lucas Ostarek      ###");
        System.out.println("###################################################################");
        System.out.println("###################################################################");
        System.out.println(handleInput(scanFile("tasks.txt")));
    }
}