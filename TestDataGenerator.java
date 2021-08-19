import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TestDataGenerator {
    final String dataSource = "https://jimpix.co.uk/generators/word-generator.asp#results;";

    public TestDataGenerator() {
    }

    static ArrayList<String> generateRow(){


        Random r = new Random();
        ArrayList <ArrayList<String>>  arrayOfWords= new ArrayList<ArrayList<String>>();
        ArrayList<String> source = new ArrayList<String>();
        ArrayList<String> empty= new ArrayList<String>();
        File file = new File("data.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String word;
            while((word = reader.readLine()) != null) {
                source.add(word);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + file + "'");
        }

        for(int counter=0; counter < 28;counter++){
            empty.add(source.get(r.nextInt(28)));

        }
        return empty;
    }

    static ArrayList<ArrayList<String>> generateGrid() {
        Random r = new Random();
        ArrayList <ArrayList<String>>  arrayOfWords= new ArrayList<ArrayList<String>>();
        ArrayList<String> source = new ArrayList<String>();
        ArrayList<String> empty= new ArrayList<String>();
        File file = new File("data.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String word;
            while((word = reader.readLine()) != null) {
                source.add(word);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + file + "'");
        }


        for(int counter=0; counter < 28;counter++){
            arrayOfWords.add(generateRow());

        }






        return arrayOfWords;
    }


}
