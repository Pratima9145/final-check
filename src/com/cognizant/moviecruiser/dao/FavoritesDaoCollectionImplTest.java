package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public class FavoritesDaoCollectionImplTest {
	public static void main(String[] args) throws FavoritesEmptyException {
		System.out.println("All favorite items ");
		testGetAllFavoritesItems();
		testAddFavoritesItem();
		testGetAllFavoritesItems();
		testRemoveFavoritesItem();
		testGetAllFavoritesItems();
	}

	public static void testAddFavoritesItem() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoritesItems(1, 2L);
		favoritesDao.addFavoritesItems(1, 5L);
		favoritesDao.addFavoritesItems(1, 3L);
		List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1l);
		System.out.println("\nList of items added to the favorites by user");
		for (MovieItem movieItem : movieItemListCustomer) {
			System.out.println(movieItem);
		}
	}

	public static void testGetAllFavoritesItems() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		try {

			List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1l);
			System.out.println("\nUser List All Favorites Items");
			for (MovieItem movieItem : movieItemListCustomer) {
				System.out.println(movieItem);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void testRemoveFavoritesItem() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("\nList of movies removed by the user");
		try {
			favoritesDao.removeFavoritesItems(1, 2L);
			favoritesDao.removeFavoritesItems(1, 5L);

			List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1l);
			for (MovieItem movieItem : movieItemListCustomer) {
				System.out.println(movieItem);
			}
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}
