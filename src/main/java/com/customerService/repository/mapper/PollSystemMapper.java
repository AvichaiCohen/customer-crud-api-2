package com.customerService.repository.mapper;

import com.customerService.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollSystemMapper implements RowMapper<PollSystem> {

    @Override
    public PollSystem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PollSystem(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                PollSystemFirstQuestion.valueOf(rs.getString("first_question")),
                PollSystemSecondQuestion.valueOf(rs.getString("second_question")),
                PollSystemThirdQuestion.valueOf(rs.getString("third_question")),
                PollSystemFourthQuestion.valueOf(rs.getString("fourth_question"))
        );
    }
}