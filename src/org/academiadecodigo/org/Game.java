package org.academiadecodigo.org;

import org.academiadecodigo.Controls.Controls;
import org.academiadecodigo.Objects.Controllables.PacMan;
import org.academiadecodigo.Objects.CovidFactory;
import org.academiadecodigo.Objects.GhostCovid;
import org.academiadecodigo.Objects.Syringe;
import org.academiadecodigo.graphics.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Game {

    private Field field;
    private int score;

    private PacMan pacMan;
    private Syringe syringe;
    private Picture picture;
    private CovidFactory factory = new CovidFactory();
    private GhostCovid[] covids;


    public void init() throws InterruptedException {
        field = new Field();
        field.init();
        pacMan = new PacMan();
        syringe = new Syringe();
        Controls control = new Controls();
        control.setPacman(pacMan);
        control.init();
        //covids = new GhostCovid(810, 500);
        pacMan.setSyringe(syringe);






    }

    public void start() throws InterruptedException {
        hearts();
        moveAll();
    }


    //create and remove hearts/lives
    public void hearts() {
        Picture heart1 = new Picture(20, 20, "resources/Hearth.png");
        heart1.draw();

    }

    public void moveAll() throws InterruptedException {
        covids = factory.covidFactory();
        for (GhostCovid go: covids){
            pacMan.setCovid(go);
            go.moveInDirection();
        }
    }


}
