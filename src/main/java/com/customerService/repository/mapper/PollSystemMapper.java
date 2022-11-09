package com.customerService.repository.mapper;

import com.customerService.model.PollSystem;
import com.customerService.model.PollSystemCurrency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollSystemMapper implements RowMapper<PollSystem> {

    @Override
    public PollSystem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PollSystem(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getString("item_name"),
                rs.getLong("price"),
                PollSystemCurrency.valueOf(rs.getString("currency"))
        );
    }
}