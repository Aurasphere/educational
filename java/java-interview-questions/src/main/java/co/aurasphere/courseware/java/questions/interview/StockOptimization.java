/*
* MIT License
* 
* Copyright (c) 2015 Donato Rimenti
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
package co.aurasphere.courseware.java.questions.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Question: write a method <code>getMaxProfit(int risk, double capital)</code>,
 * which returns the maximum generable profit by optimizing the earnings. The
 * method must choose only stocks with a risk factor equals to the one passed as
 * argument and only buy indivisible packets. The profit formula is the
 * following:
 * <br/><br/>
 * <code>(QUANTITY * VALUE * INTEREST RATE * DURATION)/12</code>
 * <br/><br/>
 * The method {@link #getNewStock()} returns all the available stocks (one by
 * one) sorted by descendant interest rates.
 * 
 * @author Donato Rimenti
 *
 */
public class StockOptimization {

	/**
	 * Available stocks to buy.
	 */
	private static List<Stock> availableStocks = new ArrayList<Stock>();

	/**
	 * Used to iterate the {@link #availableStocks}.
	 */
	private static Iterator<Stock> stockGenerator;

	/**
	 * Generates a list of stocks with sample values and then computes the best
	 * earnable profit out of it with a given capital and risk factor.
	 *
	 * @param args
	 *            null
	 */
	public static void main(String[] args) {
		// Builds a list of stocks sorted by interest rate.
		Stock s1 = new Stock("EI5", "aaaa", 50000, 7, 1, 12, 3);
		Stock s2 = new Stock("DWE", "dddd", 50000, 6, 1, 12, 2);
		Stock s3 = new Stock("W23", "wwww", 60000, 5, 1.5f, 12, 3);
		Stock s4 = new Stock("RTT", "tttt", 20000, 4, 2, 12, 3);
		Stock s5 = new Stock("A3R", "zzzz", 15000, 3, 2, 12, 1);
		Stock s6 = new Stock("DTR", "rrrr", 30000, 2, 1, 12, 3);
		availableStocks.add(s1);
		availableStocks.add(s2);
		availableStocks.add(s3);
		availableStocks.add(s4);
		availableStocks.add(s5);
		availableStocks.add(s6);

		// Initializes the iterator used as a stock generator.
		stockGenerator = availableStocks.iterator();

		// Computes and prints the max profit.
		double maxProfit = getMaxProfit(3, 180000);
		System.out.println("Total maximum profit: " + maxProfit);
	}

	/**
	 * Gets the max earnable profit from buying stocks with a given risk factor
	 * using the specified budget.
	 * 
	 * @param risk
	 *            the risk factor of the stocks to buy
	 * @param capital
	 *            the budget to use for buying
	 * @return the maximum earnable profit with the given capital buying stocks
	 *         with the given risk factor
	 */
	public static double getMaxProfit(int risk, double capital) {
		// Filters out the stocks with a different risk factor.
		List<Stock> riskFilteredStocks = new ArrayList<Stock>();
		Stock stock;
		while ((stock = getNewStock()) != null) {
			if (stock.getRisk() != risk) {
				continue;
			}
			riskFilteredStocks.add(stock);
		}

		// Computes the max profit.
		double totalProfit = 0;
		do {
			Stock maxProfitableStock = null;
			double maxProfit = 0;

			// Finds the best buyable stock.
			for (Stock s : riskFilteredStocks) {
				// Current stock profit and cost.
				double profit = (s.getQuantity() * s.getValue() * s.getInterestRate() / 100 * s.getDuration()) / 12;
				double cost = s.getQuantity() * s.getValue();

				// Checks if the stock is the best available and
				// if is buyable with the current capital.
				if ((profit > maxProfit) && (capital - cost >= 0)) {
					maxProfit = profit;
					maxProfitableStock = s;
				}
			}

			// Stop if we didn't find any new buyable stock.
			if (maxProfitableStock == null) {
				break;
			}

			// Buy the current best stock and update the capital.
			capital -= maxProfitableStock.getQuantity() * maxProfitableStock.getValue();
			totalProfit += maxProfit;
			riskFilteredStocks.remove(maxProfitableStock);
			System.out.println("Bought stock: " + maxProfitableStock);

			// Stop if we spent all the capital.
		} while (capital > 0);

		System.out.println("Uninvested capital: " + capital);
		return totalProfit;
	}

	/**
	 * Returns the next available stock or null if there are none left.
	 * 
	 * @return the next available stock or null if there are none left
	 */
	private static Stock getNewStock() {
		while (stockGenerator.hasNext()) {
			return stockGenerator.next();
		}
		return null;
	}

	/**
	 * Represents a stock.
	 * 
	 * @author Donato Rimenti
	 *
	 */
	@SuppressWarnings("unused")
	private static class Stock {

		/**
		 * The stock code.
		 */
		private String code;

		/**
		 * The stock description.
		 */
		private String description;

		/**
		 * The stock quantity.
		 */
		private int quantity;

		/**
		 * The stock interest rate.
		 */
		private float interestRate;

		/**
		 * The stock value.
		 */
		private float value;

		/**
		 * The stock duration.
		 */
		private int duration;

		/**
		 * The stock risk.
		 */
		private int risk;

		/**
		 * Instantiates a new Stock.
		 *
		 * @param code
		 *            the {@link #code}
		 * @param description
		 *            the {@link #description}
		 * @param quantity
		 *            the {@link #quantity}
		 * @param interestRate
		 *            the {@link #interestRate}
		 * @param value
		 *            the {@link #value}
		 * @param duration
		 *            the {@link #duration}
		 * @param risk
		 *            the {@link #risk}
		 */
		public Stock(String code, String description, int quantity, float interestRate, float value, int duration,
				int risk) {
			this.code = code;
			this.description = description;
			this.quantity = quantity;
			this.interestRate = interestRate;
			this.value = value;
			this.duration = duration;
			this.risk = risk;
		}

		/**
		 * Gets the {@link #code}.
		 *
		 * @return the {@link #code}
		 */
		public String getCode() {
			return code;
		}

		/**
		 * Sets the {@link #code}.
		 *
		 * @param code
		 *            the new {@link #code}
		 */
		public void setCode(String code) {
			this.code = code;
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
		 * Gets the {@link #quantity}.
		 *
		 * @return the {@link #quantity}
		 */
		public int getQuantity() {
			return quantity;
		}

		/**
		 * Sets the {@link #quantity}.
		 *
		 * @param quantity
		 *            the new {@link #quantity}
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		/**
		 * Gets the {@link #interestRate}.
		 *
		 * @return the {@link #interestRate}
		 */
		public float getInterestRate() {
			return interestRate;
		}

		/**
		 * Sets the {@link #interestRate}.
		 *
		 * @param interestRate
		 *            the new {@link #interestRate}
		 */
		public void setInterestRate(float interestRate) {
			this.interestRate = interestRate;
		}

		/**
		 * Gets the {@link #value}.
		 *
		 * @return the {@link #value}
		 */
		public float getValue() {
			return value;
		}

		/**
		 * Sets the {@link #value}.
		 *
		 * @param value
		 *            the new {@link #value}
		 */
		public void setValue(float value) {
			this.value = value;
		}

		/**
		 * Gets the {@link #duration}.
		 *
		 * @return the {@link #duration}
		 */
		public int getDuration() {
			return duration;
		}

		/**
		 * Sets the {@link #duration}.
		 *
		 * @param duration
		 *            the new {@link #duration}
		 */
		public void setDuration(int duration) {
			this.duration = duration;
		}

		/**
		 * Gets the {@link #risk}.
		 *
		 * @return the {@link #risk}
		 */
		public int getRisk() {
			return risk;
		}

		/**
		 * Sets the {@link #risk}.
		 *
		 * @param risk
		 *            the new {@link #risk}
		 */
		public void setRisk(int risk) {
			this.risk = risk;
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
			result = prime * result + ((code == null) ? 0 : code.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + duration;
			result = prime * result + Float.floatToIntBits(interestRate);
			result = prime * result + quantity;
			result = prime * result + risk;
			result = prime * result + Float.floatToIntBits(value);
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
			Stock other = (Stock) obj;
			if (code == null) {
				if (other.code != null)
					return false;
			} else if (!code.equals(other.code))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (duration != other.duration)
				return false;
			if (Float.floatToIntBits(interestRate) != Float.floatToIntBits(other.interestRate))
				return false;
			if (quantity != other.quantity)
				return false;
			if (risk != other.risk)
				return false;
			if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
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
			return "Stock [code=" + code + ", description=" + description + ", quantity=" + quantity + ", interestRate="
					+ interestRate + ", value=" + value + ", duration=" + duration + ", risk=" + risk + "]";
		}

	}

}