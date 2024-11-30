package com.example.spring_boot_rest;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//If we dont want to use @ResponseBody and we know we are always returning data dont search for view name we can
// also use @RestController

//Now in order to allow request we use CrossOrigin. We are saying allow request for the given urlS
//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    //Whenever we use @Controller it will try to return view resolver means UI so we have to tell spring
    // that we are returning data that why we have use @ResponseBody dont search for the view name
    @GetMapping("jobPosts")
//    @ResponseBody
    public List<JobPost> Alljobs(){
        return service.getAllJob();
    }

    //If we want a data of a particular id
    //We will perform this using two methods,
    //1. We are hardcoding a value
//    @GetMapping("jobPosts/3")
//    public JobPost getJob(){
//        return service.getJob(3);
//    }

//    2nd Making it dynamically
    @GetMapping("jobPosts/{PostId}")
    public JobPost getJob(@PathVariable("PostId") int PostId){
        return service.getJob(PostId);
    }

//    @GetMapping("jobPost/{PostId}")
//    public JobPost getJob(@RequestParam("PostId") int PostId){
//        return service.getJob(PostId);
//    }


    //Sending data to server
    @PostMapping("jobPost")
    public void addJob( @RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }

    //Updating the data
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());   //Whatever we are updating we are fetching that part
    }

    //Deleting the data
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "Deleted";
    }


    //we have created on method to by default save 5 data in service we have created it
    @GetMapping("load")
    public String loadData(){
        service.load();
        return "success";
    }


    //Now what if we want to fetched data by serching some keyword
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }
}
