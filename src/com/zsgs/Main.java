package com.zsgs;

import com.zsgs.taxiViewmodel.TaxiViewModel;
import com.zsgs.taxiview.TaxiView;

//The are 6 points(A,B,C,D,E,F) 15 KM apart 60 min travel between each, n taxis all taxis at A starting
//100 rs for first 5 KM and then 10 for each of the further KMs, rate from pickup to drop only
//pickup time example : 9 hrs, 15 hrs
//
//When a customer books a Taxi, a free taxi at that point is allocated
//-If no free taxi is available at that point, a free taxi at the nearest point is allocated.
//-If two taxi’s are free at the same point, one with lower earning is allocated
//-If no taxi is free at that time, booking is rejected
public class Main {
	public static void main(String[] args) {
//		TaxiModel model = new TaxiModel();
//		TaxiViewModel viewModel = new TaxiViewModel(model);
		TaxiView view = new TaxiView();

		view.showMenu();
	}
}
