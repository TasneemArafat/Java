public class Dog extends Animal{
    public String type;
    public Dog(){
        super("Animal");
        type = "mammal";
        System.out.println("Iam a dog");
    }

    public void display(){
        System.out.println("here is a dog");
    }

    public void printMessage(){
        display();
        super.display();
    }

    public void printType(){
        System.out.println(type);
        System.out.println(super.type);
    }
}