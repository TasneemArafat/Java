public class ProjectTest{
    public static void main(String[] args){
        Project first = new Project();
        first.setName("Bookify");
        first.setDesc("Mlokheye Python Project");
        first.setCost(50);
        System.out.println(first.elevatorPitch());
        System.out.println(first.getName());
        Project second = new Project("Tasneem");
        System.out.println(second.elevatorPitch());
    }
}