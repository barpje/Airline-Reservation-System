package com.ARSproject.controller;

import com.ARSproject.DAO.LoginDao;
import com.ARSproject.exceptions.IncorrectCityException;
import com.ARSproject.models.Account;
import com.ARSproject.service.SecurityService;
import com.ARSproject.utils.ReservationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    LoginDao userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView logger(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        try {
            //true if user is an admin
            if (securityService.login(email, password)) {
                ModelAndView modelAndView = new ModelAndView("adminView");
                modelAndView.addObject("message", "Uzyskano dostęp admina");
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("loggedView");
                modelAndView.addObject("message", "Zostałeś zalogowany, witamy");
                return modelAndView;
            }
        } catch (UsernameNotFoundException e) {
            ModelAndView modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Nie znaleziono użytkownika");
            return modelAndView;
        } catch (BadCredentialsException e) {
            ModelAndView modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Błędne hasło");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/user/flights/form", method = RequestMethod.GET)
    public ModelAndView searchLoggedFlights() {
        ModelAndView modelAndView = new ModelAndView("flightsFormLoggedView");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView regger(@RequestParam(value = "email") String email,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "surname") String surname,
                               @RequestParam(value = "city") String city,
                               @RequestParam(value = "address") String address,
                               @RequestParam(value = "phone") String phone) {
        if (!ReservationUtil.checkData(email, password, name, surname, address, phone)) {
            ModelAndView modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Podano niepoprawne dane, spróbuj jeszcze raz");
            return modelAndView;
        }
        try {
            Account acc = userRepository.findAccountByEmail(email);
            if (acc != null) {
                ModelAndView modelAndView = new ModelAndView("errorView");
                modelAndView.addObject("message", "Użytkownik o podanym email już istnieje");
                return modelAndView;
            } else {
                long id = userRepository.insertAccount(email, password);
                long id_passenger = userRepository.insertPassenger(id, name, surname, city, address, phone, email);
                ModelAndView modelAndView = new ModelAndView("errorView");
                modelAndView.addObject("message", "Rejestracja udana");
                return modelAndView;
            }
        } catch (IncorrectCityException e) {
            ModelAndView modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Podanego miasta nie ma w bazie");
            return modelAndView;
        } catch (DataAccessException e) {
            ModelAndView modelAndView = new ModelAndView("errorView");
            modelAndView.addObject("message", "Wystąpił błąd");
            return modelAndView;
        }
    }
}
