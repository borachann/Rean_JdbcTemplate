package com.rean.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rean.model.Student;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Student> getStudent(){
		return jdbcTemplate.query("select * from Student", new RowMapper<Student>(){
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setStuid(rs.getInt("stuid"));
				student.setStuname(rs.getString("stuname"));
				student.setLvlyear(rs.getString("lvlyear"));
				student.setScore(rs.getBigDecimal("score"));
				return student;
			}
		});
	}
	
	
	public Boolean insertStudent(Student student){
		int i = jdbcTemplate.update("insert into student(stuid,stuname,lvlyear,score) values(nextval('seq_student_id'),?,?,?)", new Object[] {student.getStuname(), student.getLvlyear(), student.getScore()});
		if(i>0) return true;
		return false;
	}
	
	public Boolean deleteStudent(int stuId){
		int i = jdbcTemplate.update("delete from student where stuid = ?", stuId);
		if (i>0) return true;
		return false;
	}
	
	public Boolean editStudent(Student student){
		
		int i = jdbcTemplate.update("update student set stuname=?, lvlyear=?, score=? where stuid=?", new Object[]{student.getStuname(), student.getLvlyear(), student.getScore(), student.getStuid()});
		if (i>0) return true;
		return false;
	}
	
	public Boolean updateStudent(Student student, int stuid){
		
		int i = jdbcTemplate.update("update student set stuname=?, lvlyear=?, score=? where stuid=?", new Object[]{student.getStuname(), student.getLvlyear(), student.getScore(), stuid});
		if (i>0) return true;
		return false;
	}
	
	public List<Student> searchStudent(int stuId){
		return jdbcTemplate.query("select * from student where stuid=?", new Object[] { stuId }, new RowMapper<Student>(){
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setStuid(rs.getInt("stuid"));
				student.setStuname(rs.getString("stuname"));
				student.setLvlyear(rs.getString("lvlyear"));
				student.setScore(rs.getBigDecimal("score"));
				return student;
			}
		});
	}
}
