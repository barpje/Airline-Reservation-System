package com.ARSproject.controller;

import com.ARSproject.DAO.FlightDao;
import com.ARSproject.exceptions.IncorrectCityException;
import com.ARSproject.exceptions.IncorrectFlightCodeException;
import com.ARSproject.wrappers.FlightInfoWrapper;
import com.ARSproject.wrappers.FlightWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    private final FlightDao lotRepository;

    @Autowired
    public SearchController(FlightDao lotRepository) {
        this.lotRepository = lotRepository;
    }

    @RequestMapping(value = "/flights/cities", method = RequestMethod.GET)
    public ModelAndView searchFlights(@RequestParam(value = "start_city") String startCity,
                                      @RequestParam(value = "end_city") String endCity) {
        ModelAndView modelAndView;

        try {
            List<FlightWrapper> f = lotRepository.searchFlights(startCity, endCity);
            if (!f.isEmpty()) {
                modelAndView = new ModelAndView("flightsView");
                modelAndView.addObject("flights", f);
            } else {
                modelAndView = new ModelAndView("errorView");
                modelAndView.addObject("message", "Brak lotu o podanym kodzie");
            }

        } catch (IncorrectCityException e) {
            modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Podanego miasta nie ma w bazie");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/flights/city", method = RequestMethod.GET)
    public ModelAndView searchFlightsFromCity(@RequestParam(value = "start_city") String startCity) {
        ModelAndView modelAndView;
        try {
            List<FlightWrapper> f = lotRepository.searchFlightsFromCity(startCity);
            if (!f.isEmpty()) {
                modelAndView = new ModelAndView("flightsView");
                modelAndView.addObject("flights", f);
            } else {
                modelAndView = new ModelAndView("errorView");
                modelAndView.addObject("message", "Brak lotu o podanym kodzie");
            }

        } catch (IncorrectCityException e) {
            modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Podanego miasta nie ma w bazie");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/user/flights", method = RequestMethod.GET)
    public ModelAndView searchLoggedFlights(@RequestParam(value = "start_city") String startCity, @RequestParam(value = "end_city") String endCity) {
        ModelAndView modelAndView;
        try {
            List<FlightWrapper> f = lotRepository.searchFlights(startCity, endCity);
            if (!f.isEmpty()) {
                modelAndView = new ModelAndView("flightsLoggedView");
                modelAndView.addObject("flights", f);
            } else {
                modelAndView = new ModelAndView("errorLoggedView");
                modelAndView.addObject("message", "Brak lotów");
            }

        } catch (IncorrectCityException e) {
            modelAndView = new ModelAndView("errorLoggedView");
            modelAndView.addObject("message", "Podanego miasta nie ma w bazie");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/flight", method = RequestMethod.GET)
    public ModelAndView searchFlightInfo(@RequestParam(value = "flight_code") String code) {
        ModelAndView modelAndView;
        try {
            List<FlightInfoWrapper> f = lotRepository.searchFlightInfo(code);
            if (!f.isEmpty()) {
                modelAndView = new ModelAndView("flightInfoView");
                modelAndView.addObject("flights", f);
            } else {
                modelAndView = new ModelAndView("errorView");
                modelAndView.addObject("message", "Brak lotu o podanym kodzie");
            }

        } catch (IncorrectFlightCodeException e) {
            modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Podanego miasta nie ma w bazie");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/flights/airline", method = RequestMethod.GET)
    public ModelAndView searchFlightInfoByAirline(@RequestParam(value = "airline") String airlineName) {
        ModelAndView modelAndView;
        try {
            List<FlightInfoWrapper> f = lotRepository.searchFlightsByAirline(airlineName);
            if (!f.isEmpty()) {
                modelAndView = new ModelAndView("flightInfoView");
                modelAndView.addObject("flights", f);
            } else {
                modelAndView = new ModelAndView("errorView");
                modelAndView.addObject("message", "Brak lotów dla podanej linii");
            }

        } catch (Exception e) {
            modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

}
