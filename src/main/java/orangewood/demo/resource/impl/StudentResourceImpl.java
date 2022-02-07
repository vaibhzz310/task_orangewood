package orangewood.demo.resource.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orangewood.demo.domain.Student;
import orangewood.demo.resource.Resource;
import orangewood.demo.service.IService;

@RestController
@RequestMapping("/students")
public class StudentResourceImpl implements Resource<Student> {
	
	@Autowired
	private IService<Student> studentService;

	@Override
	public ResponseEntity<Collection<Student>> findAll() {
		return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> findById(Long id) {
		Student ret_val=studentService.findById(id);
		if(ret_val==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<>(ret_val, HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseEntity<Student> save(Student student) {
		return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Student> update(Student student) {
		return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> patchUpdate(Student student) {
		return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		return new ResponseEntity<>(studentService.deleteById(id), HttpStatus.OK);
	}

}
