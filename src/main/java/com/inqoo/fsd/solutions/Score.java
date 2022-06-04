package com.inqoo.fsd.solutions;

public enum Score {

    BAD(1),
    GOOD(2),
    EXCELLENT(3);

    private final int score;

    Score(int score) {
        this.score = score;
    }
}
