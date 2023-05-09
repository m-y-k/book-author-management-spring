package LiftManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LiftController {

    @Autowired
    LiftService liftService;


    // all APIs will be written below

    // API 1 -> add lift
    @PostMapping("/add-lift")
    public void addLift(@RequestBody Lift lift) {

        liftService.addLift(lift);
    }

    // API 2 -> add a passenger
    @PostMapping("/add-passenger")
    public void addPassenger(@RequestBody Passenger passenger) {

        liftService.addPassenger(passenger);
    }

    // API 3 -> delete all passengers with id < 5
    @DeleteMapping("/delete-passenger-id-less-than/{value}")
    public void deletePassengersWithIdLessThan5(@PathVariable("value") Integer value) {

        liftService.deletePassengersWithIdLessThan5(value);
    }

    // API 4 -> max no of people with weight x that can travel in a given lift M
    @GetMapping("/passengers-with-weight")
    public int passengersWithWeightXThatCanTravelInALiftM(@RequestParam("weight") Integer weight,
                                                          @RequestParam("liftId") Integer liftId) {

        return liftService.passengersWithWeightXThatCanTravelInALiftM(weight, liftId);
    }

    // API 5 -> no of people with weight greater than 50 in a given lift M
    @GetMapping("/passengers-with-wieght-more")
    public int passengersWithWeightMore50InALiftM(@RequestParam("liftId") Integer liftId) {

        return liftService.passengersWithWeightMore50InALiftM(liftId);
    }

}
