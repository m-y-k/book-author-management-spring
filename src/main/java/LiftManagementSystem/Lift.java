package LiftManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Lift {

    private int liftNo;
    private int capacityInWeight;
    private int capacityInPerson;
    List<Passenger> passengerList;

    public Lift(int liftNo, int capacityInWeight, int capacityInPerson) {
        this.liftNo = liftNo;
        this.capacityInWeight = capacityInWeight;
        this.capacityInPerson = capacityInPerson;
        this.passengerList = new ArrayList<>();
    }

    public int getLiftNo() {
        return liftNo;
    }

    public void setLiftNo(int liftNo) {
        this.liftNo = liftNo;
    }

    public int getCapacityInWeight() {
        return capacityInWeight;
    }

    public void setCapacityInWeight(int capacityInWeight) {
        this.capacityInWeight = capacityInWeight;
    }

    public int getCapacityInPerson() {
        return capacityInPerson;
    }

    public void setCapacityInPerson(int capacityInPerson) {
        this.capacityInPerson = capacityInPerson;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
