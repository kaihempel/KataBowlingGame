package bowlinggame;

/**
 * The game class
 *
 * @author Kai Hempel
 */
public class Game {

    private int rolls[]     = new int[21];
    private int currentRoll = 0;

    /**
     * Roll method
     * Registers the rolled pins
     *
     * @param pins
     */
    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    /**
     * Score method
     * Calculates the current game score
     *
     * @return int
     */
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

    /**
     * Calculates the frame score
     *
     * @param currentIndex
     * @return
     */
    private int calculateNormalFrameScore(int currentIndex) {
        return rolls[currentIndex] + rolls[currentIndex + 1];
    }

    /**
     * Checks if the frame was a spare
     *
     * @param currentIndex
     * @return int
     */
    private boolean isSpare(int currentIndex) {
        return (calculateNormalFrameScore(currentIndex) == 10);
    }

    /**
     * Calculates the score of a spare frame
     *
     * @param currentIndex
     * @return int
     */
    private int calculateSpareFrameScore(int currentIndex) {
        return 10 + rolls[currentIndex + 2];
    }

    /**
     * Checks if the frame was a strike
     *
     * @param currentIndex
     * @return int
     */
    private boolean isStrike(int currentIndex) {
        return (rolls[currentIndex] == 10);
    }

    /**
     * Calculates the score of a strike frame
     *
     * @param currentIndex
     * @return int
     */
    private int calculateStrikeFrameScore(int currentIndex) {
        return 10 + rolls[currentIndex + 1] + rolls[currentIndex + 2];
    }

}
