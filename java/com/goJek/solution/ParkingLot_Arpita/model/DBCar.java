/**
 * 
 */
package com.goJek.solution.ParkingLot_Arpita.model;

/**
 * @author arpita
 *
 */
public class DBCar extends Vehicle {

	public String color;

	public DBCar(String registrationNumber, String color) {
		this.registrationNumber = registrationNumber;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
