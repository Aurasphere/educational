/*
 * MIT License
 *
 * Copyright (c) 2018 Donato Rimenti
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.courseware.java.hibernate.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model class for a film.
 * 
 * @author Donato Rimenti
 * 
 */
@Entity
public class Film {

	/**
	 * The film id.
	 */
	@Id
	@Column(name = "film_id")
	private int id;

	/**
	 * The film title.
	 */
	@Column
	private String title;

	/**
	 * The film description.
	 */
	@Column
	private String description;

	/**
	 * The film release year.
	 */
	@Column(name = "release_year")
	private int releaseYear;

	/**
	 * The film rental rate.
	 */
	@Column(name = "rental_rate")
	private BigDecimal rentalRate;

	/**
	 * The film rating.
	 */
	@Column
	private String rating;

	/**
	 * Gets the {@link #id}.
	 *
	 * @return the {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the {@link #id}.
	 *
	 * @param id
	 *            the new {@link #id}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the {@link #title}.
	 *
	 * @return the {@link #title}
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the {@link #title}.
	 *
	 * @param title
	 *            the new {@link #title}
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the {@link #description}.
	 *
	 * @return the {@link #description}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the {@link #description}.
	 *
	 * @param description
	 *            the new {@link #description}
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the {@link #releaseYear}.
	 *
	 * @return the {@link #releaseYear}
	 */
	public int getReleaseYear() {
		return releaseYear;
	}

	/**
	 * Sets the {@link #releaseYear}.
	 *
	 * @param releaseYear
	 *            the new {@link #releaseYear}
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * Gets the {@link #rentalRate}.
	 *
	 * @return the {@link #rentalRate}
	 */
	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	/**
	 * Sets the {@link #rentalRate}.
	 *
	 * @param rentalRate
	 *            the new {@link #rentalRate}
	 */
	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	/**
	 * Gets the {@link #rating}.
	 *
	 * @return the {@link #rating}
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the {@link #rating}.
	 *
	 * @param rating
	 *            the new {@link #rating}
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + ((rentalRate == null) ? 0 : rentalRate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalRate == null) {
			if (other.rentalRate != null)
				return false;
		} else if (!rentalRate.equals(other.rentalRate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", rentalRate=" + rentalRate + ", rating=" + rating + "]";
	}

}