package day7;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BagRules {

    public int numberOfColorsCanHoldShinyBag(List<Map<String, List<Map<String, Integer>>>> bagsWithMappedRules) {
        int counter = 0;
        Set<String> newBagColorToCheck;
       List<Map<String, List<Map<String, Integer>>>> bagsToCheck = new ArrayList<>();
        for (Map<String, List<Map<String, Integer>>> bag : bagsWithMappedRules) {
            for ( List<Map<String, Integer>> rules : bag.values()) {
                for ( Map<String, Integer> oneRule : rules) {
                    if (oneRule.containsKey("shiny gold")) {
                        counter++;
                        bagsToCheck.add(bag);
                    }
                }
            }
        }

        return counter;

    }

    public List<Map<String, List<Map<String, Integer>>>> bagListWithMappedRules(List<String> inputRules) {
        List<Map<String, List<Map<String, Integer>>>> bagsWithMappedRules = new ArrayList<>();
        for (String rule : inputRules) {
            bagsWithMappedRules.add(oneBagRules(rule));
        }
        return bagsWithMappedRules;
    }

    //    light red bags contain 1 bright white bag, 2 muted yellow bags.
    public Map<String, List<Map<String, Integer>>> oneBagRules(String oneBagRules) {
        List<Map<String, Integer>> rulesForOneBag = new ArrayList<>();
        Map<String, List<Map<String, Integer>>> bagRules = new HashMap<>();

        String[] split = oneBagRules.split(" bags contain");
        String bagColour = split[0];
        rulesForOneBag = orderRulesForEachBag(split[1]);
        bagRules.put(bagColour, rulesForOneBag);

        return bagRules;
    }

    //    1 bright white bag, 2 muted yellow bags.
    private List<Map<String, Integer>> orderRulesForEachBag(String rules) {
        List<Map<String, Integer>> bagRulesList = new ArrayList<>();
        Map<String, Integer> rule = new HashMap<>();
        String[] parts = rules.split(",");
        for (String part : parts) {
            rule = mapRules(part);
            bagRulesList.add(rule);
        }
        return bagRulesList;

    }

    private Map<String, Integer> mapRules(String rules) {
        Map<String, Integer> bagRules = new HashMap<>();
        Pattern p = Pattern.compile("^.*([1-9]+) ([a-zA-Z ]+) bag.*$");
        Matcher m = p.matcher(rules);
        if (m.find()) {
            String key = m.replaceAll("$2");
            Integer value = Integer.valueOf(m.replaceAll("$1"));
            bagRules.put(key, value);
        } else {
            System.out.println("no rules");
        }
        return bagRules;
    }


}
