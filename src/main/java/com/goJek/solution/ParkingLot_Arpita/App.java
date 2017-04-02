package com.goJek.solution.ParkingLot_Arpita;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.goJek.solution.ParkingLot_Arpita.model.DBCar;
import com.goJek.solution.ParkingLot_Arpita.model.Vehicle;
import com.goJek.solution.ParkingLot_Arpita.services.CarParkingServices;
import com.goJek.solution.ParkingLot_Arpita.services.IParkingLotServices;

/**
 * Main method to start the parking lot service.
 *
 */
public class App {
	public static void main(String[] args) {
		IParkingLotServices services = new CarParkingServices();
		Scanner scanner = null;

		if (args.length > 0) {
			System.out.println("Entered Input " + args[0]);
			try {
				scanner = new Scanner(new File(args[0]));
			} catch (FileNotFoundException e) {
				System.out.println("Something is wrong with the file path, please check.");
				e.printStackTrace();
			}
		} else {
			scanner = new Scanner(System.in);
		}

		extractCommand(services, scanner);
		scanner.close();

	}

	private static void extractCommand(IParkingLotServices services, Scanner scanner) {
		while (scanner.hasNext()) {
			String nextLine = scanner.nextLine();
			if (nextLine.startsWith("create_parking_lot")) {
				String[] values = nextLine.split(" ");
				if (values.length == 2) {
					services.create_parking_lot(Integer.valueOf(values[1]));
					if (services.status() != null) {
						System.out.println("Created a parking lot with " + values[1] + " slots");
					}
				}
			} else if (nextLine.startsWith("park")) {
				String[] values = nextLine.split(" ");
				if (values.length == 3) {
					int park = services.park(values[1], values[2]);
					if (park == 0) {
						System.out.println("Sorry, parking lot is full");
					} else {
						System.out.println("Allocated slot number: " + park);
					}
				}
			} else if (nextLine.startsWith("leave")) {
				String[] values = nextLine.split(" ");
				if (values.length == 2) {
					if(services.leave(Integer.valueOf(values[1]))){
						System.out.println("Slot number " + values[1] + " is free");
					}
				}
			} else if (nextLine.toLowerCase().startsWith("status")) {
				Map<Integer, Vehicle> status = services.status();
				if(status != null && status.size() > 0){
					System.out.println("No\tRegistration Slot No.\tColour");
					for (Entry<Integer, Vehicle> entry : status.entrySet()) {
						System.out.println(entry.getKey() + "\t" + entry.getValue().getRegistrationNumber() + "\t\t"
								+ ((DBCar) entry.getValue()).getColor());
					}
				} else{
					System.out.println("Parking lot is not created yet");
				}
			} else if (nextLine.startsWith("registration_numbers_for_cars_with_colour")) {
				String[] values = nextLine.split(" ");
				if (values.length == 2) {
					List<String> registration_number = services.registration_numbers_for_cars_with_colour(values[1]);
					System.out.println(String.join(",", registration_number));
				}
			} else if (nextLine.startsWith("slot_numbers_for_cars_with_colour")) {
				String[] values = nextLine.split(" ");
				if (values.length == 2) {
					List<Integer> slot_Number = services.slot_numbers_for_cars_with_colour(values[1]);
					System.out.println(String.join(",", slot_Number.toString()));
				}
			} else if (nextLine.startsWith("slot_number_for_registration_number")) {
				String[] values = nextLine.split(" ");
				if (values.length == 2) {
					Integer slot_Number = services.slot_number_for_registration_number(values[1]);
					if (slot_Number == 0) {
						System.out.println("Not Found");
					} else {
						System.out.println(slot_Number);
					}
				}
			} else {
				System.out.println("Not a valid input");
			}
		}
	}

}
