package day7;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BagRulesTest {
    String inputBag1;
    String inputBag2;
    String inputBag3;
    String inputBag4;
    String inputBag5;
    String inputBag6;
    String inputBag7;
    String inputBag8;
    String inputBag9;

    List<String> bagsExample;
    BagRules bagRules = new BagRules();


    Map<String, Integer> rule1Bag1 = new HashMap<>();
    Map<String, Integer> rule2Bag1 = new HashMap<>();
    Map<String, Integer> rule1Bag2 = new HashMap<>();
    Map<String, Integer> rule2Bag2 = new HashMap<>();
    Map<String, Integer> rule1Bag3 = new HashMap<>();
    Map<String, Integer> rule1Bag4 = new HashMap<>();
    Map<String, Integer> rule2Bag4 = new HashMap<>();
    Map<String, Integer> rule1Bag5 = new HashMap<>();
    Map<String, Integer> rule2Bag5 = new HashMap<>();
    Map<String, Integer> rule1Bag6 = new HashMap<>();
    Map<String, Integer> rule2Bag6 = new HashMap<>();
    Map<String, Integer> rule1Bag7 = new HashMap<>();
    Map<String, Integer> rule2Bag7 = new HashMap<>();
    Map<String, Integer> rule1Bag8 = new HashMap<>();
    Map<String, Integer> rule1Bag9 = new HashMap<>();

    List<Map<String, Integer>> rulesBag1 = new ArrayList<>();
    List<Map<String, Integer>> rulesBag2 = new ArrayList<>();
    List<Map<String, Integer>> rulesBag3 = new ArrayList<>();
    List<Map<String, Integer>> rulesBag4 = new ArrayList<>();
    List<Map<String, Integer>> rulesBag5 = new ArrayList<>();
    List<Map<String, Integer>> rulesBag6 = new ArrayList<>();
    List<Map<String, Integer>> rulesBag7 = new ArrayList<>();
    List<Map<String, Integer>> rulesBag8 = new ArrayList<>();
    List<Map<String, Integer>> rulesBag9 = new ArrayList<>();
    Map<String, List<Map<String, Integer>>> bag1 = new HashMap<>();
    Map<String, List<Map<String, Integer>>> bag2 = new HashMap<>();
    Map<String, List<Map<String, Integer>>> bag3 = new HashMap<>();
    Map<String, List<Map<String, Integer>>> bag4 = new HashMap<>();
    Map<String, List<Map<String, Integer>>> bag5 = new HashMap<>();
    Map<String, List<Map<String, Integer>>> bag6 = new HashMap<>();
    Map<String, List<Map<String, Integer>>> bag7 = new HashMap<>();
    Map<String, List<Map<String, Integer>>> bag8 = new HashMap<>();
    Map<String, List<Map<String, Integer>>> bag9 = new HashMap<>();

    List<Map<String, List<Map<String, Integer>>>> bagsListWithRules = new ArrayList<>();

    @Before
    public void setUp() {
        bagsExample = Arrays.asList(
                "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags.");

        inputBag1 = "light red bags contain 1 bright white bag, 2 muted yellow bags.";
        inputBag2 = "dark orange bags contain 3 bright white bags, 4 muted yellow bags.";
        inputBag3 = "bright white bags contain 1 shiny gold bag.";
        inputBag4 = "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.";
        inputBag5 = "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.";
        inputBag6 = "dark olive bags contain 3 faded blue bags, 4 dotted black bags.";
        inputBag7 = "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.";
        inputBag8 = "faded blue bags contain no other bags.";
        inputBag9 = "dotted black bags contain no other bags.";

        rule1Bag1.put("bright white", 1);
        rule2Bag1.put("muted yellow", 2);
        rule1Bag2.put("bright white", 3);
        rule2Bag2.put("muted yellow", 4);
        rule1Bag3.put("shiny gold", 1);
        rule1Bag4.put("shiny gold", 2);
        rule2Bag4.put("faded blue", 9);
        rule1Bag5.put("dark olive", 1);
        rule2Bag5.put("vibrant plum", 2);
        rule1Bag6.put("faded blue", 3);
        ;
        rule2Bag6.put("dotted black", 4);
        rule1Bag7.put("faded blue", 5);
        rule2Bag7.put("dotted black", 6);

        rulesBag1.add(rule1Bag1);
        rulesBag1.add(rule2Bag1);

        rulesBag2.add(rule1Bag2);
        rulesBag2.add(rule2Bag2);

        rulesBag3.add(rule1Bag3);

        rulesBag4.add(rule1Bag4);
        rulesBag4.add(rule2Bag4);

        rulesBag5.add(rule1Bag5);
        rulesBag5.add(rule2Bag5);

        rulesBag6.add(rule1Bag6);
        rulesBag6.add(rule2Bag6);

        rulesBag7.add(rule1Bag7);
        rulesBag7.add(rule2Bag7);

        rulesBag8.add(rule1Bag8);

        rulesBag9.add(rule1Bag9);

        bag1.put("light red", rulesBag1);
        bag2.put("dark orange", rulesBag2);
        bag3.put("bright white", rulesBag3);
        bag4.put("muted yellow", rulesBag4);
        bag5.put("shiny gold", rulesBag5);
        bag6.put("dark olive", rulesBag6);
        bag7.put("vibrant plum", rulesBag7);
        bag8.put("faded blue", rulesBag8);
        bag9.put("dotted black", rulesBag9);

        bagsListWithRules.add(bag1);
        bagsListWithRules.add(bag2);
        bagsListWithRules.add(bag3);
        bagsListWithRules.add(bag4);
        bagsListWithRules.add(bag5);
        bagsListWithRules.add(bag6);
        bagsListWithRules.add(bag7);
        bagsListWithRules.add(bag8);
        bagsListWithRules.add(bag9);

    }


    @Test
    public void checkBagRules() {
        bagRules = new BagRules();
        System.out.println(bagRules.oneBagRules(inputBag1));

        assertEquals(bag1, bagRules.oneBagRules(inputBag1));
        assertEquals(bag2, bagRules.oneBagRules(inputBag2));
        assertEquals(bag3, bagRules.oneBagRules(inputBag3));
        assertEquals(bag4, bagRules.oneBagRules(inputBag4));
        assertEquals(bag5, bagRules.oneBagRules(inputBag5));
        assertEquals(bag6, bagRules.oneBagRules(inputBag6));
        assertEquals(bag7, bagRules.oneBagRules(inputBag7));
        assertEquals(bag8, bagRules.oneBagRules(inputBag8));
        assertEquals(bag9, bagRules.oneBagRules(inputBag9));
    }

    @Test
    public void checkIfConvertingBagsInputIntoBagsRules() {
        bagRules = new BagRules();
        assertEquals(bagsListWithRules, bagRules.bagListWithMappedRules(bagsExample));
        System.out.println(bagsListWithRules);
        System.out.println(bagRules.bagListWithMappedRules(bagsExample));
    }

    @Test
    public void checkHowManyColorsCanHoldShinyGold(){
        bagRules = new BagRules();
        assertEquals(4, bagRules.numberOfColorsCanHoldShinyBag(bagRules.bagListWithMappedRules(bagsExample)));
    }

}