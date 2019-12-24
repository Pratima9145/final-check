package com.cognizant.moviecruiser.dao;

public class FavoritesEmptyException extends Exception {

	public FavoritesEmptyException() {
		super("\nFavorites is empty");

	}

	public FavoritesEmptyException(String arg0) {
		super(arg0);

	}

}
