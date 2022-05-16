package com.example.testdb.manager;

import com.example.testdb.entity.TestEntity;

import java.util.List;

public interface TestManager {


    void save(List<TestEntity> entities);
}
