package com.RandomBeer.sampleApp;

import java.util.ArrayList;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.RandomBeer.sampleApp.domain.Beer;
import com.RandomBeer.sampleApp.service.BeerDetailService;
/**
 * @author Renjith Kachappilly Ittoop
 * 
 * RandomBeer controller
 * http://localhost:8080/
 * http://localhost:8080/index.html
 * http://localhost:8080/random-beer-details
 * http://localhost:8080/beer-list
 *
 */
@Controller
public class RandomBeerController {

	private static Logger logger = Logger
			.getLogger(RandomBeerController.class);

	@Autowired
	private BeerDetailService beerDetailService;
	
	@RequestMapping(value = "/random-beer-details", method=RequestMethod.GET)
	public String randomBeerDetails(Model model) {
		logger.info("inside random-beer-details method");
		Beer randomBeer = beerDetailService.getRandomBeer();
		if (randomBeer != null) {			
			model.addAttribute("beer", randomBeer);			
		}		
		return "random-beer-details";
	}	
	
	@RequestMapping(value = "/random-beer-details", method=RequestMethod.POST)
	public String beerdetailsPost(Model model) {
		logger.info("inside beerdetailsPost method");
		Beer randomBeer = beerDetailService.getRandomBeer();
		if (randomBeer != null) {			
			model.addAttribute("beer", randomBeer);			
		}		
		return "random-beer-details";
	}
	
	@RequestMapping(value = "/beer-list", method=RequestMethod.GET)
	public String list(Model model) {
		logger.info("inside list() method >>>>");
		ArrayList<Beer> beerlist =(ArrayList<Beer>) beerDetailService.getBeerList();
		if (beerlist != null) {
			logger.info("list size >>"+beerlist.size());
			model.addAttribute("beerlist", beerlist);			
		}		
		return "beerlisting";
	}
	
	
	
	/**
	 *
	 * @return home view
	 */
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/index.html")
	public String index() {
		return "home";
	}
	
	/**
	 *
	 * @return home view
	 */
	@RequestMapping(value = "/beer-details", method=RequestMethod.GET)
	public String beerDetails(@RequestParam("id") int id, Model model) {
		logger.info("inside random-beer-details method");
		Beer beer = beerDetailService.getBeer(id);
		if (beer != null) {
			model.addAttribute("beer", beer);			
		}
		return "random-beer-details";
	}
	/**
	 *
	 * @return error view
	 */
	@ExceptionHandler(value=RuntimeException.class)
	@ResponseStatus(value=HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
	public String error() {
		return "error";
	}
}
