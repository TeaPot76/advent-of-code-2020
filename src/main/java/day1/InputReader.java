package day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

    public static List<Integer> inputFileToAList(){


        Path path = null;
        try {
            path = Paths.get(InputReader.class.getClassLoader()
                            .getResource("day1/input").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("invalid path format");
        }

        try {
            return Files.lines(path).map(Integer::valueOf).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("file not found");
        }

//        List<Integer> numbersFromInput = new ArrayList<>();
//        Stream<String> lines = Files.lines(path);
//
//        numbersFromInput = lines.map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.valueOf(s);
//            }
//        }).collect(Collectors.toList());
//
//        return numbersFromInput;
    }



}
