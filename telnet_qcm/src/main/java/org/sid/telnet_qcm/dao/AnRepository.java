package org.sid.telnet_qcm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sid.telnet_qcm.entities.An;

@Repository
public interface AnRepository extends JpaRepository<An, Long>{

}
