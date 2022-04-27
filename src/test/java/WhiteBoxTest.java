package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import main.java.character.CharacterFactory;
import main.java.character.CharacterType;
import main.java.character.ConcreteCharacter;
import main.java.character.ElfCharacter;
import main.java.character.FaerieCharacter;
import main.java.character.HumanCharacter;
import main.java.character.OrcCharacter;
import main.java.character.WizardCharacter;
import main.java.dungeon.CandyRealm;
import main.java.dungeon.Dungeon;
import main.java.dungeon.FireRealm;
import main.java.dungeon.GoldRealm;
import main.java.dungeon.IceRealm;
import main.java.dungeon.MudRealm;
import main.java.dungeon.SlimeRealm;
import main.java.item.HealingPotion;
import main.java.item.ObscuringPotion;
import main.java.item.ParalyzingPotion;
import main.java.item.PermanentItem;
import main.java.item.SleepingPotion;
import main.java.item.TemporaryItem;
import main.java.item.WeakeningPotion;
import main.java.weapon.Bow;
import main.java.weapon.Club;
import main.java.weapon.Sceptre;
import main.java.weapon.Sword;
import main.java.weapon.Wand;
import main.java.weapon.Weapon;

public class WhiteBoxTest {

    private ConcreteCharacter char1;
    private ConcreteCharacter char2;
    private ConcreteCharacter char3;
    private ConcreteCharacter char4;
    private ConcreteCharacter char5;
    private Weapon weapon1;
    private Weapon weapon2;
    private Weapon weapon3;
    private Weapon weapon4;
    private Weapon weapon5;
    private PermanentItem item;
    private TemporaryItem potion;
    private Dungeon dungeon;
    private MudRealm mudRealm;
    private CandyRealm candyRealm;
    private SlimeRealm slimeRealm;
    private IceRealm iceRealm;
    private FireRealm fireRealm;
    private GoldRealm goldRealm;


    @org.junit.Before
    public void setUp() throws Exception {

        char1 = CharacterFactory.buildCharacter(CharacterType.ORC);
        char2 = CharacterFactory.buildCharacter(CharacterType.ELF);
        char3 = CharacterFactory.buildCharacter(CharacterType.HUMAN);
        char4 = CharacterFactory.buildCharacter(CharacterType.WIZARD);
        char5 = CharacterFactory.buildCharacter(CharacterType.FAERIE);
        weapon1 = new Club(char1);
        weapon2 = new Bow(char2);
        weapon3 = new Sword(char3);
        weapon4 = new Sceptre(char4);
        weapon5 = new Wand(char5);

        item = new PermanentItem(char1);
        potion = new TemporaryItem(char1);

        dungeon = new Dungeon();
        mudRealm = new MudRealm(dungeon);
        candyRealm = new CandyRealm(dungeon);
        slimeRealm = new SlimeRealm(dungeon);
        iceRealm = new IceRealm(dungeon);
        fireRealm = new FireRealm(dungeon);
        goldRealm = new GoldRealm(dungeon);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCharacterTypeOrc() {
        assertEquals(char1.getClass(), OrcCharacter.class);
    }

    @Test
    public void testCharacterTypeElf() {
        assertEquals(char2.getClass(), ElfCharacter.class);
    }

    @Test
    public void testCharacterTypeHuman() {
        assertEquals(char3.getClass(), HumanCharacter.class);
    }

    @Test
    public void testCharacterTypeWizard() {
        assertEquals(char4.getClass(), WizardCharacter.class);
    }

    @Test
    public void testCharacterTypeFaerie() {
        assertEquals(char5.getClass(), FaerieCharacter.class);
    }

    @Test
    public void testNewWeaponClub() {
        assertEquals(weapon1.getClass(), Club.class);
    }

    @Test
    public void testNewWeaponBow() {
        assertEquals(weapon2.getClass(), Bow.class);
    }

    @Test
    public void testNewWeaponSword() {
        assertEquals(weapon3.getClass(), Sword.class);
    }

    @Test
    public void testNewWeaponSceptre() {
        assertEquals(weapon4.getClass(), Sceptre.class);
    }

    @Test
    public void testNewWeaponWand() {
        assertEquals(weapon5.getClass(), Wand.class);
    }

    @Test
    public void testTakeDamageDamageVariable() {
        char1.setDefense(10);
        int damage = char1.takeDamage(50);
        assertEquals(damage, 45);
    }

    @Test
    public void testTakeDamageHealthPoints() {
        char1.setDefense(10);
        char1.setHealthPoints(100);
        char1.takeDamage(50);
        assertEquals(char1.getHealthPoints(), 55);
    }

    @Test
    public void testHeal() {
        char1.setHealthPoints(80);
        char1.setTotalHP(100);
        char1.heal();
        assertEquals(char1.getHealthPoints(), 100);
    }

    @Test
    public void testHealMaxHP() {
        char1.setHealthPoints(100);
        char1.setTotalHP(100);
        char1.heal();
        assertEquals(char1.getHealthPoints(), 100);
    }

    @Test
    public void testStrikeFirstTrue() {
        assertTrue(char1.strikeFirst(0));
    }

    @Test
    public void testStrikeFirstFalse() {
        assertFalse(char1.strikeFirst(char1.getMaxSpeed() - 1));
    }

    @Test
    public void testStrikeFailFalse() {
        assertFalse(char1.strikeFail(0));
    }

    @Test
    public void testStrikeFailTrue() {
        assertTrue(char1.strikeFail(char1.getMaxAccuracy() - 1));
    }

    @Test
    public void testfindTreasureTrue() {
        assertTrue(char1.findTreasure(0));
    }

    @Test
    public void testfindTreasureFalse() {
        assertFalse(char1.findTreasure(char1.getMaxLuck() - 1));
    }

    @Test
    public void testCriticalStrikeTrue() {
        assertTrue(char1.criticalStrike(0));
    }

    @Test
    public void testCriticalStrikeFalse() {
        assertFalse(char1.criticalStrike(char1.getMaxCriticalStrike()));
    }

    @Test
    public void testFindRandom() {
        int rand = char1.findRandom(10);
        assertTrue(rand < 10);
    }

    @Test
    public void testSetHealthPoints() {
        char3.setHealthPoints(-3);
        assertEquals(char3.getHealthPoints(), 0);
    }

    @Test
    public void testSetExpPointsAndGetLevel1() {
        char3.setExpPoints(0);
        assertEquals(char3.getLevel(), 1);
    }

    @Test
    public void testSetExpPointsAndGetLevel2() {
        char3.setExpPoints(50);
        assertEquals(char3.getLevel(), 2);
    }

    @Test
    public void testSetExpPointsAndGetLevel3() {
        char3.setExpPoints(150);
        assertEquals(char3.getLevel(), 3);
    }

    @Test
    public void testSetExpPointsAndGetLevel4() {
        char3.setExpPoints(300);
        assertEquals(char3.getLevel(), 4);
    }

    @Test
    public void testSetExpPointsAndGetLevel5() {
        char3.setExpPoints(500);
        assertEquals(char3.getLevel(), 5);
    }

    @Test
    public void testSetExpPointsAndGetLevel6() {
        char3.setExpPoints(750);
        assertEquals(char3.getLevel(), 6);
    }

    @Test
    public void testSetExpPointsAndGetLevel7() {
        char3.setExpPoints(1050);
        assertEquals(char3.getLevel(), 7);
    }

    @Test
    public void testSetExpPointsAndGetLevel8() {
        char3.setExpPoints(1400);
        assertEquals(char3.getLevel(), 8);
    }

    @Test
    public void testSetExpPointsAndGetLevel9() {
        char3.setExpPoints(1800);
        assertEquals(char3.getLevel(), 9);
    }

    @Test
    public void testSetExpPointsAndGetLevel10() {
        char3.setExpPoints(2250);
        assertEquals(char3.getLevel(), 10);
    }

    @Test
    public void testSetExpPointsAndGetLevel11() {
        char3.setExpPoints(2750);
        assertEquals(char3.getLevel(), 11);
    }

    @Test
    public void testSetExpPointsAndGetLevel12() {
        char3.setExpPoints(3300);
        assertEquals(char3.getLevel(), 12);
    }

    @Test
    public void testSetExpPointsAndGetLevel13() {
        char3.setExpPoints(3990);
        assertEquals(char3.getLevel(), 13);
    }

    @Test
    public void testSetExpPointsAndGetLevel14() {
        char3.setExpPoints(4550);
        assertEquals(char3.getLevel(), 14);
    }

    @Test
    public void testSetExpPointsAndGetLevel15() {
        char3.setExpPoints(5250);
        assertEquals(char3.getLevel(), 15);
    }

    @Test
    public void testGetTreasureTemporaryItem() {
        char1.getTreasure(0, weapon5, item, potion);
        assertEquals(char1.getTemporaryItems().size(), 1);
    }

    @Test
    public void testGetTreasureWeapon() {
        char1.getTreasure(4, weapon5, item, potion);
        assertEquals(char1.getWeapons().size(), 1);
    }

    @Test
    public void testLevelUp() {
        char4.setTotalHP(100);
        char4.levelUp();
        assertEquals(char4.getTotalHP(), 120);
    }

    @Test
    public void testSpecialSkillHuman() {
        int a = char3.getExpPoints();
        char3.specialSkill();
        int b = char3.getExpPoints();
        assertTrue(b > a);
    }

    @Test
    public void testGetWeaponSword() {
        weapon5.getWeapon(0, char5);
        assertEquals(char5.getWeapons().get(0).getClass(), Sword.class);
    }

    @Test
    public void testGetWeaponBow() {
        weapon5.getWeapon(1, char5);
        assertEquals(char5.getWeapons().get(0).getClass(), Bow.class);
    }

    @Test
    public void testGetWeaponClub() {
        weapon5.getWeapon(2, char5);
        assertEquals(char5.getWeapons().get(0).getClass(), Club.class);
    }

    @Test
    public void testGetWeaponWand() {
        weapon5.getWeapon(3, char5);
        assertEquals(char5.getWeapons().get(0).getClass(), Wand.class);
    }

    @Test
    public void testGetWeaponSceptre() {
        weapon5.getWeapon(4, char5);
        assertEquals(char5.getWeapons().get(0).getClass(), Sceptre.class);
    }

    @Test
    public void testGetWeaponDropWeapon() {
        char1.setWeapons(weapon1);
        char1.setWeapons(weapon4);
        int a = char1.getWeapons().size();
        weapon1.getWeapon(0, char1);
        int b = char1.getWeapons().size();
        assertEquals(a, b);
    }

    @Test
    public void testGetWeaponSameWeapon() {
        char1.setWeapons(weapon1);
        char1.setWeapons(weapon4);
        int a = char1.getWeapons().size();
        weapon1.getWeapon(4, char1);
        int b = char1.getWeapons().size();
        assertEquals(a, b);
    }

    @Test
    public void testWhichWeapon1() {
        char3.setWeapons(weapon3);
        Weapon weapon = weapon3.whichWeapon(char3);
        assertTrue(weapon.equals(weapon3));
    }

    @Test
    public void testWhichWeapon2() {
        char3.setWeapons(weapon1);
        char3.setWeapons(weapon2);
        Weapon weapon = weapon1.whichWeapon(char3);
        assertTrue(weapon.equals(weapon1)
                || weapon.equals(weapon2));
    }

    @Test
    public void testWhichWeapon2b() {
        char3.setWeapons(weapon5);
        char3.setWeapons(weapon4);
        Weapon weapon = weapon5.whichWeapon(char3);
        assertTrue(weapon.equals(weapon5)
                || weapon.equals(weapon4));
    }

    @Test
    public void testWhichWeapon3() {
        char3.setWeapons(weapon1);
        char3.setWeapons(weapon2);
        char3.setWeapons(weapon3);
        Weapon weapon = weapon1.whichWeapon(char3);
        assertTrue(weapon.equals(weapon1)
                || weapon.equals(weapon2)
                || weapon.equals(weapon3));
    }

    @Test
    public void testWhichWeapon3b() {
        char3.setWeapons(weapon5);
        char3.setWeapons(weapon4);
        char3.setWeapons(weapon3);
        Weapon weapon = weapon5.whichWeapon(char3);
        assertTrue(weapon.equals(weapon5)
                || weapon.equals(weapon4)
                || weapon.equals(weapon3));
    }

    @Test
    public void testWhichWeapon4() {
        char3.setWeapons(weapon1);
        char3.setWeapons(weapon2);
        char3.setWeapons(weapon3);
        char3.setWeapons(weapon4);
        Weapon weapon = weapon1.whichWeapon(char3);
        assertTrue(weapon.equals(weapon1)
                || weapon.equals(weapon2)
                || weapon.equals(weapon3)
                || weapon.equals(weapon4));
    }

    @Test
    public void testWhichWeapon4b() {
        char3.setWeapons(weapon5);
        char3.setWeapons(weapon4);
        char3.setWeapons(weapon3);
        char3.setWeapons(weapon2);
        Weapon weapon = weapon5.whichWeapon(char3);
        assertTrue(weapon.equals(weapon5)
                || weapon.equals(weapon4)
                || weapon.equals(weapon3)
                || weapon.equals(weapon2));
    }

    @Test
    public void testWhichWeapon5() {
        char3.setWeapons(weapon1);
        char3.setWeapons(weapon2);
        char3.setWeapons(weapon3);
        char3.setWeapons(weapon4);
        char3.setWeapons(weapon5);
        Weapon weapon = weapon1.whichWeapon(char3);
        assertTrue(weapon.equals(weapon1)
                || weapon.equals(weapon2)
                || weapon.equals(weapon3)
                || weapon.equals(weapon4)
                || weapon.equals(weapon5));
    }

    @Test
    public void testWhichWeapon5b() {
        char3.setWeapons(weapon5);
        char3.setWeapons(weapon4);
        char3.setWeapons(weapon3);
        char3.setWeapons(weapon2);
        char3.setWeapons(weapon1);
        Weapon weapon = weapon1.whichWeapon(char3);
        assertTrue(weapon.equals(weapon5)
                || weapon.equals(weapon4)
                || weapon.equals(weapon3)
                || weapon.equals(weapon2)
                || weapon.equals(weapon1));
    }

    @Test
    public void testStrikeClub() {
        char1.setExpPoints(0);
        int damage = weapon1.strike(char1);
        assertEquals(damage, 15);
    }

    @Test
    public void testStrikeBow() {
        char1.setExpPoints(0);
        int damage = weapon2.strike(char1);
        assertEquals(damage, 7);
    }

    @Test
    public void testStrikeSword() {
        char1.setExpPoints(0);
        int damage = weapon3.strike(char1);
        assertEquals(damage, 10);
    }

    @Test
    public void testStrikeSceptre() {
        char1.setExpPoints(0);
        int damage = weapon4.strike(char1);
        assertTrue(damage >= 5 && damage <= 20);
    }

    @Test
    public void testStrikeWand() {
        char1.setExpPoints(0);
        int damage = weapon5.strike(char1);
        assertEquals(damage, 5);
    }

    @Test
    public void testGetPermanentItemHelmet() {
        int a = char1.getCriticalStrike();
        item.getItem(0, char1, item);
        int b = char1.getCriticalStrike();
        assertTrue(b > a);
    }

    @Test
    public void testGetPermanentItemShield() {
        int a = char1.getDefense();
        item.getItem(1, char1, item);
        int b = char1.getDefense();
        assertTrue(b > a);
    }

    @Test
    public void testGetPermanentItemBoots() {
        int a = char1.getSpeed();
        item.getItem(2, char1, item);
        int b = char1.getSpeed();
        assertTrue(b > a);
    }

    @Test
    public void testGetPermanentItemArmor() {
        int a = char1.getStrength();
        item.getItem(3, char1, item);
        int b = char1.getStrength();
        assertTrue(b > a);
    }

    @Test
    public void testGetPermanentItemCharm() {
        int a = char1.getLuck();
        item.getItem(4, char1, item);
        int b = char1.getLuck();
        assertTrue(b > a);
    }

    @Test
    public void testGetPermanentItemGlasses() {
        int a = char1.getAccuracy();
        item.getItem(5, char1, item);
        int b = char1.getAccuracy();
        assertTrue(b > a);
    }

    @Test
    public void testGeTemporaryItemHealingPotion() {
        potion.getItem(0, char2, item);
        assertEquals(char2.getTemporaryItems().get(0).getClass(), HealingPotion.class);
    }

    @Test
    public void testGeTemporaryItemSleepingPotion() {
        potion.getItem(1, char2, item);
        assertEquals(char2.getTemporaryItems().get(0).getClass(), SleepingPotion.class);
    }

    @Test
    public void testGeTemporaryItemObscuringPotion() {
        potion.getItem(2, char2, item);
        assertEquals(char2.getTemporaryItems().get(0).getClass(), ObscuringPotion.class);
    }

    @Test
    public void testGeTemporaryItemParalyzingPotion() {
        potion.getItem(3, char2, item);
        assertEquals(char2.getTemporaryItems().get(0).getClass(), ParalyzingPotion.class);
    }

    @Test
    public void testGeTemporaryItemWeakeningPotion() {
        potion.getItem(4, char2, item);
        assertEquals(char2.getTemporaryItems().get(0).getClass(), WeakeningPotion.class);
    }

    @Test
    public void testUpdateRealmMudRealm() {
        dungeon.setRealm(mudRealm);
        dungeon.updateRealm();
        assertEquals(dungeon.getRealm().getClass(), candyRealm.getClass());
    }

    @Test
    public void testUpdateRealmCandyRealm() {
        dungeon.setRealm(candyRealm);
        dungeon.updateRealm();
        assertEquals(dungeon.getRealm().getClass(), slimeRealm.getClass());
    }

    @Test
    public void testUpdateRealmSlimeRealm() {
        dungeon.setRealm(slimeRealm);
        dungeon.updateRealm();
        assertEquals(dungeon.getRealm().getClass(), iceRealm.getClass());
    }

    @Test
    public void testUpdateRealmIceRealm() {
        dungeon.setRealm(iceRealm);
        dungeon.updateRealm();
        assertEquals(dungeon.getRealm().getClass(), fireRealm.getClass());
    }

    @Test
    public void testUpdateRealmFireRealm() {
        dungeon.setRealm(fireRealm);
        dungeon.updateRealm();
        assertEquals(dungeon.getRealm().getClass(), goldRealm.getClass());
    }

    @Test
    public void testCalculateDamageMudRealm1() {
        int damage = mudRealm.calculateDamage(1);
        assertTrue(damage < 6);
    }

    @Test
    public void testCalculateDamageMudRealm2() {
        int damage = mudRealm.calculateDamage(10);
        assertTrue(damage < 20 && damage >= 10);
    }

    @Test
    public void testCalculateDamageCandyRealm1() {
        int damage = candyRealm.calculateDamage(1);
        assertTrue(damage < 11 && damage >= 6);
    }

    @Test
    public void testCalculateDamageCandyRealm2() {
        int damage = candyRealm.calculateDamage(10);
        assertTrue(damage < 30 && damage >= 20);
    }

    @Test
    public void testCalculateDamageSlimeRealm1() {
        int damage = slimeRealm.calculateDamage(1);
        assertTrue(damage < 11 && damage >= 6);
    }

    @Test
    public void testCalculateDamageSlimeRealm2() {
        int damage = slimeRealm.calculateDamage(10);
        assertTrue(damage < 30 && damage >= 20);
    }

    @Test
    public void testCalculateDamageIceRealm1() {
        int damage = iceRealm.calculateDamage(1);
        assertTrue(damage < 11);
    }

    @Test
    public void testCalculateDamageIceRealm2() {
        int damage = iceRealm.calculateDamage(5);
        assertTrue(damage < 25 && damage >= 10);
    }

    @Test
    public void testCalculateDamageIceRealm3() {
        int damage = iceRealm.calculateDamage(10);
        assertTrue(damage < 50 && damage >= 30);
    }

    @Test
    public void testCalculateDamageFireRealm1() {
        int damage = fireRealm.calculateDamage(1);
        assertTrue(damage < 11);
    }

    @Test
    public void testCalculateDamageFireRealm2() {
        int damage = fireRealm.calculateDamage(5);
        assertTrue(damage < 25 && damage >= 10);
    }

    @Test
    public void testCalculateDamageFireRealm3() {
        int damage = fireRealm.calculateDamage(10);
        assertTrue(damage < 50 && damage >= 30);
    }

    @Test
    public void testCalculateDamageGoldRealm1() {
        int damage = goldRealm.calculateDamage(1);
        assertTrue(damage < 12);
    }

    @Test
    public void testCalculateDamageGoldRealm2() {
        int damage = goldRealm.calculateDamage(5);
        assertTrue(damage < 30 && damage >= 15);
    }

    @Test
    public void testCalculateDamageGoldRealm3() {
        int damage = goldRealm.calculateDamage(10);
        assertTrue(damage < 60 && damage >= 40);
    }

    @Test
    public void testChooseEnemyMudRealm1() {
        dungeon.setFloor(5);
        String text = mudRealm.chooseEnemy(0);
        assertEquals(text, "The Mega Blob appeared!");
    }

    @Test
    public void testChooseEnemyMudRealm2() {
        dungeon.setFloor(1);
        String text = mudRealm.chooseEnemy(0);
        assertEquals(text, "A mud blob appeared!");
    }

    @Test
    public void testChooseEnemyMudRealm3() {
        dungeon.setFloor(1);
        String text = mudRealm.chooseEnemy(1);
        assertEquals(text, "A cave spider appeared!");
    }

    @Test
    public void testChooseEnemyMudRealm4() {
        dungeon.setFloor(1);
        String text = mudRealm.chooseEnemy(2);
        assertEquals(text, "A sewer rat appeared!");
    }

    @Test
    public void testChooseEnemyCandyRealm1() {
        dungeon.setFloor(5);
        String text = candyRealm.chooseEnemy(0);
        assertEquals(text, "The Psychic Gobstopper appeared!");
    }

    @Test
    public void testChooseEnemyCandyRealm2() {
        dungeon.setFloor(1);
        String text = candyRealm.chooseEnemy(0);
        assertEquals(text, "A candy blob appeared!");
    }

    @Test
    public void testChooseEnemyCandyRealm3() {
        dungeon.setFloor(1);
        String text = candyRealm.chooseEnemy(1);
        assertEquals(text, "A candy goblin appeared!");
    }

    @Test
    public void testChooseEnemyCandyRealm4() {
        dungeon.setFloor(1);
        String text = candyRealm.chooseEnemy(2);
        assertEquals(text, "A candy robot appeared!");
    }

    @Test
    public void testChooseEnemySlimeRealm1() {
        dungeon.setFloor(5);
        String text = slimeRealm.chooseEnemy(0);
        assertEquals(text, "The Slime King appeared!");
    }

    @Test
    public void testChooseEnemySlimeRealm2() {
        dungeon.setFloor(1);
        String text = slimeRealm.chooseEnemy(0);
        assertEquals(text, "A slime blob appeared!");
    }

    @Test
    public void testChooseEnemySlimeRealm3() {
        dungeon.setFloor(1);
        String text = slimeRealm.chooseEnemy(1);
        assertEquals(text, "A slime lizard appeared!");
    }

    @Test
    public void testChooseEnemySlimeRealm4() {
        dungeon.setFloor(1);
        String text = slimeRealm.chooseEnemy(2);
        assertEquals(text, "A slime rat appeared!");
    }

    @Test
    public void testChooseEnemyIceRealm1() {
        dungeon.setFloor(5);
        String text = iceRealm.chooseEnemy(0);
        assertEquals(text, "The Ice Queen appeared!");
    }

    @Test
    public void testChooseEnemyIceRealm2() {
        dungeon.setFloor(1);
        String text = iceRealm.chooseEnemy(0);
        assertEquals(text, "An ice blob appeared!");
    }

    @Test
    public void testChooseEnemyIceRealm3() {
        dungeon.setFloor(1);
        String text = iceRealm.chooseEnemy(1);
        assertEquals(text, "A ghost appeared!");
    }

    @Test
    public void testChooseEnemyIceRealm4() {
        dungeon.setFloor(1);
        String text = iceRealm.chooseEnemy(2);
        assertEquals(text, "An angry yeti appeared!");
    }

    @Test
    public void testChooseEnemyFireRealm1() {
        dungeon.setFloor(5);
        String text = fireRealm.chooseEnemy(0);
        assertEquals(text, "The Hellhound appeared!");
    }

    @Test
    public void testChooseEnemyFireRealm2() {
        dungeon.setFloor(1);
        String text = fireRealm.chooseEnemy(0);
        assertEquals(text, "A fire blob appeared!");
    }

    @Test
    public void testChooseEnemyFireRealm3() {
        dungeon.setFloor(1);
        String text = fireRealm.chooseEnemy(1);
        assertEquals(text, "A lava monster appeared!");
    }

    @Test
    public void testChooseEnemyFireRealm4() {
        dungeon.setFloor(1);
        String text = fireRealm.chooseEnemy(2);
        assertEquals(text, "A flaming skull appeared!");
    }

    @Test
    public void testChooseEnemyGoldRealm1() {
        dungeon.setFloor(5);
        String text = goldRealm.chooseEnemy(0);
        assertEquals(text, "The Golden Gorgon appeared!");
    }

    @Test
    public void testChooseEnemyGoldRealm2() {
        dungeon.setFloor(1);
        String text = goldRealm.chooseEnemy(0);
        assertEquals(text, "A gold blob appeared!");
    }

    @Test
    public void testChooseEnemyGoldRealm3() {
        dungeon.setFloor(1);
        String text = goldRealm.chooseEnemy(1);
        assertEquals(text, "A gold serpent appeared!");
    }

    @Test
    public void testChooseEnemyGoldRealm4() {
        dungeon.setFloor(1);
        String text = goldRealm.chooseEnemy(2);
        assertEquals(text, "A gold dragon appeared!");
    }

    @Test
    public void testSetEnemyHpMudRealm1() {
        mudRealm.setEnemyHP(-3);
        assertEquals(mudRealm.getEnemyHP(), 0);
    }

    @Test
    public void testSetEnemyHpMudRealm2() {
        mudRealm.setEnemyHP(100);
        assertEquals(mudRealm.getEnemyHP(), 100);
    }

    @Test
    public void testSetEnemyHpCandyRealm1() {
        candyRealm.setEnemyHP(-3);
        assertEquals(candyRealm.getEnemyHP(), 0);
    }

    @Test
    public void testSetEnemyHpCandyRealm2() {
        candyRealm.setEnemyHP(100);
        assertEquals(candyRealm.getEnemyHP(), 100);
    }

    @Test
    public void testSetEnemyHpSlimeRealm1() {
        slimeRealm.setEnemyHP(-3);
        assertEquals(slimeRealm.getEnemyHP(), 0);
    }

    @Test
    public void testSetEnemyHpSlimeRealm2() {
        slimeRealm.setEnemyHP(100);
        assertEquals(slimeRealm.getEnemyHP(), 100);
    }

    @Test
    public void testSetEnemyHpIceRealm1() {
        iceRealm.setEnemyHP(-3);
        assertEquals(iceRealm.getEnemyHP(), 0);
    }

    @Test
    public void testSetEnemypIceRealm2() {
        iceRealm.setEnemyHP(100);
        assertEquals(iceRealm.getEnemyHP(), 100);
    }

    @Test
    public void testSetEnemyHpFireRealm1() {
        fireRealm.setEnemyHP(-3);
        assertEquals(fireRealm.getEnemyHP(), 0);
    }

    @Test
    public void testSetEnemyHpFireRealm2() {
        fireRealm.setEnemyHP(100);
        assertEquals(fireRealm.getEnemyHP(), 100);
    }

    @Test
    public void testSetEnemyHpGoldRealm1() {
        goldRealm.setEnemyHP(-3);
        assertEquals(goldRealm.getEnemyHP(), 0);
    }

    @Test
    public void testSetEnemyHpGoldRealm2() {
        goldRealm.setEnemyHP(100);
        assertEquals(goldRealm.getEnemyHP(), 100);
    }

    @Test
    public void testCalculateTotalHpMudRealm() {
        int hp = mudRealm.calculateTotalHP(1);
        assertEquals(hp, 12);
    }

    @Test
    public void testCalculateTotalHpCandyRealm() {
        int hp = candyRealm.calculateTotalHP(1);
        assertEquals(hp, 12);
    }

    @Test
    public void testCalculateTotalHpSlimeRealm() {
        int hp = slimeRealm.calculateTotalHP(1);
        assertEquals(hp, 13);
    }

    @Test
    public void testCalculateTotalHpIceRealm() {
        int hp = iceRealm.calculateTotalHP(1);
        assertEquals(hp, 13);
    }

    @Test
    public void testCalculateTotalHpFireRealm() {
        int hp = fireRealm.calculateTotalHP(1);
        assertEquals(hp, 14);
    }

    @Test
    public void testCalculateTotalHpGoldRealm() {
        int hp = goldRealm.calculateTotalHP(1);
        assertEquals(hp, 15);
    }
}
