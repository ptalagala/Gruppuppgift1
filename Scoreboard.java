import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.*;

public class Scoreboard {

    public static void saveToFile(String name, int score) throws IOException {
        Path file = Path.of("scoreboard.txt");
        int game = 0;

        try (BufferedWriter writer = Files.newBufferedWriter(file, CREATE, APPEND)) {
            game++;
            writer.append("Game " + game + " ").append(name).append(" " + score).append("\n");
        }
    }

}
