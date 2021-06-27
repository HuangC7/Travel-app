package com.example.trainapp.entity;

import java.io.Serializable;

public class Activity implements Serializable {
    private String name;
    private int imageId;
    private int image_detailedID1, image_detailedID2, image_detailedID3;
    private String content;
    private String content_detailed;
    private String title;
    private String time;
    private String t_abstract;
    private String place;


    /*  text1 */
    public Activity(String name, int imageId, String title) {
        this.name = name;
        this.imageId = imageId;
        this.title = title;
    }

    /*  text2 */
    public Activity(String name, int imageId, String content, String title) {
        this.name = name;
        this.imageId = imageId;
        this.content = content;
        this.title = title;
    }

    /*  text2_content */
    public Activity(String name, int imageId, String content, String title, String time, String t_abstract, String content_detailed) {
        this.name = name;
        this.imageId = imageId;
        this.content = content;
        this.content_detailed = content_detailed;
        this.title = title;
        this.time = time;
        this.t_abstract = t_abstract;
    }

    /*  Activity_detailed */
    public Activity(String name, int imageId, int image_detailedID1, int image_detailedID2, int image_detailedID3, String content, String title, String time, String place, String content_detailed) {
        this.name = name;
        this.imageId = imageId;
        this.image_detailedID1 = image_detailedID1;
        this.image_detailedID2 = image_detailedID2;
        this.image_detailedID3 = image_detailedID3;
        this.content = content;
        this.content_detailed = content_detailed;
        this.title = title;
        this.time = time;
        this.place = place;
    }

    public int getImage_detailedID1() {
        return image_detailedID1;
    }

    public void setImage_detailedID1(int image_detailedID1) {
        this.image_detailedID1 = image_detailedID1;
    }

    public int getImage_detailedID2() {
        return image_detailedID2;
    }

    public void setImage_detailedID2(int image_detailedID2) {
        this.image_detailedID2 = image_detailedID2;
    }

    public int getImage_detailedID3() {
        return image_detailedID3;
    }

    public void setImage_detailedID3(int image_detailedID3) {
        this.image_detailedID3 = image_detailedID3;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getT_abstract() {
        return t_abstract;
    }

    public void setT_abstract(String t_abstract) {
        this.t_abstract = t_abstract;
    }

    public String getContent_detailed() {
        return content_detailed;
    }

    public void setContent_detailed(String content_detailed) {
        this.content_detailed = content_detailed;
    }
}
