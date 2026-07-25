package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
    // 1. make a main method
    public static void main(String[] args){
        // 2. create an array of 5 robots.
        Robot[] robots = new Robot[5];
        // 3. use a for loop to initialize the robots.
        for(int i = 0; i < robots.length; i++) {
            robots[i] = new Robot();

            // 4. make each robot start at the bottom of the screen, side by side, facing up
            int startingX = i*200+50;
            int startingY = 550;
            int speed = 10;
            robots[i].setX(startingX);
            robots[i].setY(startingY);
            robots[i].setSpeed(speed);
        }
        Random rand = new Random();
        boolean isRaceWon = false;
        int winnerIndex = -1;
        // 6. use a while loop to repeat step 5 until a robot has reached the top of the
        // screen.
        while (!isRaceWon) {

            // 5. use another for loop to iterate through the array and make each robot move
            // a random amount less than 50.
            for (int i = 0; i < robots.length; i++) {
                int randomDistance = rand.nextInt(50);
                robots[i].move(randomDistance);

                if (robots[i].getY() <= 50) {
                    isRaceWon = true;
                    winnerIndex = i;
                    break;
                }
            }
        }

        // 7. declare that robot the winner and throw it a party!

        // 8. try different races with different amounts of robots.

        // 9. make the robots race around a circular track.
    }


}
