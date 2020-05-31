package com.telnet.qcm.service;

import com.telnet.qcm.entities.Test;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TestService {

    public List<Test> getAllTests();
    public void saveTest(@RequestBody Test test);
    public void removetest( @PathVariable("id") Long id) ;
    public void updatetest( @PathVariable("id") Long id) ;
    public Test getTestbyid(Long id);
    public Test getTestByName (String name);

}
