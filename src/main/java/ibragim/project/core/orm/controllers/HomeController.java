package ibragim.project.core.orm.controllers;

import ibragim.project.core.orm.models.Car;
import ibragim.project.core.orm.models.Country;
import ibragim.project.core.orm.repositories.CarRepository;
import ibragim.project.core.orm.repositories.CountryRepository;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CountryRepository countryRepository;

    @GetMapping(value = "/")
    public String getMainPage(Model model){
        model.addAttribute("cars",carRepository.findAll());
        return "mainPage";
    }

    @GetMapping(value = "/addCar")
    public String getAddCarPage(Model model){
        model.addAttribute("countries", countryRepository.findAll());
        return "addCarPage";
    }

    @PostMapping(value = "/addCar")
    public String addNewCar(@RequestParam(name="name")String name,
                            @RequestParam(name="price")int price,
                            @RequestParam(name="model") String model,
                            @RequestParam(name="country") Long countryId,
                            @RequestParam(name="year") int year){
        Country country = countryRepository.findById(countryId).orElse(null);
        if(country!=null){
            Car newCar = new Car();
            newCar.setName(name);
            newCar.setModel(model);
            newCar.setYear(year);
            newCar.setPrice(price);
            newCar.setCountry(country);
            carRepository.save(newCar);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/details/{carId}")
    public String carDetails(@PathVariable(name = "carId")Long id,
                             Model model){
        Car theCar = carRepository.findById(id).orElse(null);
        if(theCar!=null){
            model.addAttribute("car", theCar);
        }
        return "details";
    }
}
