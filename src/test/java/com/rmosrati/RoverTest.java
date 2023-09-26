package com.rmosrati;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RoverTest {

    @ParameterizedTest
    @MethodSource("turnRightActionList")
    public void
    should_turn_right(String instruction, String expectedPosition) {
        Rover marsRover = new Rover(0, 0, "N");
        String newPosition = marsRover.navigate(instruction);
        assertEquals(expectedPosition, newPosition);
    }

    @ParameterizedTest
    @MethodSource("turnLeftActionList")
    public void
    should_turn_Left(String instruction, String expectedPosition) {
        Rover marsRover = new Rover(0, 0, "N");
        String newPosition = marsRover.navigate(instruction);
        assertEquals(expectedPosition, newPosition);
    }

    @ParameterizedTest
    @MethodSource("moveUpActionList")
    public void
    should_move_up(String instruction, String expectedPosition) {
        Rover marsRover = new Rover(0, 0, "N");
        String newPosition = marsRover.navigate(instruction);
        assertEquals(expectedPosition, newPosition);
    }

    @Test
    public void
    should_move_back() {
        Rover marsRover = new Rover(0, 3, "S");
        String newPosition = marsRover.navigate("M");
        assertEquals("0 2 S", newPosition);
    }

    @Test
    public void
    should_move_right() {
        Rover marsRover = new Rover(0, 0, "N");
        String newPosition = marsRover.navigate("RM");
        assertEquals("1 0 E", newPosition);
    }

    @Test
    public void
    should_move_Left() {
        Rover marsRover = new Rover(2, 0, "N");
        String newPosition = marsRover.navigate("LM");
        assertEquals("1 0 W", newPosition);
    }
    static Stream<Arguments> moveUpActionList() {
        return Stream.of(
                arguments("M", "0 1 N"),
                arguments("MM", "0 2 N")
        );
    }

    static Stream<Arguments> turnLeftActionList() {
        return Stream.of(
                arguments("L", "0 0 W"),
                arguments("LL", "0 0 S"),
                arguments("LLL", "0 0 E"),
                arguments("LLLL", "0 0 N")
        );
    }

    static Stream<Arguments> turnRightActionList() {
        return Stream.of(
                arguments("R", "0 0 E"),
                arguments("RR", "0 0 S"),
                arguments("RRR", "0 0 W"),
                arguments("RRRR", "0 0 N")
        );
    }

    @Test
    public void
    should_return_the_position_1_3_N() {
        Rover marsRover = new Rover(1, 2, "N");
        String newPosition = marsRover.navigate("LMLMLMLMM");
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void
    should_return_the_position_5_1_E() {
        Rover marsRover = new Rover(3, 3, "E");
        String newPosition = marsRover.navigate("MMRMMRMRRM");
        assertEquals("5 1 E", newPosition);
    }
}