package bowlinggame;

/**
 * The game class
 *
 * @author Kai Hempel
 */
public class Game {

    private int rolls[]     = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score       = 0;
        int frameIndex  = 0;

        // Game frame loop
        for (int frame = 0; frame < 10; frame++) {

            // Calculate score
            if (isStrike(frameIndex)) {
                score += calculateStrikeFrameScore(frameIndex);

                // Increment the frame only by one
                frameIndex++;

            } else if (isSpare(frameIndex)) {
                score += calculateSpareFrameScore(frameIndex);

                // Increment the frame index by two
                frameIndex += 2;

            } else {
                score += calculateNormalFrameScore(frameIndex);

                // Increment the frame index by two
                frameIndex += 2;
            }


        }

        return score;
    }

    private int calculateNormalFrameScore(int currentIndex) {
        return rolls[currentIndex] + rolls[currentIndex + 1];
    }

    private boolean isSpare(int currentIndex) {
        return (calculateNormalFrameScore(currentIndex) == 10);
    }

    private int calculateSpareFrameScore(int currentIndex) {
        return 10 + rolls[currentIndex + 2];
    }

    private boolean isStrike(int currentIndex) {
        return (rolls[currentIndex] == 10);
    }

    private int calculateStrikeFrameScore(int currentIndex) {
        return 10 + rolls[currentIndex + 1] + rolls[currentIndex + 2];
    }

}
