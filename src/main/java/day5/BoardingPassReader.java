package day5;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BoardingPassReader {

    public List<String> readBoardingPassesFromFile(String fileName) {
        Path path = null;

        try {
            path = Paths.get(BoardingPassReader.class.getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("incorrect path");
        }

        Stream<String> allBoardingPasses = null;
        try {
            allBoardingPasses = Files.lines(path);
            return allBoardingPasses.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("could not read file");
        }
    }

}
