package kh.edu.istad.springrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiApplication.class, args);
    }

}

/*
 * MVC Patter (Original)
 * Model -> application's data, logic, access to database
 * View ->
 * Controller ->
 * Model (Spring Web MVC)
 * 1. domain -> store application data
 * 2. repository -> access data from database
 * 3. service -> implement logical
 * */
