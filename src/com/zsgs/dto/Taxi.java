package com.zsgs.dto;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

	static int taxicount = -1;
	public int id;
	boolean booked;
	char currentSpot;
	public int freeTime;

	public char getCurrentSpot() {
		return currentSpot;
	}

	public void setCurrentSpot(char currentSpot) {
		this.currentSpot = currentSpot;
	}

	int totalEarnings;
	List<String> trips;

	public void setTotalEarnings(int totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public int getFreeTime() {
		return freeTime;
	}

	public void setFreeTime(int freeTime) {
		this.freeTime = freeTime;
	}

	public Taxi() {
		booked = false;
		currentSpot = 'A';
		this.freeTime = 6;
		totalEarnings = 0;
		trips = new ArrayList<String>();
		taxicount = taxicount + 1;
		id = taxicount;
	}

	public int getTotalEarnings() {

		return totalEarnings;
	}

	public void setDetails(boolean booked, char currentSpot, int freeTime, int totalEarnings, String tripDetail) {
		this.booked = booked;
		this.currentSpot = currentSpot;
		this.freeTime = freeTime;
		this.totalEarnings = totalEarnings;
		this.trips.add(tripDetail);
	}

	public void printDetails() {
		System.out.println("Taxi - " + this.id + " Total Earnings - " + this.totalEarnings);
		System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
		for (String trip : trips) {
			System.out.println(id + "          " + trip);
		}
		System.out.println("--------------------------------------------------------------------------------------");

	}

	public void printTaxiDetails() {
		// print total earningand taxi details like current location and free time
		System.out.println("Taxi - " + this.id + " Total Earnings - " + this.totalEarnings + " Current spot - "
				+ this.currentSpot + " Free Time - " + this.freeTime);
	}

}
