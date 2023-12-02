package kolos;

public interface Movable {
    void moveTo(Position position, World world) throws OutsideTheWorldException, BoundaryException;
    void moveBack();
}
