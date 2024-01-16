import java.util.InputMismatchException;
import java.util.Scanner;
import hostel.Hostel;
import booking.BoysHostel;
import booking.GirlsHostel;

public class HostelBookingSystem extends Exception{
    public static void main(String[] args) {
        booking();
    }
    public static void booking() {
        Scanner scanner = new Scanner(System.in);
        Hostel hostel = null;

        while (true) {
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Hostel Booking and Management System");
            System.out.println("1. Create Boys Hostel");
            System.out.println("2. Create Girls Hostel");
            System.out.println("3. Display Hostel Information");
            System.out.println("4. Book a Room");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------");
            
            int choice = scanner.nextInt();
            String tempName;
            int tempTotalRooms;
            int tempAvailableRooms;
            String tempTimings;
            Boolean tempMess;

            try {
            
            switch (choice) {
                case 1:
                System.out.println("ENTER THE NAME OF THE BOYS HOSTEL (without white spaces)");
                tempName = scanner.next();

                System.out.println("ENTER THE NUMBER OF ROOMS IN YOUR HOSTEL");
                
                tempTotalRooms = scanner.nextInt();
                
                
                do {
                    System.out.println("ENTER THE AVAILABLE ROOMS IN YOUR HOSTEL");
                    
                    tempAvailableRooms = scanner.nextInt();
                    
                    if (tempAvailableRooms > tempTotalRooms) {
                        System.out.println("Available rooms should be less than total rooms. Please enter again.");
                    }
                } while (tempAvailableRooms > tempTotalRooms);

                System.out.println("ENTER THE TIMINGS FOR YOUR HOSTEL");
                scanner.nextLine();
                tempTimings = scanner.nextLine();

                System.out.println("DOES YOUR HOSTEL HAVE A MESS? (yes/no)");
                String messInput = scanner.next().toLowerCase();
                tempMess = messInput.equals("yes");
                hostel = new BoysHostel(tempName, tempTotalRooms, tempAvailableRooms, tempTimings, tempMess);
                System.out.println("Boys Hostel created.");
                break;

                case 2:
                System.out.println("ENTER THE NAME OF THE GIRLS HOSTEL");
                tempName = scanner.next();

                System.out.println("ENTER THE NUMBER OF ROOMS IN YOUR HOSTEL");
                tempTotalRooms = scanner.nextInt();
                scanner.nextLine();
                do {
                    System.out.println("ENTER THE AVAILABLE ROOMS IN YOUR HOSTEL");
                    tempAvailableRooms = scanner.nextInt();
                    scanner.nextLine();

                    if (tempAvailableRooms >= tempTotalRooms) {
                        System.out.println("Available rooms should be less than total rooms. Please enter again.");
                    }
                } while (tempAvailableRooms >= tempTotalRooms);

                System.out.println("ENTER THE TIMINGS FOR YOUR HOSTEL");
                tempTimings = scanner.nextLine();

                System.out.println("DOES YOUR HOSTEL HAVE A MESS? (yes/no)");
                messInput = scanner.next().toLowerCase();
                tempMess = messInput.equals("yes");
                hostel = new GirlsHostel(tempName, tempTotalRooms, tempAvailableRooms, tempTimings, tempMess);
                System.out.println("GIRLS Hostel created.");
                break;

                case 3:
                    System.out.println("Display Hostel Information");
                    System.out.println("1. Display Boys Hostel Information");
                    System.out.println("2. Display Girls Hostel Information");
                    System.out.println("Enter your choice: ");
                    int displayChoice = scanner.nextInt();
            
                    switch (displayChoice) {
                        case 1:
                            if (hostel instanceof BoysHostel) {
                                hostel.displayHostelInfo();
                            } else {
                                System.out.println("No Information Available.. ");
                            }
                            break;
            
                        case 2:
                            if (hostel instanceof GirlsHostel) {
                                hostel.displayHostelInfo();
                            } else {
                                System.out.println("No Information Available.. ");
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Room Booking");
                    System.out.println("1. Book a Room (Boys)");
                    System.out.println("2. Book a Room (Girls)");
                    System.out.print("Enter your choice: ");
                    int bookingChoice = scanner.nextInt();
                
                    boolean bookingStatus = false;
                
                    if (hostel == null) {
                        System.out.println("No hostel selected.");
                        break;
                    }
                
                    switch (bookingChoice) {
                        case 1:
                            if (hostel instanceof BoysHostel) {
                                bookingStatus = hostel.bookRoom();
                            } else {
                                System.out.println("Boys Hostel not selected.");
                            }
                            break;
                
                        case 2:
                            if (hostel instanceof GirlsHostel) {
                                bookingStatus = hostel.bookRoom();
                            } else {
                                System.out.println("Girls Hostel not selected.");
                            }
                            break;
                
                        default:
                            System.out.println("Invalid choice for room booking.");
                    }
                
                    if (bookingStatus) {
                        System.out.println("Room booked successfully!");
                    } else {
                        System.out.println("No available rooms.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Hostel Booking System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Data type. Enter Again");
            booking();
        }
        }
    }
}