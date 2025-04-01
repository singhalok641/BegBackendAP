package parkinglot.strategies.spotAssignmentStrategy;

import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.enums.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
