package com.solid.principles.lsp;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BirdTest {
    @Test
    void allBirds_MakeSound() {
        List<Bird> birds = Arrays.asList(
            new Penguin("Emperor"),
            new Sparrow("Jack"),
            new Eagle("Baldy")
        );

        for (Bird bird : birds) {
            assertNotNull(bird.makeSound());
            assertTrue(bird.makeSound().length() > 0);
        }
    }

    @Test
    void allFlyingBirds_HaveFlightSpeed() {
        List<FlyingBird> flyingBirds = Arrays.asList(
            new Sparrow("Jack"),
            new Eagle("Baldy")
        );

        for (FlyingBird bird : flyingBirds) {
            assertTrue(bird.getFlightSpeed() > 0);
        }
    }

    @Test
    void penguin_CanSwim() {
        Penguin penguin = new Penguin("Emperor");
        assertTrue(penguin.getSwimmingSpeed() > 0);
    }

    @Test
    void birdNames_AreSet() {
        Bird penguin = new Penguin("Emperor");
        Bird sparrow = new Sparrow("Jack");
        Bird eagle = new Eagle("Baldy");

        assertEquals("Emperor", penguin.getName());
        assertEquals("Jack", sparrow.getName());
        assertEquals("Baldy", eagle.getName());
    }

    @Test
    void specificBirdSounds_AreCorrect() {
        assertEquals("Squawk!", new Penguin("Emperor").makeSound());
        assertEquals("Chirp!", new Sparrow("Jack").makeSound());
        assertEquals("Screech!", new Eagle("Baldy").makeSound());
    }

    @Test
    void flyingBirds_HaveDistinctSpeeds() {
        FlyingBird sparrow = new Sparrow("Jack");
        FlyingBird eagle = new Eagle("Baldy");

        assertTrue(eagle.getFlightSpeed() > sparrow.getFlightSpeed());
    }
} 