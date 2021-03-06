
/**
 * Write a description of ParsingExportData here.
 * 
 * @author yamatokataoka 
 * @version September 12th, 2019
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParsingExportData {
    // Write a method named tester that will create your CSVParser 
    // and call each of the methods below
    public void tester () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // test countryInfo method
        String country = "Nauru";
        System.out.println("Look info for " + country);
        System.out.println("The country info is " + countryInfo(parser, country));
        
        // test listExportersTwoProducts
        // reset the parser
        parser = fr.getCSVParser();
        String exportItem1 = "cotton";
        String exportItem2 = "flowers";
        System.out.println("Exports items are " + exportItem1 +" and "
                            + exportItem2);
        listExportersTwoProducts(parser, exportItem1, exportItem2);
        
        // test numberOfExporters
        // reset the parser
        parser = fr.getCSVParser();
        String exportItem = "cocoa";
        System.out.println("The number of exporters of " + exportItem + " is "
                            + numberOfExporters(parser, exportItem));
        
        // test bigExporters
        // reset the parser
        parser = fr.getCSVParser();
        String amount = "$999,999,999,999";
        System.out.println("amout is " + amount);
        bigExporters(parser, amount);
    }
    
    // Write a method named countryInfo that has two parameters, 
    // parser is a CSVParser and country is a String.
    // This method returns a string
    private String countryInfo (CSVParser parser, String country) {
        // for each row in CSV file
        for (CSVRecord record : parser) {
            String countryOfRow = record.get("Country");
            if (countryOfRow.equals(country)) {
                return countryOfRow + ": " + record.get("Exports")
                       + ": " + record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }
    
    // Write a void method named listExportersTwoProducts that has 
    // three parameters, parser is a CSVParser, exportItem1 is a String 
    // and exportItem2 is a String.
    // This method prints the names of all the countries that have 
    // both exportItem1 and exportItem2 as export items.
    private void listExportersTwoProducts (CSVParser parser
                                            , String exportItem1
                                            , String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    // Write a method named numberOfExporters, which has two parameters, 
    // parser is a CSVParser, and exportItem is a String. 
    // This method returns the number of countries that export exportItem.
    private int numberOfExporters (CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }
    
    // Write a void method named bigExporters that has two parameters, 
    // parser is a CSVParser, and amount is a String
    // This method prints the names of countries and their Value amount for 
    // all countries whose Value (dollars) string is longer than 
    // the amount string.
    private void bigExporters (CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                System.out.println(record.get("Country") + " " 
                                        + value);
            }
        }
    }
}
