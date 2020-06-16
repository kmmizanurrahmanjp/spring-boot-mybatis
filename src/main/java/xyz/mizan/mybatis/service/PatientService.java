package xyz.mizan.mybatis.service;

import java.util.List;
import java.util.Map;

import xyz.mizan.mybatis.entity.Patient;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface PatientService {

	public Integer countAll();
	public Integer countByParams(Map<String, Object> params);
	
	public List<Patient> selectAll();
	public Patient selectById(Integer id);
	public List<Patient> search(Map<String, Object> params);
	
	public void insert(Patient patient);
	public void update(Patient patient);
	public void delete(Integer id);
}
