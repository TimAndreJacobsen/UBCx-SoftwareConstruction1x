package model;


import sound.MidiSynth;

import java.awt.*;


public class RectShape extends Shape {  // hvis jeg bare klarer å skille Shape fra de bitene som tegner som rektangel


    public RectShape(Point topLeft, MidiSynth midiSynth) {  // Shapetool kaller <-
        this((int) topLeft.getX(), (int) topLeft.getY(), 0, 0); //note to students: calls the other constructor!
        selected = false;
        this.midiSynth = midiSynth;
        instrument = 0;
        playLineCoord = 0;
        PLAYING_COLOR = new Color(230, 158, 60);
    }


    public RectShape(int x, int y, int w, int h) {
        super(x, w, h, y);  // <- public Shape overloader hit - kunne vi ikke extracted til rect?
                        //   eller bare ha det her, declare protected. men må jo constructe noe i Oval og Rekt for å få form
                        //   eller kommer formen nå du kaller draw. så trenger kun å override paint metodene.
                        // så kan objektene bare være så logisk like de vil.
    }


    // Drawing method, this HAS to go
    //EFFECTS: draws the shape
    @Override
    protected void drawGraphics(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    // Painting method, this HAS to go
    //EFFECTS: fills the shape
    @Override
    protected void fillGraphics(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    @Override
    public boolean contains(Point point) {
        int point_x = point.x;
        int point_y = point.y;

        return containsX(point_x) && containsY(point_y);
    }


}
