package org.example.coffeewithtelegram;

import java.time.LocalDate;
import java.time.LocalTime;

import org.example.coffeewithtelegram.service.MyTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MyController {

    @GetMapping({"/", "/home/page"})
    public String home(Model mod) {
        Booked booked = new Booked(
                1,
                "Ear Songchay",
                "087546533",
                "songchay.ear@gmail.com.kh",
                LocalDate.now(),
                LocalTime.now(),
                2
        );
        mod.addAttribute("booked", booked);
        return "index";
    }


    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/testimonial")
    public String testimonial() {
        return "testimonial";
    }

    @GetMapping("/reservation")
    public String reservation(Model mod) {
        Booked booked = new Booked(
                1,
                "Songchay Ear",
                "012540456",
                "earsongchay@gmail.com",
                LocalDate.now(),
                LocalTime.now(),
                2
        );
        mod.addAttribute("booked", booked);
        return "reservation";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @Autowired
    private BookedRepo bookedRepo;
    @Autowired
    private MyTelegramBot bot;

    @PostMapping("/success")
    public String success(@ModelAttribute Booked booked) {
        var b = bookedRepo.save(booked);
        String message = String.format(
                "Dear %s, Thank you for booking a table with us at [Your Restaurant's Name]! We're excited to have you. 🥂😊" +
                        "\nOrder ID: %d" +
                        "\n Name: %s" +
                        "\n Phone Number: %s" +
                        "\n Email: %s" +
                        "\n Date: %s at %s" +
                        "\n Number of Guests: %s",
                b.getName(),
                b.getId(),
                b.getName(),
                b.getPhoneNumber(),
                b.getEmail(),
                b.getDate(),
                b.getTime(),
                b.getPerson()
        );

        bot.sendResponse(message);
        return "success";
    }


}
