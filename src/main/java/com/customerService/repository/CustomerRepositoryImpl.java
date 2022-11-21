package com.customerService.repository;

import com.customerService.model.Customer;
import com.customerService.repository.mapper.CustomerMapper;
import com.customerService.repository.redis.CacheRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createCustomer(Customer customer) {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " (first_name, last_name, email, age, address, joining_date) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getAge(),customer.getAddress(),customer.getJoiningDate());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateCustomerById(Long customerId, Customer customer) {
        String sql = "UPDATE " + CUSTOMER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, age=?, address=?,joining_date=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(),customer.getAge(),customer.getAddress(),customer.getJoiningDate(), customerId);
    }

    @Override
    public void deleteCustomerById(Long id) {
        System.out.println("in repository");
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
        System.out.println("in repository after delete");
    }

    @Override
    public Customer getCustomerById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE first_name=?";
        try {
            return jdbcTemplate.query(sql, new CustomerMapper(), firstName);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new CustomerMapper());
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Long> getCustomerIdsByFirstName(String firstName) {
        String sql = "SELECT c.id FROM " + CUSTOMER_TABLE_NAME + " AS c WHERE c.first_name = ?";
        try {
            return jdbcTemplate.queryForList(sql, Long.class, firstName);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}
