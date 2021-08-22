import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reader.FindPathInputReaderFile;

public class Tests {
    private final FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile();

    @Test
    void noPathFileTestMaze1() {
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
        Exception exception = Assertions.assertThrows(Exception.class, () -> findPathInputReaderFile
                .readFile("./src/main/resources/multipleEndsMaze.txt"));

        String expectedMessage = "Only one end point is allowed";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void multipleStartsFileTestMaze3() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> findPathInputReaderFile
                .readFile("./src/main/resources/multipleStartsMaze.txt"));

        String expectedMessage = "Only one start point is allowed";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void noStartTestMaze4() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> findPathInputReaderFile
                .readFile("./src/main/resources/noStartMaze.txt"));

        String expectedMessage = "Couldnt find start or end point";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void badDimensionsFileTestMaze6() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> findPathInputReaderFile
                .readFile("./src/main/resources/badDimensionsMaze.txt"));

        String expectedMessage = "Bad dimensions";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void directionsFileTestMaze5() throws Exception {
        findPathInputReaderFile.readFile("./src/main/resources/validMaze.txt");
        String actualDirections = findPathInputReaderFile.findShortestPath();
        String expectedDirections = "rrrddl";
        System.out.println("Actual directions were: " + actualDirections);
        System.out.println("Expected directions were: " + expectedDirections);

        Assertions.assertEquals(expectedDirections, actualDirections);
    }

    @Test
    void badCharacterFileTest() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> findPathInputReaderFile
                .readFile("./src/main/resources/badCharacterMaze.txt"));

        String expectedMessage = "Bad input. Allowed 'SX.#'";
        String actualMessage = exception.getMessage();
        System.out.println("Actual message was: " + actualMessage);
        System.out.println("Expected message was: " + expectedMessage);

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
