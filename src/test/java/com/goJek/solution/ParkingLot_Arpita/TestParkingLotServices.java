/**
 * 
 */
package com.goJek.solution.ParkingLot_Arpita;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.goJek.solution.ParkingLot_Arpita.services.CarParkingServices;

/**
 * @author arpita
 *
 */
public class TestParkingLotServices {
		
	CarParkingServices services = new CarParkingServices();
	
	@Test
	public void test_create_ParkingLot(int size){
		services.create_parking_lot(5);
		assertEquals(services.status().size(), 5);
	}
	
	@Test
	public void test_park(){
		int park = services.park("KA-01-HH-1234", "WHITE");
		assertEquals(1, park);
	}
	
	@Test
	public void test_leave(){
		services.leave(1);
		assertEquals(services.status().size(), 1);
	}
	
	@Test
	public void test_status(){
		services.park("KA-01-HH-1234", "WHITE");
		assertEquals(2, services.status().size());
	}
	
	@Test
	public void test_registration_numbers_for_cars_with_colour(){
		services.park("KA-01-HH-3344", "RED");
		List<String> regNumber = services.registration_numbers_for_cars_with_colour("RED");
		assertEquals(Collections.singletonList("KA-01-HH-3344"), regNumber);
	}
	
	@Test
	public void test_invalidColor_registration_numbers_for_cars_with_colour(){
		List<String> regNumber1 = services.registration_numbers_for_cars_with_colour("TEST");
		assertEquals(Collections.EMPTY_LIST, regNumber1);
	}
	
	@Test
	public void test_slot_numbers_for_cars_with_colour(){
		List<Integer> slotNumber = services.slot_numbers_for_cars_with_colour("RED");
		assertEquals(Collections.singletonList(2), slotNumber);
	}
	
	@Test
	public void test_invalidColor_slot_numbers_for_cars_with_colour(){
		List<Integer> slotNumber1 = services.slot_numbers_for_cars_with_colour("TEST");
		assertEquals(Collections.EMPTY_LIST, slotNumber1);
	}
	
	@Test
	public void test_slot_number_for_registration_number(){
		int slotNumber = services.slot_number_for_registration_number("KA-01-HH-1234");
		assertEquals(1, slotNumber);
	}
	
	@Test
	public void test_InvalidReg_slot_number_for_registration_number(){
		int slotNumber1 = services.slot_number_for_registration_number("TEST");
		assertEquals(-1, slotNumber1);
	}
	
}
