import java.util.Arrays;
import java.util.Stack;

/**
 * Created by jianzhe on 11/1/18.
 */
public class carFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        return carCrush(cars, target);
    }
    public int carCrush(Car[] cars, int target) {
        Arrays.sort(cars, (o1, o2) -> Integer.compare(o1._pos, o2._pos));
        Stack<Car> stack = new Stack<>();
        for (Car car : cars) {
            while (!stack.isEmpty() && Isfaster(stack.peek(), car, target)) {
                stack.pop();
            }
            stack.push(car);
        }
        return stack.size();
    }
    private boolean Isfaster(Car car1, Car car2, int target) {
        return (target - car1._pos) / car1._speed <= (target - car2._pos) / car2._speed;
    }
    public class Car{
        int _pos;
        int _speed;
        public Car(int pos, int speed) {
            this._pos = pos;
            this._speed = speed;
        }
    }
}
