package com.sppm.pipo;

public class Post {
    String difficulty;
    int LA,TI;
    public Post(){}
    public Post(String difficulty,int LA,int TI){
        this.difficulty=difficulty;
        this.LA=LA;
        this.TI=TI;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getLA() {
        return LA;
    }

    public void setLA(int LA) {
        this.LA = LA;
    }

    public int getTI() {
        return TI;
    }

    public void setTI(int TI) {
        this.TI = TI;
    }
}
