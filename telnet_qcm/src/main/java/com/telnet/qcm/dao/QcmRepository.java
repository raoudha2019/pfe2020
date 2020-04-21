package com.telnet.qcm.dao;

import com.telnet.qcm.entities.Qcm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("QcmRepository")
public interface QcmRepository extends JpaRepository <Qcm,Long> {


    @Query("SELECT q FROM Qcm q WHERE q.domain.name=: name")
    List<Qcm> findQcmByDomain (@Param("name")  String name);

    //Qcm findAllByDomain(String domainName);
   // Qcm getqcmbyQustion(String question );

}
