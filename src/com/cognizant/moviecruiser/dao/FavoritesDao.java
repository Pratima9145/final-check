package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface FavoritesDao {
	public void addFavoritesItems(long userId, long movieItemId);

	public List<MovieItem> getAllFavoritesItems(Long userId) throws FavoritesEmptyException;

	public void removeFavoritesItems(long userId, long movieItemId);

}
