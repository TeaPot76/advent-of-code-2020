package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassportReader {

    public List<String> readPassportsInput(String pathName) {
        Path path = null;
        try {
            path = Paths.get(PassportReader.class.getClassLoader().getResource(pathName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("incorrect path");
        }

        try {
            Stream<String> passportsStream = Files.lines(path);
            return passportsStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("file not found");
        }

    }


    public List<Map<String, String>> convertToPassports(List<String> passportDetails) {
        List<Map<String, String>> passports = new ArrayList<>();
        Map<String, String> passport = new HashMap<>();
        for (String singlePassportDetail : passportDetails) {
            if (!singlePassportDetail.equals("")) {
                String[] singlePassportValues = singlePassportDetail.split(" ");
                for (String singlePassportValue : singlePassportValues) {
                    String[] partsOfPassport = singlePassportValue.split(":");
                    passport.put(partsOfPassport[0], partsOfPassport[1]);
                }
            } else {
                passports.add(passport);
                passport = new HashMap<>();
            }
        }
        if (!passport.isEmpty()){
            passports.add(passport);
        }

        return passports;
    }


    public static void readToMapPassportInput(String pathToPassports) throws IOException {
        String filePath = pathToPassports;


        Map<String, String> map = new HashMap<>();


        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        reader.close();
    }

}
