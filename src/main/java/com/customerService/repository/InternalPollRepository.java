package com.customerService.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InternalPollRepository {

    private static final String POLL_SERVICE_TABLE_NAME = "poll_service";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void deleteCustomerById(Long customer_id) {
        String sql = "DELETE FROM " + POLL_SERVICE_TABLE_NAME + " WHERE customer_id=?";
        jdbcTemplate.update(sql, customer_id);
    }
}
