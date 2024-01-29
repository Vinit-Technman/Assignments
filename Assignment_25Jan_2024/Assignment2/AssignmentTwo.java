import java.time.LocalDate;
import java.util.*;

public class AssignmentTwo {
    public static class Student{
        private Integer studentId;
        private String name;
        private String email;
        private Integer contactNumber;   

        Student(int id,String name,String email,int number)
        {
            this.studentId=id;
            this.name=name;
            this.email=email;
            this.contactNumber=number;
        }
        public Integer getId(){
            return this.studentId;
        }
        public String getName(){
            return name;
        }
        @Override
        public int hashCode() {
            return Objects.hash(studentId, name, email, contactNumber);
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Student student = (Student) obj;
            return studentId == student.studentId && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(contactNumber, student.contactNumber);
        }
       
    }   
    public static class Assignment{
        private Integer assignmentId;
        private String title;
        private String description;
        private Date dueDate;
        private List<Question> Question;

        Assignment(int id,String title,String desc,Date date,List<Question>Ques)
        {
            this.assignmentId=id;
            this.title=title;
            this.description=desc;
            this.dueDate=date;
            this.Question=Ques;
        }

        
        public Integer getId(){
            return this.assignmentId;
        }

        public List<Question> getQuestions(){
            return Question;
        }
        public String getTitle(){
            return title;
        }
    }
    public static class Trainer{
        private Integer trainerId;
        private String name;
        private String email;
        private Integer contactNumber;
        private List<String> TechStack;

        Trainer(int id,String name,String email,int contact,List<String>TechStack)
        {
            this.trainerId=id;
            this.name=name;
            this.email=email;
            this.contactNumber=contact;
            this.TechStack=TechStack;
        }
        
        public Integer getId(){
            return this.trainerId;
        }
    }
    public static class TechStack{
            private Integer techStackId;
            private String name;
            private String description;

            TechStack(int id,String name,String desc)
        {
            this.techStackId=id;
            this.name=name;
            this.description=desc;
        }

        public Integer getId(){
            return this.techStackId;
        }

    }
    public static class Result{
            private Integer resultId;
            private Student student;
            private Assignment assignment;
            private Trainer trainer;
            private Integer score;
            private String feedback;
            private Date submissionDate;

            Result(int id,Student s,Assignment assign,Trainer t,int score,String feedback, Date subDate)
            {
                this.resultId=id;
                this.student=s;
                this.assignment=assign;
                this.trainer=t;
                this.score=score;
                this.feedback=feedback;
                this.submissionDate=subDate;
            }
            public Student getStudent(){
                return student;
            }
            public Integer getTotalScore(){
                // System.out.println(score+" "+student.getName());
                return score;
            }
            public Assignment getAssignment(){
                return assignment;
            }
            public Integer getId(){
                return resultId;
            }
            public String getFeedback(){
                return feedback;
            }
    }
    public static class ResultsData{
        private List<Result>resultList;

        ResultsData(){
            this.resultList=new ArrayList<>();
        }

        public void addResult(Result result)
        {
            this.resultList.add(result);
            // for(Result r:resultList)
            // {
            //     System.out.println(r.getId());
            // }
        }

        public List<Result> getResultsByStudent(Student s)
        {
         List<Result>studentR=new ArrayList<>();
            for(Result r:resultList)
            {
                if(r.getStudent().equals(s))
                {
                // return r;
                    studentR.add(r);
                }
            }
            // return null;
            return studentR;
        }
        public double getTotalScoreByStudent(Student s){
            double Score=0;
            for(Result res:resultList)
            {
                if(res.getStudent().equals(s))
                Score+=res.getTotalScore();
            }
            return Score;
        }
    }

    public static class Question{
        private Integer QuestionId;
        private List<String> Answer;
        private Integer answerKey;
        private Integer scoreOfQues;
        private Integer techstackId;
        private Integer assignmentId;
        
        Question(int id,List<String>answers,int ans,int scoreOfQ,TechStack t,int ass)
        {
            this.QuestionId=id;
            this.Answer=answers;
            this.answerKey=ans;
            this.scoreOfQues=scoreOfQ;
            this.techstackId=t.getId();
            this.assignmentId=ass;
        }

        public Integer getScore(){
            return scoreOfQues;
        }

    }
    

    public static void HighestPerfomingStudents(List<Student>s,ResultsData r)
    {
        Student highestPerformingStudent=null;
        double highestPercentage=0;
        for(Student stu:s){
            List<Result>R=r.getResultsByStudent(stu);
            double Score=0;
            for(Result res:R)
            {
                Score+=res.getTotalScore();
            }
            // double Score=r.getResultsByStudent(stu).getTotalScore();
            double percentage=(Score/(1600))*100;
            if (percentage > highestPercentage) {
                highestPercentage = percentage;
                highestPerformingStudent = stu;
            }
        }
        System.out.println("Highest Performing Student: " + highestPerformingStudent.getName() +
                ", Percentage: " + highestPercentage + "%");
    }

    // create a method to Find the second-highest student
    //  by adding all techStack(Subjects) marks/Assignments and finding percentages.
    public static void SecondsHighestPerfomingStudents(List<Student>s,ResultsData r)
    {
        Student highestPerformingStudent=null;
        Student secondHighestPerformingStudent=null;

        double highestPercentage=0;
        double secondHighestPercentage=0;
        for(Student stu:s){
            
            List<Result>R=r.getResultsByStudent(stu);
            double Score=0;
            for(Result res:R)
            {
                Score+=res.getTotalScore();
            }
            // double percentage=(Score/r.getResultsByStudent(stu).getAssignment().getQuestions().size()*100);
            double percentage=(Score/1600)*100;
            if (percentage > highestPercentage) {
                secondHighestPercentage=highestPercentage;
                highestPercentage = percentage;

                secondHighestPerformingStudent=highestPerformingStudent;
                highestPerformingStudent = stu;
            }
            else if (percentage > secondHighestPercentage) {
                secondHighestPercentage = percentage;
                secondHighestPerformingStudent = stu;
            }   

        }
        System.out.println("Second Highest Performing Student: " + secondHighestPerformingStudent.getName() +
                ", Percentage: " + secondHighestPercentage + "%");
    }

    // Create a method to find the overall ranking of students by Scores.
    public static void findOverAllRanking(List<Student>students,ResultsData resData)
    {
        List<Student>rankList=new ArrayList<>(students);
        rankList.sort((s1,s2)->{
            double score1=resData.getTotalScoreByStudent(s1);
            double score2=resData.getTotalScoreByStudent(s2);
            return Double.compare(score2, score1);
        });    
        int rank=1;
        System.out.println("Overall Ranking of Students: ");
        for(Student stu:rankList)
        {
            double totalScore = resData.getTotalScoreByStudent(stu);
            double percentage = (totalScore / (1600)) * 100;
            System.out.println(rank + ". " + stu.getName() + ", Percentage: " + percentage + "%");
            rank++;
        }
        System.out.println();
    }


    // Get all the Students who need improvements and scored less than 60%.
    public static void ScoreLessThan60(List<Student>students,ResultsData resData)
    {
        System.out.println("Student Needing Imporvement (Less Than 60%)");

        for(Student stu:students)
        {
            double score=resData.getTotalScoreByStudent(stu);
            double percentage=(score/1600)*100;
            if(percentage<60)
            {
                System.out.println(stu.getName()+", Percentage: "+percentage+" %");
            }
        }
    }

    // Get all the Results of one Student named “Rohan/Prashant“ of all his Assignments and questions scores.
    public static void getResultOfStudent(String StudentName,List<Student>s,ResultsData resultsData)
    {
        Student stud=null;
        for(Student stu:s)
        {
            if(stu.getName()==StudentName)
            {
                stud=stu;
            }
        }

        if(stud==null)
        {
            System.out.println("Student with name " + stud.getName() + " not found.");
        }
        else{
            List<Result> ResultOfStudent=resultsData.getResultsByStudent(stud);
            System.out.println("Results for " + stud.getName() + ":");
            for(Result res:ResultOfStudent)
            {
                System.out.println("Assignment: " + res.getAssignment().getTitle() +
                ", Score: " + res.getTotalScore() + ", Feedback: " + res.getFeedback());
            }
        }
    }


    // Get all the students' results and their scores on all the individual assignments and questions.


    public static List<Question> createDummyQuestions(List<TechStack>techstacks,List<Assignment>assignments){
        List<Question>questions=new ArrayList<>();

        for(int i=0;i<4;i++)
        {
            questions.add(new Question(1, Arrays.asList("A", "B","C","D"),1,100, techstacks.get(i),i));
        } 
        return questions;
    }
    public static void main(String[] args)
    {

        // Create 10 students Objects
        List<Student>students=new ArrayList<>();
        List<String>name=Arrays.asList("Vinit","Rohan","Yash","Dwij","Fenil","Fidu","Aakarshak","Gopi","John","Cena");
        for (int i=0;i<name.size();i++)
        {
            students.add(new Student( i, name.get(i) ,name.get(i)+"@gmail.com", 123456789));
        }


        // Create 3 trainers   
        List<Trainer>trainers=new ArrayList<>();
        trainers.add(new Trainer(1, "Ritu","Ritu@gmail.com", 9977777,Arrays.asList("Python","Java")));
        trainers.add(new Trainer(2, "Krishna","Krishna@gmail.com", 9977777,Arrays.asList("AWS","Java")));
        trainers.add(new Trainer(3, "Rishabh","Rishabh@gmail.com", 9977777,Arrays.asList("Python","Java","AWS")));


        // Create 5 tech stacks
        List<TechStack>techstacks=new ArrayList<>();
        techstacks.add(new TechStack(1, "Java","Language"));
        techstacks.add(new TechStack(2, "Python","Language")); 
        techstacks.add(new TechStack(3, "C++","Language"));
        techstacks.add(new TechStack(3, "React","Framework"));
        techstacks.add(new TechStack(5, "Java","Language"));

        

        List<Assignment>assignments=new ArrayList<>();
        //Create 4 Assignments
        for (int i = 1; i <= 4; i++) {
        // Create 4 questions in each assignment
            List<Question> questions = createDummyQuestions(techstacks,assignments);
            assignments.add(new Assignment( i, "Assignment" + i, "Description" + i, new Date(), questions));
        }
        // assignments.add(new Assignment(1,"Ass-1" ,"DS in java", LocalDate.of(2024,2,1), Arrays.asList(questions.get(0),questions.get(1),questions.get(2),questions.get(3))));
        //         assignments.add(new Assignment(2,"Ass-2" ,"DS in python", LocalDate.of(2024,2,2), Arrays.asList(questions.get(0),questions.get(1),questions.get(2),questions.get(3))));
        //         assignments.add(new Assignment(3,"Ass-3" ,"DS in c", LocalDate.of(2024,2,3), Arrays.asList(questions.get(0),questions.get(1),questions.get(2),questions.get(3))));
        //         assignments.add(new Assignment(3,"Ass-3" ,"DS in c", LocalDate.of(2024,2,3), Arrays.asList(questions.get(0),questions.get(1),questions.get(2),questions.get(3))));
        
                

        // Create Results on the above data
        ResultsData resultsData = new ResultsData();

        List<Integer>Scores=Arrays.asList(
        300,350,390,400,
        200,250,200,250,
        320,370,250,350,
        300,350,200,400,
        310,340,250,390,
        340,250,240,380,
        310,380,285,400,
        340,355,250,330,340,250,300,250,
        320,340,250,340
        );
        int scoreIndex=0;
        for (Student student : students) {
            for (Assignment assignment : assignments) {
                Trainer trainer = trainers.get((int) (Math.random() * trainers.size()));
                int score=0;
                score+=Scores.get(scoreIndex);
                scoreIndex++;
                String feedback = "Feedback for assignment " + assignment.getId();
                Date submissionDate = new Date();
                Result result = new Result(1,student, assignment, trainer, score, feedback, submissionDate);
                resultsData.addResult(result);
            }
        }
        HighestPerfomingStudents(students,resultsData);

        SecondsHighestPerfomingStudents(students,resultsData);
        
        findOverAllRanking(students, resultsData);
 
        ScoreLessThan60(students, resultsData);
        
        getResultOfStudent("Rohan", students, resultsData);
        System.out.println("Hello World!!");

        
        }
}
