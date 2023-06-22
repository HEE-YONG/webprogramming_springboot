package com.example.webprogramming_springboot.dao;

import com.example.webprogramming_springboot.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ScoreDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void record(Score score) {
        String createScoreQuery = "insert into score(" +
                "name, " +
                //"score, " +
                "location) VALUES (?,?)"; // 실행될 동적 쿼리문
        Object[] createScoreParams = new Object[]{
                score.getName(),
                //score.getScore(),
                score.getLocation()}; // 동적 쿼리의 ?부분에 주입될 값
        this.jdbcTemplate.update(createScoreQuery, createScoreParams);

    }
    public List<Score> getScore(String location) {
        String getScoreQuery = "SELECT * FROM score WHERE location = ? ORDER BY CAST(score AS DECIMAL) DESC";
        String getScoreParams = location;
        return this.jdbcTemplate.query(getScoreQuery,
                (rs, rowNum) -> new Score(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("score"),
                        rs.getString("location")),
                getScoreParams);
    }

}
