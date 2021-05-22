package ru.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.models.User;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;
    private static int USERS_COUNT;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User show(int id) {
        return jdbcTemplate.query("SELECT * FROM User WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO User VALUES(++USERS_COUNT, ?, ?, ?)", user.getName(), user.getSurname(),
                user.getEmail());
    }

    public void update(int id, User updatedUser) {
        jdbcTemplate.update("UPDATE Person SET name=?, surname=?, email=? WHERE id=?", updatedUser.getName(),
                updatedUser.getSurname(), updatedUser.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
