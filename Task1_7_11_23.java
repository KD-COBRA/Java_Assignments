//Domain:-Online Examinations
package Assignments_Java;

class Exam {
    private String Examination_name;
    private String Examination_date;

    Exam() {
        this.Examination_name = "This will be your Examination Name";
        this.Examination_date = "This will be your Examination Date";
    }

    Exam(String exam_name, String exam_date) {
        this.Examination_name = exam_name;
        this.Examination_date = exam_date;
    }

    public String getExamName() {
        return this.Examination_name;
    }

    public String getExamDate() {
        return this.Examination_date;
    }

}

class Student {
    String Student_name;
    int Student_id;

    Student() {
        this.Student_name = "";
        this.Student_id = 0;
    }

    public void Set_Student_Details() {
        this.Student_name = "This field is for the Student Name";
        System.out.println(this.Student_name);
    }

    public void Set_Student_Details(String Student_name, int Student_id) {
        this.Student_name = Student_name;
        this.Student_id = Student_id;
    }


}

class Invigilator extends Exam {
    String Invigilator_name;
    int Invigilator_id;

    Invigilator(String exm_name, String exm_date) {
        super(exm_name, exm_date);
    }

    @Override
    public String getExamName() {
        return super.getExamName();
    }
    @Override
    public String getExamDate(){
        return super.getExamDate();
    }

}

public class Task1_7_11_23 {
    public static void main(String[] args) {
        Exam obj2 = new Exam();
        Exam obj1 = new Exam("Java Exam", "7-11-2023");
        System.out.println("The Examination Name is:" + obj2.getExamName());
        System.out.println("The Examination Date is:" + obj2.getExamDate());
//        obj2.Examination_name="You cannot change it,as it is made Private";

        Student obj3 = new Student();
        obj3.Set_Student_Details();
        obj3.Set_Student_Details("Koushik Das", 1148);
        System.out.println("The Student Name is:" + obj3.Student_name);
        System.out.println("The Student ID is:" + obj3.Student_id);

        Invigilator obj4 = new Invigilator(obj1.getExamName(), obj1.getExamDate());
        System.out.println("Invigilator Set for:"+obj4.getExamName());
        System.out.println("Invigilator Set on:"+obj4.getExamDate());
    }
}
