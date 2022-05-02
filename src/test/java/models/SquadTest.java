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
    void newSquadgetName_true() throws Exception {
        Squad squad =Squad.setUpNewSquad();
        assertEquals("Justice",squad.getName());
    }

    @Test
    void newSquadgetCause_true() throws Exception {
        Squad squad =Squad.setUpNewSquad();
        assertEquals("Justice",squad.getCause());
    }

    @Test
    void newSquadgetSize_int()throws Exception {
        Squad squad =Squad.setUpNewSquad();
        assertEquals(10,squad.getSize());
    }

    @Test
    void newSquadgetSquadId_true() throws Exception {
        Squad.clearAllSquad();
        Squad squad =Squad.setUpNewSquad();
        assertEquals(1,squad.getSquadId());
    }

    @Test
    void newSquadgetInstances_true() throws Exception {
        Squad squad =Squad.setUpNewSquad();
        Squad squad2= new Squad("Guners","fightCorruption",10);
        assertTrue(Squad.getInstances().contains(squad));
        assertTrue(Squad.getInstances().contains(squad2));
    }

    @Test
    void setMember() {
    }

    @Test
    void getMember() {
    }

    @Test
    void clearAllSquad() {
    }

    @Test
    void findById() {
    }
}