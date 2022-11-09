package com.customerService.repository;
import com.customerService.model.PollSystem;
import com.customerService.repository.mapper.PollSystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PollSystemRepositoryImpl implements PollSystemRepository {

    private static final String CUSTOMER_ORDER_TABLE_NAME = "customer_order";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createCustomerOrder(PollSystem pollSystem) throws Exception {
        String sql = "INSERT INTO " + CUSTOMER_ORDER_TABLE_NAME + " (customer_id, item_name, price, currency) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, pollSystem.getCustomerId(), pollSystem.getItemName(), pollSystem.getPrice(), pollSystem.getCurrency().name());
    }

    @Override
    public void updateCustomerOrderById(Long customerOrderId, PollSystem pollSystem) throws Exception {
        String sql = "UPDATE " + CUSTOMER_ORDER_TABLE_NAME + " SET customer_id=?, item_name=?, price=?, currency=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql, pollSystem.getCustomerId(), pollSystem.getItemName(), pollSystem.getPrice(), pollSystem.getCurrency().name(), customerOrderId);
    }

    @Override
    public void deleteCustomerOrderById(Long id) throws Exception {
        String sql = "DELETE FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public PollSystem getCustomerOrderById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new PollSystemMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<PollSystem> getCustomerOrdersByCustomerId(Long customerId) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE customer_id=?";
        try {
            return jdbcTemplate.query(sql, new PollSystemMapper(), customerId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}