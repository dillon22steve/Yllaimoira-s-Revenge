package equipment;

public class Equipment {

    private String name;
    private int modifier;

    public Equipment(String name, int modifier) {
        this.name = name;
        this.modifier = modifier;
    }



    public String getName() {
        return this.name;
    }

    public int getModifier() {
        return this.modifier;
    }
    
}
