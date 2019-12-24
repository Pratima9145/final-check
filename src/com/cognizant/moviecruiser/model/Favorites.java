package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favorites {
	private List<MovieItem> movieItemList;

	private double noOfFavorites;

	public List<MovieItem> getMovieItemList() {
		return movieItemList;
	}

	public void setMovieItemList(List<MovieItem> movieItemList) {
		this.movieItemList = movieItemList;
	}

	public double getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(double noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	public Favorites() {
		super();
		movieItemList = new ArrayList<>();
		noOfFavorites = 0;
	}

}
