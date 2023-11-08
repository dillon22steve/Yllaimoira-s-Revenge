package utilz.constants.character_constants.attacks;

import characters.attacks.Attack;

public class AttackConstants {

    public static Attack Kick;
    public static Attack Punch;
    public static Attack Slap;


    public static void InitAttacks() {
        Kick = new Attack(5, 1, 1, "Kick");
        Punch = new Attack(5, 1, 1, "Punch");
        Slap = new Attack(3, 0, 1, "Slap");
    } //InitAttacks
    
} //AttackConstants
