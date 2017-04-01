/**
 * 
 */
package com.goJek.solution.ParkingLot_Arpita;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.goJek.solution.ParkingLot_Arpita.services.CarParkingServices;

/**
 * @author arpita
 *
 */
public class TestParkingLotServices {
		
	@Test
	public void test_create_ParkingLot(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(2);
		assertNotNull(services.status());
	}
	
	@Test
	public void test_park(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(2);
		int park = services.park("KA-01-HH-1234", "WHITE");
		assertEquals(1, park);
	}
	
	@Test
	public void test_full_park(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(1);
		services.park("KA-01-HH-3344", "RED");
		int park = services.park("KA-01-HH-8899", "Blue");
		assertEquals(0, park);
	}
	
	@Test
	public void test_leave(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(2);
		services.park("KA-01-HH-3344", "RED");
		services.park("KA-01-HH-8899", "Blue");
		services.leave(1);
		assertEquals(1, services.status().size());
	}
	
	@Test
	public void test_status(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(2);
		services.park("KA-01-HH-3344", "RED");
		services.park("KA-01-HH-1234", "WHITE");
		assertEquals(2, services.status().size());
	}
	
	@Test
	public void test_registration_numbers_for_cars_with_colour(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(1);
		services.park("KA-01-HH-3344", "RED");
		List<String> regNumber = services.registration_numbers_for_cars_with_colour("RED");
		assertEquals(Collections.singletonList("KA-01-HH-3344"), regNumber);
	}
	
	@Test
	public void test_invalidColor_registration_numbers_for_cars_with_colour(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(1);
		List<String> regNumber1 = services.registration_numbers_for_cars_with_colour("TEST");
		assertEquals(Collections.EMPTY_LIST, regNumber1);
	}
	
	@Test
	public void test_slot_numbers_for_cars_with_colour(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(1);
		services.park("KA-01-HH-3344", "RED");
		List<Integer> slotNumber = services.slot_numbers_for_cars_with_colour("RED");
		assertEquals(Collections.singletonList(1), slotNumber);
	}
	
	@Test
	public void test_invalidColor_slot_numbers_for_cars_with_colour(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(1);
		services.park("KA-01-HH-3344", "RED");
		List<Integer> slotNumber1 = services.slot_numbers_for_cars_with_colour("TEST");
		assertEquals(Collections.EMPTY_LIST, slotNumber1);
	}
	
	@Test
	public void test_slot_number_for_registration_number(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(1);
		services.park("KA-01-HH-3344", "RED");
		int slotNumber = services.slot_number_for_registration_number("KA-01-HH-3344");
		assertEquals(1, slotNumber);
	}
	
	@Test
	public void test_InvalidReg_slot_number_for_registration_number(){
		CarParkingServices services = new CarParkingServices();
		services.create_parking_lot(1);
		services.park("KA-01-HH-3344", "RED");
		int slotNumber1 = services.slot_number_for_registration_number("TEST");
		assertEquals(0, slotNumber1);
	}
	
}
