public class Project{
    private String name;
    private String description;
    private double initialCost;

    public String elevatorPitch(String name, String description){
        return (String.format(name + " ("+ initialCost + ") " + ":" + description));
    }

    public String elevatorPitch(){
        return (String.format(this.name + " ("+ this.initialCost + ") " + " : " + this.description));
    }

    public Project() {}

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDesc(){
        return description;
    }

    public void setDesc(String desc){
        description = desc;
    }

    public double getCost(){
        return initialCost;
    }

    public void setCost(double cost){
        initialCost = cost;
    }
}

