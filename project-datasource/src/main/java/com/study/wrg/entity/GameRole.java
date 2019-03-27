package com.study.wrg.entity;

import org.springframework.stereotype.Repository;

/**
 * CREATE TABLE GAME_ROLE (ID INT IDENTITY, NAME VARCHAR(100),PROF VARCHAR(100) );
 */
public class GameRole {
    private Integer id;
    private String name;
    private String prof;

    public GameRole() {
    }

    public GameRole(Integer id, String name, String prof) {
        this.id = id;
        this.name = name;
        this.prof = prof;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    @Override
    public String toString() {
        return "GameRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prof='" + prof + '\'' +
                '}';
    }
}
