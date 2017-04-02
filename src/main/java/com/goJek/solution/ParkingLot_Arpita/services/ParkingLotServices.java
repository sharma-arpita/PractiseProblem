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

	public boolean leave(int slot) {
		if(parkingLot != null && parkingLot.containsKey(slot)){
			parkingLot.remove(slot);
			freeSpace.add(slot);
			return true;
		} else {
			if(slot > parkingLotSize){
				System.out.println("No slot allocated with slot Number " +slot);
			} else {
				System.out.println("No vehicle parked at slot " +slot);
			}
			return false;
		}
	}

	public Map<Integer, Vehicle> status() {
		return parkingLot;
	}

	public int slot_number_for_registration_number(String registrationNumber) {
		if(parkingLot != null){
			for (Entry<Integer, Vehicle> entry : parkingLot.entrySet()) {
				if (entry.getValue().getRegistrationNumber().equals(registrationNumber)) {
					return entry.getKey();
				}
			}
		}
		return 0;
	}
}
