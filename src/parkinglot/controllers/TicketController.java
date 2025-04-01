package parkinglot.controllers;

import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.dtos.IssueTicketResponseDto;
import parkinglot.dtos.ResponseStatus;
import parkinglot.models.Ticket;
import parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(
            IssueTicketRequestDto issueTicketRequestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        try{
            Ticket ticket = ticketService.issueTicket(
                    issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getOwnerName(),
                    issueTicketRequestDto.getVehicleType()
            );

            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            issueTicketResponseDto.setTicket(ticket);
        }
        catch (Exception e) {
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return issueTicketResponseDto;
    }
}
