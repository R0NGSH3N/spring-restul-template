package com.r0ngsh3n.restful.template.repository;

import com.r0ngsh3n.restful.template.model.Item;
import com.r0ngsh3n.restful.template.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository{

    private static final String SELECT_USER_WITH_ITEMS = "Select * FROM item WHERE id in (SELECT items_id FROM user_items WHERE user_id = ?)";
    private static final String SELECT_USER = "Select * FROM user WHERE id = ?";
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findUserAndItemsWithUserId(Long userId) {
        User linkedUser = jdbcTemplate.queryForObject(SELECT_USER, new Object[]{userId},
                (rs,rowNum) ->{
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    return user;
                });
        List<Item> items = jdbcTemplate.query(SELECT_USER_WITH_ITEMS, new Object[]{userId},
                (rs, rowNum) -> {
                    Item item = new Item();
                    item.setId(rs.getLong("id"));
                    item.setName(rs.getString("name"));
                    item.setProvider(rs.getString("provider"));
                    item.setUnitPrice(rs.getBigDecimal("price"));
                    return item;
                } );

        linkedUser.setItems(items);
        return linkedUser;
    }

}
