package org.sid.telnet_qcm.dao;
import org.sid.telnet_qcm.entities.Util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtilRepository extends JpaRepository<Util, Long>{

}
