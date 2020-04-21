package com.telnet.qcm.service;

import com.telnet.qcm.dao.QcmRepository;
import com.telnet.qcm.dao.AnswerRepository;
import com.telnet.qcm.entities.Qcm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("qcmservice")
public class QcmServiceImpl implements QcmService {

    @Autowired
    QcmRepository qcmRepository;
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<Qcm> getAllqcms() {
        return qcmRepository.findAll();
    }

    @Override
    public void saveQcm(Qcm qcm) {
        qcmRepository.save(qcm);
    }

    @Override
    public void removeQcm(Long id) {

        Qcm qcm =qcmRepository.getOne(id);
        qcmRepository.delete(qcm);
    }

    @Override
    public void updateQcm(Long id) {
    }

    @Override
    public Qcm getqcmbyid(Long id) {
        return qcmRepository.getOne(id);
    }

   /* @Override
    public Qcm getqcmbyQustion(String question) {
        return (Qcm) qcmRepository.findQcmByDomain(question);
    }

*/

}
