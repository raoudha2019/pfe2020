package org.sid.telnet_qcm.dao;

import org.sid.telnet_qcm.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("PermissionRepository")
    public interface PermissionRepository extends JpaRepository<Permission, Long> {

    }

