/*
 * MIT License
 *
 * Copyright (c) 2019 Donato Rimenti
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
package co.aurasphere.courseware.java.interview.questions.logic;

import java.awt.Point;
import java.util.Random;

/**
 * Question: write a program that given a group of points finds the pair with
 * the smaller distance between them.
 * 
 * @author Donato Rimenti
 * 
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Closest_pair_of_points_problem">Closest
 *      pair of points problem</a>
 *
 */
public class ClosestPairPoints {

	/**
	 * Program which generates some random points and gets the closest pair.
	 * 
	 * @param args
	 *            null
	 */
	public static void main(String[] args) {
		// Generate some points.
		Point[] generatedPoints = generatePoints(10);

		// Finds the points with the smaller distance between them.
		Point[] minimumDistancePoints = getPointsWithMinimumDistance(generatedPoints);

		// Prints the result.
		System.out.println();
		System.out.println("Closest points: " + minimumDistancePoints[0] + ", " + minimumDistancePoints[1] + " = "
				+ computePointDistance(minimumDistancePoints[0], minimumDistancePoints[1]));
	}

	/**
	 * Returns the pair of points with the smaller distance between them.
	 * 
	 * @param points
	 *            the available points
	 * @return a pair of points with the smaller distance between them
	 */
	private static Point[] getPointsWithMinimumDistance(Point[] points) {
		double minimumDistance = Integer.MAX_VALUE;
		Point[] minimumDistancePoints = new Point[2];

		// Generate points pair by matching each point with its successors and
		// compute the pair distance.
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double currentDistance = computePointDistance(points[i], points[j]);
				System.out
						.println("Distance between points: " + points[i] + ", " + points[j] + " = " + currentDistance);

				// Check if this pair is closer than the current best. If so,
				// update the current closest points and distance.
				if (currentDistance < minimumDistance) {
					minimumDistance = currentDistance;
					minimumDistancePoints[0] = points[i];
					minimumDistancePoints[1] = points[j];
				}

			}
		}

		// Returns the points found.
		return minimumDistancePoints;
	}

	/**
	 * Computes the distance between two points.
	 * 
	 * @param pointOne
	 *            the first point
	 * @param pointTwo
	 *            the second point
	 * @return the distance between the two points
	 */
	private static double computePointDistance(Point pointOne, Point pointTwo) {

		// Manhattan or taxicab distance.
		// return Math.abs(pointOne.x - pointTwo.x) + Math.abs(pointOne.y -
		// pointTwo.y);

		// Euclidean distance.
		return Math.sqrt(Math.pow(pointOne.x - pointTwo.x, 2) + Math.pow(pointOne.y - pointTwo.y, 2));
	}

	/**
	 * Generates an array of points with random coordinates.
	 * 
	 * @param numberOfPoints
	 *            the number of points to generate
	 * @return an array of points with random coordinates
	 */
	private static Point[] generatePoints(int numberOfPoints) {
		Random random = new Random();
		Point[] generatedPoints = new Point[numberOfPoints];

		// Generate points with random coordinates.
		for (int i = 0; i < numberOfPoints; i++) {
			int x = random.nextInt(10000);
			int y = random.nextInt(10000);
			Point point = new Point(x, y);
			generatedPoints[i] = point;
		}

		return generatedPoints;
	}

}