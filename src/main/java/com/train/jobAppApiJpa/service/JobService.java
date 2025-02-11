package com.train.jobAppApiJpa.service;

import com.train.jobAppApiJpa.model.JobPost;
import com.train.jobAppApiJpa.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }


    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "java developer", "text1", 2, List.of("java", "spring")),
                new JobPost(2, "python developer", "text2", 3, List.of("python", "django")),
                new JobPost(3, "react developer", "text3", 3, List.of("react")),
                new JobPost(4, "php developer", "text4", 3, List.of("laravel")),
                new JobPost(5, "c# developer", "text5", 3, List.of(".net", "asp"))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
