package com.RandomBeer.sampleApp.domain;
import javax.persistence.Entity;

/**
 * @author Renjith
 *
 */
@Entity
public class Beer {
	private final String name;
	private final String description;
	private final double percentage;
	private final String breweryLoaction;	
	
	public Beer(String name, String description, double d, String breweryLoaction) {	
		this.name = name;
		this.description = description;
		this.percentage = d;
		this.breweryLoaction = breweryLoaction;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getPercentage() {
		return percentage;
	}
	public String getBreweryLoaction() {
		return breweryLoaction;
	}
	
	@Override
	public String toString() {
		return "Beer [name=" + name + ", description=" + description + ", percentage=" + percentage
				+ ", breweryLoaction=" + breweryLoaction + "]";
	}
}
