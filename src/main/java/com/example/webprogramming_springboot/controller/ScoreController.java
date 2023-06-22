package com.example.webprogramming_springboot.controller;

import com.example.webprogramming_springboot.entity.Score;
import com.example.webprogramming_springboot.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ScoreController {
//    @GetMapping("")
//    public String indexpage(){
//        return "index";
//    }
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/recordpro")
    public String scoreRecordPro(Score score){
//        System.out.println(score.getName());
//        System.out.println(score.getScore());
//        System.out.println(score.getLocation());
        String location = score.getLocation();
        scoreService.record(score);
        return "redirect:/score/list?"+"location="+location;
    }


    @GetMapping("/score/list")
    public String scoreList(Model model,@RequestParam(required = false)String location) {
        model.addAttribute("list", scoreService.scoreList(location));
        return "scorelist";
    }


}
