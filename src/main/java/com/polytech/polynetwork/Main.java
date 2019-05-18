package com.polytech.polynetwork;

import com.polytech.polynetwork.StoryRepository;
import com.polytech.polynetwork.application.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.net.Socket;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        String hash = new BCryptPasswordEncoder().encode("mdp");
        System.out.println(hash);
        }
    }

