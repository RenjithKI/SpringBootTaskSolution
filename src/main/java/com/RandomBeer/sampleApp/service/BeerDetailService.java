package com.RandomBeer.sampleApp.service;

import java.util.List;
import java.util.Map;

import com.RandomBeer.sampleApp.domain.Beer;;

/**
 * @author Renjith
 *
 */
public interface BeerDetailService {
	
	List<Beer> getBeerList();
	
	Beer getBeer(int id);
	
	Map<Integer, Beer> getBeerMap();
	
	Beer getRandomBeer();
}
