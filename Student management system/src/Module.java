public class Module{

    // Instance variables to store the marks,average and grade
    private double[] marks= new double[3];
    private double average;
    private String grade;

    // Getter method for marks array
    public double[] getMarks() {
        return marks;
    }

    //setter method for setmarks
    public void setMarks (double[] marks) {
        this.marks = marks;
    }

    //defalt constructer
    public Module() {
    }

    // Parameterize constructor to initialize marks, average, and grade
    public Module(double[] marks, double average, String grade) {
        this.marks = marks;
        this.average = average;
        this.grade = grade;
    }

    //getter method for get average
    public double getAverage() {
        return average;
    }

    //setter method for set average
    public void setAverage(double average) {
        this.average = average;
    }

    //getter method for get grade
    public String getGrade() {
        return grade;
    }

    // setter method for set grade
    public void setGrade(String grade) {
        this.grade = grade;
    }


    //this funtion is use calculate average marks of odules
    public  double calculateAverage(double[] marks){
        double sum=0;
        for (double mark : marks) {
            sum += mark;
        }
        average=sum/ marks.length;
        return average;
    }


    //this is a find a grade of mark
    public  String grade(double average){
        if(average>=80){//average>=80 return distintion
            return "Distinction";
        }
        else if(average>=70){//average>=70 return merit
            return "Merit";
        }
        else if(average>=40){//average>=40 return pass
            return "Pass";
        }else{
            return "Fail";//else return fail
        }
    }


    //this is calculate total markss
    public double totalCalculate(double[] marks){
        double sum=0;

        for (double mark : marks) {
            sum += mark;
        }
        return sum;
    }
}