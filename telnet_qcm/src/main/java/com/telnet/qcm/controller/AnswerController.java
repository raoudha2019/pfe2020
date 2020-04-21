package com.telnet.qcm.controller;

import com.telnet.qcm.dao.AnswerRepository;
import com.telnet.qcm.dao.QcmRepository;
import com.telnet.qcm.entities.Answer;
import com.telnet.qcm.entities.Qcm;
import com.telnet.qcm.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Answer")
public class AnswerController {
 @Autowired
    AnswerService answerService;
 @Autowired
    AnswerRepository answerRepository;

 @Autowired
    QcmRepository qcmRepository;

    @RequestMapping(value = ("/allAnsewr"), method = RequestMethod.GET)
    public List<Answer> getAlldomaines()
    {
        return answerService.getAllAnswer();
    }

    @RequestMapping(value="/addAnswer/{Qcmid}",method= RequestMethod.POST)
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer, @PathVariable("Qcmid")Long id) throws ValidationException{
        Qcm qcm=qcmRepository.getOne(id) ;
        answer.setQcm(qcm);
        if (answer.getOption1() .isEmpty()&& answer.getOption2().isEmpty()&& answer.getOption3().isEmpty()) {
            throw new ValidationException("Options is mondatery !");
            // return (HttpStatus.NOT_FOUND);
        }
        else {
            answerService.saveAnswer(answer);
            return (ResponseEntity.ok(answer));
        } }

    @RequestMapping(value="/deleteAnswer/{id}",method=RequestMethod.DELETE)
    public void removeAnswer(@PathVariable("id") Long id) {
        Answer answer=answerService.getAnswerbyid(id);
        answerService.removeAnswer(id);
    }

    @RequestMapping(value="/updateAnswer/{id}/{Qcmid}",method=RequestMethod.PUT)
    public ResponseEntity<Answer> updateUser(@RequestBody Answer answer, @PathVariable long id,@PathVariable long Qcmid) throws ValidationException {
        answer.setId(id);
        Qcm qcm=qcmRepository.getOne(Qcmid) ;
        answer.setQcm(qcm);

        if (answer.getOption1() .isEmpty()&& answer.getOption2().isEmpty()&& answer.getOption3().isEmpty()) {
            throw new ValidationException("Options is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }

        answerService.saveAnswer(answer);
        return (ResponseEntity.ok(answer));
    }

    @RequestMapping(value = ("/oneAnswer/{id}"), method = RequestMethod.GET)
    public Answer getAnswer(@PathVariable("id") Long id) {
        return answerService.getAnswerbyid(id);
    }





}