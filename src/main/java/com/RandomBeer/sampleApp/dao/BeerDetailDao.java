package com.RandomBeer.sampleApp.dao;

import java.util.List;
import java.util.Map;

import com.RandomBeer.sampleApp.domain.Beer;

/**
 * @author Renjith
 *
 */
public interface BeerDetailDao {
	
	Map<Integer, Beer> getBeerMap();
	List<Beer> getBeerList();
	Beer getBeer(int id);
	Beer getRandomBeer();	
}
