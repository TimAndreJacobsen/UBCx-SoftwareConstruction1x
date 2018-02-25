package ui.tools;


import model.RectShape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class RectShapeTool extends ShapeTool {

    public RectShapeTool(DrawingEditor editor, JComponent parent) {
		super(editor, parent);
    }


    //EFFECTS: Constructs and returns the new shape
    @Override
    protected void makeShape(MouseEvent e) {
		shape = new RectShape(e.getPoint(), editor.getMidiSynth());
	}

}

