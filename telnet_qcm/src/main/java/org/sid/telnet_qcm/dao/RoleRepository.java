package org.sid.telnet_qcm.dao;

import org.sid.telnet_qcm.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("RoleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {

}


        

