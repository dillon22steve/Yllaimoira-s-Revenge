package utilz.constants.character_constants.attacks.spells;

import characters.attacks.Spell;

public class DamageSpells {
    
    public static Spell Firebolt;
    public static Spell Frostbite;
    public static Spell Thunderclap;
    public static Spell TollTheDead;
    public static Spell BurningHands;
    public static Spell ChaosBolt;
    public static Spell EarthTremor;
    public static Spell ThunderWave;
    public static Spell CloudOfDaggers;
    public static Spell ScorchingRay;
    public static Spell Shatter;
    public static Spell Fireball;
    public static Spell LightningBolt;
    public static Spell IceStorm;
    public static Spell WallOfFire;

    //Warlock specific
    public static Spell EldritchBlast;

    //Druid
    public static Spell ThornWhip;
    public static Spell Moonbeam;
    public static Spell TidalWave;

    //Bard specific
    public static Spell ViciousMockery;

    //Wizard Specific
    public static Spell PhantasmalKiller;

    //Cleric specific
    public static Spell SpiritGuardians;


    public static void InitDamageSpells() {
        Firebolt = new Spell(10, 1, 1, "Firebolt");
        Frostbite = new Spell(10, 1, 1, "Frostbite");
        Thunderclap = new Spell(10, 1, 1, "Thunderclap");
        TollTheDead = new Spell(10, 1, 1, "Toll the Dead");
        ThornWhip = new Spell(10, 1, 1, "Thorn Whip");

        //Need to update this to account for AOE
        EarthTremor = new Spell(6, 1, 2, "Earth Tremor");

        BurningHands = new Spell(18, 3, 3, "Burning Hands");
        CloudOfDaggers = new Spell(22, 4, 4, "Cloud of Daggers");
        ChaosBolt = new Spell(22, 3, 5, "Chaos Bolt");
        Moonbeam = new Spell(22, 2, 5, "Moonbeam");

        //Need to update this to account for AOE
        ThunderWave = new Spell(16, 2, 6, "Thunderwave");

        //Need to update this to account for multiple targets
        ScorchingRay = new Spell(12, 2, 7, "Scorching Ray");

        //Need to update this to account for AOE
        Shatter = new Spell(24, 3, 8, "Shatter");
        SpiritGuardians = new Spell(24, 3, 8, "Spirit Guardians");

        //Need to update this to account for AOE
        Fireball = new Spell(48, 8, 10, "Fireball");
        LightningBolt = new Spell(48, 8, 10, "Lightning Bolt");

        //Need to update these to account for AOE
        IceStorm = new Spell(60, 8, 15, "Ice Storm");
        WallOfFire = new Spell(60, 8, 15, "Wall of Fire");

        PhantasmalKiller = new Spell(60, 8, 15, "Phantasmal Killer");
    } //InitDamageSpells

} //SpellConstants
