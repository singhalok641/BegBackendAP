package parkinglot.services;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.factories.SpotAssignmentStrategyFactory;
import parkinglot.models.*;
import parkinglot.models.enums.VehicleType;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.ParkingLotRepository;
import parkinglot.repositories.TicketRepository;
import parkinglot.repositories.VehicleRepository;
import parkinglot.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(
            GateRepository gateRepository,
            VehicleRepository vehicleRepository,
            ParkingLotRepository parkingLotRepository,
            TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(
            String vehicleNumber,
            Long gateId,
            String ownerName,
            VehicleType vehicleType) throws GateNotFoundException {

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        Optional<Gate> optionalGate = gateRepository.findById(gateId);

        if (optionalGate.isEmpty()) {
            throw new GateNotFoundException("Please enter a valid gate number");
        }
        Gate gate = optionalGate.get();;
        ticket.setGate(gate);

        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle newVehicle = null;
        if(vehicleOptional.isEmpty()) {
            // Create a new Vehicle
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            newVehicle = vehicleRepository.save(vehicle);
        }
        else {
            newVehicle = vehicleOptional.get();
        }

        ticket.setVehicle(newVehicle);
        ticket.setNumber("ticket-number");

        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findParkingLotByGateId(gateId);

        if (optionalParkingLot.isEmpty()) {
            // throw exception
        }

        ParkingLot parkingLot = optionalParkingLot.get();

        SpotAssignmentStrategy spotAssignmentStrategy =
                SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(
                        parkingLot.getSpotAssignmentStrategyType()
                );

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        ticket.setParkingSpot(parkingSpot);

        return ticketRepository.save(ticket);
    }
}
