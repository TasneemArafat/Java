public class HumanTest{
    public static void main(String[] args){
        Human Mahmoud = new Human();
        Ninja Tasnim = new Ninja();
        Samurai Hadeel = new Samurai();
        Samurai Ibtisal = new Samurai();
        Wizard Kamal = new Wizard();
        System.out.println("Before Human Mahmoud Attacked Ninja Tasnim");
        System.out.println("Human Mahmoud's Health: "+ Mahmoud.getHealth());
        System.out.println("Ninja Tasnim's Health: "+ Tasnim.getHealth());
        Tasnim.steal(Mahmoud);
        System.out.println("After Human Mahmoud Attacked Ninja Tasnim");
        System.out.println("Human Mahmoud's Health: "+ Mahmoud.getHealth());
        System.out.println("Ninja Tasnim's Health: "+ Tasnim.getHealth());
        Tasnim.runAway();
        System.out.println("After Ninja Tasnim runAway");
        System.out.println("Ninja Tasnim's Health: "+ Tasnim.getHealth());
        System.out.println("Before Samurai Hadeel deathBlow Wizard Kamal");
        System.out.println("Samurai Hadeel's Health: "+ Hadeel.getHealth());
        System.out.println("Wizard Kamal's Health: "+ Kamal.getHealth());
        Hadeel.deathBlow(Kamal);
        System.out.println("After Samurai Hadeel deathBlow Wizard Kamal");
        System.out.println("Samurai Hadeel's Health: "+ Hadeel.getHealth());
        System.out.println("Wizard Kamal's Health: "+ Kamal.getHealth());
        System.out.println("After Samurai Hadeel meditated");
        Hadeel.meditate();
        System.out.println("Samurai Hadeel's Health: "+ Hadeel.getHealth());
        System.out.println("number of Samurais: " + Samurai.howMany());
    }
}