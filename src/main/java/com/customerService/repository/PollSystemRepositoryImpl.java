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
    public void createPollSystem(PollSystem pollSystem) throws Exception {
        String sql = "INSERT INTO " + CUSTOMER_ORDER_TABLE_NAME + " (customer_id,first_question,second_question,third_question,fourth_question ) VALUES (?, ?, ?, ?,?)";
        jdbcTemplate.update(sql, pollSystem.getCustomerId(), pollSystem.getFirstQuestion(),pollSystem.getSecondQuestion(),pollSystem.getThirdQuestion(),pollSystem.getFourthQuestion());
    }

    @Override
    public void updatePollSystemById(Long pollSystemId, PollSystem pollSystem) throws Exception {
        String sql = "UPDATE " + CUSTOMER_ORDER_TABLE_NAME + " SET customer_id=?, first_question=?, second_question=?, third_question=?, fourth_question=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql, pollSystem.getCustomerId(), pollSystem.getFirstQuestion(),pollSystem.getSecondQuestion(),pollSystem.getThirdQuestion(),pollSystem.getFourthQuestion(), pollSystemId);
    }

    @Override
    public void deletePollSystemById(Long id) throws Exception {
        String sql = "DELETE FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public PollSystem getPollSystemById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new PollSystemMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<PollSystem> getPollSystemByCustomerId(Long customerId) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE customer_id=?";
        try {
            return jdbcTemplate.query(sql, new PollSystemMapper(), customerId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}