package com.telnet.qcm.service;

import com.telnet.qcm.dao.AnswerRepository;
import com.telnet.qcm.entities.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerService answerService;
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);

    }

    @Override
    public void removeAnswer(Long id) {
        Answer answer = answerRepository.getOne(id);
       answerRepository.delete(answer);

    }

    @Override
    public void updateAnswer(Long id) {

    }

    @Override
    public Answer getAnswerbyid(Long id) {

            return answerRepository.getOne(id);
        }

    }

