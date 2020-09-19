class Person{
	private	String	first_name;
	private String	last_name;
	
	public void	displayDetails(){
		System.out.printf("First name\t%s\n",first_name);
		System.out.printf("Last name\t%s\n",last_name);
	}

	public static void	main(String[] args){
		Person me = new Person();

	}
}
class private Student extends Person{
	private int	ID;
	private String	course;
	private String	teacher_name;

	public Student(int set_ID, String set_course,\
				String set_teacher_name){
		ID = set_ID;
		course = set_course;
		teacher_name = set_teacher_name;
	}

	public void	displayDetails(){
		System.out.printf("First name\t%s\n",first_name);
		System.out.printf("Last name\t%s\n",last_name);
		System.out.printf('
	}
}
