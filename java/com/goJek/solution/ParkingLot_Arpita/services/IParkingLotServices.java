/**
 * 
 */
package com.goJek.solution.ParkingLot_Arpita.services;

import java.util.List;
import java.util.Map;

import com.goJek.solution.ParkingLot_Arpita.model.Vehicle;

/**
 * @author arpita
 *
 */
public interface IParkingLotServices {

	public void create_parking_lot(int size);

	public int park(String registrationNumber, String color);

	public void leave(int slot);

	public Map<Integer, Vehicle> status();

	public List<String> registration_numbers_for_cars_with_colour(String color);

	public List<Integer> slot_numbers_for_cars_with_colour(String color);

	public int slot_number_for_registration_number(String registrationNumber);
}
