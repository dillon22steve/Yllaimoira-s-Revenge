package characters.attacks;

import java.awt.image.BufferedImage;

public class Spell extends Attack {

    private BufferedImage img;

    public Spell(int maxDamage, int minDamage, int level, String name) {
        super(maxDamage, minDamage, level, name);
        //Update this later to include the artwork
    } //constructor


    public BufferedImage getImg() {
        return this.img;
    } //getImg
    
} //Spell
