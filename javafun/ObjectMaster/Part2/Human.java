public class Human{
    private int strength = 3;
    private int stealth = 3;
    private int intelligence = 3;
    private int health = 100;

    public void attack(Human attacked){
        attacked.health = attacked.health - this.strength;
    }


    public int getStrength(){
        return this.strength;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }


    public int getStealth(){
        return this.stealth;
    }

    public void setStealth(int stealth){
        this.stealth = stealth;
    }


    public int getIntelligence(){
        return this.intelligence;
    }

    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }


    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

}