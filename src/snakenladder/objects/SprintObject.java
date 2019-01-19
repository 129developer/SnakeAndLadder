/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakenladder.objects;

/**
 *
 * @author bayasys
 */
public class SprintObject {

    int width, height;
    int x, y;
    String name;

//    public SprintObject(int x, int y, String name) {
//        this.x = x;
//        this.y = y;
//        this.name = name;
//    }
//
//    public SprintObject(int width, int height, int x, int y, String name) {
//        this.width = width;
//        this.height = height;
//        this.x = x;
//        this.y = y;
//        this.name = name;
//    }
//
//    public SprintObject(int width, int height, int x, int y) {
//        this.width = width;
//        this.height = height;
//        this.x = x;
//        this.y = y;
//    }
//
//    public SprintObject(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
