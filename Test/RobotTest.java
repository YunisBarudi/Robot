import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Robot buddy = new Robot("bodybuilder" );


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
            Robot chuck = new Robot("");
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