package com.teluskoLearning.demo.service;

import com.teluskoLearning.demo.model.JobPost;
import com.teluskoLearning.demo.repo.JobRepo;
import com.teluskoLearning.demo.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    public com.teluskoLearning.demo.repo.JobRepo repo;


    // method to add a jobPost
    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);


    }


    //method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();


    }


    public JobPost getJob(int postId) {
        return repo.getJob(postId);
    }

    public void updateJob(JobPost jobpost) {
        repo.updateJob(jobpost);
    }

    public void deleteJob(int postId) {
        repo.deleteJob(postId);
    }
}