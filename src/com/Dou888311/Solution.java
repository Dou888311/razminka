package com.Dou888311;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Solution {

    public Solution() {
        System.out.println("Enter String to reverse: ");
        Scanner sc = new Scanner(System.in);
        start(sc.nextLine());
    }

    public String solution(String str) {
        char[] array = str.toCharArray();
        int endIndex = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[endIndex];
            array[endIndex] = temp;
            endIndex--;
        }
        return new String(array);
    }

    public void start(String str) {
        Instant timeOfStart = Instant.now();
        int counter = 0;
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + solution(str));
        while (counter < 100000) {
            solution(str);
            counter++;
            if (counter == 1000) timeStatistic(timeOfStart, 1000);
            if (counter == 10000) timeStatistic(timeOfStart, 10000);
            if (counter == 100000) timeStatistic(timeOfStart, 100000);
        }
    }

    public void timeStatistic(Instant start, int count) {
        Instant current = Instant.now();
        Duration thousand = Duration.between(start, current);
        System.out.println("Time of method working " + count + " times: " +
                thousand.toMinutesPart() + " minutes, " +
                thousand.toSecondsPart() + " seconds, " +
                thousand.toMillisPart()+ " milliseconds.");
    }
}
