package characters.attacks;

public class Attack {

    private int maxDamage;
    private int minDamage;
    private String name;

    public Attack(int maxDamage, int minDamage, int level, String name) {
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.name = name;
    } //constructor



    public int getMaxDamage() {
        return maxDamage;
    } //getMaxDamage

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    } //setMaxDamage

    public int getMinDamage() {
        return minDamage;
    } //getMinDamage

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    } //setMinDamage

    public String getName() {
        return name;
    } //getName

} //Attack
