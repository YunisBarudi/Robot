public class Owner {

    private String name;

    private double maintenance_payments = 100.00;

    public Owner (String name ){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getMonthlyPayments(){
        return maintenance_payments;
    }
}
