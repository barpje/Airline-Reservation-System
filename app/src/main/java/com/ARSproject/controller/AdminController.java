package com.ARSproject.controller;

import com.ARSproject.DAO.InsertsDao;
import com.ARSproject.DAO.UserDao;
import com.ARSproject.DAO.ViewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

@Controller
public class AdminController {
    @Autowired
    ViewsDao viewsDao;
    @Autowired
    InsertsDao insertsDao;
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/admin/view/country", method = RequestMethod.GET)
    public ModelAndView showCoutries() {
        ModelAndView modelAndView = new ModelAndView("admin/countryView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableCountry());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/city", method = RequestMethod.GET)
    public ModelAndView showCities() {
        ModelAndView modelAndView = new ModelAndView("admin/cityView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableCity());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/plane", method = RequestMethod.GET)
    public ModelAndView showPlanes() {
        ModelAndView modelAndView = new ModelAndView("admin/planeView");
        try {
            modelAndView.addObject("elements", viewsDao.showTablePlane());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/manufacturer", method = RequestMethod.GET)
    public ModelAndView showManufacturerers() {
        ModelAndView modelAndView = new ModelAndView("admin/manufacturerView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableManufacturer());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/model", method = RequestMethod.GET)
    public ModelAndView showModel() {
        ModelAndView modelAndView = new ModelAndView("admin/modelView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableModel());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/airline", method = RequestMethod.GET)
    public ModelAndView showAirlines() {
        ModelAndView modelAndView = new ModelAndView("admin/airlineView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableAirline());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/airport", method = RequestMethod.GET)
    public ModelAndView showAirports() {
        ModelAndView modelAndView = new ModelAndView("admin/airportView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableAirport());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/flight", method = RequestMethod.GET)
    public ModelAndView showFlights() {
        ModelAndView modelAndView = new ModelAndView("admin/flightView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableFlight());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/account", method = RequestMethod.GET)
    public ModelAndView showAccounts() {
        ModelAndView modelAndView = new ModelAndView("admin/accountView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableAccount());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/ticket", method = RequestMethod.GET)
    public ModelAndView showTickets() {
        ModelAndView modelAndView = new ModelAndView("admin/ticketView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableTicket());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/reservation", method = RequestMethod.GET)
    public ModelAndView showReservations() {
        ModelAndView modelAndView = new ModelAndView("admin/reservationView");
        try {
            modelAndView.addObject("elements", viewsDao.showTableReservation());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/view/passenger", method = RequestMethod.GET)
    public ModelAndView showPassengers() {
        ModelAndView modelAndView = new ModelAndView("admin/passengerView");
        try {
            modelAndView.addObject("elements", viewsDao.showTablePassenger());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/country", method = RequestMethod.GET)
    public ModelAndView addFormCountry() {
        ModelAndView modelAndView = new ModelAndView("admin/countryFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/add_country", method = RequestMethod.POST)
    public ModelAndView addCountry(@RequestParam(value = "name") String name) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            insertsDao.addCountry(name);
            modelAndView.addObject("message", "Dodano rekord");

        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/city", method = RequestMethod.GET)
    public ModelAndView addFormCity() {
        ModelAndView modelAndView = new ModelAndView("admin/cityFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/add_city", method = RequestMethod.POST)
    public ModelAndView addCity(@RequestParam(value = "name") String name, @RequestParam(value = "idCountry") long idCountry) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            insertsDao.addCity(name, idCountry);
            modelAndView.addObject("message", "Dodano rekord");

        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/manufacturer", method = RequestMethod.GET)
    public ModelAndView addFormManufacturer() {
        ModelAndView modelAndView = new ModelAndView("admin/manufacturerFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/add_manufacturer", method = RequestMethod.POST)
    public ModelAndView addManufacturer(@RequestParam(value = "name") String name) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            insertsDao.addManufacturer(name);
            modelAndView.addObject("message", "Dodano rekord");

        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/model", method = RequestMethod.GET)
    public ModelAndView addFormModel() {
        ModelAndView modelAndView = new ModelAndView("admin/modelFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/add_model", method = RequestMethod.POST)
    public ModelAndView addModel(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "seatsNumber") int seatsNumber,
                                 @RequestParam(value = "idManufacturer") long idManufacturer) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            insertsDao.addModel(name, seatsNumber, idManufacturer);
            modelAndView.addObject("message", "Dodano rekord");

        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/plane", method = RequestMethod.GET)
    public ModelAndView addFormPlane() {
        ModelAndView modelAndView = new ModelAndView("admin/planeFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/add_plane", method = RequestMethod.POST)
    public ModelAndView addPlane(@RequestParam(value = "register") String register,
                                 @RequestParam(value = "idModel") long idModel,
                                 @RequestParam(value = "idAirline") long idAirline) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            insertsDao.addPlane(register, idModel, idAirline);
            modelAndView.addObject("message", "Dodano rekord");

        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/airport", method = RequestMethod.GET)
    public ModelAndView addFormAirport() {
        ModelAndView modelAndView = new ModelAndView("admin/airportFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/add_airport", method = RequestMethod.POST)
    public ModelAndView addAirport(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "code") String code,
                                   @RequestParam(value = "idCity") long idCity) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            insertsDao.addAirport(name, code, idCity);
            modelAndView.addObject("message", "Dodano rekord");

        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/airline", method = RequestMethod.GET)
    public ModelAndView addFormAirline() {
        ModelAndView modelAndView = new ModelAndView("admin/airlineFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/add_airline", method = RequestMethod.POST)
    public ModelAndView addAirline(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "idCountry") long idCountry) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            insertsDao.addAirline(name, idCountry);
            modelAndView.addObject("message", "Dodano rekord");

        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/flight", method = RequestMethod.GET)
    public ModelAndView addFormFlight() {
        ModelAndView modelAndView = new ModelAndView("admin/flightFormView");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/insert/add_flight", method = RequestMethod.POST)
    public ModelAndView addFlight(@RequestParam(value = "code") String code,
                                  @RequestParam(value = "idPlane") long idPlane,
                                  @RequestParam(value = "idStartAirport") long idStartAirport,
                                  @RequestParam(value = "idStopAirport") long idStopAirport,
                                  @RequestParam(value = "departureTime") Timestamp departureTime,
                                  @RequestParam(value = "arrivalTime") Timestamp arrivalTime) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            insertsDao.addFlight(code, idPlane, idStartAirport, idStopAirport, departureTime, arrivalTime);
            modelAndView.addObject("message", "Dodano rekord");

        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete-user", method = RequestMethod.GET)
    public ModelAndView showUserTable() {
        ModelAndView modelAndView = new ModelAndView("admin/deleteUserView");
        try {
            modelAndView.addObject("elements", userDao.showUsers());
        } catch (DataAccessException e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete-user", method = RequestMethod.POST)
    public ModelAndView deleteUserData(@RequestParam(value = "id_user") long id) {
        ModelAndView modelAndView = new ModelAndView("admin/adminErrorView");
        try {
            userDao.deleteUser(id);
            modelAndView.addObject("message", "Usunięto konto użytkownika, jego rezerwacje i bilety");

        } catch (Exception e) {
            modelAndView = new ModelAndView("admin/adminErrorView");
            modelAndView.addObject("message", "Wystąpił błąd");
        }
        return modelAndView;
    }

}