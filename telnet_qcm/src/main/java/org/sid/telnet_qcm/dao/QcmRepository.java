package org.sid.telnet_qcm.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sid.telnet_qcm.entities.Qcm;

@Repository
public interface QcmRepository extends JpaRepository<Qcm, Long>{

}
