package org.sid.telnet_qcm.controller;
import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import javax.validation.Valid;

import org.sid.telnet_qcm.entities.Util;
import org.sid.telnet_qcm.exception.ResourceNotFoundException;
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

import org.sid.telnet_qcm.dao.UtilRepository;

@RestController
@RequestMapping("/api/v1")
public class UtilController {
    @Autowired
    private UtilRepository utilRepository;

    @GetMapping("/employees")
    public List<Util> getAllEmployees() {
        return utilRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Util> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Util util = utilRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Util not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(util);
    }

    @PostMapping("/employees")
    public Util createEmployee(@Valid @RequestBody Util util) {
        return utilRepository.save(util);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Util> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                               @Valid @RequestBody Util utilDetails) throws ResourceNotFoundException {
        Util util = utilRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Util not found for this id :: " + employeeId));

        util.setEmailId(utilDetails.getEmailId());
        util.setLastName(utilDetails.getLastName());
        util.setFirstName(utilDetails.getFirstName());
        final Util updatedUtil = utilRepository.save(util);
        return ResponseEntity.ok(updatedUtil);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Util util = utilRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Util not found for this id :: " + employeeId));

        utilRepository.delete(util);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }}