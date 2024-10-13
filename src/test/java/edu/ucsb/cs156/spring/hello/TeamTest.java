package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void testEquals_sameObject() {
        Team team1 = new Team("Team 1");
        team1.addMember("Alice");
        team1.addMember("Bob");
        assertEquals(true, team1.equals(team1));
    }

    @Test
    public void testEquals_differentClass() {
        Team team1 = new Team("Team 1");
        String notTeam = "Different Class";
        assertEquals(false, team1.equals(notTeam));
    }

    @Test
    public void testEquals_sameNameAndMembers() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 1");
        team1.addMember("Alice");
        team1.addMember("Bob");
        team2.addMember("Alice");
        team2.addMember("Bob");
        assertEquals(true, team1.equals(team2));
    } 

    @Test
    public void testEquals_sameNameDiffMembers() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 1");
        team1.addMember("Alice");
        team1.addMember("Bob");
        team2.addMember("Alice");
        team2.addMember("Chris");
        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void testEquals_diffNameSameMembers() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        team1.addMember("Alice");
        team1.addMember("Bob");
        team2.addMember("Alice");
        team2.addMember("Bob");
        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void testEquals_diffNameAndMembers() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        team1.addMember("Alice");
        team1.addMember("Bob");
        team2.addMember("Alice");
        team2.addMember("Chris");
        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void testHashCode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        int result = t1.hashCode();
        int expectedResult = 130294;
        assertEquals(expectedResult, result);
    }
}
