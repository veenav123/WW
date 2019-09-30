
import java.io.BufferedReader;
import java.util.LinkedHashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {

	public static void main(String[] agr) {
// data location
		String filepath = "src\\TestData.txt";
		try {
			doesFileExist(filepath);
			readFile(filepath);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Unable to read the file" + filepath + e.getMessage());
		}

	}

	/***
	 * doesFileExist verifies whether the file exist or not.
	 * 
	 * @param filepath
	 *            {@code String} for verifying the existence of the file @
	 * throws IOException, FileNotFoundException
	 ***/
	public static void doesFileExist(String filepath) throws IOException, FileNotFoundException {

		FileReader fileReader = new FileReader(filepath);
		fileReader.read();

	}

	/***
	 * readFile file from file and prints each word and possible meaning of the
	 * word
	 * 
	 * @param filepath
	 *            {@code String} for verifying the existence of the file @ catch
	 * IOException
	 ***/
	public static void readFile(String filepath) {
		int count = 0;
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		String readline;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			while ((readline = br.readLine()) != null) {
				count = count + 1;
				String[] lineparts = readline.split("-", 2);
				if (lineparts.length >= 2) {
					String key = lineparts[0];
					String value = lineparts[1];
					map.put(key, value);
				} else {
					System.out.println("ignoring line number " + count + " The line content is : " + readline);
				}
			}

			for (String key : map.keySet()) {
				System.out.println(key + "\n" + map.get(key).replace(",", "\n"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}

}
