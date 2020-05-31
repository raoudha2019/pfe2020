package com.telnet.qcm.controller;

import com.telnet.qcm.entities.Domain;
import com.telnet.qcm.entities.Qcm11;
import com.telnet.qcm.entities.QcmJ;
import com.telnet.qcm.service.DomainService;
import com.telnet.qcm.service.QcmJService;
import com.telnet.qcm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/QcmJ")

public class QcmController {

    @Autowired
    QcmJService qcmJService;
    @Autowired
    DomainService domainService;
    @Autowired
    TestService testService ;

    @RequestMapping(value = ("/allQcm"), method = RequestMethod.GET)
    public List<QcmJ> getAllqcmsJ() {
        return qcmJService.getAllqcmsJ();
    }


  @RequestMapping(value = ("/oneQcmJ/{id}"), method = RequestMethod.GET)
    public QcmJ getQcm(@PathVariable("id") Long id)
    {
        return qcmJService.getqcmbyid(id);
    }




  @RequestMapping(value = "/addQcmJ/{domainId}", method = RequestMethod.POST)
  public ResponseEntity<Qcm11> saveQcmJ(@RequestBody Qcm11 qcm, @PathVariable("domainId") Long id) throws ValidationException {
      Domain domain = domainService.getdomainbyid(id);
      qcm.setDomain(domain);


      QcmJ qcmToCreate = new QcmJ();
      //  qcmToCreate.setDomain(domain);
      qcmToCreate.setSubDomain(qcm.getSubDomain());
      qcmToCreate.setTitle(qcm.getTitle());
      qcmToCreate.setQuestionBody(qcm.getQuestionBody());
      qcmToCreate.setDomain(qcm.getDomain());
      if (qcm.getSubDomain().isEmpty()) {
          throw new ValidationException(" SubDomain is mondatery ");
          // return (HttpStatus.NOT_FOUND);
      }
      if (qcm.getTitle().isEmpty()) {
          throw new ValidationException(" title is mondatery ");
          // return (HttpStatus.NOT_FOUND);
      }
      if (qcm.getQuestionBody() == null ) {
          throw new ValidationException(" question_Body is mondatery ");
          // return (HttpStatus.NOT_FOUND);
      }

      else {
      qcmJService.saveQcmJ(qcmToCreate);
      return (ResponseEntity.ok(qcm));}
  }





    @RequestMapping(value = "/deleteQcmJ/{id}", method = RequestMethod.DELETE)
    public void removeqcmJ(@PathVariable("id") Long id) {
        QcmJ qcm = qcmJService.getqcmbyid(id);
        qcmJService.removeQcmJ(id);
    }
    @RequestMapping(value = "/updateQcm/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Qcm11> updateQcmJ(@RequestBody Qcm11 qcm, @PathVariable long id) throws com.telnet.qcm.exception.ValidationException {

        qcm.setId(id);
        QcmJ qcmToCreate = new QcmJ();
        //  qcmToCreate.setDomain(domain);
        qcmToCreate.setSubDomain(qcm.getSubDomain());

        qcmToCreate.setTitle(qcm.getTitle());
        qcmToCreate.setQuestionBody(qcm.getQuestionBody());
        qcmToCreate.setDomain(qcm.getDomain());
        qcmJService.saveQcmJ(qcmToCreate);
        return (ResponseEntity.ok(qcm));
    }
    @RequestMapping(value="/getqcms/{domainid}",method=RequestMethod.GET)
    public List<QcmJ> getQcms(@PathVariable("domainid")Long id) {
        Domain domain = domainService.getdomainbyid(id);
        return domain.getQcmJ() ;

    }
}