/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.floodfill;

import java.awt.Color;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Floodfill {

<<<<<<< HEAD
	public Grid<Color> fillAt(Grid<Color> givenGrid, int startX, int startY, Color newColor) {
		Position initialPosition = new Position(startX, startY);
		givenGrid.validateIndex(startX, startY);
		Grid<Color> clonedGrid = cloneGrid(givenGrid);
		Queue<Position> cellToProcess = new LinkedList<>();
		cellToProcess.add(initialPosition);
		Color replacingColor = givenGrid.get(startX, startY);
		if (replacingColor.equals(newColor)) {
			return clonedGrid;
		}
		updateGrid(newColor, clonedGrid, cellToProcess, replacingColor);
		return clonedGrid;
	}

	private void updateGrid(Color newColor, Grid<Color> clonedGrid, Queue<Position> cellToProcess, Color replacingColor) {
		while (!cellToProcess.isEmpty()) {
			Position at = cellToProcess.poll();
			if (checkCoordinatesValidity(at.x(), at.y(), clonedGrid)) {
				clonedGrid.set(newColor, at.x(), at.y());
				Collection<Position> neighbors = getNeighbourCells(at);
				Collection<Position> uncoloredNeighbors = new ArrayList<>();
				findUncoloredNeighbours(clonedGrid, replacingColor, neighbors, uncoloredNeighbors);

				cellToProcess.addAll(uncoloredNeighbors);
			}
		}
	}

	private void findUncoloredNeighbours(Grid<Color> clonedGrid, Color replacingColor, Collection<Position> neighbors, Collection<Position> uncoloredNeighbors) {
		for (Position position : neighbors) {
			if (checkCoordinatesValidity(position.x(), position.y(), clonedGrid)) {
				Color colorAtPosition = clonedGrid.get(position.x(), position.y());
				if (colorAtPosition.equals(replacingColor)) {
					uncoloredNeighbors.add(position);
=======
	public Grid<Color> fillAt(Grid<Color> original, int startX, int startY, Color color) {
		Position start = new Position(startX, startY);
		if (start.x() >= 0 && start.x() < original.width() && start.y() >= 0 && start.y() < original.height()) {
			Grid<Color> copy = getGridCopy(original);
			Queue<Position> left = new LinkedList<>();
			left.add(new Position(startX, startY));
			Color replacingColor = original.get(startX, startY);
			if (!replacingColor.equals(color)) {
				while (!left.isEmpty()) {
					Position at = left.poll();
					if (at.x() >= 0 && at.x() < copy.width() && at.y() >= 0 && at.y() < copy.height()) {
						copy.set(color, at.x(), at.y());
						Collection<Position> neighbors = asList(
								new Position(at.x() + 1, at.y()),
								new Position(at.x(), at.y() + 1),
								new Position(at.x() - 1, at.y()),
								new Position(at.x(), at.y() - 1)
						);
						Collection<Position> uncoloredNeighbors = new ArrayList<>();
						for (Position position : neighbors) {
							if (position.x() >= 0 && position.x() < copy.width() && position.y() >= 0 && position.y() < copy.height()) {
								Color colorAtPosition = copy.get(position.x(), position.y());
								if (colorAtPosition.equals(replacingColor)) {
									uncoloredNeighbors.add(position);
								}
							}
						}

						left.addAll(uncoloredNeighbors);
					}
>>>>>>> 6c6a317bbca01acece5129fa59a97d2236abad98
				}
			}
		}
	}

<<<<<<< HEAD
	private Boolean checkCoordinatesValidity(int x, int y, Grid grid) {
		return x >= 0 && x < grid.width() && y >= 0 && y < grid.height();
	}

	private Collection<Position> getNeighbourCells(Position at) {
		return asList(
				new Position(at.x() + 1, at.y()),
				new Position(at.x(), at.y() + 1),
				new Position(at.x() - 1, at.y()),
				new Position(at.x(), at.y() - 1)
		);
	}

	private Grid<Color> cloneGrid(Grid<Color> givenGrid) {
		Grid<Color> copy = new ArrayBackedGrid<>(givenGrid.width(), givenGrid.height());
		for (int x = 0; x < givenGrid.width(); x++) {
			for (int y = 0; y < givenGrid.height(); y++) {
				copy.set(givenGrid.get(x, y), x, y);
=======
	private Grid<Color> getGridCopy(Grid<Color> original) {
		Grid<Color> copy = new ArrayBackedGrid<>(original.width(), original.height());
		for (int x = 0; x < original.width(); x++) {
			for (int y = 0; y < original.height(); y++) {
				copy.set(original.get(x, y), x, y);
>>>>>>> 6c6a317bbca01acece5129fa59a97d2236abad98
			}
		}
		return copy;
	}
}
