package com.example.monolith.backend.dto;

import java.io.Serializable;

public class LessonDto implements Serializable {

    public int id;

    public String name;
    public int year;
    public String date;
    public String hour;

    public LessonDto() {
    }
}
