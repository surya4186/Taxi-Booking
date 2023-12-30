package com.zsgs.repo;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.taxiViewmodel.TaxiViewModel;
import com.zsgs.dto.Taxi;

public class TaxiModel {
	private List<Taxi> taxis;
	TaxiViewModel taxiViewModel;

	public TaxiModel(TaxiViewModel taxiViewModel) {
		taxis = new ArrayList<>();
		this.taxiViewModel = taxiViewModel;

	}

	public List<Taxi> getTaxis() {
		return taxis;
	}

	public List<Taxi> createTaxi() {
		// TODO Auto-generated method stub
		List<Taxi> taxiList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Taxi taxi = new Taxi();
			taxiList.add(taxi);
		}
		return taxiList;
	}

}
