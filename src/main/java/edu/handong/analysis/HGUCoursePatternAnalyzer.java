package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import java.util.ArrayList;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
								"1999-2, JC Nam, Programming Language Theory",
								"1999-1, JC Nam, Data Structures",
								"2001-1, JC Nam, Database Systems",
								"2018-1, SB Lim, Java Programming",
								"2018-2, SB Lim, Programming Language Theory",
								"2019-1, SB Lim, Data Structures",
								"2019-1, SB Lim, Algorithm Analysis",
								"2018-1, SJ Kim, Java Programming",
								"2018-2, SJ Kim, Programming Language Theory",
								"2019-1, SJ Kim, Logic Design",
								"2019-1, SJ Kim, Algorithm Analysis",
							};

	private int numOfStudents;
	private int numOfCourses;
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Course> courses= new ArrayList<Course>();
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		
		
		initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		
		for(Student student : students) {
			{
					System.out.println(student.getName());
			}		
			
		}
		
		initiateCourseArrayFromLines(lines);
		
		System.out.println("Number of All Courses: " + numOfCourses);
			for(Course course: courses) {
				System.out.println(course.getCourseName());
			}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return void
	 */
	private void initiateStudentArrayFromLines(String[] lines) {
		
		Student std ;		
		
		for(String line : lines) {
			std = new Student(line.split(",")[1].trim());
			
			if((this.studentExist(this.students, std))) {
				this.students.add(std);	
			}
		}
	
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {
		
		for(int i=0 ; i<students.size() ; i++) {
				if(students.get(i).getName().equals(student.getName())==true) 
					return false;
		}
		
		return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return void
	 */
	private void initiateCourseArrayFromLines(String[] lines) {
		
		Course crs ;		
			
			for(String line : lines) {
				crs = new Course(line.split(",")[2].trim());
				
				if((this.courseExist(courses, crs))) {
					this.courses.add(crs);	
				}
			}
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course crs) {
		
		for(int i=0 ; i<courses.size() ; i++) {
			if(courses.get(i).getCourseName().equals(crs.getCourseName())==true) 
				return false;
	}
	
	return true;
	}
}
