package com.example.testdb.manager;

import com.example.testdb.entity.TestEntity;
import com.example.testdb.repo.TestRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TestManagerImpl implements TestManager{
    private TestRepository  testRepository;



    @Override
    @Transactional
    public void save(List<TestEntity> entities) {
        log.info("save");
        List<List<TestEntity>> block = Lists.partition(entities, 10000);
        block.forEach(b ->{
            this.testRepository.saveAll(b);
        });
//        this.testRepository.saveAll(entities);
    }





}
