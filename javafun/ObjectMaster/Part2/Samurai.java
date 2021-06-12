public class Samurai extends Human{
    private int health = 200;
    public static int count = 0;

    public Samurai(){
        count+=1;
    }

    public void deathBlow(Human attacked){
        this.setHealth(this.getHealth()/2);
        attacked.setHealth(0);
    }

    public void meditate(){
        this.setHealth(this.getHealth() + this.getHealth()/2);
    }

    public static int howMany(){
        return count;
    }
}