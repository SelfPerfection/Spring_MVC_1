package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    /*
     Defualt Data DAO, which emulutes DB work
     */
    private Car carsArray[] = {
            new Car(1, "BMW", "X5", 5600000),
            new Car(2, "Mercedes-Benz", "W223", 12000000),
            new Car(3, "Porsche", "991", 6900000),
            new Car(4, "Infiniti", "Q60", 5100000),
            new Car(5, "Ferrari", "Enzo", 18060000),
    };

    /*
     Method, which emulutes SELECT from DB
     */
    @Override
    public List<Car> selectCars(int amount) {
        List<Car> cars = Arrays.asList(carsArray);

        if (amount < 2) {
            return cars.subList(0, 1);
        } else if (amount > 4) {
            return cars;
        } else {
            return cars.subList(0, amount);
        }
    }
}
