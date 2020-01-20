package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;


public class FavoritesDaoSqlImplTest {
	public static void main(String[] args) throws FavoritesEmptyException {
		testGetAllFavoritesItems();
		testAddFavoritesItems();
		testGetAllFavoritesItems();
		testRemoveFavoritesItems();
		testGetAllFavoritesItems();
	}

	private static void testGetAllFavoritesItems() {
		try {
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		FavoritesDao favoritesDao = favoritesDaoSqlImpl;
		List<MovieItem> movieItemList;
	
			movieItemList = favoritesDao.getAllFavoritesItems(1L);
			for (MovieItem x : movieItemList) {
				System.out.println(x);
			}
		} catch (FavoritesEmptyException e) {
			e.printStackTrace();
		}
	}

	private static void testRemoveFavoritesItems() throws FavoritesEmptyException {
		FavoritesDao favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		FavoritesDao favoritesDao = favoritesDaoSqlImpl;
        System.out.println("Favorite List for Customer after Remove");
        try {
        	List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1L);
		
			favoritesDao.removeFavoritesItems(1, 4);
			favoritesDao.removeFavoritesItems(1, 2);
			
		} catch (Exception e) {
			throw new FavoritesEmptyException("Favorites List is empty");
		}
		
	}

	private static void testAddFavoritesItems() {
		try {
		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();
		//FavoritesDao favoritesDao = favoritesDaoSqlImpl;
		favoritesDao.addFavoritesItems(1, 4);
		favoritesDao.addFavoritesItems(1, 2);
		favoritesDao.addFavoritesItems(1, 1);
		favoritesDao.addFavoritesItems(1, 3);
		
			List<MovieItem> movieItemListCustomer = favoritesDao.getAllFavoritesItems(1L);
		} catch (FavoritesEmptyException e) {
			e.printStackTrace();
		}
	}
}

