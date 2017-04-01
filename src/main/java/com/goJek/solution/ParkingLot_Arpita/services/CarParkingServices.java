/**
 * 
 */
package com.goJek.solution.ParkingLot_Arpita.services;

import java.util.ArrayList;
import java.util.List;

import com.goJek.solution.ParkingLot_Arpita.model.DBCar;
import com.goJek.solution.ParkingLot_Arpita.model.Vehicle;

/**
 * @author arpita
 *
 */
public class CarParkingServices extends ParkingLotServices {

	/* (non-Javadoc)
	 * @see com.goJek.solution.ParkingLot_Arpita.services.IParkingLotServices#park(java.lang.String, java.lang.String)
	 */
	public int park(String registrationNumber, String color) {
		if (status().size() > 0) {
			Vehicle car = new DBCar(registrationNumber, color);
			if (parkingLot.keySet().size() < status().size()) {
				parkingLot.put(freeSpace.first(), car);
				freeSpace.remove(freeSpace.first());
			}
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.goJek.solution.ParkingLot_Arpita.services.IParkingLotServices#registration_numbers_for_cars_with_colour(java.lang.String)
	 */
	public List<String> registration_numbers_for_cars_with_colour(String color) {
		List<String> registrationNumber = new ArrayList<>();
		parkingLot.values().forEach(car -> {
			if (car instanceof DBCar) {
				if (((DBCar) car).getColor().equals(color)) {
					registrationNumber.add(car.getRegistrationNumber());
				}
			}
		});
		return registrationNumber;
	}

	/* (non-Javadoc)
	 * @see com.goJek.solution.ParkingLot_Arpita.services.IParkingLotServices#slot_numbers_for_cars_with_colour(java.lang.String)
	 */
	public List<Integer> slot_numbers_for_cars_with_colour(String color) {
		List<Integer> slotNumber = new ArrayList<>();
		parkingLot.entrySet().forEach(entry -> {
			if (entry.getValue() instanceof DBCar) {
				if (((DBCar) entry.getValue()).getColor().equals(color)) {
					slotNumber.add(entry.getKey());
				}
			}
		});
		return slotNumber;
	}

}
