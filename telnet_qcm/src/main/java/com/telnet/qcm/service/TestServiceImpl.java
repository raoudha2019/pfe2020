package com.telnet.qcm.service;

import com.telnet.qcm.dao.QcmJRepository;
import com.telnet.qcm.dao.TestRepository;
import com.telnet.qcm.entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("testservice")
public class TestServiceImpl implements TestService {
    @Autowired
    TestRepository testRepository;
    @Autowired
    QcmJRepository qcmJRepository;


    @Override
    public List<Test> getAllTests() {
        return  testRepository.findAll();
    }

    @Override
    public void saveTest(Test test) {
        testRepository.save(test);
    }

    @Override
    public void removetest(Long id) {
        Test test = testRepository.getOne(id);
        testRepository.delete(test);
    }

    @Override
    public void updatetest(Long id) {

    }

    @Override
    public Test getTestbyid(Long id) {
        return testRepository.getOne(id);
    }

    @Override
    public Test getTestByName(String name) {
        return null;
    }
}
