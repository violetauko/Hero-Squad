package com.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        Hero.clearAllHeroes();
    }

    @Test
    public void newHeroInstantiatesCorrectly_true() {
        Hero hero = Hero.setUpNewHero();
        assertTrue(hero instanceof Hero);
    }

    @Test
    void newHerogetName_String() throws Exception {
        Hero hero = Hero.setUpNewHero();
        assertEquals("SuperMan",hero.getName());
    }

    @Test
    void newHerogetAge_Int() throws Exception {
        Hero hero = Hero.setUpNewHero();
        assertEquals(34,hero.getAge());
    }

    @Test
    void newHerogetSpecialPower_String() throws Exception {
        Hero hero = Hero.setUpNewHero();
        assertEquals("Speed",hero.getSpecialPower());
    }

    @Test
    void nwHerogetWeakness_String() throws Exception {
        Hero hero = Hero.setUpNewHero();
        assertEquals("Magic",hero.getWeakness());
    }

    @Test
    void newHerogetId_Int() throws Exception {
        Hero.clearAllHeroes();
        Hero hero = Hero.setUpNewHero();
        assertEquals(1, hero.getId());

    }

    @Test
    void newHerogetAll_true() throws Exception{
        Hero hero = Hero.setUpNewHero();
        Hero anotherHero = new Hero("Flash",27,"SuperSpeed","fatigue");
        assertEquals(2, hero.getAll().size());
    }

    @Test
    void findById() {
        Hero hero = Hero.setUpNewHero();
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }
    @Test
    void deleteSpecificHero() throws Exception {
        Hero hero = Hero.setUpNewHero();
        Hero anotherHero = new Hero("Flash",27,"SuperSpeed","fatigue");
        hero.deleteHero();
        assertEquals(1, Hero.getAll().size());
        assertEquals(Hero.getAll().get(0).getId(), 2);


    }
    }