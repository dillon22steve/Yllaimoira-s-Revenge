package quests;

public class Quest {
    private String name;
    private int gold;
    private int xp;
    private String description;

    public Quest(String name, int gold, int xp, String description) {
        this.name = name;
        this.gold = gold;
        this.xp = xp;
        this.description = description;
    } //constructor



    public String getName() {
        return this.name;
    } //getName
    public int getGold() {
        return this.gold;
    } //getGold
    public int getXp() {
        return this.xp;
    } //getXp
    public String getDescription() {
        return this.description;
    } //getDescription
}
