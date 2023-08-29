package ui.bars.character_creation;

import java.awt.Graphics;

import ui.buttons.CharCreatBtn;
import utilz.constants.ClassConstants;
import utilz.constants.Constants;

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
            case ClassConstants.Classes.BARBARIAN:
                selectedName = "Barbarian";
                desc = ClassConstants.ClassDescriptions.BARBARIAN_DESC;
                break;
            case ClassConstants.Classes.BARD:
                selectedName = "Bard";
                desc = ClassConstants.ClassDescriptions.BARD_DESC;
                break;
            case ClassConstants.Classes.CLERIC:
                selectedName = "Cleric";
                desc = ClassConstants.ClassDescriptions.CLERIC_DESC;
                break;
            case ClassConstants.Classes.DRUID:
                selectedName = "Druid";
                desc = ClassConstants.ClassDescriptions.DRUID_DESC;
                break;
            case ClassConstants.Classes.FIGHTER:
                selectedName = "Fighter";
                desc = ClassConstants.ClassDescriptions.FIGHTER_DESC;
                break;
            case ClassConstants.Classes.RANGER:
                selectedName = "Ranger";
                desc = ClassConstants.ClassDescriptions.RANGER_DESC;
                break;
            case ClassConstants.Classes.ROGUE:
                selectedName = "Rogue";
                desc = ClassConstants.ClassDescriptions.ROGUE_DESC;
                break;
            case ClassConstants.Classes.SORCERER:
                selectedName = "Sorcerer";
                desc = ClassConstants.ClassDescriptions.SORCERER_DESC;
                break;
            case ClassConstants.Classes.WARLOCK:
                selectedName = "Warlock";
                desc = ClassConstants.ClassDescriptions.WARLOCK_DESC;
                break;
            case ClassConstants.Classes.WIZARD:
                selectedName = "Wizard";
                desc = ClassConstants.ClassDescriptions.WIZARD_DESC;
                break;
        }

        g.setFont(Constants.Fonts.CHAR_CREAT_RACE_NAME_FONT);
        g.drawString("Class:", 350, 130);
        g.drawString(selectedName, 650, 130);
        yPos = 220;
        g.drawString("Description: ", 350, yPos);

        int start = 0;
        int end = 72;
        while (end < desc.length()) {
            if (desc.charAt(end) != ' ') {
                for (int i = end + 1; i < desc.length(); i++) {
                    if (desc.charAt(i) == ' ') {
                        end = i;
                        break;
                    } //if
                } //for
            } //if
            String descSubStr = desc.substring(start, end);
            g.setFont(Constants.Fonts.CHAR_CREAT_DESC_FONT);
            g.drawString(descSubStr, 650, yPos);

            start = end;
            end += 72;
            yPos += 28;
        } //while

        yPos += 50;
        /*
        g.setFont(Constants.Fonts.CHAR_CREAT_RACE_NAME_FONT);
        g.drawString("Attributes:", 350, yPos);
        g.setFont(Constants.Fonts.CHAR_CREAT_DESC_FONT);
        g.drawString(attributes, 650, yPos);
        */
    } //drawClassDescription
    
}
