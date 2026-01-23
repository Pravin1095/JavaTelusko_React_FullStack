package com.teluskoLearning.demo.repo;

import com.teluskoLearning.demo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//The first field next to JPARepository is the Java object for which we want
//to store data, second is the type of field of Primary key in JobPost which is PostId
@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    //DSL is a powerful concept in Java that is in JpaRepository used to create method like below and access without writing any business logic
    //It generates business logic from the name that we have provided

List <JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
//    // ArrayList to store JobPost objects
//    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//
//            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//
//
//            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
//                    List.of("HTML", "CSS", "JavaScript", "React")),
//
//
//            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                    List.of("Python", "Machine Learning", "Data Analysis")),
//
//
//            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
//                    List.of("Networking", "Cisco", "Routing", "Switching")),
//
//
//            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
//                    List.of("iOS Development", "Android Development", "Mobile App"))
//    ));
//
//    // method to return all JobPosts
//    public List<JobPost> getAllJobs() {
//        return jobs;
//    }
//
//    // method to save a job post object into arrayList
//    public void addJob(JobPost job) {
//        jobs.add(job);
//        System.out.println("AddedJobs "+jobs);
//
//    }
//
//
//    public JobPost getJob(int id) {
//
//        for(JobPost job : jobs){
//            if(job.getPostId()==id){
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost jobpost) {
//        for(JobPost jobpost1 : jobs){
//            if(jobpost1.getPostId()==jobpost.getPostId()){
//                jobpost1.setPostProfile(jobpost.getPostProfile());
//                jobpost1.setPostDesc(jobpost.getPostDesc());
//                jobpost1.setReqExperience(jobpost.getReqExperience());
//                jobpost1.setPostTechStack(jobpost.getPostTechStack());
//            }
//        }
//    }
//
//
//    //If we are using normal forEach for removal of elment it throws ConcurrentModification
//    //Error, which means the following definition, Java collections use a fail-fast iterator.
//    //Iterator keeps a modCount
//    //If list structure changes (add/remove) during iteration
//    //Java throws ConcurrentModificationException
//
//    public void deleteJob(int id) {
//        Iterator<JobPost> it = jobs.iterator();
//
//        while (it.hasNext()) {
//            JobPost job = it.next();
//            if (job.getPostId() == id) {
//                it.remove();
//            }
//        }
//    }
//    }
