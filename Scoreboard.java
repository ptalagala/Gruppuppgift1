import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;

public class Scoreboard {

    public static void saveToFile(String name, int score) throws IOException {
        Path file = Path.of("scoreboard.txt");
        File filetemp = new File("scoreboard.txt");
        int game = 0;

        if (filetemp.exists()){
            Scanner scanner = new Scanner(filetemp);
            while (scanner.hasNextInt()) {
                String line = scanner.nextLine();

                if (line.startsWith("Game ")){
                    game++;
                }                
            }
            scanner.close();
        } 

        try (BufferedWriter writer = Files.newBufferedWriter(file, CREATE, APPEND)) {
            game++;
            writer.append("Game " + game + " ").append(name).append(" " + score).append("\n");
        }
    }

}
