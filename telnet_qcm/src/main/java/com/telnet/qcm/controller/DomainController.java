package com.telnet.qcm.controller;

import com.telnet.qcm.dao.DomainRepository;
import com.telnet.qcm.entities.Domain;
import com.telnet.qcm.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Domain")
public class DomainController {
    @Autowired
    DomainRepository domainRepository;
    @Autowired
    DomainService domainService;

    @RequestMapping(value = ("/allDomain"), method = RequestMethod.GET)
    public List<Domain> getAlldomaines() {
        return domainService.getAllDomain();
    }


    @RequestMapping(value="/addDomain",method= RequestMethod.POST)

    public void saveDomain(@RequestBody Domain domain) {
        domainService.saveDomain(domain);

    }

    @RequestMapping(value="/deleteDomain/{id}",method=RequestMethod.DELETE)
    public void removedomain(@PathVariable("id") Long id) {
        Domain domain = domainService.getdomainbyid(id);
        domainService.removeDomain(id);
    }

    @RequestMapping(value="/updateDomain/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Domain> updateUser(@RequestBody Domain domain, @PathVariable long id) throws ValidationException {
        domain.setId(id);
        if (domain.getName() .isEmpty()) {
            throw new ValidationException("Name is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }

        domainService.saveDomain(domain);
        return (ResponseEntity.ok(domain));

    }



    @RequestMapping(value = ("/onedomaine/{id}"), method = RequestMethod.GET)
    public Domain getQcm(@PathVariable("id") Long id) {
        return domainService.getdomainbyid(id);
    }

}
