import day2.FileReader;
import org.junit.Test;

public class FileReaderTest {

    @Test
    public void checkIfReaderWorks(){
        String path = "day2/passwords";
        System.out.println(FileReader.readAdventFiles(path));
    }


}