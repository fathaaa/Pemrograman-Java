import java.util.*;

class Hotspot {
    private Set<Point> points;

    public Hotspot() {
        points = new HashSet<>();
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public void printPoints() {
        List<Point> sortedPoints = new ArrayList<>(points);
        Collections.sort(sortedPoints);

        int count = 0;
        for (Point p : sortedPoints) {
            if (p.y > 0 && p.x >= 0) {
                count++;
                System.out.print("(" + p.x + "," + p.y + ") ");
            }
        }

        System.out.println();
    }

    public int getSize() {
        return points.size();
    }
}

class Point implements Comparable<Point> {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }

        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point other) {
        if (x != other.x) {
            return other.x - x;
        }
        return other.y - y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Hotspot hotspot = new Hotspot();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            hotspot.addPoint(new Point(x, y));
        }

        System.out.println(hotspot.getSize());
        hotspot.printPoints();

        scanner.close();
    }
}
