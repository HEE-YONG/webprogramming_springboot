package com.example.webprogramming_springboot.service;

import com.example.webprogramming_springboot.dao.ScoreDao;
import com.example.webprogramming_springboot.entity.Score;
import com.example.webprogramming_springboot.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ScoreDao scoreDao;

    public String record(Score score){
        //scoreDao.record(score);
        scoreRepository.save(score);
        return "";
    }

    public List<Score> scoreList(String location){
        List<Score> scoreRes = scoreDao.getScore(location);
        if(scoreRes.size()>5){
            scoreRes=scoreRes.subList(0,5);
        }
        return scoreRes;
    }

}
