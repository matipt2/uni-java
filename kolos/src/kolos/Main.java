package kolos;

public class Main {
    public static void main(String[] args) {
        try {
            if(args.length!=3){
                throw new IllegalArgumentException("invalid number of arguments!");
            }
            double width = Double.parseDouble(args[0]);
            double height = Double.parseDouble(args[1]);
            String commands = args[2];

            World world = new World(width, height);
            Robot robot = new Robot(world);

            for (int i = 0; i < commands.length(); i++) {
                char command = commands.charAt(i);

                switch (command) {
                    case 'l' ->
                            robot.moveTo(new Position(robot.getPosition().getX() - 1, robot.getPosition().getY()), world);
                    case 'r' ->
                            robot.moveTo(new Position(robot.getPosition().getX() + 1, robot.getPosition().getY()), world);
                    case 'u' ->
                            robot.moveTo(new Position(robot.getPosition().getX(), robot.getPosition().getY() + 1), world);
                    case 'd' ->
                            robot.moveTo(new Position(robot.getPosition().getX(), robot.getPosition().getY() - 1), world);
                    case 'b' -> robot.moveBack();
                    case 't' -> robot.treasureDistance(world.getTreasure());
                    case 'p' -> System.out.println("Pozycja robota w tym momencie: " + robot.getPosition());
                    default -> System.out.println("unknown command: " + command);
                }
            }

        } catch (BoundaryException | OutsideTheWorldException e) {
            System.out.println("there is a problem: " + e.getMessage());
        }
    }
}