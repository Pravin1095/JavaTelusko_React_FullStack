package com.teluskoLearning.demo;

import com.teluskoLearning.demo.model.JobPost;
import com.teluskoLearning.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//The Controller annotation defaultly goes to viewResolver to fetch JSP eventhough we
//do not want it to be resolved. Hence when returning JSON data add an annotation
//@ResponseBody

//Also if we do not want to add ResponseBody annotation each time we can give
//@RestController at top instead of controller now it returns JSON data by default

//CrossOrigin allows the request coming from the url that we pass to the annotation

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    @Autowired
    JobService service;

    @GetMapping("jobPosts")  //jobPosts is the request url for which get method is called
    public List<JobPost> getAllJobs(){
       return service.getAllJobs();
   }


   //@PathVariable receives the pathVariable that we pass in request url

   @GetMapping("jobPosts/{postId}")
   public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
   }

   @PostMapping("jobPosts")
    public JobPost addJob(@RequestBody JobPost jobpost){
        service.addJob(jobpost);
        return service.getJob(jobpost.getPostId());
   }

   @PutMapping("jobPosts")
   public JobPost updateJob(@RequestBody JobPost jobpost){
        service.updateJob(jobpost);
        return service.getJob(jobpost.getPostId());
   }

   @DeleteMapping("jobPosts/{postId}")
   public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "Deleted";
   }
}

