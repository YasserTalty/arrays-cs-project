package samplearrays;

public class CourseNumbersArray {
    int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
    public void addCourse(int newCourse){
        int [] updatedCourses = new int[registeredCourses.length + 1];
        for(int i = 0; i <registeredCourses.length; i++){
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[registeredCourses.length] = newCourse;
        registeredCourses = updatedCourses;
    }
    public void printCourses(){
        for(int course : registeredCourses){
            System.out.println("Course: " +course);
        }
        System.out.println("");
    }
    public static void main(String[] args){
        CourseNumbersArray obj = new CourseNumbersArray();
        System.out.println("Before adding : ");
        obj.printCourses();
        obj.addCourse(2077);
        System.out.println("After adding : ");
        obj.printCourses();

    }
}
