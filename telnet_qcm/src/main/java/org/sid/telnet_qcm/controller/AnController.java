package org.sid.telnet_qcm.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sid.telnet_qcm.entities.An;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.sid.telnet_qcm.exception.ResourceNotFoundException;
import org.sid.telnet_qcm.dao.AnRepository;

    @RestController
    @RequestMapping("/api/v1")
    public class AnController {
        @Autowired
        private AnRepository anRepository;

        @GetMapping("/answers")
        public List<An> getAllAnswer() {
            return anRepository.findAll();
        }

        @GetMapping("/answers/{id}")
        public ResponseEntity<An> getAnswerById(@PathVariable(value = "id") Long answerId)
                throws ResourceNotFoundException {
            An an = anRepository.findById(answerId)
                    .orElseThrow(() -> new ResourceNotFoundException("AAnswer not found for this id :: " + answerId));
            return ResponseEntity.ok().body(an);
        }

        @PostMapping("/answers")
        public An createAnswer(@Valid @RequestBody An an) {
            return anRepository.save(an);
        }


        @PutMapping("/answers/{id}")
        public ResponseEntity<An> updateAnswer(@PathVariable(value = "id") Long answerId,
                                               @Valid @RequestBody An anDetails) throws ResourceNotFoundException {
            An an = anRepository.findById(answerId)
                    .orElseThrow(() -> new ResourceNotFoundException("An not found for this id :: " + answerId));

            an.setOption(anDetails.getOption());
            an.setStat(anDetails.getStat ());
            final An updatedAn = anRepository.save(an);
            return ResponseEntity.ok(updatedAn);
        }


        @DeleteMapping("/answers/{id}")
        public Map<String, Boolean> deleteAnswer(@PathVariable(value = "id") Long answerId)
                throws ResourceNotFoundException {
            An an = anRepository.findById(answerId)
                    .orElseThrow(() -> new ResourceNotFoundException("An not found for this id :: " + answerId));

            anRepository.delete(an);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }}


