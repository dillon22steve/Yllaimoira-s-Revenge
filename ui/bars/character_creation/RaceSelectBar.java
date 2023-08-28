package ui.bars.character_creation;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import ui.buttons.CharCreatBtn;
import utilz.Constants;
import utilz.Enums;

public class RaceSelectBar extends CharacterCreationBar {
    CharCreatBtn[] races = {
        new CharCreatBtn("Human", 75, 40, 50, 100),
        new CharCreatBtn("High Elf", 75, 40, 50, 170),
        new CharCreatBtn("Wood Elf", 75, 40, 50, 240),
        new CharCreatBtn("Dark Elf", 75, 40, 50, 310),
        new CharCreatBtn("Half-Elf", 75, 40, 50, 380),
        new CharCreatBtn("Dwarf", 75, 40, 50, 450),
        new CharCreatBtn("Tiefling", 75, 40, 50, 520),
        new CharCreatBtn("Gnome", 75, 40, 50, 590),
        new CharCreatBtn("Dragonborn", 75, 40, 50, 660),
        new CharCreatBtn("Halfling", 75, 40, 50, 730),
        new CharCreatBtn("Half-Orc", 75, 40, 50, 800),
    };


    public static int selectedRace = 0;
    String raceDescr;
    
    public RaceSelectBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        super.btns = races;
    } //constructor


    public void draw(Graphics g) {
        drawButtons(g);
        drawRaceDescr(g, selection);
    } //draw


    private void drawRaceDescr(Graphics g, int race) {
        switch(race) {
            case Constants.Races.HUMAN:
                selectedName = "Human";
                desc = Constants.RaceDescriptions.HUMAN_DESC;
                attributes = "All ability scores increase by 1";
                break;
            case Constants.Races.HIGH_ELF:
                selectedName = "High Elf";
                desc = Constants.RaceDescriptions.HIGH_ELF_DESC;
                attributes = "Dexterity + 2,   Intelligence + 1";
                break;
            case Constants.Races.WOOD_ELF:
                selectedName = "Wood Elf";
                desc = Constants.RaceDescriptions.WOOD_ELF_DESC;
                attributes = "Dexterity + 2,   Wisdom + 1";
                break;
            case Constants.Races.DARK_ELF:
                selectedName = "Dark Elf";
                desc = Constants.RaceDescriptions.DARK_ELF_DESC;
                attributes = "Dexterity + 2,   Charisma + 1";
                break;
            case Constants.Races.HALF_ELF:
                selectedName = "Half-Elf";
                desc = Constants.RaceDescriptions.HALF_ELF_DESC;
                attributes = "Charisma + 2,   Two other ability scores + 1";
                break;
            case Constants.Races.DWARF:
                selectedName = "Dwarf";
                desc = Constants.RaceDescriptions.DWARF_DESC;
                attributes = "Constitution + 2";
                break;
            case Constants.Races.TIEFLING:
                selectedName = "Tiefling";
                desc = Constants.RaceDescriptions.TIEFLING_DESC;
                attributes = "Intelligence + 1,   Charisma + 2";
                break;
            case Constants.Races.GNOME:
                selectedName = "Gnome";
                desc = Constants.RaceDescriptions.GNOME_DESC;
                attributes = "Intelligence + 2";
                break;
            case Constants.Races.DRAGONBORN:
                selectedName = "Dragonborn";
                desc = Constants.RaceDescriptions.DRAGONBORN_DESC;
                attributes = "Strengh + 2,   Charisma + 1";
                break;
            case Constants.Races.HALFLING:
                selectedName = "Halfling";
                desc = Constants.RaceDescriptions.HALFLING_DESC;
                attributes = "Dexterity + 2";
                break;
            case Constants.Races.HALF_ORC:
                selectedName = "Half-Orc";
                desc = Constants.RaceDescriptions.HALF_ORC_DESC;
                attributes = "Strength +2,   Constitution + 1";
                break;
        } //switch

        g.setFont(Constants.Fonts.CHAR_CREAT_RACE_NAME_FONT);
        g.drawString("Race:", 350, 130);
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
        g.setFont(Constants.Fonts.CHAR_CREAT_RACE_NAME_FONT);
        g.drawString("Attributes:", 350, yPos);
        g.setFont(Constants.Fonts.CHAR_CREAT_DESC_FONT);
        g.drawString(attributes, 650, yPos);
    } //drawRaceDesc


    /*
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.UP:
                isSelected = false;
                if(selection > 0) {
                    selection = selection - 1;
                } else {
                    selection = (races.length - 1);
                } //if
                break;
            case Constants.KeyboardConstants.DOWN:
                isSelected = false;
                if (selection < (races.length - 1)) {
                    selection = selection + 1;
                } else {
                    selection = 0;
                } //if
                break;
            case Constants.KeyboardConstants.ENTER:
                isSelected = true;
                break;
        } //switch
    } //keyPressed


    public void mouseMoved(int x, int y) {
        for (int i = 0; i < races.length; i++) {
            if ((races[i].getBounds().contains(x, (y - 25))) ||
                (races[i].getBounds().contains(x, (y + 25)))) {
                selection = i;
            } //if
        } //for
    } //mouseMoved


    public void mouseClicked(int x, int y) {
        if (isSelected == true && (confirmSelecBtn.getBounds().contains(x, y - 25)) ||
            confirmSelecBtn.getBounds().contains(x, y + 25)) {
            Enums.CharacterCreationStates.State = Enums.CharacterCreationStates.CLASS_SELECT;
            return;
        }
        for (int i = 0; i < races.length; i++) {
            if ((races[i].getBounds().contains(x, (y - 25))) ||
                (races[i].getBounds().contains(x, (y + 25)))) {
                isSelected = true;
                selection = i;
            } //if
        } //for
    } //mouseClicked
    */
    
}
