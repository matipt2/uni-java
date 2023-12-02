package kolos;

import java.util.ArrayList;
import java.util.List;

public class Robot implements Movable {
    private final List<Position> listOfPositions;
    private double firstDistance;

    public Robot(World world) {
        listOfPositions = new ArrayList<>();
        Position initialPosition = new Position(0, 0);
        listOfPositions.add(initialPosition);
        firstDistance = distanceCalculations(initialPosition, world.getTreasure());
    }
    public Robot() {
        listOfPositions = new ArrayList<>();
        listOfPositions.add(new Position(0, 0));
    }

    @Override
    public void moveTo(Position position, World world) throws OutsideTheWorldException {
        if (!isIn(position, world)) {
            throw new OutsideTheWorldException("Wychodzisz poza granice!");
        }
        listOfPositions.add(position);
    }

    @Override
    public void moveBack() {
        if (listOfPositions.size() > 1) {
            listOfPositions.remove(listOfPositions.size() - 1);
        }
    }

    public Position getPosition() {
        return listOfPositions.get(listOfPositions.size() - 1);
    }

    private boolean isIn(Position position, World world) {
        double x = position.getX();
        double y = position.getY();
        return x >= 0 && x <= world.getWidth() && y >= 0 && y <= world.getHeight();
    }

    void treasureDistance(Treasure treasure) {
        Position robotPosition = getPosition();
        double current = distanceCalculations(robotPosition, treasure);
        if (current == 0) {
            System.out.println("Gratulacje znalazles skarb!");
        } else {
            if (current < firstDistance) {
                System.out.println("hot");
            } else {
                System.out.println("cold");
            }
            firstDistance = current;
        }
    }

    private double distanceCalculations(Position position, Treasure treasure) {
        return Math.sqrt(Math.pow(position.getX() - treasure.getX(), 2) + Math.pow(position.getY() - treasure.getY(), 2)
        );
    }
}
