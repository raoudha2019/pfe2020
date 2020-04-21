package com.telnet.qcm.dao;

import com.telnet.qcm.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AnswerRepository")
public interface AnswerRepository extends JpaRepository<Answer,Long> {


}
