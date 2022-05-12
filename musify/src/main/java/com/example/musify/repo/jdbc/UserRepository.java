package com.example.musify.repo.jdbc;

import com.example.musify.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public List<User> getALlUSers() {

        return jdbcTemplate.query("Select * from users ;",
                (rs, rowNum) ->
                        new User(rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("country"),
                                rs.getString("role")
                        ));

    }

    public List<User> getUserById(int id) {
        // User u=null;
        // return jdbcTemplate.queryForObject("Select * from users where idusers=?;", new Object[]{id},User.class);
        return jdbcTemplate.query("Select * from users where id=?;", new Object[]{id},
                (rs, rowNum) ->
                        new User(rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("country"),
                                rs.getString("role")
                        ));

    }

    public List<User> getUserByEmailPassword(String email, String password) {
        // User u=null;
        // return jdbcTemplate.queryForObject("Select * from users where idusers=?;", new Object[]{id},User.class);
        return jdbcTemplate.query("Select * from users where email=? and password=?;", new Object[]{email, password},
                (rs, rowNum) ->
                        new User(rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("country"),
                                rs.getString("role")
                        ));

    }

    public List<User> getUserByEmail(String email) {
        // User u=null;
        // return jdbcTemplate.queryForObject("Select * from users where idusers=?;", new Object[]{id},User.class);
        return jdbcTemplate.query("Select * from users where email=? ;", new Object[]{email},
                (rs, rowNum) ->
                        new User(rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("country"),
                                rs.getString("role")
                        ));

    }

    public void insertUser(User user) {
        jdbcTemplate.update("insert into users(first_name,last_name, email, password,country,role) values (?,?,?,?,?,?);", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getCountry(), user.getRole());
    }

    public void updateUser(User user) {
        jdbcTemplate.update("update users set first_name=?, last_name=?,password=?,country=?,role=?,email=? where id=?;", user.getFirstName(), user.getLastName(), user.getPassword(), user.getCountry(), user.getRole(), user.getEmail(), user.getId());
    }

    public void deleteUser(User user) {
        jdbcTemplate.update("delete from users where id=?;", user.getId());
    }
}
