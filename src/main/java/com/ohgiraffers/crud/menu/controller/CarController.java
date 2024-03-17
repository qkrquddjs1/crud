package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CarDTO;
import com.ohgiraffers.crud.menu.model.service.CarService;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final MessageSource messageSource;

    public CarController(CarService carService, MessageSource messageSource) {

        this.carService = carService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String findCarList(Model model) {

        List<CarDTO> carList = carService.findAllCar();

        model.addAttribute("carList", carList);

        return "car/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registCar(@ModelAttribute CarDTO car, RedirectAttributes rttr){

        carService.registCar(car);

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registCar", null, Locale.getDefault()));

        return "redirect:/car/list";
    }
}
