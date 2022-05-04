package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        Squad.clearAllSquad();
    }

    @Test
    public void newSquadInstantiatesCorrectly_true() {
        Squad squad = Squad.setUpNewSquad();
        assertTrue(squad instanceof Squad);
    }

    @Test
    void newSquadgetName_String() throws Exception {
        Squad squad = Squad.setUpNewSquad();
        assertEquals("Justice", squad.getName());
    }

    @Test
    void newSquadgetCause_String() throws Exception {
        Squad squad = Squad.setUpNewSquad();
        assertEquals("Justice", squad.getCause());
    }

    @Test
    void newSquadgetSize_Int() throws Exception {
        Squad squad = Squad.setUpNewSquad();
        assertEquals(10, squad.getSize());
    }

    @Test
    void newSquadgetSquadId_Int() throws Exception {
        Squad.clearAllSquad();
        Squad squad = Squad.setUpNewSquad();
        assertEquals(1, squad.getSquadId());
    }

    @Test
    void newSquadgetInstances_true() throws Exception {
        Squad squad = Squad.setUpNewSquad();
        Squad squad2 = new Squad("Guners", "fightCorruption", 10);
        assertTrue(Squad.getInstances().contains(squad));
        assertTrue(Squad.getInstances().contains(squad2));
    }

    @Test
    void setMember() throws Exception {
        Hero.clearAllHeroes();
        Hero hero = Hero.setUpNewHero();
        Squad.setMember(hero);
        assertEquals(1, Squad.getMembers().get(0).getId());


    }

    @Test
    void getMembers() throws Exception {
        Squad squad = Squad.setUpNewSquad();
        Hero hero = Hero.setUpNewHero();
        squad.setMember(hero);
        assertEquals("SuperMan", Squad.getMembers().get(0).getName());


    }

    @Test
    void findBySquadId() {
        Squad squad = Squad.setUpNewSquad();
        assertEquals(1, Squad.findBySquadId(squad.getSquadId()).getSquadId());
//    } @Test
//    public void addMember_addsHeroMemberToSquad(){
//        Hero hero = Hero.setUpNewHero();
//        Squad squad = Squad.findBySquadId();
//        squad.clearAllMember();
//        squad.getMember().add(hero);
//        assertEquals(1,squad.getMember().size());
//    }

    }
}