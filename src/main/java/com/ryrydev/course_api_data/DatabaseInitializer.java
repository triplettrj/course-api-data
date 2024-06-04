package com.ryrydev.course_api_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import com.ryrydev.course_api_data.entity.Topic;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DatabaseInitializer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initialize() {
        dropTablesIfExist();
        executeSqlScript("classpath:schema.sql");
        executeSqlScript("classpath:data.sql");
        verifyDataInsertion();
    }

    private void dropTablesIfExist() {
        try {
            jdbcTemplate.execute("DROP TABLE courses");
        } catch (Exception e) {
            // Log the exception or handle it if necessary
        }
        try {
            jdbcTemplate.execute("DROP TABLE topics");
        } catch (Exception e) {
            // Log the exception or handle it if necessary
        }
    }

    private void executeSqlScript(String scriptPath) {
        Resource resource = resourceLoader.getResource(scriptPath);
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

    private void verifyDataInsertion() {
        List<Topic> topics = jdbcTemplate.query("SELECT * FROM topics", new RowMapper<Topic>() {
            @Override
            public Topic mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
                Topic topic = new Topic();
                topic.setId(rs.getString("id"));
                topic.setName(rs.getString("name"));
                topic.setDescription(rs.getString("description"));
                return topic;
            }
        });

        topics.forEach(topic -> System.out.println("Inserted topic: " + topic));
    }
}
