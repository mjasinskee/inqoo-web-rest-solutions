package com.inqoo.fsd.solutions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

class Review {

    private final String nickName;
    private final Score score;
    private final String content;

    @JsonCreator
    Review(
            @JsonProperty("nickName") String nickName,
            @JsonProperty("score") Score score,
            @JsonProperty("content") String content) {
        this.nickName = nickName;
        this.score = score;
        this.content = content;
    }

    public String getNickName() {
        return nickName;
    }

    public Score getScore() {
        return score;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(nickName, review.nickName) && score == review.score && Objects.equals(content, review.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, score, content);
    }

    @Override
    public String toString() {
        return "Review{" +
                "nickName='" + nickName + '\'' +
                ", score=" + score +
                ", content='" + content + '\'' +
                '}';
    }
}
