import java.io.BufferedReader;//import reading characters,arrays,lines from input stream
import java.io.FileReader;//import file reader
import java.io.FileWriter;//import file writer
import java.io.IOException;//import input output exeptions
import java.util.InputMismatchException;//
import java.util.Scanner;//get a input from user

public class Main{

    static final int max_seats = 100 ;//define maximum number of seat
    static Student[] studentDetails = new Student[max_seats];//create array for students deatails

    public static void main(String[] args){

        //welcome massege
        System.out.println("\n**********---   WELCOME TO STUDENT ACTIVITY MANAGEMENT SYSTEM    ---**********");

        //main menu options
        String [] menuQuestions = {

                "\n                M E N U   O P T I O N S ",

                "\n 1 Check available seat.",
                " 2 Register student (with ID) ",
                " 3 Delete Student",
                " 4 Find student (with student ID) ",
                " 5 Store student details into a file",
                " 6 Load student details from the file to the system",
                " 7 View the list of students based on their names",
                " 8 Add student details",
                " 0 Exit",
        };
        //infinite loop for main menu
        while(true){

            //print menu options
            for(String  question:menuQuestions){
                System.out.println(question);
            }
            try{
                //scanner to get user input
                Scanner input = new Scanner(System.in);//get new scanner
                System.out.print("\nPlease select an option : ");//print this to get input
                int option = input.nextInt();//get user input


                // using swith statement to handling user choice
                switch (option){

                    //this is use to check available seat
                    case 1:
                        checkSeats();
                        break;

                    //this is use to register student data
                    case 2:
                        studentRegister();
                        break;

                    //this is use to delete student data
                    case 3:
                        studentDelete();
                        break;

                    //this is use for serch student
                    case 4:
                        searchStudent();
                        break;


                    //this is use  to save file student data
                    case 5:
                        saveToFile();
                        break;

                    //method is use to load student data from file
                    case 6:
                        loadFromFile();
                        break;

                    //method is use for view student list
                    case 7:
                        viewList();
                        break;

                    // method to display the sub menu
                    case 8:
                        subMenu();
                        break;

                    //method to exite a program
                    case 0:
                        System.out.println("Exiting...");
                        return;//exit the program

                    //input invalid number display thi
                    default:
                        System.out.println("Wrong input...!\n");
                }
            }catch (InputMismatchException e){      //this is error handling
                System.out.println("Please input a valid option.");
            }
        }
    }
    //this funtion is use to register student data
    public static void studentRegister(){

        Scanner input = new Scanner(System.in);//get new scanner
        System.out.print("\nEnter student ID (ex: w1234567) : ");// print get student id
        String studentID = input.nextLine();//get student id

        if (studentID.matches("w\\d{7}")){  //get have w and has 7 digit of uow id

            boolean isAvailable= false;

            //check student id has a student data
            for(Student idNo:studentDetails){//create loop for check student id
                if(idNo!=null && studentID.equals(idNo.getStudentID())){
                    isAvailable = true;
                    break;//find student id break the loop
                }
            }// student already registerd print this
            if(isAvailable){
                System.out.println("Sorry, This ID is already registered\n");
            }else{
                //register student if avalable space
                for (int i = 0; i < studentDetails.length; i++) {

                    if(studentDetails[studentDetails.length-1]!=null){

                        //already booked seat print this
                        System.out.println("Sorry, all seats are booked. Please try again later.");
                        return;
                    }else if (studentDetails[i] == null) {

                        //add student to next seat in array
                        studentDetails[i] = new Student(studentID, null,null);

                        System.out.println(studentID+" registered successfully.");
                        System.out.println("\nIf you want to add more details, please press 8 to add details.");
                        break;
                    }
                }
            }
        }else {

            //if uow id format is wrong print this
            System.out.println("Please enter a valid student ID.");
        }
    }
    //this function is use to check seat
    public static void checkSeats(){
        // get available seats to maximum seats
        int available=max_seats;

        // loop for student Details to count occupied seats
        for( Student seats:studentDetails){

            // Check the seat is occupied
            if(seats != null){
                available--;//decrese available seat
            }
        }
        //check all seat booked
        if(available== 0){
            System.out.println("Sorry, all seats are booked. Please try again later.");

            //serch available another seat
        }else{
            System.out.println("Available seats : "+available);//print available seat number
        }
    }


    //this is use to delete student data from student data
    public static void studentDelete() {

        Scanner input = new Scanner(System.in);//get new scanner
        System.out.print("\nEnter student ID (ex: w1234567) : ");//print this to get uow id
        String studentID = input.nextLine();//get uow id to delete data from student data record

        //check uow id correct
        if (studentID.matches("w\\d{7}")){

            boolean found= false;

            //loop for student data array
            for (int i = 0; i < studentDetails.length; i++) {

                //check for mach the student id
                if(studentDetails[i]!=null && studentDetails[i].getStudentID().equals(studentID)){

                    //if found student id
                    found=true;

                    //delete student data and shift other student data to left
                    for (int j = i; j < studentDetails.length-1 ; j++) {
                        studentDetails[j]=studentDetails[j+1];
                    }
                    // create last element is null
                    studentDetails[studentDetails.length-1]=null;
                    System.out.println(studentID+" deleted successfully.");
                    break;// exit the program found student data and delete it
                }
            }
            if(!found){  //if student id is not found in array print this
                System.out.println("sorry, This student ID is not registered in the system.");
            }
        }else{  //student id is invalid print this
            System.out.println("Please enter a valid student ID.");
        }
    }


        //this is sub menu for add student more details
        public static void subMenu(){

            //make a array for menu options
            String[] MenuQuestions={
                    "\n(a). Add Student name",
                    "(b). Add module marks",
                    "(c). Generate summary",
                    "(d). Generate report"
            };

            for(String question:MenuQuestions){ //loop for print menu for line by line
                System.out.println(question);
            }

            Scanner input = new Scanner(System.in);//get new scanner
            System.out.print("\nPlease select an option : ");//print this to get inputs
            String option = input.next(); //get input to get options


            //  using swith statement to handling user choice
            switch (option){

                //this method is use add name
                case "a":
                    addName();
                    break;

                //this method is use to add ict marks
                case "b":
                    addMarks();
                    break;

                //this method is use to genarate student data summery
                case "c":
                    generateSummary();
                    break;


                //this method is use to generate report to student data
                case "d":
                    generateReport();
                    break;

                // input wrong input display this
                default:
                    System.out.println("Wrong input...!\n");
            }

        }


        //this method is use to add name to student data
        public static void addName(){

            Scanner input = new Scanner(System.in);//get new scanner
            System.out.print("\nEnter student ID (ex: w1234567) : ");//print this to get user input
            String studentID = input.nextLine();//get user input

            if (studentID.matches("w\\d{7}")){          //check uow is valid

                boolean isAvailable=false;

                for(Student idNo:studentDetails) {  //check student details
                    if (idNo != null && studentID.equals(idNo.getStudentID())) {
                        isAvailable = true;
                        break;
                    }
                }//if student id is registerd in student data
                if(isAvailable){
                    //check student id is already registerd with name
                    for (Student studentDetail : studentDetails) {
                        if (studentDetail != null && studentID.equals(studentDetail.getStudentID()) && studentDetail.getStudentName() != null) {
                            System.out.println("Sorry, This student ID is already registered with name : " + studentDetail.getStudentName());//print Sorry, This student ID is already registered with name
                            return;//exit the funtion
                        }
                    }
                    //if student id hadnt name input the name
                    System.out.println("please enter your name :");
                    String name =  input.nextLine();//input the name

                    //itarate the array to add a name to array
                    for (Student studentDetail : studentDetails) {
                        if (studentDetail != null && studentDetail.getStudentID().equals(studentID)) {
                            studentDetail.setStudentName(name);
                            System.out.println("\nstudent name added successfully." );
                            break;//after adding name to array break the iteration
                        }
                    }

                }else{//student not registerd in the system
                    System.out.println("sorry, This student ID is not registered in the system.");
                }
            }else{//student id is invalid
                System.out.println("Please enter a valid student ID.");
            }
        }
       //this method is use to serch the student
       public static void searchStudent() {
           Scanner input = new Scanner(System.in);//create scanner to get user input

           System.out.print("\nEnter student ID (ex: w1234567) : ");//promt to get uow id
           String studentID = input.nextLine();//get student id from input

           if (studentID.matches("w\\d{7}")) {//check student id is correct
               boolean found = false;
               for (Student idNo : studentDetails) {

                   //iterate to find student by studet id
                   if (idNo != null && studentID.equals(idNo.getStudentID())) {//check currnt student math the enterd student id
                       System.out.println("STUDENT ID : " + idNo.getStudentID());//print student id
                       System.out.println("STUDENT NAME : " + idNo.getStudentName());//print student name

                       Module module = idNo.getModule();    //get module details and mark from student
                       if (module != null) { //check module data available
                           double[] marks = module.getMarks();//check marks of the module
                           if (marks != null && marks.length >= 3) {
                               System.out.println("Module 1 marks : " + marks[0]);//print module 1 marks
                               System.out.println("Module 2 marks : " + marks[1]);//print module 2 marks
                               System.out.println("Module 3 marks : " + marks[2]);//print module 3 marks
                               System.out.printf("Average : %.2f\n" , module.getAverage());//print all module marks average
                               System.out.println("Grade : " + module.getGrade());//print module grade
                           } else {
                               System.out.println("Module marks information is incomplete.");//marks informations are incompleted
                           }
                       } else {
                           System.out.println("\nModule information is not available.");//module informations is not avalable
                       }

                       found = true;//mark has found
                       break;//exit the loop
                   }
               }
               if (!found) {//if student is not found print this
                   System.out.println("Sorry, this student ID is not registered in the system.");
               }
           } else {//student id is invalid print this
               System.out.println("Please enter a valid student ID.");
           }
       }
        //this method is use to add marks
       public static void addMarks() {

           Scanner input = new Scanner(System.in);//create scanner to get user input
           System.out.print("\nEnter student ID (ex: w1234567) : ");//promt to get uow id
           String studentID = input.nextLine();//get student id from input


            //check student id is correct
           if (studentID.matches("w\\d{7}")) {

               boolean found = false;
               for (Student idNo : studentDetails) {
                   if (idNo != null && studentID.equals(idNo.getStudentID())) {
                       found = true;
                       break;//exit the loop student found
                   }
               }
               if (!found) {//student not found
                   System.out.println("Sorry, this student ID is not registered in the system.");
               } else {

                   //iterate a list to add marks
                   for (Student studentDetail : studentDetails) {
                       if (studentDetail != null && studentID.equals(studentDetail.getStudentID())) {
                           //if student name is not added can add student name
                           if (studentDetail.getStudentName() == null) {
                               System.out.println();
                               System.out.println("please enter your name :" );
                               String name = input.nextLine();//get the student name
                               studentDetail.setStudentName(name);//add student name
                               break;//name added break the loop
                           } else if (studentDetail.getModule() != null && studentDetail.getModule().getMarks() != null) {
                               System.out.println("This student marks are already added. " );//if the module mark already added print this
                               return;//exit the funtion
                           }
                       }
                   }

               double[] marks = new double[3];//add array to the new module mark
               for (int i = 0; i < 3; i++) {
                   boolean validInput = false;
                   while (!validInput) {
                       try {
                           System.out.println("\nPlease enter marks for module " + (i + 1) + " (1-100): ");
                           marks[i] = input.nextDouble();//read module mark
                           input.nextLine();//input the module marks

                           if (marks[i] >= 1 && marks[i] <= 100) {
                               validInput = true;//check mark within the range(0-100)
                           } else {
                               System.out.println("Marks must be between 1 and 100. Please try again.");
                           }
                       } catch (InputMismatchException e) {//error handling
                           System.out.println("Invalid input. Please enter a number.");
                           input.nextLine();
                       }
                   }
               }
                    //iterate list to add module information
                   for (Student studentDetail : studentDetails) {

                       if (studentDetail != null && studentID.equals(studentDetail.getStudentID())) {
                           Module module = new Module();//create new object
                           double average = module.calculateAverage(marks);//calculate the avg mark
                           String Grade = module.grade(average);//calculate the grade
                           studentDetail.setModule(new Module(marks, average, Grade));//set the student module
                           break;//module is set lopp is break
                       }
                   }
               System.out.println("Marks added successfully.");
               }
           } else {
               System.out.println("Please enter a valid student ID.");//student id is invalid
           }
       }



       //this is a save to text file
       public static void saveToFile(){
           try{
               //create file writer to save student_details.txt
               FileWriter file= new FileWriter("Student_Details.txt");

               // Iterate Student object in the student Details list
               for(Student idNo :studentDetails){

                   //check currrent object is not null
                   if(idNo!=null){
                       Module module = idNo.getModule();

                       //check module object is not null
                       if(module!=null){
                           //get marks array form module object
                           double[] marks= module.getMarks();
                           //mark arrAY IS not NULL and HAD 3 element
                           if(marks!=null && marks.length>=3){
                               //print studen  deatails and module marks
                               file.write(idNo.getStudentID()+","+idNo.getStudentName()+","+marks[0]+","+marks[1]+","+marks[2]+","+String.format("%.2f",module.getAverage())+","+module.getGrade()+"\n");
                           }else{
                               //marks null write student deatails
                               file.write(idNo.getStudentID()+","+idNo.getStudentName()+"\n");
                           }
                       }else{
                           file.write(idNo.getStudentID()+","+idNo.getStudentName()+"\n");
                       }
                   }
               }

               file.close();//close file
               System.out.println("File saved successfully.");

           }catch (IOException e){//error handling
               System.out.println("Error while writing to a file.");
           }

       }

       //load file
       public static void loadFromFile(){

            try{
                //read from from   student deatails.txt
                BufferedReader reader = new BufferedReader(new FileReader("Student_Details.txt"));
                String line;
                int index=0;

                //read line by line fro file
                while ((line = reader.readLine()) != null) {

                    //split line in coma
                    String[] data = line.split(",");
                    String studentID = data[0];
                    String studentName = data[1].trim();

                    //check student deatails null or empty
                    if (studentName.equals("null") || studentName.isEmpty()) {
                        Student student = new Student(studentID, null, null);
                        studentDetails[index++] = student;
                    }else if(data.length==2){
                        //length is two create a Student object with the name and null module
                        Student student = new Student(studentID, studentName, null);
                        studentDetails[index++] = student;

                    }else {
                        //get the marks average and grade from data
                        double[] marks = new double[3];
                        marks[0] = Double.parseDouble(data[2]);
                        marks[1] = Double.parseDouble(data[3]);
                        marks[2] = Double.parseDouble(data[4]);
                        double average = Double.parseDouble(data[5]);
                        String grade = data[6];

                        // get  a Student object with getted data and a new Module object
                        Student student = new Student(studentID, studentName, new Module(marks, average, grade));
                        studentDetails[index++] = student;
                    }
                }
                reader.close();//close reader
                System.out.println("File loaded successfully.");//print this
            }catch(IOException e){//reror handiling error from file
                System.out.println("Error while reading from a file.");
            }
       }
       // this method is use view list
      public static void viewList() {
          System.out.println();
          int n = studentDetails.length;
          Student temp;

          // buble sort alogorim  is use to  sort studentDetails array by student name
          for (int i = 0; i < n - 1; i++) {
              for (int j = 0; j < n - i - 1; j++) {
                  if (studentDetails[j] != null && studentDetails[j + 1] != null &&
                          compareIgnoreCase(studentDetails[j].getStudentName(), studentDetails[j + 1].getStudentName()) > 0) {

                      // Swap the elements they are  wrong order
                      temp = studentDetails[j];
                      studentDetails[j] = studentDetails[j + 1];
                      studentDetails[j + 1] = temp;
                  }
              }

          }
          // Print the sorted student name list
          System.out.println("      S O R T E D   S T U D E N T   N A M E   L I S T      \n\n");

          System.out.printf("%10s    %-30s%n", "Student ID", "Student Name");
          System.out.printf("%10s    %-30s%n", "----------", "---------------------------");

          //display student name and id from sorted list
          for (Student student : studentDetails) {
              if (student != null) {
                  System.out.printf("%10s    %-30s%n",student.getStudentID(), student.getStudentName());
              }
          }
      }
    // this method is use to compare two strings ignoring case,
      public static int compareIgnoreCase(String str1, String str2) {
          if (str1 == null) {
              str1="ZZZ";
          }
          if (str2 == null) {
              str2="ZZZ";
          }
          // compere two str  case insensitively and return the result
          return str1.compareToIgnoreCase(str2);
      }

      //this is use to generatee summer y
      public static void generateSummary(){

          int available=max_seats;//get available seat
          int passStudents=0;//ths is get all module pass student

          // Iterate Student object in the student Details list
          for(Student idNo:studentDetails){
              if(idNo != null){
                  available--;

                  // get module object with current student
                  Module module= idNo.getModule();
                  if(module!=null){
                      double[] marks= module.getMarks();
                      if(marks[0]>40 && marks[1]>40 && marks[2]>40){
                          passStudents++;
                      }
                  }
              }
          }
          int calculate=max_seats-available;//calculate total number of register student
          System.out.println("\nTotal student registrations : "+calculate);//print total number of registerd student
          System.out.println("No of student who scored more than 40 in all modules : "+passStudents);//print all module pass student

      }


      //this is use to generate report
    public static void generateReport(){

        boolean dataAvailable= false;
        int n = studentDetails.length;//get length of student array

        String header = String.format("%-15s %-30s %-10s %-10s %-10s %-10s %-10s %-10s",
                "StudentID", "Student Name", "Module 1", "Module 2", "Module 3", "Total", "Average", "Grade");

        //use a  bubble sort on the student Details array use  on module averages
        for (int i = 0; i <n-1 ; i++) {
            for (int j = 0; j < n-i; j++) {

                if(studentDetails[j]!= null && studentDetails[j+1]!=null){

                    //get Module objects for current and next students
                    Module module1 = studentDetails[j].getModule();
                    Module module2 = studentDetails[j+1].getModule();

                    if(module1!= null && module2!= null){
                        if(module1.getAverage() < module2.getAverage()){

                            Student temp = studentDetails[j];
                            studentDetails[j] = studentDetails[j + 1];
                            studentDetails[j + 1] = temp;
                        }
                    }
                }
            }
        }

        // iterete sorted  student Details array to print report
        for (Student studentDetail : studentDetails) {

            if (studentDetail != null) {//check student object not null
                //if data available pringt header
                if (!dataAvailable) {

                    System.out.println(header);

                    dataAvailable = true;
                }
                // get module object for the current student
                Module module = studentDetail.getModule();
                if (module != null) {
                    double[] marks = module.getMarks();//get mark from array
                    double total = module.totalCalculate(marks);

                    // Print the student details,module marks,total,average,grade
                    System.out.printf("%-15s %-30s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-10s%n",
                            studentDetail.getStudentID(),
                            studentDetail.getStudentName(),
                            marks[0], marks[1], marks[2],
                            total, module.getAverage(), module.getGrade());

                } else {
                    // print student deatails with tba  marks,total,average,grade is  null
                    System.out.printf("%-15s %-30s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                            studentDetail.getStudentID(),
                            studentDetail.getStudentName(),
                            "TBA", "TBA", "TBA", "TBA", "TBA", "TBA" );
                }
            }
        }

        //print footer data
        if (dataAvailable) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------\n");
        } else {
            System.out.println("No data available");
        }
    }
}