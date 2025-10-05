package samplearrays;
import java.util.Arrays;

public class ManageStudent {
    public static Student findOldest(Student[] students) {
        if(students.length == 0) return null;
        Student oldest = students[0];
        for(int i=1;i<students.length;i++){
            if(students[i].getAge() > oldest.getAge()){
                oldest = students[i];
            }
        }
        return oldest;
    }
    public static int countAdults(Student[] students) {
        int count=0;
        for(int i=0;i<students.length;i++){
            if(students[i].getAge()>=18){
                count++;
            }
        }
        return count;
    }
    public static double averageGrade(Student[] students) {
        if(students.length==0) return Double.NaN;
        double sum=0;
        for(int i=0;i<students.length;i++){
            sum+=students[i].getGrade();
        }
        return sum/students.length;
    }
    public static Student findStudentByName(Student[] students, String name) {
        for(int i=0;i<students.length;i++){
            if(students[i].getName().equals(name)){
                return students[i];
            }
        }
        return null;
    }
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students,(s1,s2)->s2.getGrade()-s1.getGrade());
    }
    public static void printHighAchievers(Student[] students) {
        for(int i=0;i<students.length;i++){
            if(students[i].getGrade()>=15){
                System.out.println(students[i].getName());
            }
        }
    }
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(int i=0;i<students.length;i++){
            if(students[i].getId()==id){
                students[i].setGrade(newGrade);
                return true;
            }
        }
        return false;
    }
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i=0;i<students.length;i++){
            for(int j=i+1;j<students.length;j++){
                if(students[i].getName().equals(students[j].getName())){
                    return true;
                }
            }
        }
        return false;
    }

    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newArray = new Student[students.length+1];
        for(int i=0;i<students.length;i++){
            newArray[i] = students[i];
        }
        newArray[students.length] = newStudent;
        return newArray;
    }

    public static void main(String[] args){
        Student[] arr = new Student[6];
        arr[0] = new Student(1,"Yasser");
        arr[1] = new Student(2,"Alae",17);
        arr[2] = new Student(3,"Nizar",21);
        arr[3] = new Student(4,"Marwa",20,19);
        arr[4] = new Student(5,"Oussama",21);
        arr[5] = new Student(6,"Mouad",21,20);

        System.out.println("== All Students ==");
        for(Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        Student oldest = findOldest(arr);
        System.out.println("\nOldest student: " + oldest);

        int adults = countAdults(arr);
        System.out.println("Number of adult students: " + adults);

        double avgGrade = averageGrade(arr);
        System.out.println("Average grade: " + avgGrade);

        Student found = findStudentByName(arr,"Marwa");
        System.out.println("Found student by name Marwa: " + found);

        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for(Student s : arr) System.out.println(s);

        System.out.println("\nHigh achievers (grade >= 15):");
        printHighAchievers(arr);

        boolean updated = updateGrade(arr,4,20);
        System.out.println("\nUpdated grade for id=4? " + updated);
        System.out.println("Student id=4 now: " + findStudentByName(arr,"Marwa"));

        boolean duplicates = hasDuplicateNames(arr);
        System.out.println("\nHas duplicate names? " + duplicates);

        arr = appendStudent(arr,new Student(7,"Sami",19,17));
        System.out.println("\nAfter appending new student:");
        for(Student s : arr) System.out.println(s);

        Student[][] school = new Student[2][3];

        school[0][0] = new Student(1, "Ilham", 18, 16);
        school[0][1] = new Student(2, "Zaineb", 17, 18);
        school[0][2] = new Student(3, "Lina", 19, 15);

        school[1][0] = new Student(4, "Hamza", 20, 17);
        school[1][1] = new Student(5, "Zarina", 18, 19);
        school[1][2] = new Student(6, "Mouad", 19, 14);

        for(int classIndex = 0; classIndex < school.length; classIndex++){
            System.out.println("Class " + (classIndex+1) + ":");
            for(int studentIndex = 0; studentIndex < school[classIndex].length; studentIndex++){
                System.out.println(" - " + school[classIndex][studentIndex].getName());
            }
        }

        for(int classIndex = 0; classIndex < school.length; classIndex++){
            Student topStudent = school[classIndex][0];
            for(int studentIndex = 1; studentIndex < school[classIndex].length; studentIndex++){
                if(school[classIndex][studentIndex].getGrade() > topStudent.getGrade()){
                    topStudent = school[classIndex][studentIndex];
                }
            }
            System.out.println("Top student in Class " + (classIndex+1) + ": "
                    + topStudent.getName() + " (Grade: " + topStudent.getGrade() + ")");
        }
    }
}
