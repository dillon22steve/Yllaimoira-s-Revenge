package utilz.constants.character_constants.attacks;

import characters.attacks.Attack;

public class AttackConstants {

    public static Attack Kick;
    public static Attack Punch;
    public static Attack Slap;
    public static Attack ShieldBash;
    public static Attack Riposte;
    public static Attack Counter;


    public static void InitAttacks() {
        Kick = new Attack(5, 1, 1, "Kick");
        Punch = new Attack(5, 1, 1, "Punch");
        Slap = new Attack(3, 0, 1, "Slap");

        ShieldBash = new Attack(10, 1, 1, "Shield Bash");
        Counter = new Attack(14, 2, 2, "Counter");
        Riposte = new Attack(18, 3, 3, "Riposte");
    } //InitAttacks
    
} //AttackConstants
