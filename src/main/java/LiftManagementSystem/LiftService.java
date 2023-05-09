package LiftManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiftService {

    @Autowired
    LiftRepository liftRepository;


    public void addLift(Lift lift) {

        liftRepository.addLift(lift);
    }

    public void addPassenger(Passenger passenger) {

        liftRepository.addPassenger(passenger);
    }

    public void deletePassengersWithIdLessThan5(Integer value) {

        liftRepository.deletePassengersWithIdLessThan5(value);
    }

    public int passengersWithWeightXThatCanTravelInALiftM(Integer weight, Integer liftId) {

        return liftRepository.passengersWithWeightXThatCanTravelInALiftM(weight, liftId);
    }

    public int passengersWithWeightMore50InALiftM(Integer liftId) {

        return liftRepository.passengersWithWeightMore50InALiftM(liftId);
    }
}
