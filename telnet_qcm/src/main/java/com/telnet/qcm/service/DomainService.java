package com.telnet.qcm.service;

import com.telnet.qcm.entities.Domain;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DomainService {

    public List<Domain> getAllDomain();
    public void saveDomain(@RequestBody Domain domain);
    public void removeDomain( @PathVariable("id") Long id) ;
    public void updateDomain( @PathVariable("id") Long id) ;
    public Domain getdomainbyid(Long id);
    public Domain findDomainByName (String name);

}
