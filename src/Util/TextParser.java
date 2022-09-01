package Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TextParser {
    public static List<String> parseTextFile(File textFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(textFile);
        List<String> result = new ArrayList<>();

        while (scanner.hasNextLine()) {
            result.add(scanner.nextLine());
        }

        return result;
    }

    public static List<String> breakLineBySeparatorCharacter(String line, String separatorCharacter) {
        List<String> result = List.of(line.split(separatorCharacter));

        return result;
    }
}
