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
public class cell extends SprintObject {

    int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

//    public cell(int width, int height, int x, int y) {
//
//    }
//
//    public cell(int x, int y) {
//
//    }
//
//    public cell(int x, int y, String name) {
//
//    }
    public cell(int width, int height, int x, int y, String name) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.name = name;
        this.no = Integer.parseInt(name);
    }

}
