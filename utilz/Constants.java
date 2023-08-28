package utilz;

import java.awt.Font;

import render.GamePanel;

public class Constants {

    public class Fonts {
        public static Font MAIN_MENU_BTN_FONT = new Font("Bookman Old Style", Font.PLAIN, (int)(0.015* GamePanel.PANEL_WIDTH));
        public static Font MAIN_MENU_TITLE_FONT = new Font("Bookman Old Style", Font.PLAIN, (int)(0.042* GamePanel.PANEL_WIDTH));
        public static Font CHAR_CREAT_BTN_FONT = new Font("Bookman Old Style", Font.PLAIN, (int)(0.015* GamePanel.PANEL_WIDTH));
        public static Font CHAR_CREAT_RACE_NAME_FONT = new Font("Bookman Old Style", Font.BOLD, (int)(0.021* GamePanel.PANEL_WIDTH));
        public static Font CHAR_CREAT_DESC_FONT = new Font("Bookman Old Style", Font.PLAIN, (int)(0.012* GamePanel.PANEL_WIDTH));
    }

    public class KeyboardConstants {
        public static final int ESC = 27;
        public static final int ENTER = 10;

        public static final int LEFT = 37;
        public static final int UP = 38;
        public static final int RIGHT = 39;
        public static final int DOWN = 40;
    }

    public class Races {
        public static final int HUMAN = 0;
        public static final int HIGH_ELF = 1;
        public static final int WOOD_ELF = 2;
        public static final int DARK_ELF = 3;
        public static final int HALF_ELF = 4;
        public static final int DWARF = 5;
        public static final int TIEFLING = 6;
        public static final int GNOME = 7;
        public static final int DRAGONBORN = 8;
        public static final int HALFLING = 9;
        public static final int HALF_ORC = 10;
    }

    public class Classes {
        public static final int BARBARIAN = 0;
        public static final int BARD = 1;
        public static final int CLERIC = 2;
        public static final int DRUID = 3;
        public static final int FIGHTER = 4;
        public static final int PALADIN = 5;
        public static final int RANGER = 6;
        public static final int ROGUE = 7;
        public static final int SORCERER = 8;
        public static final int WARLOCK = 9;
        public static final int WIZARD = 10;
    }

    public class RaceDescriptions {
        public static final String HUMAN_DESC = "In the reckonings of most worlds, humans are the youngest of the common races, late to arrive on the world scene and " +
            "short-lived in comparison to dwarves, elves, and dragons. Perhaps it is because of their shorter lives that they strive to achieve as much as they can in the years " 
            + "they are given. Or maybe they feel they have something to prove to the elder races, and that\u2019s why they build their mighty empires on the foundation of " +
            "conquest and trade. Whatever drives them, humans are the innovators, the achievers, and the pioneers of the worlds.";
        public static final String HIGH_ELF_DESC = "Elves are a magical people of otherworldly grace, living in the world but not entirely part of it. They live in places of ethereal " +
            "beauty, in the midst of ancient forests or in silvery spires glittering with faerie light, where soft music drifts through the air and gentle fragrances waft on the " +
            "breeze. Elves love nature and magic, art and artistry, music and poetry, and the good things of the world. As a high elf, you have a keen mind and a mastery of at " +
            "least the basics of magic.";
        public static final String WOOD_ELF_DESC = "Elves are a magical people of otherworldly grace, living in the world but not entirely part of it. They live in places of ethereal " +
            "beauty, in the midst of ancient forests or in silvery spires glittering with faerie light, where soft music drifts through the air and gentle fragrances waft on the " +
            "breeze. Elves love nature and magic, art and artistry, music and poetry, and the good things of the world. As a wood elf, you have keen senses and intuition, and your " +
            "fleet feet carry you quickly and stealthily through your native forests. They are reclusive and distrusting of non-elves. Wood elves skin tends to be copperish in hue, " +
            "sometimes with traces of green. Their hair tends toward browns and blacks, but it is occasionally blond or copper-colored. Their eyes are green, brown, or hazel.";
        public static final String DARK_ELF_DESC = "Descended from an earlier subrace of dark-skinned elves, the drow were banished from the surface world for following the " + 
            "goddess Lolth down the path to evil and corruption. Now they have built their own civilization in the depths of the Underdark, patterned after the Way of Lolth. " +
            "Also called dark elves. The drow have black skin that resembles polished obsidian and stark white or pale yellow hair. They commonly have very pale eyes (so pale " +
            "as to be mistaken for while) in shades of lilac, silver, pink, red, and blue. They lend to be smaller and thinner than most elves.";
        public static final String HALF_ELF_DESC = "Walking in two worlds but truly belonging to neither, half-elves combine what some say are the best qualities of their elf and " +
            "human parents: human curiosity, inventiveness, and ambition tempered by the refined senses, love of nature, and artistic tastes of the elves. Some half-elves live " +
            "among humans, set apart by their emotional and physical differences, watching friends and loved ones age while time barely touches them. Others live with the elves, " +
            "growing restless as they reach adulthood in the timeless elven realms, while their peers continue to live as children. Many half-elves, unable to fit into either " +
            "society, choose lives of solitary wandering or join with other misfits and outcasts in the adventuring life.";
        public static final String DWARF_DESC = "Bold and hardy, dwarves are known as skilled warriors, miners, and workers of stone and metal. Though they stand well under 5 feet " +
            "tall, dwarves are so broad and compact that they can weigh as much as a human standing nearly two feet taller. Their courage and endurance are also easily a match for " +
            "any of the larger folk. Dwarven skin ranges from deep brown to a paler hue tinged with red, but the most common shades are light brown or deep tan, like certain tones " +
            "of earth. Their hair, worn long but in simple styles, is usually black, gray, or brown, though paler dwarves often have red hair. Male dwarves value their beards " +
            "highly and groom them carefully.";
        public static final String DRAGONBORN_DESC = "Born of dragons, as their name proclaims, the dragonborn walk proudly through a world that greets them with fearful " +
            "incomprehension. Shaped by draconic gods or the dragons themselves, dragonborn originally hatched from dragon eggs as a unique race, combining the best attributes " +
            "of dragons and humanoids. Some dragonborn are faithful servants to true dragons, others form the ranks of soldiers in great wars, and still others find themselves " +
            "adrift, with no clear calling in life.";
        public static final String GNOME_DESC = "A constant hum of busy activity pervades the warrens and neighborhoods where gnomes form their close-knit communities. Louder " +
            "sounds punctuate the hum: a crunch of grinding gears here, a minor explosion there, a yelp of surprise or triumph, and especially bursts of laughter. Gnomes take " +
            "delight in life, enjoying every moment of invention, exploration, investigation, creation, and play.";
        public static final String TIEFLING_DESC = "To be greeted with stares and whispers, to suffer violence and insult on the street, to see mistrust and fear in every eye: " +
            "this is the lot of the tiefling. And to twist the knife, tieflings know that this is because a pact struck generations ago infused the essence of Asmodeus, overlord " +
            "of the Nine Hells, into their bloodline. Their appearance and their nature are not their fault but the result of an ancient sin, for which they and their children " +
            "and their children's children will always be held accountable.";
        public static final String HALFLING_DESC = "The comforts of home are the goals of most halflings\u2019 lives: a place to settle in peace and quiet, far from marauding " +
            "monsters and clashing armies; a blazing fire and a generous meal; fine drink and fine conversation. Though some halflings live out their days in remote " +
            "agricultural communities, others form nomadic bands that travel constantly, lured by the open road and the wide horizon to discover the wonders of new lands and " +
            "peoples. But even these wanderers love peace, food, hearth, and home, though home might be a wagon jostling along a dirt road or a raft floating downriver.";
        public static final String HALF_ORC_DESC = "Whether united under the leadership of a mighty warlock or having fought to a standstill after years of conflict, orc and " +
            "human communities, sometimes form alliances. When these alliances are sealed by marriages, half-orcs are born. Some half-orcs rise to become proud leaders of orc " +
            "communities. Some venture into the world to prove their worth. Many of these become adventurers, achieving greatness for their mighty deeds.";
    }


    public class ClassDescriptions {
        public static final String BARBARIAN_DESC = "People of towns and cities take pride in their settled ways, as if denying one's connection to nature were a mark of " +
            "superiority. To a barbarian, though, a settled life is no virtue, but a sign of weakness. The strong embrace nature--valuing keen instincts, primal physicality, " +
            "and ferocious rage. Barbarians are uncomfortable when hedged in by walls and crowds. They thrive in the wilds of their homelands: the tundra, jungle, or " +
            "grasslands where their tribes live and hunt.Barbarians come alive in the chaos of combat. They can enter a berserk state where rage takes over, giving them " +
            "superhuman strength and resilience. A barbarian can draw on this reservoir of fury only a few times without resting, but those few rages are usually sufficient " +
            "to defeat whatever threats arise.";
        public static final String BARD_DESC = "To bards, words and music are not just vibrations of air, but vocalizations with power all their own. The bard is a master of " +
            "song, speech, and the magic they contain. Bards say that the multiverse was spoken into existence, that the words of the gods gave it shape, and that echoes of " +
            "these primordial Words of Creation still resound throughout the cosmos. The music of bards is an attempt to snatch and harness those echoes, subtly woven into " +
            "their spells and powers. The greatest strength of bards is their sheer versatility. Many bards prefer to stick to the sidelines in combat, using their magic to " +
            "inspire their allies and hinder their foes from a distance. But bards are capable of defending themselves in melee if necessary, using their magic to bolster " +
            "their swords and armor. Their spells lean toward charms and illusions rather than blatantly destructive spells. They have a wide-ranging knowledge of many subjects " +
            "and a natural aptitude that lets them do almost anything well. Bards become masters of the talents they set their minds to perfecting, from musical performance to " +
            "esoteric knowledge.";
        public static final String CLERIC_DESC = "Not every acolyte or officiant at a temple or shrine is a cleric. Some priests are called to a simple life of temple service, " +
            "carrying out their gods' will through prayer and sacrifice, not by magic and strength of arms. In some cities, priesthood amounts to a political office, viewed as a " +
            "stepping stone to higher positions of authority and involving no communion with a god at all. True clerics are rare in most hierarchies. When a cleric takes up an " +
            "adventuring life, it is usually because his or her god demands it. Pursuing the goals of the gods often involves braving dangers in unsettled lands, smiting evil, or " +
            "seeking holy relics in ancient tombs. Many clerics are also expected to protect their deities' worshipers, which can mean fighting enemy raiders, negotiating peace " +
            "between warring nations, or sealing a portal that would allow a demon prince to enter the world. Most adventuring clerics maintain some connection to established " +
            "temples and orders of their faiths. A temple might ask for a cleric's aid, or a high priest might be in a position to demand it.";
        public static final String DRUID_DESC = "Druids revere nature above all, gaining their spells and other magical powers either from the force of nature itself or from a " +
            "nature deity. Many druids pursue a mystic spirituality of transcendent union with nature rather than devotion to a divine entity, while others serve gods of wild " +
            "nature, animals, or elemental forces. The ancient druidic traditions are sometimes called the Old Faith, in contrast to the worship of gods in temples and shrines. " +
            "Druid spells are oriented toward nature and animals--the power of tooth and claw, of sun and moon, of fire and storm. Druids also gain the ability to take on animal " +
            "forms, and some druids make a particular study of this practice, even to the point where they prefer animal form to their natural form.";
        public static final String FIGHTER_DESC = "Fighters learn the basics of all combat styles. Every fighter can swing an axe, fence with a rapier, wield a longsword or a " +
            "greatsword, use a bow, and even trap foes in a net with some degree of skill. Likewise, a fighter is adept with shields and every form of armor. Beyond that basic " +
            "degree of familiarity, each fighter specializes in a certain style of combat. Some concentrate on archery, some on fighting with two weapons at once, and some on " +
            "augmenting their martial skills with magic. This combination of broad general ability and extensive specialization makes fighters superior combatants on battlefields " +
            "and in dungeons alike.";
        public static final String PALADIN_DESC = "A paladin swears to uphold justice and righteousness, to stand with the good things of the world against the encroaching " +
            "darkness, and to hunt the forces of evil wherever they lurk. Different paladins focus on various aspects of the cause of righteousness, but all are bound by the " +
            "oaths that grant them power to do their sacred work. Although many paladins are devoted to gods of good, a paladin's power comes as much from a commitment to justice " +
            "itself as it does from a god. Paladins train for years to learn the skills of combat, mastering a variety of weapons and armor. Even so, their martial skills are " +
            "secondary to the magical power they wield: power to heal the sick and injured, to smite the wicked and the undead, and to protect the innocent and those who join " +
            "them in the fight for justice.";
        public static final String RANGER_DESC = "";
        public static final String ROGUE_DESC = "";
        public static final String SORCERER_DESC = "";
        public static final String WARLOCK_DESC = "";
        public static final String WIZARD_DESC = "";
    }
}
