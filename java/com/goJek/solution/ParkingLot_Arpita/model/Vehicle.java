/**
 * 
 */
package com.goJek.solution.ParkingLot_Arpita.model;

/**
 * @author arpita
 *
 */
public abstract class Vehicle {

	public String registrationNumber;

	public int slot;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

}
