package com.telnet.qcm.dao;

import com.telnet.qcm.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TestRepository")
public interface TestRepository extends JpaRepository<Test, Long> {

}
