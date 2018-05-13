package com.RandomBeer.sampleApp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.RandomBeer.sampleApp.domain.Beer;

/**
 * @author Renjith
 *
 */
@Repository
public class BeerDetailDaoImpl implements BeerDetailDao {
	private List<Beer> beerList;

	public BeerDetailDaoImpl() {
		beerList = new ArrayList<>();
		beerList.add(new Beer("Heinekan", "pale lager beer, most popular acoross Europe", 4.2, "Amsterdam, NeatherLands") );
		beerList.add(new Beer("CarlsBerg", "pale lager beer, popular in Denmark and Eastern Europe", 4.2, "CopenHagen, Denmark") );
		beerList.add(new Beer("Budweiser", "pale lager beer", 4.5, "USA") );
		
		beerList.add(new Beer("Guinness", "stout Ireland Special Beer", 4.5, "Dublin, Ireland") );
		beerList.add(new Beer("Tiger", "lager beer", 4.2, "Singapore") );
		beerList.add(new Beer("KingFisher", "lager beer", 5.5, "India") );
		
		beerList.add(new Beer("KingFisher strong", "lager beer", 7.5, "India") );
		beerList.add(new Beer("Tyskie", "lager beer, Budget friendly", 4.5, "Poland") );
		beerList.add(new Beer("Lech", "lager beer, Budget friendly", 4.5, "Poland") );
		
		beerList.add(new Beer("Prazky", "pale lager beer", 4.6, "Chech Republic") );		
		beerList.add(new Beer("Paulaner", "lager beer", 4.6, "Germany") );
		beerList.add(new Beer("Paulaner Non-Alcoholic", "Non-Alcoholic beer", 0, "Germany") );
		beerList.add(new Beer("Erdinger", "lager beer", 4.6, "Brussels") );
		
		beerList.add(new Beer("Miller", "lager beer", 4.6, "USA") );
		beerList.add(new Beer("Bud Light", "pale lager beer", 4.6, "USA") );
		beerList.add(new Beer("Coor Light", "pale lager beer", 4.6, "USA") );
	}

	@Override
	public List<Beer> getBeerList() {
		return beerList;
	}
	
	@Override
	public Map<Integer, Beer> getBeerMap() {
		HashMap<Integer, Beer> beerMap = new HashMap<>();
		ArrayList<Beer> beerList = (ArrayList<Beer>) getBeerList();		
		for (int i = 0; i < beerList.size(); i++) {
			beerMap.put(i+1, beerList.get(i));
		}		
		return beerMap;		
	}
	
	@Override
	public Beer getBeer(int beerId) {
		int x = 0;
		if (beerId < beerList.size()) {x = beerId;}			
		return beerList.get(x);
	}
	
	@Override
	public Beer getRandomBeer() {			
		Random rand = new Random(); 
		int randomi = rand.nextInt(beerList.size()); 		
		return beerList.get(randomi);
	}
}
