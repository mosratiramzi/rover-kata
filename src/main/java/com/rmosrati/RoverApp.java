package com.rmosrati;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class RoverApp {
    public static void main(String[] args) {
        // args [0] is the absolute path of input.txt
        // example C:\Users\Desktop\input.txt
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String plateauSize = reader.readLine();
            String line = reader.readLine();

            while (line != null) {
                String[] position = line.split(" ");
                Rover rover = new Rover(Integer.parseInt(position[0]), Integer.parseInt(position[1]), position[2]);
                // read next line
                String newPosition = rover.navigate(reader.readLine());
                line = reader.readLine();
                System.out.println(newPosition);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}