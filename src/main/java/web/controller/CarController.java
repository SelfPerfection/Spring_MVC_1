package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String cars(ModelMap model, @RequestParam(required = false) String count) {

        int amount = (count != null) ? Integer.parseInt(count) : 5;
        List<Car> cars = carService.selectCars(amount);

        model.addAttribute("cars", cars);
        return "cars";
    }
}