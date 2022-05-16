package com.example.testdb;

import com.example.testdb.entity.TestEntity;
import com.example.testdb.manager.TestManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
@Slf4j
public class TestUseCaseImpl implements TestUseCase{

    @Autowired
    private TestManager testManager;

    @Override
    public void test() {
        int dataSize = 200000;

        int numThread = 8;
        List<String> stream = new ArrayList<>(numThread);
        for(int i = 0; i < numThread; i++){
            stream.add(""+i);
        }
        List<TestEntity> data = stream.stream().map(s -> this.genData(dataSize, numThread)).flatMap(Collection::parallelStream).collect(Collectors.toList());
        log.info("data size {}", data.size());
        this.testManager.save(data);
    }

    private List<TestEntity> genData(int datasize, int numThread){
        String val = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<TestEntity> list = new ArrayList<>();
        for(int i = 0; i < datasize/numThread; i++){
            TestEntity data = TestEntity.builder()
                    .column1(val)
                    .column2(val)
                    .column3(val)
                    .column4(val)
                    .column5(val)
                    .column6(val)
                    .column7(val)
                    .column8(val)
                    .build();
            list.add(data);
        }
        return list;

    }
}
