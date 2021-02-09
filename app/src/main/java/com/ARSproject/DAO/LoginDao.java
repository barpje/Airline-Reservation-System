package com.ARSproject.DAO;

import com.ARSproject.exceptions.IncorrectCityException;
import com.ARSproject.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class LoginDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;//temp

    @Autowired
    public LoginDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccount(String email, String password) {
        String sql = "SELECT k.id_konto, k.email, k.haslo from konto k WHERE k.email = ? AND k.haslo =?";
        String sql_p = "SELECT k.rola from konto k WHERE k.email = ? AND k.haslo =?";

        try {
            String role = (String) jdbcTemplate.queryForObject(
                    sql_p, new Object[]{email, password}, String.class);

            Account account = jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{email, password},
                    (rs, rowNum) ->
                            new Account(
                                    rs.getLong("id_konto"),
                                    rs.getString("email"),
                                    rs.getString("haslo")
                            )
            );
            if (role.equals("admin")) account.addAdminAuthority();
            return account;
        } catch (Exception e) {
            return null;
        }
    }

    public Account findAccountByEmail(String email) {
        String sql = "SELECT k.id_konto, k.email, k.haslo from konto k WHERE k.email = ?";

        String sql_p = "SELECT k.rola from konto k WHERE k.email = ?";

        try {
            String role = (String) jdbcTemplate.queryForObject(
                    sql_p, new Object[]{email}, String.class);

            Account account = jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{email},
                    (rs, rowNum) ->
                            new Account(
                                    rs.getLong("id_konto"),
                                    rs.getString("email"),
                                    rs.getString("haslo")
                                    //bCryptPasswordEncoder.encode(rs.getString("haslo"))//zmienic bez encode po dodaniu rejestracji
                            )
            );
            if (role.equals("admin")) account.addAdminAuthority();
            return account;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public long insertAccount(String email, String password) throws DataAccessException {
        String sql = "INSERT INTO konto (email, haslo) VALUES (?,?)";
        String encoded = bCryptPasswordEncoder.encode(password);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(con -> {
                        PreparedStatement ps = con.prepareStatement(sql, new String[]{"id_konto"});
                        ps.setString(1, email);
                        ps.setString(2, encoded);
                        return ps;
                    }
                    , keyHolder);

            return keyHolder.getKey().longValue();
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public long insertPassenger(long id, String name, String surname, String city, String address, String phone, String email) throws DataAccessException, IncorrectCityException {
        String sql = "INSERT INTO pasazer (imie, nazwisko, id_miasto, adres, email, numer_telefonu,id_konto) " +
                "VALUES (?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql_p = "SELECT id_miasto from miasto WHERE miasto.nazwa = ?";
        try {
            long id_city = (long) jdbcTemplate.queryForObject(
                    sql_p, new Object[]{city}, Long.class);

            jdbcTemplate.update(con -> {
                        PreparedStatement ps = con.prepareStatement(sql, new String[]{"id_pasazer"});
                        ps.setString(1, name);
                        ps.setString(2, surname);
                        ps.setLong(3, id_city);
                        ps.setString(4, address);
                        ps.setString(6, phone);
                        ps.setString(5, email);
                        ps.setLong(7, id);
                        return ps;
                    }
                    , keyHolder);

            return keyHolder.getKey().longValue();
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new IncorrectCityException();
        } catch (DataAccessException e) {
            throw e;
        }
    }

}
