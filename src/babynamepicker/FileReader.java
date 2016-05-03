package babynamepicker;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 * This class reads in files and creates Dataset.
 * @author victoriayi
 *
 */
public class FileReader {
	/**
	 * instance variables
	 */
	private Dataset data;
	private String path;
	private Scanner in;
	private int year;
	
	/**
	* constructor
	* @param _path, the path of files
	* @param _year, the starting year
	*/
	public FileReader(String _path, int _year) {
		path = _path;
		data = new Dataset();
		year = _year;
	}
	
	/**
	 * Parse the data from files
	 * @return data
	 */
	public Dataset parseData() {
		String delimiter = ",";
		
		try {
			Files.walk(Paths.get(path)).forEach(filePath -> {
			    if (Files.isRegularFile(filePath)) {
			    	File f = new File(filePath.toString());
			        try {
						in = new Scanner(f);
						while(in.hasNextLine()) {
							String s = in.nextLine();
							String[] split = s.split(delimiter);
							String babyname = split[0]; //the name
							char initial = babyname.charAt(0); //the first character of the name, i.e. the initial
							String sex = split[1]; //gender, M or F
							int pop = Integer.parseInt(split[2]); //popularity (number of occurrences in that year)
							
							data.addName(babyname, sex, initial, year, pop);
						}
						year++; //increment the year for the next file
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
			        
			    }
			});
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
