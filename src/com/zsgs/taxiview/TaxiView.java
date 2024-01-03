package com.zsgs.taxiview;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.zsgs.booktaxi.BookTaxiView;
import com.zsgs.dto.Taxi;
import com.zsgs.taxiViewmodel.TaxiViewModel;

public class TaxiView {
	private TaxiViewModel viewModel;
	List<Taxi> taxi;
	List<Taxi> freeTaxi;
	private Scanner scanner;
	BookTaxiView bookTaxi;

	public TaxiView() {
//		this.viewModel = new TaxiViewModel(this);
		this.scanner = new Scanner(System.in);
		this.bookTaxi = new BookTaxiView(this);

	}

	public void showMenu() throws SQLException {
		while (true) {
			System.out.println("valid pickup points A,B,C,D,E,F");
			System.out.println("0 - > Book Taxi");
			System.out.println("1 - > Print Taxi details");
			int choice = scanner.nextInt();

			switch (choice) {
			case 0:

				bookTaxi.bookTaxi();
				break;
			case 1:
				bookTaxi.printTaxiDetails();
				break;
			default:
				return;
			}
		}
	}

//	private void printTaxiDetails() {
////		for (Taxi taxi : viewModel.getTaxis()) {
////			taxi.printDetails();
////		}
//		for (Taxi taxi : taxi) {
////			System.out.println();
//			taxi.printTaxiDetails();
//		}
//		if (freeTaxi == null) {
//			System.out.println("No Taxi Details");
//			return;
//		}
//
//		for (Taxi taxi : freeTaxi) {
//			taxi.printDetails();
//
////			System.out.println("hi");
//		}
//	}
}
