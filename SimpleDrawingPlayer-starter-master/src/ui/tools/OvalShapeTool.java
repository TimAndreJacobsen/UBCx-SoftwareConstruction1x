package ui.tools;

import model.OvalShape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class OvalShapeTool extends ShapeTool {

    public OvalShapeTool(DrawingEditor editor, JComponent parent) {
        super(editor, parent);
    }

    @Override
    protected void makeShape(MouseEvent e) {
        shape = new OvalShape(e.getPoint(), editor.getMidiSynth());
    }
}
