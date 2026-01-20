package com.teluskoLearning.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

//With Lombok we no need to write getters and setters for every data, The Data
//annotation creates implicitly and with NoArgs and AllArgs we no need to write
//constructor explicitly. It will be handled by Lombok

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}
