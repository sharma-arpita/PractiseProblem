/**
 * 
 */
package com.goJek.solution.ParkingLot_Arpita.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import com.goJek.solution.ParkingLot_Arpita.model.Vehicle;

/**
 * @author arpita
 *
 */
public abstract class ParkingLotServices implements IParkingLotServices {

	Map<Integer, Vehicle> parkingLot;
	int parkingLotSize;
	SortedSet<Integer> freeSpace = new TreeSet<Integer>();

	public void create_parking_lot(int size) {
		parkingLot = new HashMap<Integer, Vehicle>(size);
		parkingLotSize = size;
		for (int i = 1; i <= size; i++) {
			freeSpace.add(i);
		}
	}

	public void leave(int slot) {
		parkingLot.remove(slot);
		freeSpace.add(slot);
	}

	public Map<Integer, Vehicle> status() {
		return parkingLot;
	}

	public int slot_number_for_registration_number(String registrationNumber) {
		for (Entry<Integer, Vehicle> entry : parkingLot.entrySet()) {
			if (entry.getValue().getRegistrationNumber().equals(registrationNumber)) {
				return entry.getKey();
			}
		}
		return 0;
	}
}
