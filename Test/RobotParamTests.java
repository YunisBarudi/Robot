import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RobotParamTests {
    private String expected;
    private int age;
    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestFile.csv", numLinesToSkip = 1)
    void testcheckageAll(int age, String expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkage() );
    }
    @ParameterizedTest
    @CsvFileSource (resources = "ParamTestCostFile.csv", numLinesToSkip = 1)
    void testCostRobot (int age, double cost){
        Robot buddy = new Robot("buddy", age);
        assertEquals(cost, buddy.checkCost() );
    }


}