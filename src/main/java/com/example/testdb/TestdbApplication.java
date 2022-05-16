package com.example.testdb;

import com.example.testdb.manager.TestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestdbApplication {



    public static void main(String[] args) {
        SpringApplication.run(TestdbApplication.class, args);
        T t = new T();
        t.test();
    }



}

class T{
    @Autowired
    TestUseCase  testUseCase;
    void test(){
        testUseCase.test();
    }
}
