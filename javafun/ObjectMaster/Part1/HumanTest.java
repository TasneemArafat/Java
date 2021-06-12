public class HumanTest{
    public static void main(String[] args){
        Human Mahmoud = new Human();
        Human Tasnim = new Human();
        System.out.println("Before Attack");
        System.out.println(Mahmoud.health);
        System.out.println(Tasnim.health);
        Mahmoud.attack(Tasnim);
        System.out.println("After Attack");
        System.out.println(Mahmoud.health);
        System.out.println(Tasnim.health);
    }
}