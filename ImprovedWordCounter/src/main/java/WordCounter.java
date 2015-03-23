import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class WordCounter {
	public static void main(String[] args) {

		HashMap<String, Integer> words = new HashMap<String, Integer>();

		try {
			FileReader file = new FileReader("./src/main/resources/Source.txt");
			BufferedReader buff = new BufferedReader(file);

			boolean eof = false;

			while (!eof) {
				String line = buff.readLine();

				if (line == null) {
					eof = true;
				} else {
					for (String str : line.split("\\s+")) {
						String token = str.toLowerCase();
						if (words.containsKey(token)) {
							words.put(token, words.get(token) + 1);
						} else {
							words.put(token, 1);
						}
					}
				}
			}
			buff.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error — " + e.toString());
		} catch (IOException e) {
			System.out.println("Error — " + e.toString());
		}

		for (HashMap.Entry<String, Integer> entry : words.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
