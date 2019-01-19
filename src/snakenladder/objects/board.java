/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakenladder.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import snakenladder.resources.utils.GenUtils;

/**
 *
 * @author bayasys
 */
public class board extends JPanel {

    int width = 700;
    int height = 700;
    int cellWidth = width / 10;
    ArrayList<cell> cellList;
    ArrayList<Snake> snakes = new ArrayList<>();
    ArrayList<Ladder> ladders = new ArrayList<>();
    ArrayList<player> players = new ArrayList<>();

    private void populateSnakesAndLadders() {
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        JSONObject obj = GenUtils.readJSON("input.json");
        JSONArray snakesRA = (JSONArray) obj.get("snakes");
        snakesRA.forEach((t) -> {
            JSONObject ob = (JSONObject) t;
            Snake ld = new Snake(findCellByName(Long.toString((long) ob.get("from"))), findCellByName(Long.toString((long) ob.get("to"))), "SNAKE_" + ob.get("from") + "" + ob.get("to"));
            snakes.add(ld);
        });
        JSONArray laddersRA = (JSONArray) obj.get("ladders");
        laddersRA.forEach((t) -> {
            JSONObject ob = (JSONObject) t;
            Ladder ld = new Ladder(findCellByName(Long.toString((long) ob.get("from"))), findCellByName(Long.toString((long) ob.get("to"))), "LADDER_" + ob.get("from") + "" + ob.get("to"));
            ladders.add(ld);
        });

    }

    private cell findCellByName(String name) {
        cell cl = null;
        for (int i = 0; i < cellList.size(); i++) {
            cell t = cellList.get(i);
            if (t.getName().equalsIgnoreCase(name)) {
                cl = t;
                break;
            }
        }
        System.out.println("CELL : " + cl.getName() + " , X : " + cl.getX() + "," + cl.getY());
        return cl;
    }

    public board(ArrayList<player> players) {
        this.players = players;
        setBounds(0, 0, width + 1, height + 1);
        setVisible(true);
        setBackground(Color.WHITE);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawCells(g2d);
        drawSnakes(g2d);
        drawLadders(g2d);
        drawPlayers(g2d);
    }

    private void drawCells(Graphics2D g2d) {
        int no = 100;
        cellList = new ArrayList<cell>();
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                g2d.setColor(Color.BLACK);
                g2d.draw3DRect(i * cellWidth, j * cellWidth, cellWidth, cellWidth, false);
                g2d.setColor(Color.red);
                g2d.setFont(new Font("Cochin", Font.BOLD, 14));
                g2d.drawString(Integer.toString(no), i * cellWidth + (cellWidth / 2) - 10, j * cellWidth + (cellWidth / 2));
                cellList.add(new cell(cellWidth, cellWidth, i * cellWidth, j * cellWidth, Integer.toString(no)));
                no--;
            }
        }
        populateSnakesAndLadders();
    }

    private void drawSnakes(Graphics2D g2d) {
        snakes.forEach((t) -> {
            t.draw(g2d);
        });
    }

    private void drawLadders(Graphics2D g2d) {
        ladders.forEach((t) -> {
            t.draw(g2d);
        });
    }

    private void drawPlayers(Graphics2D g2d) {
        players.forEach((t) -> {
            t.draw(g2d);
        });
    }
}
