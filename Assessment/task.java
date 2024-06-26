import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;


public class task {

    private static final Logger logger =Logger.getLogger(task.class.getName());
       
    private static String reverseWord(String word) {
        StringBuilder letters = new StringBuilder();
        StringBuilder specials = new StringBuilder();
        StringBuilder reversed = new StringBuilder();
    
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                letters.append(ch);
            } else {
                specials.append(ch);
            }
        }
    
        reversed.append(letters.reverse());
        reversed.append(specials);
    
        return reversed.toString();
    }


    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (
             BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    StringBuilder reversedLine = new StringBuilder();
    
                    for (String word : words) {
                        String reversedWord = reverseWord(word);
                        reversedLine.append(reversedWord).append(" ");
                    }

                    
                    logger.info("Operations Performed Successfully" );
                
                    writer.write(reversedLine.toString().trim());
                    writer.newLine();
                }   

        }catch(IOException e) {
            logger.info("Error in File Handling" );
            e.printStackTrace();
        }   
    

    }





   
    
}
