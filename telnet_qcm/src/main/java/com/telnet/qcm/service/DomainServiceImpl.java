package com.telnet.qcm.service;

import com.telnet.qcm.dao.DomainRepository;
import com.telnet.qcm.dao.QcmRepository;
import com.telnet.qcm.entities.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DomainService")
public class DomainServiceImpl implements DomainService {

    @Autowired
    DomainRepository domainRepository;
    @Autowired
    QcmRepository qcmRepository;

    @Override
    public List<Domain> getAllDomain() {
        return domainRepository.findAll()   ;
    }

    @Override
    public void saveDomain(Domain domain) {

        domainRepository.save(domain);

    }

    @Override
    public void removeDomain(Long id) {

        Domain domain=domainRepository.getOne(id);
        domainRepository.delete(domain);

    }

    @Override
    public void updateDomain(Long id) {

    }

    @Override
    public Domain getdomainbyid(Long id) {
        return domainRepository.getOne(id);
    }

    @Override
    public Domain findDomainByName(String name) {
        return domainRepository.findDomainByName(name);
    }
}
