package com.telnet.qcm.controller;

import com.telnet.qcm.dao.DomainRepository;
import com.telnet.qcm.dao.QcmRepository;
import com.telnet.qcm.entities.Domain;
import com.telnet.qcm.entities.Qcm;
import com.telnet.qcm.service.DomainService;
import com.telnet.qcm.service.QcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Qcm")
public class QcmController {
    @Autowired
    QcmRepository qcmRepository;
    @Autowired
    QcmService qcmService;
    @Autowired
    DomainRepository domainRepository;
    @Autowired
    DomainService domainService;

    @RequestMapping(value = ("/allQcm"), method = RequestMethod.GET)
    public List<Qcm> getAllqcms() {
        return qcmService.getAllqcms();
    }


 /*   @RequestMapping (value=("/QcmByDomain"),method = RequestMethod.GET)
    public List<Qcm> getQcmByDomain(@RequestBody Domain d)
    {
        return qcmRepository.findQcmByDomain(d.getName());
    }

/*
 @Override
    public List<Qcm> findAllByDomain(String domainName) {
        return qcmRepository.findQcmByDomain();}
        @RequestMapping(value="/addUser/{Roleid}",method=RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user, @PathVariable("Roleid")Long id) throws ValidationException {
        Role role =roleservice.getRolebyid(id);
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setRole(role);
        if( user.getFirstname().isEmpty() )
        {
            throw new ValidationException(" Firstname is mondatery ");
        }

        else {
            userService.saveUser(user);
            return (ResponseEntity.ok(user));
        } }
 */

    @RequestMapping(value="/addQcm/{Qcmid}",method= RequestMethod.POST)

    public ResponseEntity<Qcm> saveUser(@RequestBody Qcm qcm, @PathVariable("Qcmid")Long id) throws ValidationException {
        Domain domain =domainService.getdomainbyid(id);
        qcm.setDomain(domain);
        if (qcm.getDesQuestion().isEmpty())
        {
            throw new ValidationException(" Firstname is mondatery ");
        }

  else {
            qcmService.saveQcm(qcm);
            return (ResponseEntity.ok(qcm));
        } }

    @RequestMapping(value="/deleteQcm/{id}",method=RequestMethod.DELETE)
    public void removeqcm(@PathVariable("id") Long id) {
        Qcm qcm = qcmService.getqcmbyid(id);

            qcmService.removeQcm(id);
        }

    @RequestMapping(value="/updateQcm/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Qcm> updateUser(@RequestBody Qcm qcm, @PathVariable long id) throws ValidationException {
        qcm.setId(id);
        if (qcm.getDesQuestion() .isEmpty()) {
            throw new ValidationException("qcm description is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        if (qcm.getRequiredTime().isEmpty()) {
            throw new ValidationException("Time is mondatery");
            // return (HttpStatus.NOT_FOUND);
        }
            qcmService.saveQcm(qcm);
        return (ResponseEntity.ok(qcm));

        }



    @RequestMapping(value = ("/oneQcm/{id}"), method = RequestMethod.GET)
    public Qcm getQcm(@PathVariable("id") Long id) {
        return qcmService.getqcmbyid(id);
    }






}








