public class Animal{
    public String type;

    public Animal(){
        type = "animal";
        System.out.println("Iam an animal");
    }

    public Animal (String type){
        this.type = type;
        System.out.println("Type: " + type);
    }

    public void display(){
        System.out.println("here is an animal");
    }

}