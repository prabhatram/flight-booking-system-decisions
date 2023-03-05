package prog2.exercise4.flight.booking.system;

//import java.sql.Date;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
//import java.time.LocalDateTime;
//import java.time.Period;
//import java.time.format.DateTimeFormatter;

import javax.management.Descriptor;
import javax.xml.transform.Source;

public class FlightBooking {
    private String flightID;
    private String passengerFullName;
    private String passengerAddress;

    enum TripType{
        ONE_WAY, RETURN;
    }
    
    enum BookingClass{
        FIRST, BUSINESS, ECONOMY;
    }

    enum TripSource{
        NANJING, BEIJING, OULU, HELSINKI;
    }

    enum TripDestination{
        NANJING, BEIJING, OULU, HELSINKI;
    }
    
    enum SourceAirport{
        NANJING_LUKOU_INTERNATIONAL_AIRPORT, BEIJING_CAPITAL_INTERNATOINAL_AIRPORT, OULU_AIRPORT, HELSINKI_AIRPORT;
    }

    enum DestinationAirport{
        NANJING_LUKOU_INTERNATIONAL_AIRPORT, BEIJING_CAPITAL_INTERNATOINAL_AIRPORT, OULU_AIRPORT, HELSINKI_AIRPORT;
    }

    public static final String FLIGHT_COMPANY = "Flights-Of-Fancy";
    
    private TripType tripType;
    private BookingClass bookingClass;
    private TripSource tripSource;
    private TripDestination tripDestination;
    private SourceAirport sourceAirport;
    private DestinationAirport destinationAirport;

    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;

    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;

    private String ticketNumber;

    
    public FlightBooking(String fullName, LocalDate departureDate, LocalDate returnDate, int children, int adults) {
        passengerFullName = fullName;
        //passengerAddress = address;
        //this.tripType = tripType;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        childPassengers = children;
        adultPassengers = adults;
    }

    
    public void setTripSource(String source){
        switch(source){
            case "1":
            tripSource = TripSource.NANJING;
            break;
            case "2":
            tripSource = TripSource.BEIJING;
            break;
            case "3":
            tripSource = TripSource.OULU;
            break;
            case "4":
            tripSource = TripSource.HELSINKI;
            break;
            default:
            System.out.println("No trip source entered");
        }
    }

    public TripSource gTripSource(){
        return tripSource;
    }

    public void setTripType(String type){
        switch(type){
            case "1":
            tripType = TripType.ONE_WAY;
            break;
            case "2":
            tripType = TripType.RETURN;;
            break;
            default:
            System.out.println("Trip type is missing");
        }
    }

    public TripType getTripType(){
        return this.tripType;
    }

    public void setSourceAirport(String source){
        switch(source){
            case "1":
            sourceAirport = SourceAirport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
            break;
            case "2":
            sourceAirport = SourceAirport.BEIJING_CAPITAL_INTERNATOINAL_AIRPORT;
            break;
            case "3":
            sourceAirport = SourceAirport.OULU_AIRPORT;
            break;
            case "4":
            sourceAirport = SourceAirport.HELSINKI_AIRPORT;
            break;
            default:
            System.out.println("No source airport could be selected");
        }
    }

    public SourceAirport getSourceAirport(){
        return sourceAirport;
    }

    public void setTripDestination(String source, String destination){
        
        if(source.equals(destination)){
            System.out.println("Source and destination cannot be same");
        }
        else {
            switch(destination){
                case "1":
                tripDestination = TripDestination.NANJING;
                break;
                case "2":
                tripDestination = TripDestination.BEIJING;
                break;
                case "3":
                tripDestination = TripDestination.OULU;
                break;
                case "4":
                tripDestination = TripDestination.HELSINKI;
                break;
                default:
                System.out.println("No trip destination entered");
            }
        }
    }   
    
    public void setDestinationAirport(String source, String destination){
        
        if(source.equals(destination)){
            System.out.println("Both the trip source and trip destination cannot be the same location");
        }
        else {
            switch(destination){
                case "1":
                destinationAirport = DestinationAirport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
                break;
                case "2":
                destinationAirport = DestinationAirport.BEIJING_CAPITAL_INTERNATOINAL_AIRPORT;
                break;
                case "3":
                destinationAirport = DestinationAirport.OULU_AIRPORT;
                break;
                case "4":
                destinationAirport = DestinationAirport.HELSINKI_AIRPORT;
                break;
                default:
                System.out.println("No destination airport could be selected");
            }
        }
    }
    
    public void setBookingClass(String source){
        switch(source){
            case "1":
            bookingClass = BookingClass.FIRST;
            break;
            case "2":
            bookingClass = BookingClass.BUSINESS;
            break;
            case "3":
            bookingClass = BookingClass.ECONOMY;
            break;
            default:
            System.out.println("No booking class selected");
        }
    }



    public void setPassengerFullName(String name){
        this.passengerFullName = name;
    }

    public String getPassengerFullName(){
        return passengerFullName;
    }

    public int getChildPassengers(){
        return childPassengers;
    }

    public int getAdultPassengers(){
        return adultPassengers;
    }

    public String setFlightID(String fullName) {
        return "FOF" + fullName.substring(1,4) + "IN";
    }

    // TODO- add logic to set ticket number
    public void setTicketNumber(String fullName) {
        
        this.ticketNumber = 
    }

    public String getTicketNumber(){
        this.ticketNumber = "11FASDFDOM";
        return ticketNumber;
    }

    public void setTotalPassengers(int children, int adults) {
        totalPassengers = children + adults;
    }

    public int getTotalPassengers(){
        return totalPassengers;
    }

    private String calculateTripScope(){
        if((tripSource.equals(TripSource.OULU) && tripDestination.equals(TripDestination.HELSINKI)) || 
        (tripSource.equals(TripSource.HELSINKI) && tripDestination.equals(TripDestination.OULU)) ||
        (tripSource.equals(TripSource.BEIJING) && tripDestination.equals(TripDestination.NANJING)) ||
        (tripSource.equals(TripSource.NANJING) && tripDestination.equals(TripDestination.BEIJING))) {
            return "Domestic";
        }
        else{
            return "International";
        }
    }

    private String calcualteBookingClass(){
        if((bookingClass.equals(BookingClass.FIRST))){
            return "First";
        }
        if((bookingClass.equals(BookingClass.BUSINESS))){
            return "Business";
        }
        else {
            return "Economy";
        }
    }

    private String calcualteTripType(){
        if(tripType.equals(TripType.ONE_WAY)){
            return "One way";
        }
        else {
            return "Return";
        }
    }
    
    public void setDepartingTicketPrice(int child, int adults){
        
        String tripScope = calculateTripScope();
        String bClass = calcualteBookingClass();
        //String tType = calcualteTripType();
        double priceComponent1 = 0;

        if((tripScope == "Domestic") && (bClass == "First")){
            priceComponent1 = ((child*(300 * (0.1*300) + (0.05*300))) + (adults*(300 * (0.1*300) + (0.05*300)))) + 250;
        }
        else if((tripScope == "Domestic") && (bClass == "Business")){
            priceComponent1 = ((child*(300 * (0.1*300) + (0.05*300))) + (adults*(300 * (0.1*300) + (0.05*300)))) + 150;
        }
        else if((tripScope == "Domestic") && (bClass == "Economy")){
            priceComponent1 = ((child*(300 * (0.1*300) + (0.05*300))) + (adults*(300 * (0.1*300) + (0.05*300)))) + 50;
        }
        else if((tripScope == "International") && (bClass == "First")){
            priceComponent1 = ((child*(300 * (0.15*300) + (0.1*300))) + (adults*(300 * (0.15*300) + (0.1*300)))) + 250;
        }
        else if((tripScope == "International") && (bClass == "Business")){
            priceComponent1 = ((child*(300 * (0.15*300) + (0.1*300))) + (adults*(300 * (0.15*300) + (0.1*300)))) + 150;
        }
        else if((tripScope == "International") && (bClass == "Economy")){
            priceComponent1 = ((child*(300 * (0.15*300) + (0.1*300))) + (adults*(300 * (0.15*300) + (0.1*300)))) + 50;
        }
        else{
            departingTicketPrice = 0;
        }

        departingTicketPrice = priceComponent1;  
    }

    public double getDepartingTicketPrice(){
        return departingTicketPrice;
    }

    public void setReturnTicketPrice(){
        if ((tripType.equals(TripType.ONE_WAY))){
            returnTicketPrice = 0;
        }
        else {
            returnTicketPrice = this.departingTicketPrice;
        }
    }

    public double getReturnTicketPrice(){
        return returnTicketPrice;
    }

    public void setTotalTicketPrice() {
        totalTicketPrice = departingTicketPrice + returnTicketPrice;
    }

    public double getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setDepartureDate(LocalDate departure) {
        this.departureDate = departure;
    }

    public LocalDate getDepartureDate(){
        return departureDate;
    }


    public void setReturnDate(LocalDate returnDate) {
        int difference = returnDate.compareTo(this.departureDate);
        
        if (difference >= 2){
            this.returnDate = returnDate;
        }
        else {
            this.returnDate = this.departureDate.plusDays(2);
        }
    }

    public LocalDate getReturnDate(){
        return this.returnDate;
    }

    public String toString() {
        return "Dear " + passengerFullName + ". Thank you for booking your flight with " + 
        FLIGHT_COMPANY + "." + "\n" +
        "Following are the details of your booking and the trip:" + "\n" + 
        "Ticket Number: " + ticketNumber + "\n" + 
        "From " + TRIP_SOURCE + " to " + TRIP_DESTINATION + "\n" +
        "Date of departure: " + departureDate + "\n" +
        "Date of return: " + returnDate + "\n" +
        "Total passengers: " + totalPassengers + "\n" +
        "Total ticket price in Euros: " + totalTicketPrice;

    }

}
