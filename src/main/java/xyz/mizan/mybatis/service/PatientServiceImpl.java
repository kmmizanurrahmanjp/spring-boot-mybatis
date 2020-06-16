package xyz.mizan.mybatis.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.mizan.mybatis.entity.Patient;
import xyz.mizan.mybatis.mapper.PatientMapper;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class PatientServiceImpl implements PatientService{

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	PatientMapper mapper;

	@Override
	public Integer countAll() {
		return mapper.countAll();
	}

	@Override
	public Integer countByParams(Map<String, Object> params) {
		return mapper.countByParams(params);
	}

	@Override
	public List<Patient> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public Patient selectById(Integer id) {
		return mapper.selectById(id);
	}

	@Override
	public List<Patient> search(Map<String, Object> params) {
		return mapper.search(params);
	}

	@Override
	public void insert(Patient patient) {
		mapper.insert(patient);
	}

	@Override
	public void update(Patient patient) {
		mapper.update(patient);
	}

	@Override
	public void delete(Integer id) {
		mapper.delete(id);
	}

	
}
