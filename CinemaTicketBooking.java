import java.util.Scanner;

class MovieTicket {
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    private String seatType;

    public MovieTicket(String movieName, double ticketPrice, int numberOfTickets, String seatType) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        this.seatType = seatType;
    }

    public double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    public double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10;
        }
        return 0.0;
    }

    public double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    public void displayBill() {
        System.out.println("\n----- Cinema Ticket Booking Bill -----");
        System.out.println("Movie Name       : " + movieName);
        System.out.println("Seat Type        : " + seatType);
        System.out.printf("Ticket Price     : %.2f%n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.printf("Total Amount     : %.2f%n", calculateTotal());
        System.out.printf("Discount         : %.2f%n", calculateDiscount());
        System.out.printf("Final Amount     : %.2f%n", calculateFinalAmount());
        System.out.println("--------------------------------------");
    }
}

public class CinemaTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] movies = {
            "Avengers: Endgame",
            "Inception",
            "The Dark Knight",
            "Interstellar",
            "Parasite"
        };

        System.out.println("========== Available Movies ==========");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }
        System.out.println("======================================");

        System.out.print("Select a movie (1-5): ");
        int movieChoice = sc.nextInt();

        while (movieChoice < 1 || movieChoice > 5) {
            System.out.print("Invalid choice! Please select a movie (1-5): ");
            movieChoice = sc.nextInt();
        }

        String selectedMovie = movies[movieChoice - 1];

        System.out.println("\n========== Seat Types ==========");
        System.out.println("1. General  - Rs. 150.00");
        System.out.println("2. Premium  - Rs. 250.00");
        System.out.println("3. VIP      - Rs. 400.00");
        System.out.println("================================");

        System.out.print("Select seat type (1-3): ");
        int seatChoice = sc.nextInt();

        while (seatChoice < 1 || seatChoice > 3) {
            System.out.print("Invalid choice! Please select seat type (1-3): ");
            seatChoice = sc.nextInt();
        }

        double ticketPrice = 0;
        String seatType = "";

        switch (seatChoice) {
            case 1:
                ticketPrice = 150.00;
                seatType = "General";
                break;
            case 2:
                ticketPrice = 250.00;
                seatType = "Premium";
                break;
            case 3:
                ticketPrice = 400.00;
                seatType = "VIP";
                break;
            default:
                break;
        }

        System.out.print("\nEnter Number of Tickets: ");
        int numberOfTickets = sc.nextInt();

        while (numberOfTickets <= 0) {
            System.out.print("Invalid number! Enter Number of Tickets: ");
            numberOfTickets = sc.nextInt();
        }

        MovieTicket ticket = new MovieTicket(selectedMovie, ticketPrice, numberOfTickets, seatType);
        ticket.displayBill();

        sc.close();
    }
}