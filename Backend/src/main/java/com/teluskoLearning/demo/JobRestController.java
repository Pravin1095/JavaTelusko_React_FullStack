package com.teluskoLearning.demo;

import com.teluskoLearning.demo.model.JobPost;
import com.teluskoLearning.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//The Controller annotation defaultly goes to viewResolver to fetch JSP eventhough we
//do not want it to be resolved. Hence when returning JSON data add an annotation
//@ResponseBody

//Also if we do not want to add ResponseBody annotation each time we can give
//@RestController at top instead of controller now it returns JSON data by default


@RestController
public class JobRestController {

    @Autowired
    JobService service;

    @GetMapping("jobPosts")  //jobPosts is the request url for which get method is called
    public List<JobPost> getAllJobs(){
       return service.getAllJobs();
   }
}

