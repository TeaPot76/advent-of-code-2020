package day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public static List<String> readAdventFiles(String pathName){
        Path path = null;
        try {
            path = Paths.get(FileReader.class.getClassLoader().getResource(pathName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("wrong path");
        }

        try {
            Stream<String> lines = Files.lines(path);
            return lines.collect(Collectors.toList());

        } catch (IOException e) {
           throw new RuntimeException("file not found");
        }
    }
}
