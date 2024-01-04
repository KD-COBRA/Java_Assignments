package Assignments_Java;
import java.util.*;

// Functional Interface representing the eligibility criteria for a candidate or voter
@FunctionalInterface
interface EligibilityCriteria<T> {
    boolean checkEligibility(T entity);
}

class Question {
    private String questionId;
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    public Question(String questionId, String questionText, List<String> options, String correctAnswer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

class Student1 {
    private String studentId;
    private String name;
    private int age;
    private boolean registrationStatus;
    private List<String> chosenAnswers;

    public Student1(String studentId, String name, int age, boolean registrationStatus) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.registrationStatus = registrationStatus;
        this.chosenAnswers = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public List<String> getChosenAnswers() {
        return chosenAnswers;
    }

    public void chooseAnswer(String answer) {
        chosenAnswers.add(answer);
    }
}

class Exam1 {
    private String examId;
    private String examName;
    private List<Question> questions;
    private List<Student1> students;

    public Exam1(String examId, String examName, List<Question> questions) {
        this.examId = examId;
        this.examName = examName;
        this.questions = questions;
        this.students = new ArrayList<>();
    }

    public String getExamId() {
        return examId;
    }

    public String getExamName() {
        return examName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Student1> getStudents() {
        return students;
    }

    public void addStudent(Student1 student) {
        students.add(student);
    }

    public void conductExam() {
        for (Student1 student : students) {
            if (student.isRegistrationStatus()) {
                System.out.println("\nStudent: " + student.getName() + " (ID: " + student.getStudentId() + ")");
                System.out.println("Exam: " + examName);

                for (Question question : questions) {
                    System.out.println("\nQuestion " + question.getQuestionId() + ": " + question.getQuestionText());
                    for (int i = 0; i < question.getOptions().size(); i++) {
                        System.out.println((char) ('A' + i) + ") " + question.getOptions().get(i));
                    }

                    System.out.print("Your Answer (A/B/C/D): ");
                    String chosenAnswer = new Scanner(System.in).nextLine().toUpperCase();
                    student.chooseAnswer(chosenAnswer);
                }
            }
        }
    }

    public void displayResults() {
        System.out.println("\nExam Results for " + examName + ":");
        for (Student1 student : students) {
            if (student.isRegistrationStatus()) {
                System.out.println("\nStudent: " + student.getName() + " (ID: " + student.getStudentId() + ")");
                System.out.println("Chosen Answers:");

                for (int i = 0; i < questions.size(); i++) {
                    Question question = questions.get(i);
                    System.out.println("Question " + question.getQuestionId() + ": " + student.getChosenAnswers().get(i));
                }
            }
        }
    }
}

public class Lab7_Lambda_Exp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of questions
        System.out.print("Enter the number of questions: ");
        int numberOfQuestions = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        List<Question> questions = new ArrayList<>();

        // Taking input for each question
        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.println("Enter details for Question " + (i + 1) + ":");
            System.out.print("Question ID: ");
            String questionId = scanner.nextLine();
            System.out.print("Question Text: ");
            String questionText = scanner.nextLine();
            System.out.print("Number of Options: ");
            int numberOfOptions = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            List<String> options = new ArrayList<>();
            for (int j = 0; j < numberOfOptions; j++) {
                System.out.print("Option " + (char) ('A' + j) + ": ");
                options.add(scanner.nextLine());
            }

            System.out.print("Correct Answer (A/B/C/D): ");
            String correctAnswer = scanner.nextLine().toUpperCase();

            Question question = new Question(questionId, questionText, options, correctAnswer);
            questions.add(question);
        }

        // Taking input for the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        List<Student1> students = new ArrayList<>();

        // Taking input for each student
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            System.out.print("Student Registration Status (true/false): ");
            boolean studentRegistrationStatus = scanner.nextBoolean();
            scanner.nextLine(); // Consume the newline

            Student1 student = new Student1(studentId, studentName, age, studentRegistrationStatus);
            students.add(student);
        }

        // Creating an online exam
        System.out.print("Enter the Exam ID: ");
        String examId = scanner.nextLine();
        System.out.print("Enter the Exam Name: ");
        String examName = scanner.nextLine();

        Exam1 onlineExam = new Exam1(examId, examName, questions);

        // Adding students to the exam
        for (Student1 student : students) {
            onlineExam.addStudent(student);
        }

        // Conducting the exam
        onlineExam.conductExam();

        // Displaying exam results
        onlineExam.displayResults();

        scanner.close();
    }
}

