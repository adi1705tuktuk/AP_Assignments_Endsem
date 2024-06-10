package org.example;

public class Event {
    private final String eventDate;
    private int eventId;
    private String eventName;
    private String eventDescription;
    private int attractionId;
    private String eventTime;
    private double ticketPrice;

    public Event(String eventDate, int eventId, String eventName, String eventDescription, int attractionId, String eventTime, double ticketPrice) {
        this.eventDate = eventDate;
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.attractionId = attractionId;
        this.eventTime = eventTime;
        this.ticketPrice = ticketPrice;
    }

    public Event(String eventName, String eventDescription, String eventDate) {
        // Initialize the event with the provided values
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public String getEventTime() {
        return eventTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
