package com.ARSproject.DAO;

import com.ARSproject.wrappers.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UserWrapper> showUsers() throws DataAccessException {
        String sql = "SELECT\n" +
                "  k.id_konto,\n" +
                "  k.email,\n" +
                "  p.imie,\n" +
                "  p.nazwisko,\n" +
                "  COUNT (DISTINCT r.id_rezerwacja) AS liczba_rezerwacji\n" +
                "\n" +
                "FROM\n" +
                "  konto k\n" +
                "  LEFT JOIN pasazer p ON k.id_konto = p.id_konto\n" +
                "  LEFT JOIN rezerwacja r ON r.id_konto = k.id_konto\n" +
                "  WHERE k.rola = 'user'\n" +
                "  GROUP BY p.nazwisko, k.id_konto,p.imie\n" +
                "  ORDER BY p.nazwisko;";
        try {
            return jdbcTemplate.query(
                    sql,
                    new Object[]{},
                    (rs, rowNum) ->
                            new UserWrapper(
                                    rs.getLong("id_konto"),
                                    rs.getString("email"),
                                    rs.getString("imie"),
                                    rs.getString("nazwisko"),
                                    rs.getInt("liczba_rezerwacji")
                            )
            );
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void deleteUser(long id) throws Exception {
        try {
            final SimpleJdbcCall updateEmployeeCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("usun_uzytkownika_i_dane");
            final Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            updateEmployeeCall.execute(params);
        } catch (Exception e) {
            throw e;
        }
    }
}
