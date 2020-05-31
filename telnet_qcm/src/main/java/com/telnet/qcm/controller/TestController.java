package com.telnet.qcm.controller;


import com.telnet.qcm.entities.Test;
import com.telnet.qcm.exception.ValidationException;
import com.telnet.qcm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Test")
public class TestController {

    @Autowired
    TestService testService;


    @RequestMapping(value = ("/allTests"), method = RequestMethod.GET)
    public List<Test> getAllTests() {
        return testService.getAllTests();
    }


    @RequestMapping(value = "/addTest", method = RequestMethod.POST)
    public ResponseEntity<Test> saveRolee(@RequestBody Test test) throws ValidationException {
    /*    if (role.getName().isEmpty()) {
            throw new ValidationException("Role name is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        if (role.getPermissions().isEmpty()) {
            throw new ValidationException("Role Permission is mondatery");
            // return (HttpStatus.NOT_FOUND);
        }
        Role rolee = roleservice.getRoleByName(role.getName());

        if (rolee != null) {
            throw new ValidationException("Role alredy exist");
            // return (HttpStatus.NOT_FOUND);
        }*/

        testService.saveTest(test);

        return (ResponseEntity.ok(test));
    }
}
