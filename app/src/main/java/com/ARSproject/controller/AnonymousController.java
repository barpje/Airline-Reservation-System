package com.ARSproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AnonymousController {

    @RequestMapping(value = "/flights/cities/form", method = RequestMethod.GET)
    public ModelAndView searchFlights() {
        ModelAndView modelAndView = new ModelAndView("flightsFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/flights/city/form", method = RequestMethod.GET)
    public ModelAndView searchFlightsFromCity() {
        ModelAndView modelAndView = new ModelAndView("flightsFormFromCityView");
        return modelAndView;
    }

    @RequestMapping(value = "/info-flight/form", method = RequestMethod.GET)
    public ModelAndView infoFlights() {
        ModelAndView modelAndView = new ModelAndView("flightInfoFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView logger() {
        ModelAndView modelAndView = new ModelAndView("loginFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView regger() {
        ModelAndView modelAndView = new ModelAndView("registerFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/flights/airline/form", method = RequestMethod.GET)
    public ModelAndView searchByAirline() {
        ModelAndView modelAndView = new ModelAndView("flightsFormByAirline");
        return modelAndView;

    }
}