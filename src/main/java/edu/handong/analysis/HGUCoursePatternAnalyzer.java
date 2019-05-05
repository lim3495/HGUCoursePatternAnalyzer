package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

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
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}

		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return Student[]
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		Student std;		
		Student[] stds = new Student[this.numOfStudents];
		String[] names = new String[1000];
		int st_cnt=0;

		
		for(int i=0 ; i<lines.length ; i++) {
			if(lines[i] !=null)
				names[i] = lines[i].trim().split(", ")[1];
		} // initial in String
		
		for(int i=0 ; i<lines.length;i++) {
			std = new Student(names[i]);
			//assign to student class
			
			//System.out.println(std.getName());
			
			if((this.studentExist(stds, std))) {
				stds[st_cnt] = std;
				st_cnt++;
			}
		}
		
		return stds;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		int i=0 ;
		
		while(students[i] != null) {
		//null 이 아닐 때 까지, students의 전체 값을 비교해주어야함.
			if(students[i].getName().equals(student.getName())==true) {
				return false;
			}	
			i++;
		}

		return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return Course[]
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		Course crs;		
		Course[] crss = new Course[this.numOfCourses];
		String[] courses = new String[1000];
		int crs_cnt=0;

		
		for(int i=0 ; i<lines.length ; i++) {
			if(lines[i] !=null)
				courses[i] = lines[i].trim().split(", ")[2];
		} // initial in String
		
		for(int i=0 ; i<lines.length;i++) {
			crs = new Course(courses[i]);
			//assign to student class
			
			//System.out.println(std.getName());
			
			if((this.courseExist(crss, crs))) {
				crss[crs_cnt] = crs;
				crs_cnt++;
			}
		}
		
		return crss;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		int i=0 ;
		
		while(courses[i] != null) {
			//null 이 아닐 때 까지, course의 전체 값을 비교해주어야함.
			if(courses[i].getCourseName().equals(course.getCourseName())==true) {
				return false;
			}	
			i++;
		}

		return true;

	}
}