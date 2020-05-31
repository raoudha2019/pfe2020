package com.telnet.qcm.dao;

import com.telnet.qcm.entities.QcmJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("QcmJRepository")

public interface QcmJRepository extends JpaRepository<QcmJ,Long > {

}
