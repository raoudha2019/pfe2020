package com.telnet.qcm.service;

import com.telnet.qcm.entities.Qcm;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QcmService {
    public List<Qcm> getAllqcms();
    public void saveQcm(@RequestBody Qcm qcm);
    public void removeQcm( @PathVariable("id") Long id) ;
    public void updateQcm( @PathVariable("id") Long id) ;
    public Qcm getqcmbyid(Long id);
   // public Qcm getqcmbyQustion (String question);
   // public  List<Qcm> findAllByDomain(String domainName);

}
