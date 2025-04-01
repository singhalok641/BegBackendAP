package parkinglot.strategies.spotAssignmentStrategy;

import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.enums.VehicleType;

public class CheaptestSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        return null;
    }
}
