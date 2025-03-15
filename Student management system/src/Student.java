// Definition of the Student class
public class Student {

    // Private instance for student name,ID and module
    private String studentName;
    private String studentID;
    private Module module;

    // Constructor to initialize the student with an ID, name, and module
    public Student(String  studentID, String studentName , Module module) {

        this.studentID = studentID;
        this.studentName = studentName;
        this.module = module;

    }

    // Getter method for studentName
    public String getStudentName() {
        return studentName;
    }

    // setter method for studentName
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // getter method for student id
    public String getStudentID() {
        return studentID;
    }
    // setter method for student id
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }


    //getter method for module
    public Module getModule() {
        return module;
    }

    //setter method for module
    public void setModule(Module module) {
        this.module = module;
    }

}
