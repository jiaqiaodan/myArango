package com.arangodb.spring.demo;
import com.arangodb.spring.demo.DemoApplication;
import com.arangodb.spring.demo.entity.Character;
import com.arangodb.spring.demo.repository.CharacterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class First {

    @Autowired
    private CharacterRepository repository;


    @Test
    public void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("@col","characters");
        map.put("surname","Stark");
        Iterable<Character> older = repository.getWithSurnameOlderThan(12,map);
        older.forEach(System.out::println);

    }
}