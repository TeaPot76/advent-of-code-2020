package day3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreesInputReaderTest {

    @Test
    public void checkReader1() {
        List<String> treesExample = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        TreesInputReader treesInputReader = new TreesInputReader();
        String path = "day3/trees";
//        System.out.println(treesInputReader.readTreesInput(path));
        TreeCounter treeCounter = new TreeCounter(0, 0);

        List<String> inst = Arrays.asList("Right 1, down 1. 2",
                "Right 3, down 1. 7 (This is the slope you already checked.)",
                "Right 5, down 1. 3",
                "Right 7, down 1. 4",
                "Right 1, down 2. 2");
        int result1 = treeCounter.numberOfTreesNew(treesExample, 1, 1);
        assertEquals(2, result1);
    }
    @Test
    public void checkNumberOfTrees2(){
    List<String> treesExample = Arrays.asList("..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#");

        TreeCounter treeCounter = new TreeCounter(0, 0);
        int result2 = treeCounter.numberOfTreesNew(treesExample, 3, 1);
        assertEquals(7, result2);
    }

        @Test
        public void checkNumberOfTrees3() {
        List<String> treesExample = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        TreeCounter treeCounter = new TreeCounter(0, 0);
        int result3 = treeCounter.numberOfTreesNew(treesExample, 5, 1);
        assertEquals(3, result3);
    }
        @Test
        public void checkNumberOfTrees4(){
        List<String> treesExample = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        TreeCounter treeCounter = new TreeCounter(0, 0);

        int result4 = treeCounter.numberOfTreesNew(treesExample, 7, 1);
        assertEquals(4, result4);
    }
        @Test
        public void checkNumberOfTrees5(){
        List<String> treesExample = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        TreeCounter treeCounter = new TreeCounter(0, 0);
        int result5 = treeCounter.numberOfTreesNew(treesExample, 1, 2);
        assertEquals(2, result5);

        }

    @Test
    public void checkIfCanMoveTobogan1(){
        TreeCounter treeCounter = new TreeCounter(0,0);
        treeCounter.moveTobogan(3,1, 5);
        assertEquals(3, treeCounter.getxCurrentPosition());
        assertEquals(1, treeCounter.getyCurrentPosition());

    }
    @Test
    public void checkIfCanMoveTobogan2(){
        TreeCounter treeCounter = new TreeCounter(1,1);
        treeCounter.moveTobogan(3,1, 5);
        assertEquals(4, treeCounter.getxCurrentPosition());
        assertEquals(2, treeCounter.getyCurrentPosition());

    }
    @Test
    public void checkIfCanMoveTobogan3(){
        TreeCounter treeCounter = new TreeCounter(0,1);
        treeCounter.moveTobogan(3,1, 5);
        assertEquals(3, treeCounter.getxCurrentPosition());
        assertEquals(2, treeCounter.getyCurrentPosition());

    }
    @Test
    public void checkIfCanMoveTobogan4(){
        TreeCounter treeCounter = new TreeCounter(3,0);
        treeCounter.moveTobogan(3,1, 5);
        assertEquals(1, treeCounter.getxCurrentPosition());
        assertEquals(1, treeCounter.getyCurrentPosition());

    }
    @Test
    public void checkNumberOfTrees() {
//        TreeCounter treeCounter = new TreeCounter(0, 0);
        TreesInputReader treesInputReader = new TreesInputReader();
        String path = "day3/trees";
        List<String> treesList = treesInputReader.readTreesInput(path);
//        System.out.println(treesList.get(0).length());
//       treeCounter.moveTobogan(3,1, treesList.get(0).length() );

        TreeCounter treeCounter1 = new TreeCounter(0, 0);
        long result1 = treeCounter1.numberOfTreesNew(treesList, 1, 1);
        System.out.println(result1);

        TreeCounter treeCounter2 = new TreeCounter(0, 0);
        long result2 = treeCounter2.numberOfTreesNew(treesList, 3, 1);
        System.out.println(result2);

        TreeCounter treeCounter3 = new TreeCounter(0, 0);
        long result3 = treeCounter3.numberOfTreesNew(treesList, 5, 1);
        System.out.println(result3);

        TreeCounter treeCounter4 = new TreeCounter(0, 0);
        long result4 = treeCounter4.numberOfTreesNew(treesList, 7, 1);
        System.out.println(result4);

        TreeCounter treeCounter5 = new TreeCounter(0, 0);
        long result5 = treeCounter5.numberOfTreesNew(treesList, 1, 2);
        System.out.println(result5);

        long total = result1 * result2 * result3 * result4 * result5;
        System.out.println(total);

    }


}