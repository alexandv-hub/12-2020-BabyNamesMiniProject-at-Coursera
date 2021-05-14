import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyNames {
	
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord currentRow: fr.getCSVParser(false) ) {
            int numBorn = Integer.parseInt(currentRow.get(2) ); 
            if (numBorn <=100) {
                System.out.println("Name " + currentRow.get(0) + 
                                    " Gender " + currentRow.get(1) + 
                                    " NumBorn " + currentRow.get(2) );
            }
            
        }
        
    }
    
    
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoysBorn = 0;
        int totalGirlsBorn = 0;
        for (CSVRecord currentRow : fr.getCSVParser(false) ) {
            int numBorn = Integer.parseInt(currentRow.get(2));
            totalBirths += numBorn;
            if (currentRow.get(1).equals("M") ) {
                totalBoysBorn += numBorn;
            }
            else {
                totalGirlsBorn += numBorn;
            }
        }
        System.out.println("totalBirths = " + totalBirths );
        System.out.println("totalBoysBorn = " + totalBoysBorn );
        System.out.println("totalGirlsBorn = " + totalGirlsBorn );
    } 
    
    public void tesTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    } 
    
    int getRank (int year, String name, String gender) {
        // returns the rank of the name in the file for the given gender,  where rank 1 
        // is the name with the largest number of births. If the name is not in the file, then -1 is returned.
        
        // create fr
        // filter by gender,
        // iterate row by row with counter for boys and girls
        // if a name is found the return th value of counter as the rank
        // take number how many were born with this name?
        // and save counter in Rank. if counter = 0, rank = -1; 
        
        
        int rank = -1;
        FileResource fr = new FileResource();
        for (CSVRecord currRow : fr.getCSVParser() ) {
            String currName = currRow.get(0);
            String currGender = currRow.get(1); 
            // int currNumBorn = Integer.parseInt(currRow.get(2) );
            int counterBoys = 0;
            int counterGirls = 0;
            if (gender == "M") {
                counterBoys++;
                System.out.println("counterBoys="+counterBoys);
                if (currName.equals(name) ) {
                    counterBoys++;
                    rank = counterBoys;
                    System.out.println("(from IF)counterBoys="+counterBoys);
                }
            }
            else {
                counterGirls++;
                System.out.println("(from else) counterGirls="+counterGirls);
                if (currName.equals(name) ) {
                    counterGirls++;
                    rank = counterGirls;
                    System.out.println("(from IF) counterGirls="+counterGirls);
                }
                
            }
        
        }
        System.out.println("rank=" + rank);
        return rank;
    } 
    
    void testGetRank () {
        int year = 2012;
        String name = "Olivia"; 
        String gender = "F";
        getRank(year, name, gender);
    } 

}
