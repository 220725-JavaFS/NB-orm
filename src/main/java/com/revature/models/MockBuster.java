package com.revature.models;

public class MockBuster {
	
	private int movieId;
	private String title;
	private double price;
	private String rating;
	private int rentedId;
	private String releaseYear;
	private String movieDescr;
	
	public MockBuster(int movieId, String title, double price, String rating, int rentedId, String releaseYear,
			String movieDescr) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.price = price;
		this.rating = rating;
		this.rentedId = rentedId;
		this.releaseYear = releaseYear;
		this.movieDescr = movieDescr;
	}
	public MockBuster() {
		super();
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getRentedId() {
		return rentedId;
	}
	public void setRentedId(int rentedId) {
		this.rentedId = rentedId;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getMovieDescr() {
		return movieDescr;
	}
	public void setMovieDescr(String movieDescr) {
		this.movieDescr = movieDescr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieDescr == null) ? 0 : movieDescr.hashCode());
		result = prime * result + movieId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentedId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MockBuster other = (MockBuster) obj;
		if (movieDescr == null) {
			if (other.movieDescr != null)
				return false;
		} else if (!movieDescr.equals(other.movieDescr))
			return false;
		if (movieId != other.movieId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentedId != other.rentedId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MockBuster [movieId=" + movieId + ", title=" + title + ", price=" + price + ", rating=" + rating
				+ ", rentedId=" + rentedId + ", releaseYear=" + releaseYear + ", movieDescr=" + movieDescr + "]";
	}
	
	

}
