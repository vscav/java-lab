package fr.umlv.shopping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class SaverLoader {
	static final String SEPARATOR = "#";
	static final String BOOK_TYPE = "B";
	static final String VIDEO_GAME_TYPE = "G";
	static final String PREPAID_TYPE = "P";

	public static void saveInTextFormat(List<DigitalItem> items, BufferedWriter stream) throws IOException {
		for (DigitalItem item : items) {
			stream.write((item).toTextFormat());
			stream.newLine();
		}
	}

	public static List<DigitalItem> loadFromTextFormat(BufferedReader stream) throws IOException {
		List<DigitalItem> items = new ArrayList<DigitalItem>();
		String line = null;
		while ((line = stream.readLine()) != null) {
			String[] strings = line.split(SEPARATOR);
			switch (strings[0]) {
			case "B":
				items.add(new Book(strings[3], strings[2], Integer.parseInt(strings[1])));
				break;
			case "G":
				items.add(
						new VideoGame(strings[2], VideoGame.Console.valueOf(strings[3]), Integer.parseInt(strings[1])));
				break;
			case "P":
				items.add(new PrePaid(Integer.parseInt(strings[1]), Integer.parseInt(strings[2])));
				break;
			default:
				break;
			}
		}
		return items;
	}

	public static void main(String[] args) {
		var sdb = new Book("S. de Beauvoir", "Mémoires d'une jeune fille rangée", 990);
		// System.out.println(sdb.toTextFormat());
		// B#990#Mémoires d'une jeune fille rangée#S. de Beauvoir
		var zelda = new VideoGame("The legend of Zelda", VideoGame.Console.WII, 4950);
		// System.out.println(zelda.toTextFormat());
		// G#4950#The legend of Zelda#WII
		var pp100 = new PrePaid(10000, 10);
		// System.out.println(pp100.toTextFormat());
		// P#10000#10

		var list = List.of(sdb, zelda, pp100);

		Path saveFilePath = Paths.get("savedFile.txt");

		try (var writer = Files.newBufferedWriter(saveFilePath, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
			SaverLoader.saveInTextFormat(list, writer);
		} catch (IOException e) {
			System.out.println(e);
		}

		Path filePathToLoad = Paths.get("testFile.txt");

		try (var reader = Files.newBufferedReader(filePathToLoad, StandardCharsets.UTF_8)) {
			List<DigitalItem> items = SaverLoader.loadFromTextFormat(reader);
			for (DigitalItem item : items) {
				System.out.println(item);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}