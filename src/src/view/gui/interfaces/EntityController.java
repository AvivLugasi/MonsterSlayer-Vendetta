package view.gui.interfaces;

import model.entities.Entity;

import java.util.ArrayList;

public interface EntityController {
    public Entity getEntity();
    public ArrayList<String> getAnimations();
}
