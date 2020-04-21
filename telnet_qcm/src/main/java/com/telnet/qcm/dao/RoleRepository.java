package com.telnet.qcm.dao;

import com.telnet.qcm.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository ("RoleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r where r.name =:name")
    Role findRoleByName (@Param("name") String name);

}


        

