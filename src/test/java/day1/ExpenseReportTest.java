package day1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExpenseReportTest {

    @Test
    public void resultDay1Test1(){
        ExpenseReport expenseReport = new ExpenseReport();
        System.out.println(expenseReport.resultDay1(InputReader.inputFileToAList()));
    }
    @Test
    public void resultDay1Test2(){
        ExpenseReport expenseReport = new ExpenseReport();
        List<Integer> exampleNumbers = Arrays.asList(1721,
                979,
                366,
                299,
                675,
                1456);
        Integer result = expenseReport.resultDay1(exampleNumbers);
        System.out.println(result);
        assertEquals(Integer.valueOf(514579), result);
    }

}