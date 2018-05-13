package com.RandomBeer.sampleApp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RandomBeer.sampleApp.dao.BeerDetailDao;
import com.RandomBeer.sampleApp.domain.Beer;

@Service
public class BeerDetailServiceImpl implements BeerDetailService {	
	
	@Autowired
	private BeerDetailDao beerDetailDao;	

	@Override
	public List<Beer> getBeerList() {		
		return beerDetailDao.getBeerList();
	}

	@Override
	public Beer getBeer(int id) {		
		return beerDetailDao.getBeer(id);
	}
	
	@Override
	public Map<Integer, Beer> getBeerMap(){
		return beerDetailDao.getBeerMap();
	}

	@Override
	public Beer getRandomBeer() {		
		return beerDetailDao.getRandomBeer();
	}	
	
}
