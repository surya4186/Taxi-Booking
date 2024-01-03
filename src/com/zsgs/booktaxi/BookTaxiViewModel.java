package com.zsgs.booktaxi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsgs.dto.Taxi;
import com.zsgs.repo.TaxiModel;

public class BookTaxiViewModel {
	BookTaxiView bookTaxiView;
	private TaxiModel model;
	Taxi t;

	public BookTaxiViewModel(BookTaxiView bookTaxiView) {
		this.bookTaxiView = bookTaxiView;
		model = new TaxiModel(this);
		t = new Taxi();

	}

	public void bookTaxi(int customerID, char pickupPoint, char dropPoint, int pickupTime, List<Taxi> freeTaxis)
			throws SQLException {
//		List<Taxi> freeTaxis = getFreeTaxis(model.getTaxis(), pickupTime, pickupPoint);

		if (freeTaxis.size() == 0) {
			System.out.println("No Taxi can be allotted. Exiting");
			return;
		}

//		Collections.sort(freeTaxis, (a, b) -> a.getTotalEarnings() - b.getTotalEarnings());
		for (int i = 0; i < freeTaxis.size(); i++) {
			for (int j = i + 1; j < freeTaxis.size(); j++) {
				Taxi taxiI = freeTaxis.get(i);
				Taxi taxiJ = freeTaxis.get(j);

				if (taxiI.getTotalEarnings() > taxiJ.getTotalEarnings()) {
					// Swap taxis
					freeTaxis.set(i, taxiJ);
					freeTaxis.set(j, taxiI);
				}
			}
		}

		int min = 999;

		int distanceBetweenpickUpandDrop = 0;

		int earning = 0;

		int nextfreeTime = 0;

		char nextSpot = 'Z';

		Taxi bookedTaxi = null;

		String tripDetail = "";

		for (Taxi t : freeTaxis) {
			int distanceBetweenCustomerAndTaxi = Math.abs((t.getCurrentSpot() - '0') - (pickupPoint - '0')) * 15;
			if (distanceBetweenCustomerAndTaxi < min) {
				bookedTaxi = t;
				System.out.println("Hii");
				// pickup and drop = (drop - pickup) * 15KM
				distanceBetweenpickUpandDrop = Math.abs((dropPoint - '0') - (pickupPoint - '0')) * 15;
				// trip earning = 100 + (distanceBetweenpickUpandDrop) * 10
				earning = (distanceBetweenpickUpandDrop) * 10;
				System.out.println(earning);

				// time calculation
				int dropTime = pickupTime + distanceBetweenpickUpandDrop / 15;
//				System.out.println("Drop" + dropTime);

				// when taxi will be free next
				nextfreeTime = dropTime;

				// taxi will be at drop point after trip
				nextSpot = dropPoint;

				// creating trip detail
				tripDetail = customerID + "               " + customerID + "          " + pickupPoint + "      "
						+ dropPoint + "       " + pickupTime + "          " + dropTime + "           " + earning;
				min = distanceBetweenCustomerAndTaxi;
			}

		}
//		model.initializeTaxis(true,nextSpot,nextfreeTime, bookedTaxi.getTotalEarnings() + earning, tripDetail);
		bookedTaxi.setDetails(true, nextSpot, nextfreeTime, bookedTaxi.getTotalEarnings() + earning, tripDetail);

		System.out.println("Taxi " + bookedTaxi.id + " booked");

	}

	public List<Taxi> getFreeTaxis(List<Taxi> taxis, int pickupTime, char pickupPoint) {

		List<Taxi> freeTaxis = new ArrayList<Taxi>();
		for (Taxi t : taxis) {
//			System.out.println(t.freeTime);

//			if (t.freeTime <= pickupTime
//					&& (Math.abs((t.getCurrentSpot() - '0') - (pickupPoint - '0')) <= pickupTime - t.freeTime)) {
//				freeTaxis.add(t);
//
//			}
			if (t.freeTime <= pickupTime) {
				freeTaxis.add(t);
			}

		}
//		System.out.println(freeTaxis.size() + "taxi size");
		return freeTaxis;

	}

	public List<Taxi> createtaxi() {

		return model.createTaxi();
	}

}
