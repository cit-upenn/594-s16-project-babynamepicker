package babynamepicker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 * 
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
							String babyname = split[0];
							char initial = babyname.charAt(0);
							String sex = split[1];
							int pop = Integer.parseInt(split[2]);
							
							data.addName(babyname, sex, initial, year, pop);
							
						}
						year++;
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
			        
			    }
			    in.close(); //***
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
