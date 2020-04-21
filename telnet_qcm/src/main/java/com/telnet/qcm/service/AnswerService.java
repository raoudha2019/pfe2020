package com.telnet.qcm.service;


import com.telnet.qcm.entities.Answer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AnswerService {

    public List<Answer> getAllAnswer();
    public void saveAnswer(@RequestBody Answer answer);
    public void removeAnswer( @PathVariable("id") Long id) ;
    public void updateAnswer( @PathVariable("id") Long id) ;
    public Answer getAnswerbyid(Long id);

}
