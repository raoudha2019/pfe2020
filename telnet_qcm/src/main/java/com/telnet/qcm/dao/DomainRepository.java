package com.telnet.qcm.dao;

import com.telnet.qcm.entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("DomainRepository")
public interface DomainRepository extends JpaRepository<Domain,Long >{

    @Query("SELECT d FROM Domain d where d.name =:name")
    Domain findDomainByName (@Param("name") String name);

}
