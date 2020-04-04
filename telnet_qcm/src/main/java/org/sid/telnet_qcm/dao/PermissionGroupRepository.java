package org.sid.telnet_qcm.dao;

import org.sid.telnet_qcm.entities.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository("PermissionGroupRepository")
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {

}