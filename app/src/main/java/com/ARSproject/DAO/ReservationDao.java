package com.ARSproject.DAO;


import com.ARSproject.wrappers.ReservationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ReservationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void makeReservation(long id_flight, String klasa) throws Exception {
        Date date = new Date();
        Object p = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) p).getUsername();

        String sql_p = "SELECT id_konto from konto WHERE konto.email = ?";
        long id_acc = (long) jdbcTemplate.queryForObject(
                sql_p, new Object[]{username}, Long.class);

        String sql = "INSERT INTO rezerwacja(id_konto, status, data) VALUES(?, ?, CAST(? as TIMESTAMP))";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        long t = date.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);

        jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(sql, new String[]{"id_rezerwacja"});
                    ps.setLong(1, id_acc);
                    ps.setString(2, "Potwierdzona");
                    ps.setTimestamp(3, sqlTimestamp);
                    return ps;
                }
                , keyHolder);
        long id_res = keyHolder.getKey().longValue();
        String sql_b = "INSERT INTO bilet(id_lot, id_rezerwacja, klasa_podrozy) VALUES(?, ?, ?)";
        jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(sql_b, new String[]{"id_rezerwacja"});
                    ps.setLong(1, id_flight);
                    ps.setLong(2, id_res);
                    ps.setString(3, klasa);
                    return ps;
                }
                , keyHolder);
        // long id_bilet =  keyHolder.getKey().longValue();
    }

    public List<ReservationWrapper> showReservations() throws Exception {
        Object p = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) p).getUsername();

        String sql = "SELECT\n" +
                "  r.id_rezerwacja,\n" +
                "  l.id_lot,\n" +
                "  l.kod_lotu,\n" +
                "  sl.nazwa as nazwaSA,\n" +
                "  el.nazwa as nazwaEA,\n" +
                "  l.czas_odlotu,\n" +
                "  p.imie,\n" +
                "  p.nazwisko,\n" +
                "  r.status,\n" +
                "  b.klasa_podrozy,\n" +
                "  r.data\n" +
                "\n" +
                "FROM\n" +
                "  konto k\n" +
                "  JOIN pasazer p ON p.id_konto = k.id_konto\n" +
                "  JOIN rezerwacja r ON r.id_konto = k.id_konto\n" +
                "  JOIN bilet b ON b.id_rezerwacja = r.id_rezerwacja\n" +
                "  JOIN lot l ON l.id_lot = b.id_lot\n" +
                "  JOIN lotnisko sl  ON l.id_lotnisko_odlotu = sl.id_lotnisko\n" +
                "  JOIN lotnisko el  ON l.id_lotnisko_przylotu = el.id_lotnisko\n" +
                "  WHERE\n" +
                "\tk.email = ?\n" +
                "ORDER BY r.data;\n";

        return jdbcTemplate.query(
                sql,
                new Object[]{username},
                (rs, rowNum) ->
                        new ReservationWrapper(
                                rs.getLong("id_rezerwacja"),
                                rs.getLong("id_lot"),
                                rs.getString("kod_lotu"),
                                rs.getString("nazwaSA"),
                                rs.getString("nazwaEA"),
                                rs.getTimestamp("czas_odlotu"),
                                rs.getString("imie"),
                                rs.getString("nazwisko"),
                                rs.getString("status"),
                                rs.getString("klasa_podrozy"),
                                rs.getTimestamp("data")

                        )
        );
    }

    public void addTicketToReservation(long idReservation, long idFlight, String travelClass) throws Exception {
        String sql_b = "INSERT INTO bilet(id_lot, id_rezerwacja, klasa_podrozy) VALUES(?, ?, ?)";
        String klasa = travelClass.equals("ECONOMIC") ? "Ekonomiczna" : "Biznesowa";
        jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(sql_b, new String[]{"id_rezerwacja"});
                    ps.setLong(1, idFlight);
                    ps.setLong(2, idReservation);
                    ps.setString(3, klasa);
                    return ps;
                }
        );
    }
}
