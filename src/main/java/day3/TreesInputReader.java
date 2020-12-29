package day3;

import day2.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreesInputReader {

    public List<String> readTreesInput(String pathName) {
        Path path = null;
        try {
            path = Paths.get(TreesInputReader.class.getClassLoader().getResource(pathName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("incorrect path");
        }

            try {
                Stream<String> characterStream = Files.lines(path);
                return characterStream.collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException("file not found");
            }
        }
    }