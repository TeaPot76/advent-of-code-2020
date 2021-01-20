package day7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BagRulesInputReader {

    public List<String> readBagRulesInput(String fileName){
        Path path;
        try {
            path = Paths.get(BagRulesInputReader.class.getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("wrong file name");
        }
        Stream<String> bagRules;
        try {
            bagRules = Files.lines(path);
            return bagRules.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("wrong path");
        }
    }
}
