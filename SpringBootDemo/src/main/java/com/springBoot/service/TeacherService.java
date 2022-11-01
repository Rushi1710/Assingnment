package com.springBoot.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.entity.Teacher;
import com.springBoot.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	
	// Insert data in teacher Table
	public Teacher  insertTeacherData(Teacher teacher) {
		
			Teacher save = this.teacherRepository.save(teacher);
			return save;	
		
	}
	
	// update Data by id
	public String  updateTeacherData(Teacher teacher) throws Exception{
		
		if(teacherRepository.existsById(teacher.getTeacherId())) {
			Teacher update = teacherRepository.save(teacher);
			return "Udate Data";
		}
	
		throw new EntityNotFoundException("Teacher Id  "+teacher.getTeacherId()+" cannot be updated as it does not exists ");	
		
	}

	// get data by id
	public Optional<Teacher> getdataById(int id) 
	{
		return this.teacherRepository.findById(id);
			
	}

	// delete data by id
	public void  deletedata(int id) {
		
		if(this.teacherRepository.existsById(id)) {
			this.teacherRepository.deleteById(id);
			//return "Data is deleted";
		}
		

		
	}
}
