package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface MovieItemDao {
	public List<MovieItem> getMovieItemListAdmin();

	public List<MovieItem> getMovieItemListCustomer();

	public void modifyMovieItem(MovieItem movieItem);

	public MovieItem getMovieItem(long movieItemId);
}
