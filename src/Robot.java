import static java.lang.Thread.sleep;

public class Robot {

    private String name;
    private int age;
    private boolean working = false;
    public Robot(String name, int age) {
       setName(name);
       setAge(age);
    }

    private void setAge(int age) {
        if (age<=30){
            this.age = age;
        }
        else{
            throw new IllegalStateException();
        }

    }
    public int getAge() {
        return age;
    }

    public boolean getWorkStatus() {
        return working;
    }
    public void turnOnRobot(){
        working = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
    public String getWorkingMsg(){
        if(!working){
            throw new IllegalStateException();
        }
        return "I am in working mode";
    }
    public void waitTillWorking() throws InterruptedException{

            sleep(100);

        }

    public void turnoffRobot() {
        working=false;
    }
    public String checkage() {
        if (age <= 20){
            return "Age ok";
        }
        else {
            return "Too old";
        }
    }
    public double checkCost() {
        if (age <= 5) {
            return 10000.00;
        }
        else if (age <= 10) {
            return 7500.00;
        }
        else
            return 5000.00;
    }
    public void sendAgeMsg() throws IllegalArgumentException {
        try {
            if (age > 25) {
        throw new IllegalArgumentException("Age too old");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }

        System.out.println( "Age ok");
    }
}
