package ui.bars.character_creation;

import java.awt.Graphics;

import ui.buttons.CharCreatBtn;
import utilz.Constants;

public class ClassSelectBar extends CharacterCreationBar {

    CharCreatBtn[] classes = {
        new CharCreatBtn("Barbarian", 75, 40, 50, 100),
        new CharCreatBtn("Bard", 75, 40, 50, 170),
        new CharCreatBtn("Cleric", 75, 40, 50, 240),
        new CharCreatBtn("Druid", 75, 40, 50, 310),
        new CharCreatBtn("Fighter", 75, 40, 50, 380),
        new CharCreatBtn("Paladin", 75, 40, 50, 450),
        new CharCreatBtn("Ranger", 75, 40, 50, 520),
        new CharCreatBtn("Rogue", 75, 40, 50, 590),
        new CharCreatBtn("Sorcerer", 75, 40, 50, 660),
        new CharCreatBtn("Warlock", 75, 40, 50, 730),
        new CharCreatBtn("Wizard", 75, 40, 50, 800),
    };

    public ClassSelectBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        super.btns = classes;
    }

    public void draw(Graphics g) {
        drawButtons(g);
        drawClassDecription(g, selection);
    }

    private void drawClassDecription(Graphics g, int classId) {
        switch(classId) {
            case Constants.Classes.BARBARIAN:
                desc = Constants.ClassDescriptions.BARBARIAN_DESC;
                break;
            case Constants.Classes.BARD:
                desc = Constants.ClassDescriptions.BARD_DESC;
                break;
            case Constants.Classes.CLERIC:
                desc = Constants.ClassDescriptions.CLERIC_DESC;
                break;
            case Constants.Classes.DRUID:
                desc = Constants.ClassDescriptions.DRUID_DESC;
                break;
            case Constants.Classes.FIGHTER:
                desc = Constants.ClassDescriptions.FIGHTER_DESC;
                break;
            case Constants.Classes.RANGER:
                desc = Constants.ClassDescriptions.RANGER_DESC;
                break;
            case Constants.Classes.ROGUE:
                desc = Constants.ClassDescriptions.ROGUE_DESC;
                break;
            case Constants.Classes.SORCERER:
                desc = Constants.ClassDescriptions.SORCERER_DESC;
                break;
            case Constants.Classes.WARLOCK:
                desc = Constants.ClassDescriptions.WARLOCK_DESC;
                break;
            case Constants.Classes.WIZARD:
                desc = Constants.ClassDescriptions.WIZARD_DESC;
                break;
        }
    }
    
}
