package kolos;

import java.util.Random;

public class World {
    private final double width;
    private final double height;
    private Treasure treasure;

    public World(double width, double height) throws BoundaryException {
        if (width <= 0 || height <= 0) {
            throw new BoundaryException("Wymiary swiata powinny byc wieksze niz zero!");
        }
        this.width = width;
        this.height = height;
        placeTreasure();
    }

    public World() throws BoundaryException {
        this(100, 100);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    void placeTreasure() {
        Random rand = new Random();
        double treasureX = rand.nextDouble() * width;
        double treasureY = rand.nextDouble() * height;
        treasure = new Treasure(treasureX, treasureY);
    }
}