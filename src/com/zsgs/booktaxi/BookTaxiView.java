package com.zsgs.booktaxi;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.zsgs.dto.Taxi;
import com.zsgs.taxiview.TaxiView;

public class BookTaxiView {
	List<Taxi> freeTaxi;
	List<Taxi> taxi;
	BookTaxiViewModel bookTaxiViewModel;
//	TaxiView taxiaxiView;

	public BookTaxiView(TaxiView taxiView) {
		this.bookTaxiViewModel = new BookTaxiViewModel(this);
		taxi = bookTaxiViewModel.createtaxi();
		taxiView = taxiView;
	}

	public void bookTaxi() throws SQLException {
//		int customerID = viewModel.getTaxis().size() + 1;
		Scanner scanner = new Scanner(System.in);
		int customerID = 1;
		System.out.println("Enter Pickup point");
		char pickupPoint = scanner.next().charAt(0);
		System.out.println("Enter Drop point");
		char dropPoint = scanner.next().charAt(0);
		System.out.println("Enter Pickup time");
		int pickupTime = scanner.nextInt();
		freeTaxi = bookTaxiViewModel.getFreeTaxis(taxi, pickupTime, dropPoint);
		bookTaxiViewModel.bookTaxi(customerID, pickupPoint, dropPoint, pickupTime, freeTaxi);
		customerID++;
	}

	public void printTaxiDetails() {

		for (Taxi taxi : taxi) {
//			System.out.println();
			taxi.printTaxiDetails();
		}
		if (freeTaxi == null) {
			System.out.println("No Taxi Details");
			return;
		}

		for (Taxi taxi : freeTaxi) {
			taxi.printDetails();

		}
	}

}
