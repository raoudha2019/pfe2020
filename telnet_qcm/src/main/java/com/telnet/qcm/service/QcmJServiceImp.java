package com.telnet.qcm.service;

import com.telnet.qcm.dao.QcmJRepository;
import com.telnet.qcm.entities.QcmJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("qcmJservice")

public class QcmJServiceImp implements QcmJService {

    @Autowired
   QcmJRepository qcmJRepository;


    @Override
    public List<QcmJ> getAllqcmsJ() {
        return qcmJRepository.findAll();
        }

    @Override
    public void saveQcmJ(QcmJ qcm) {
        qcmJRepository.save(qcm);

    }



    @Override
    public QcmJ getqcmbyid(Long id) {
        return qcmJRepository.getOne(id);
    }

    @Override
    public void removeQcmJ(Long id) {
        QcmJ qcmJ =qcmJRepository.getOne(id);
        qcmJRepository.delete(qcmJ);

    }

    @Override
    public void updateQcmJ(Long id) {

    }


}
