package day1;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InputReaderTest {

    @Test
    public void test1(){
        List<Integer> integers = InputReader.inputFileToAList();
        System.out.println(integers);
    }

}