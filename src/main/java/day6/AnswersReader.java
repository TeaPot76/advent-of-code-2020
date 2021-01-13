package day6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnswersReader {

    public List<String> readAnswerFile(String fileName) {

        Path path;
        try {
            path = Paths.get(AnswersReader.class.getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("wrong file name");
        }

        Stream<String> answers;
        try {
            answers = Files.lines(path);
            return answers.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("wrong path");
        }
    }

    public List<List<String>> putAnswersIntoGroups(List<String> listOfAnswers) {
        List<List<String>> answers = new ArrayList<>();
        List<String> currentAnswer = new ArrayList<>();

        for (String answer : listOfAnswers) {
            if (answer.equals("")) {
                answers.add(currentAnswer);
                currentAnswer = new ArrayList<>();
            } else {
                currentAnswer.add(answer);
            }
        }
        if (!currentAnswer.isEmpty()) {
            answers.add(currentAnswer);
        }
        return answers;

    }
}
