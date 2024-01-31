import static java.lang.Thread.sleep;

public class Robot {
    private String name;
    private boolean working = false;
    public Robot(String name) {
       setName(name);
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

}
