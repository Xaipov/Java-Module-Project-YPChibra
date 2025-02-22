import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать на гонку '24 часа Ле-Мана'!");
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите название автомобиля №" + (i + 1) + ": ");
            String name = scanner.nextLine();
            double speed;

            while (true) {
                System.out.print("Введите скорость автомобиля (от 1 до 250 км/ч): ");
                speed = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (speed > 0 && speed <= 250) break;
                System.out.println("Ошибка! Скорость должна быть в диапазоне от 1 до 250 км/ч.");
            }
            cars.add(new Car(name, speed));
        }
        Race race = new Race(cars);
        Car leader = race.determineLeader();
        System.out.println("Самая быстрая машина: " + leader.getName());
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
        return speed * 24;
    }
}
class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }
    public Car determineLeader() {
        return Collections.max(cars, Comparator.comparing(Car::getDistance));
    }
}