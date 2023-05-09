package LiftManagementSystem;

public class Passenger {

    private int passengerId;
    private int liftId;
    private int weight;

    public Passenger(int passengerId, int liftId, int weight) {
        this.passengerId = passengerId;
        this.liftId = liftId;
        this.weight = weight;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
