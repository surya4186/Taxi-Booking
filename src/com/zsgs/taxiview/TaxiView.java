package com.zsgs.taxiview;

import java.util.List;
import java.util.Scanner;

import com.zsgs.dto.Taxi;
import com.zsgs.taxiViewmodel.TaxiViewModel;

public class TaxiView {
	private TaxiViewModel viewModel;
	List<Taxi> taxi;
	List<Taxi> freeTaxi;
	private Scanner scanner;

	public TaxiView() {
		this.viewModel = new TaxiViewModel(this);
		this.scanner = new Scanner(System.in);
		taxi = viewModel.createtaxi();
	}

	public void showMenu() {
		while (true) {
			System.out.println("valid pickup points A,B,C,D,E,F");
			System.out.println("0 - > Book Taxi");
			System.out.println("1 - > Print Taxi details");
			int choice = scanner.nextInt();

			switch (choice) {
			case 0:

				bookTaxi();
				break;
			case 1:
				printTaxiDetails();
				break;
			default:
				return;
			}
		}
	}

	private void bookTaxi() {
//		int customerID = viewModel.getTaxis().size() + 1;
		int customerID = 1;
		System.out.println("Enter Pickup point");
		char pickupPoint = scanner.next().charAt(0);
		System.out.println("Enter Drop point");
		char dropPoint = scanner.next().charAt(0);
		System.out.println("Enter Pickup time");
		int pickupTime = scanner.nextInt();
		freeTaxi = viewModel.getFreeTaxis(taxi, pickupTime, dropPoint);

		viewModel.bookTaxi(customerID, pickupPoint, dropPoint, pickupTime, freeTaxi);
		customerID++;
	}

	private void printTaxiDetails() {
//		for (Taxi taxi : viewModel.getTaxis()) {
//			taxi.printDetails();
//		}
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

//			System.out.println("hi");
		}
	}
}
