package ui.bars.combat_menu;

public class SelectionBar extends CombatMenuBar {
    
    public SelectionBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        initButtons();
    } //constructor

    private void initBtns() {
        btns = new CombatMenuBtn[3];
        int btnWidth = this.width / 2;
        int btnHeight = this.height / 2;
        btns[0] = new CombatMenuBtn("Attack", btnWidth, btnHeight, this.xPos, this.yPos);
        btns[1] = new CombatMenuBtn("Potions", btnWidth, btnHeight, (this.xPos + btnWidth), this.yPos);
        btns[2] = new CombatMenuBtn("Run Away", btnWidth, btnHeight, (this.xPos + (btnWidth / 2)), this.yPos + btnHeight);
    } //initBtns

} //SelectionBar
