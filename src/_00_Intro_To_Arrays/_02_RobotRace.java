package _00_Intro_To_Arrays;

import java.util.Random;

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
        System.out.println("Robot #" + (winnerIndex + 1) + " is the winner!");
        robots[winnerIndex].sparkle(); // Makes the robot sparkle
        robots[winnerIndex].turn(360);  // Makes the robot do a victory spin
        // 8. try different races with different amounts of robots.
        int[] robotCounts = {3, 7, 10};

        for (int raceNum = 0; raceNum < robotCounts.length; raceNum++) {
            int totalRobots = robotCounts[raceNum];
            System.out.println("--- Starting Race #" + (raceNum + 1) + " with " + totalRobots + " robots ---");



            for (int i = 0; i < robots.length; i++) {
                robots[i] = new Robot();

                int startingX = 50 + (i * (700 / totalRobots));
                int startingY = 550;

                robots[i].setX(startingX);
                robots[i].setY(startingY);
                robots[i].setSpeed(10);
            }


            // Race loop

            System.out.println("Winner: Robot #" + (winnerIndex + 1));
            robots[winnerIndex].sparkle();
            robots[winnerIndex].turn(360);
        }
        // 9. make the robots race around a circular track.
        int numCircleRobots = 5;
        Robot[] circleRobots = new Robot[numCircleRobots];
        int[] degreesTurned = new int[numCircleRobots]; // Tracks progress around 360 degrees

// Initialize robots spaced out so they form concentric circles
        for (int i = 0; i < circleRobots.length; i++) {
            circleRobots[i] = new Robot();
            circleRobots[i].setSpeed(10);

            // Position near center, staggered along Y axis for different turning radii
            circleRobots[i].setX(400);
            circleRobots[i].setY(300 + (i * 25));
        }

        boolean circleRaceWon = false;
        int circleWinnerIndex = -1;

// Circular race loop
        while (!circleRaceWon) {
            for (int i = 0; i < circleRobots.length; i++) {
                // Move forward a small random distance, then turn 10 degrees
                int moveDistance = rand.nextInt(15) + 5;
                int turnAngle = 10;

                circleRobots[i].move(moveDistance);
                circleRobots[i].turn(turnAngle);

                // Track total rotation
                degreesTurned[i] += turnAngle;

                // Check if this robot completed a full 360-degree circuit
                if (degreesTurned[i] >= 360) {
                    circleRaceWon = true;
                    circleWinnerIndex = i;
                    break;
                }
            }
        }

// Declare the circular race winner & party
        System.out.println("Circular Race Winner: Robot #" + (circleWinnerIndex + 1) + "!");
        circleRobots[circleWinnerIndex].sparkle();
        circleRobots[circleWinnerIndex].turn(360);
    }


}
