package com.example.spring_boot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data    //Using this we dont have to write getter and setter, toString method
@NoArgsConstructor   //Annotation for default constructor
@AllArgsConstructor   //Annotation for arguement constructor
@Component   //I want to use this in other classes

@Entity
public class JobPost {

    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}
