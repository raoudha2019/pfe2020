package com.telnet.qcm.service;


import com.telnet.qcm.entities.QcmJ;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QcmJService {
    public List<QcmJ> getAllqcmsJ();

    public void saveQcmJ (@RequestBody QcmJ qcm);
    public QcmJ getqcmbyid(Long id);

    public void removeQcmJ( @PathVariable("id") Long id) ;
    public void updateQcmJ( @PathVariable("id") Long id) ;

}
