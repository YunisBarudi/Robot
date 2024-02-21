import org.junit.jupiter.api.Test;

import java.lang.reflect.Field; import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotPrivateTest {

@Test public void testageMember() throws Exception {

    System.out.println("testageMember");

    Robot target = new Robot("robbie", 5);

    Class secretClass = target.getClass();

    Field f = secretClass.getDeclaredField("age");

     f.setAccessible(true);

     System.out.println("The value in f (age) is " + f.get(target));

    int result = f.getInt(target);

     assertEquals( 5, result);
}


    @Test
    public void testsetAgeMethod() throws Exception {

    System.out.println("setAgeMethod");

    Robot target = new Robot("robbie", 3);

    Method method = Robot.class.getDeclaredMethod("setAge", int.class);

    method.setAccessible(true);

    method.invoke(target, 7);

    Class secretClass = target.getClass();

    Field f = secretClass.getDeclaredField("age");

    f.setAccessible(true);

    int result = f.getInt(target);

    System.out.println("The value in f (age) is " + f.get(target));

    assertEquals( 7, result);

    }

}