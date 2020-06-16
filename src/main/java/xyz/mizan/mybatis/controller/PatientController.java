package xyz.mizan.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.mizan.mybatis.entity.Patient;
import xyz.mizan.mybatis.service.PatientService;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/patient")
public class PatientController {

	private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	PatientService patientService;

	// Get: selectAllPatient
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> selectAllPatient() {
		Integer size = patientService.countAll();
		LOG.info(String.format("Size of all patient: %s", size));
		List<Patient> patients = patientService.selectAll();
		return new ResponseEntity<Object>(patients, HttpStatus.OK);
	}

	// Get: selectPatientById
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> selectPatientById(@PathVariable int id) {
		Patient patient = patientService.selectById(id);
		return new ResponseEntity<Object>(patient, HttpStatus.OK);
	}

	// Get: searchPatient
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<Object> searchPatient(
			@RequestParam(value = "id", required = false) String patientId,
			@RequestParam(value = "name", required = false) String patientName,
			@RequestParam(value = "address", required = false) String patientAddress,
			@RequestParam(value = "phone", required = false) String patientPhone) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("patientId", patientId);
		params.put("patientName", patientName);
		params.put("patientAddress", patientAddress);
		params.put("patientPhone", patientPhone);
		Integer size = patientService.countByParams(params);
		LOG.info(String.format("Size of search patient: %s", size));
		List<Patient> patients = patientService.search(params);
		return new ResponseEntity<Object>(patients, HttpStatus.OK);
	}

	// Post: addPatient
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addPatient(@Valid @RequestBody Patient patient) {
		//Need to check for duplicate phone number
		patientService.insert(patient);
		return new ResponseEntity<Object>("Insert Successfull", HttpStatus.OK);
	}

	// Put: updatePatient
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePatient(@PathVariable int id, @Valid @RequestBody Patient patient) {
		if(!ObjectUtils.isEmpty(patientService.selectById(id))) {
			patient.setPatientId(id);
			patientService.update(patient);
			return new ResponseEntity<Object>("Update Successfull", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Update Failed", HttpStatus.OK);
		}
	}

	// Delete: deletePatient
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePatient(@PathVariable int id) {
		if(!ObjectUtils.isEmpty(patientService.selectById(id))) {
			patientService.delete(id);
			return new ResponseEntity<Object>("Delete Successfull", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Delete Failed", HttpStatus.OK);
		}
	}
}
