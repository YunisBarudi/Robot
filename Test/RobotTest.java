import org.junit.jupiter.api.*;

import java.time.Duration;
import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RobotTest {

    Robot buddy ;
    @BeforeAll public void setup() {
        buddy = new Robot("bodybuilder",10);
        System.out.println("in setup");
    }

 @BeforeEach public void before() {
        buddy.turnoffRobot();
        System.out.println("in before");
    }



    @Test
    public void test_getName(){

        assertEquals("bodybuilder",buddy.getName());

    }
    @Test
    public void test_getWorkStatus_isNotWorking(){
        assertFalse(buddy.getWorkStatus());
    }
    @Test
    public void test_getWorkStatus_isWorking(){
        buddy.turnOnRobot();
        assertTrue(buddy.getWorkStatus());
    }
    @Test
    public void test_geWorkingMsg(){
        buddy.turnOnRobot();
        assertEquals("I am in working mode",buddy.getWorkingMsg());
    }



    @Disabled ("Timeout is disabled")
    @Test
    @DisplayName("getWorkingMsgFail catch the exception")
    public void test_getWorkingMsgFail(){
       assertThrows(IllegalStateException.class,() ->{
           buddy.getWorkingMsg();
       });
    }
    @Test()
    public void testName_Fail(){
        assertThrows(IllegalArgumentException.class, () ->{
            Robot chuck = new Robot("",21);
        });
    }
    @Test
    @DisplayName("Sleep Test")
    void timeoutExceeded(){
        assertTimeout(ofMillis(150),() ->{
            buddy.waitTillWorking();
        });
    }





}