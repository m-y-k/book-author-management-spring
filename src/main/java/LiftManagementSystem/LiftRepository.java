package LiftManagementSystem;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class LiftRepository {

    // liftNo, Lift hashmap
    HashMap<Integer, Lift> liftHashMap = new HashMap<>();

    // passengerId, Passenger hashmap
    HashMap<Integer, Passenger> passengerHashMap = new HashMap<>();


    public void addLift(Lift lift) {

        // add lift with liftId as key in liftHashmap
        int key = lift.getLiftNo();

        liftHashMap.put(key, lift);
    }

    public void addPassenger(Passenger passenger) {

        // add a passenger to the passsenger map
        int key = passenger.getPassengerId();

        // because Passener object contains liftId
        // so we have to update/add our passenger in list of passengers in that lift also

        // getting lift object form lift map
        Lift lift = liftHashMap.get(passenger.getLiftId());

        // getting list of passengers here
        List<Passenger> passengerList = lift.getPassengerList();
        passengerList.add(passenger);

        // now put this passenger in passengerHashMap
        passengerHashMap.put(key, passenger);
    }

    public void deletePassengersWithIdLessThan5(Integer value) {

        // delete all passengers having id < value

        // 1. get all passenger, filter and
            // 1. delete them from passengerHashMap
            // 2. also from list of passengers in lift object

        for (int key : passengerHashMap.keySet()) {

            // we will get passenger object
            Passenger passenger = passengerHashMap.get(key);

            if (passenger.getPassengerId() < value) {
                // delete it from hashmap
                passengerHashMap.remove(key);

                // delete from lift too
                Lift lift = liftHashMap.get(passenger.getLiftId());
                List<Passenger> passengerList = lift.getPassengerList();
                passengerList.remove(passenger);
            }

        }

    }

    public int passengersWithWeightXThatCanTravelInALiftM(Integer weight, Integer liftId) {

        // 1. get lift by liftId
        // 2. get list of passengers in that list
        // 3. filter according to weight given

        Lift lift = liftHashMap.get(liftId);

        List<Passenger> passengerList = lift.getPassengerList();

        int passengersWithWeightLessThanX = 0;
        for (Passenger passenger : passengerList) {
            // check if passenger's weight is < X
            if (passenger.getWeight() < weight) { // depends upon weight exactly = X or less than X, if = x, change < sign to = in code
                passengersWithWeightLessThanX++;
            }
        }

        return passengersWithWeightLessThanX;
    }

    public int passengersWithWeightMore50InALiftM(Integer liftId) {

        // 1. get lift by liftId
        // 2. get list of passengers in that list
        // 3. filter according to weight given

        Lift lift = liftHashMap.get(liftId);

        List<Passenger> passengerList = lift.getPassengerList();

        int passengersWithWeightMoreThan50 = 0;
        for (Passenger passenger : passengerList) {
            // check if passenger's weight is < X
            if (passenger.getWeight() > 50) {
                passengersWithWeightMoreThan50++;
            }
        }

        return passengersWithWeightMoreThan50;
    }
}
