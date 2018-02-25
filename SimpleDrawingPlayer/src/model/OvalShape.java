package model;

import sound.MidiSynth;

import java.awt.*;

public class OvalShape extends Shape {

    public OvalShape(Point topLeft, MidiSynth midiSynth) {  // Shapetool kaller <-
        this((int) topLeft.getX(), (int) topLeft.getY(), 0, 0); //note to students: calls the other constructor!
        selected = false;
        this.midiSynth = midiSynth;
        instrument = 0;
        playLineCoord = 0;
        PLAYING_COLOR = new Color(230, 158, 60);
    }


    public OvalShape(int x, int y, int w, int h) {
        super(x, w, h, y);  // <- public Shape overloader hit - kunne vi ikke extracted til rect?
        //   eller bare ha det her, declare protected. men må jo constructe noe i Oval og Rekt for å få form
        //   eller kommer formen nå du kaller draw. så trenger kun å override paint metodene.
        // så kan objektene bare være så logisk like de vil.
    }


    // Drawing method, this HAS to go
    //EFFECTS: draws the shape
    @Override
    protected void drawGraphics(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    // Painting method, this HAS to go
    //EFFECTS: fills the shape
    @Override
    protected void fillGraphics(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    @Override
    public boolean contains(Point p) {
        final double TOL = 1.0e-6;
        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;
        double diff = 0.0;

        if (halfWidth > 0.0) {
            diff = diff + sqrDiff(x + halfWidth, p.x) / (halfWidth * halfWidth);
        } else {
            diff = diff + sqrDiff(x + halfWidth, p.x);
        }
        if (halfHeight > 0.0) {
            diff = diff + sqrDiff(y + halfHeight, p.y) / (halfHeight * halfHeight);
        } else {
            diff = diff + sqrDiff(y + halfHeight, p.y);
        }
        return  diff <= 1.0 + TOL;
    }

    // Compute square of difference
// EFFECTS: returns the square of the difference of num1 and num2
    private double sqrDiff(double num1, double num2) {
        return (num1 - num2) * (num1 - num2);
    }



}
