package com.ARSproject.controller;

import com.ARSproject.DAO.FlightDao;
import com.ARSproject.DAO.ReservationDao;
import com.ARSproject.wrappers.FlightWrapper;
import com.ARSproject.wrappers.ReservationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    ReservationDao reservationDao;
    @Autowired
    FlightDao flightDao;

    @RequestMapping(value = "/user/reservation", method = RequestMethod.POST)
    public ModelAndView makeReservation(@RequestParam(value = "id_flight") long code,
                                        @RequestParam(value = "travel_class") String travel_class) {
        String klasa = travel_class.equals("ECONOMIC") ? "Ekonomiczna" : "Biznesowa";
        try {
            reservationDao.makeReservation(code, klasa);
            ModelAndView modelAndView = new ModelAndView("loggedView");//t
            modelAndView.addObject("message", "Rezerwacja udana");//t
            return modelAndView;
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("errorLoggedView");//t
            modelAndView.addObject("message", "Wystąpił błąd");//t
            return modelAndView;
        }
    }

    @RequestMapping(value = "/user/reservations", method = RequestMethod.GET)
    public ModelAndView showMyReservations() {
        ModelAndView modelAndView = new ModelAndView("myReservationsView");
        try {
            List<ReservationWrapper> r = reservationDao.showReservations();
            if (r.isEmpty()) {
                modelAndView = new ModelAndView("errorLoggedView");
                modelAndView.addObject("message", "Nie masz żadnych rezerwacji");
            } else {
                modelAndView.addObject("reservations", r);
            }
        } catch (Exception e) {
            modelAndView = new ModelAndView("errorLoggedView");
            modelAndView.addObject("message", "Wystąpił błąd");//t

        }
        return modelAndView;
    }

    @RequestMapping(value = "/user/return-ticket", params = {"idReservation", "idFlight"}, method = RequestMethod.GET)
    public ModelAndView showReturnFlights(@RequestParam long idReservation,
                                          @RequestParam long idFlight) {
        ModelAndView modelAndView = new ModelAndView("returnFlightsView");

        List<FlightWrapper> f = flightDao.showReturnFlights(idFlight);
        if(f.isEmpty()){
            modelAndView = new ModelAndView("errorLoggedView");
            modelAndView.addObject("message", "Brak lotów powrotnych");//t
        }
        else modelAndView.addObject("flights", f);

        return modelAndView;
    }

    @RequestMapping(value = "/user/return-ticket", params = {"idReservation", "idFlight", "idReturnFlight", "travelClass"}, method = {RequestMethod.POST})
    public ModelAndView addReturnTicket(@RequestParam long idReservation,
                                        @RequestParam long idFlight,
                                        @RequestParam long idReturnFlight,
                                        @RequestParam String travelClass) {
        ModelAndView modelAndView = new ModelAndView("loggedView");
        try {
            reservationDao.addTicketToReservation(idReservation, idReturnFlight, travelClass);
            modelAndView.addObject("message", "Zarezerwowano lot powrotny");
        } catch (Exception e) {
            modelAndView = new ModelAndView("errorLoggedView");
            modelAndView.addObject("message", "Wystąpił błąd");//t

        }
        return modelAndView;
    }


}
