import java.util.Scanner;

public class WasteVehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle Number: ");
        int vehicleNumber = sc.nextInt();

        System.out.print("Enter Waste Collected (in kg): ");
        double wasteCollected = sc.nextDouble();

        System.out.print("Enter Number of Collection Points: ");
        int collectionPoints = sc.nextInt();

        System.out.print("Enter Vehicle Status (single character): ");
        char vehicleStatus = sc.next().charAt(0);

        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Vehicle Number     : " + vehicleNumber);
        System.out.println("Waste Collected    : " + wasteCollected + " kg");
        System.out.println("Collection Points  : " + collectionPoints);
        System.out.println("Vehicle Status     : " + vehicleStatus);

        sc.close();
    }
}