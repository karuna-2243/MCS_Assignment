import java.util.*;

public class waterjug{

    static class State {
        int x, y;
        List<String> path;

        State(int x, int y, List<String> path) {
            this.x = x;
            this.y = y;
            this.path = new ArrayList<>(path);
        }
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            State state = (State) obj;
            return x == state.x && y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static boolean canMeasureWater(int X, int Y, int Z) {
        if (Z > X + Y) return false;
        if (Z % gcd(X, Y) != 0) return false;

        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();


        queue.add(new State(0, 0, List.of("Start: (0, 0)")));

        while (!queue.isEmpty()) {
            State current = queue.poll();


            if (current.x == Z || current.y == Z || current.x + current.y == Z) {
                System.out.println("Steps to achieve " + Z + " liters:");
                for (String step : current.path) {
                    System.out.println(step);
                }
                return true;
            }


            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);


            List<State> nextStates = Arrays.asList(
                    new State(X, current.y, appendPath(current.path, "Fill Jug X: (" + X + ", " + current.y + ")")),
                    new State(current.x, Y, appendPath(current.path, "Fill Jug Y: (" + current.x + ", " + Y + ")")),
                    new State(0, current.y, appendPath(current.path, "Empty Jug X: (0, " + current.y + ")")),
                    new State(current.x, 0, appendPath(current.path, "Empty Jug Y: (" + current.x + ", 0)")),
                    new State(current.x - Math.min(current.x, Y - current.y),
                            current.y + Math.min(current.x, Y - current.y),
                            appendPath(current.path, "Pour Jug X to Jug Y: (" +
                                    (current.x - Math.min(current.x, Y - current.y)) + ", " +
                                    (current.y + Math.min(current.x, Y - current.y)) + ")")),
                    new State(current.x + Math.min(current.y, X - current.x),
                            current.y - Math.min(current.y, X - current.x),
                            appendPath(current.path, "Pour Jug Y to Jug X: (" +
                                    (current.x + Math.min(current.y, X - current.x)) + ", " +
                                    (current.y - Math.min(current.y, X - current.x)) + ")"))
            );

            queue.addAll(nextStates);
        }

        return false;
    }

    private static List<String> appendPath(List<String> path, String action) {
        List<String> newPath = new ArrayList<>(path);
        newPath.add(action);
        return newPath;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter the capacity of Jug X:");
        int X = scanner.nextInt();

        System.out.println("Enter the capacity of Jug Y:");
        int Y = scanner.nextInt();

        System.out.println("Enter the target amount (Z):");
        int Z = scanner.nextInt();


        if (!canMeasureWater(X, Y, Z)) {
            System.out.println("It is not possible to measure " + Z + " liters.");
        }

        scanner.close();
    }
} 
