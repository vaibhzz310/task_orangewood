package orangewood.demo.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orangewood.demo.domain.Student;
import orangewood.demo.repository.StudentRepository;
import orangewood.demo.service.IService;

@Service
public class StudentServiceImpl implements IService<Student> {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Collection<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		Optional<Student> result = studentRepository.findById(id);
		if(result.isPresent())
			return result.get();
		else
			return null;
	}

	@Override
	public Student saveOrUpdate(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			studentRepository.deleteById(id);
			jsonObject.put("message", "Student deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
