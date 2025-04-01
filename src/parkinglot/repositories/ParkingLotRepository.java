package parkinglot.repositories;

import parkinglot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap;

    public Optional<ParkingLot> findParkingLotByGateId(Long gateId) {
        return null;
    }
}
