package edu.ucsb.cs56.projects.games.cs56_games_maze;

import java.io.Serializable;
import java.util.*;

/**
 * Class that holds data for  one maze score.
 * Holds no references to maze object, so must be associated with by something else.
 *
 * @author Evan West
 * @author Zakary Blake
 * @author Victor Porter
 * @version CS56 S13 UCSB
 */
public class MazeHighScore implements Serializable, Comparable<MazeHighScore> {

    private String name;
    private long time;
    private double rows;
    private double cols;
    private int moves;
    private int score;

    /**
     * Constructor for high score
     *
     * @param name Name string to associate with score (prompted from player)
     * @param time Time in milliseconds that player took to complete the maze
     */
    public MazeHighScore(String name, long time, int rows, int columns, int moves) {
        this.name = name;
        this.time = time;
        this.rows = rows;
        this.cols = columns;
        this.moves = moves;
    }

    /**
     * @return Name associated with the high score
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return Time in milliseconds of this score
     */
    public long getTime() {
        return this.time;
    }

    /**
     * @return the number of Rows in this game
     */
    public double getRows() {
        return this.rows;
    }

    /**
     * @return the number of Columns in this game
     */
    public double getCols() {
        return this.cols;
    }

    /**
     * @return the number of moves the player has made in this game
     */
    public int getMoves() {
        return this.moves;
    }

    /**
     * @return the score of this game
     */
    public int getScore() {
        score = ((int) (((rows * cols) / (time + moves)) * 10000000));
        return score;
    }


    /**
     * Override to allow comparison of scores, smallest time is first
     *
     * @param other Another MazeHighScore object to compare this one to
     */
    @Override
    public int compareTo(MazeHighScore other) {
        if (other == null) {
            throw new NullPointerException();
        }
        Long otherTime = new Long(other.getTime());
        return -1 * otherTime.compareTo(this.time);
    }

    public static Comparator<MazeHighScore> ScoreCompare = new Comparator<MazeHighScore>() {
        public int compare(MazeHighScore s1, MazeHighScore s2) {

            int score1 = s1.getScore();
            int score2 = s2.getScore();
            return score2 - score1;
        }
    };

}

// compare class for use in HighScoreSaver.java
class MazeScoreCompare implements Comparator<MazeHighScore> {
    public int compare(MazeHighScore ms1, MazeHighScore ms2) {
        return ms1.compareTo(ms2);
    }
}
