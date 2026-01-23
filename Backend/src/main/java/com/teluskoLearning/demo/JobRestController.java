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


    //Our Java Objects are sent as JSON to the client, this is done by a library
    //jackson, this converts the Java objects that we return in the method to a
    //JSON format. There is also another library jackson-xml which can convert
    //our Java objects to XML , so if we have both libraries installed and we
    //want only JSON to be sent we can add produces={application/json}, this
    //ensures only json is sent to the client

    //Similary there is consumes that we can have in PostMapping so that it accepts
    //the body only the format that we mention in consumes. If we mention "application/xml"
    //we can send body only in that format and application/json, it accepts only
    //application/json
    @GetMapping(path="jobPosts", produces = {"application/json"})  //jobPosts is the request url for which get method is called
    public List<JobPost> getAllJobs(){
       return service.getAllJobs();
   }


   //@PathVariable receives the pathVariable that we pass in request url

   @GetMapping("jobPosts/{postId}")
   public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
   }

   @GetMapping("/jobPosts/keyword/{keyword}")
   public List<JobPost> search(@PathVariable("keyword") String keyword){
return service.search(keyword);
   }

   @PostMapping(path="jobPosts", consumes={"application/json"})
    public JobPost addJob(@RequestBody JobPost jobpost){
        service.addJob(jobpost);
        return service.getJob(jobpost.getPostId());
   }

   @PutMapping("jobPosts" )
   public JobPost updateJob(@RequestBody JobPost jobpost){
        service.updateJob(jobpost);
        return service.getJob(jobpost.getPostId());
   }

   @DeleteMapping("jobPosts/{postId}")
   public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "Deleted";
   }

   @GetMapping("load")
   public String loadData(){
        service.loadData();
        return "Success";
   }
}

