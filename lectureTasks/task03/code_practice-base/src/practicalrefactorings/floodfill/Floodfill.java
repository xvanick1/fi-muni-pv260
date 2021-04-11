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
				}
			}
		}
	}

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
			}
		}
		return copy;
	}
}
