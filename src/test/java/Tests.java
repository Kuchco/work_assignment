import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    void noPathFileTestMaze1() {
        FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            findPathInputReaderFile.readFile("./src/main/resources/noPathMaze.txt");
            findPathInputReaderFile.findShortestPath();
        });

        String expectedMessage = "Couldnt find a path";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void multipleEndsFileTestMaze2() {
        FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            findPathInputReaderFile.readFile("./src/main/resources/multipleEndsMaze.txt");
        });

        String expectedMessage = "Only one end point is allowed";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void multipleStartsFileTestMaze3() {
        FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            findPathInputReaderFile.readFile("./src/main/resources/multipleStartsMaze.txt");
        });

        String expectedMessage = "Only one start point is allowed";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void noStartTestMaze4() {
        FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            findPathInputReaderFile.readFile("./src/main/resources/noStartMaze.txt");
        });

        String expectedMessage = "Couldnt find start or end point";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void badDimensionsFileTestMaze6(){
        FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            findPathInputReaderFile.readFile("./src/main/resources/badDimensionsMaze.txt");
        });

        String expectedMessage = "Bad dimensions";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void directionsFileTestMaze5() throws Exception {
        FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();

        findPathInputReaderFile.readFile("./src/main/resources/validMaze.txt");
        String actualDirections =  findPathInputReaderFile.findShortestPath();
        String expectedDirections = "rrrddl";
        System.out.println("Actual directions were: " + actualDirections);
        System.out.println("Expected directions were: " + expectedDirections);

        Assertions.assertEquals(expectedDirections, actualDirections);
    }

}
