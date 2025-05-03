import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать на гонку '24 часа Ле-Мана'!");
        List<Car> cars = new ArrayList<>();

        System.out.print("Введите количество автомобилей: ");
        int numCars = getIntInput(scanner, 1, 10);

        for (int i = 0; i < numCars; i++) {
            System.out.print("Введите название автомобиля №" + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Введите скорость автомобиля (от 1 до 250 км/ч): ");
            double speed = getDoubleInput(scanner, 1, 250);
            cars.add(new Car(name, speed));
        }

        Race race = new Race(cars);
        race.printResults();
        scanner.close();
    }

    private static int getIntInput(Scanner scanner, int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (value >= min && value <= max) return value;
            } else {
                scanner.nextLine(); // Consume invalid input
                System.out.print("Ошибка! Введите число от " + min + " до " + max + ": ");
            }
        }
    }

    private static double getDoubleInput(Scanner scanner, double min, double max) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (value >= min && value <= max) return value;
            } else {
                scanner.nextLine(); // Consume invalid input
                System.out.print("Ошибка! Введите число от " + min + " до " + max + ": ");
            }
        }
    }
}

class Car {
    private final String name;
    private final double speed;

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return speed * 24; // Расстояние за 24 часа
    }
}

class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void printResults() {
        cars.sort(Comparator.comparing(Car::getDistance).reversed());

        System.out.println("\nРезультаты гонки:");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.printf("%d. %s - %.2f км\n", i + 1, car.getName(), car.getDistance());
        }

        System.out.println("Победитель: " + cars.get(0).getName() + "!");
    }
}
