package me.fixeddev.commandflow.bukkit.factory;

import me.fixeddev.commandflow.annotated.part.PartFactory;
import me.fixeddev.commandflow.bukkit.annotation.Exact;
import me.fixeddev.commandflow.bukkit.annotation.PlayerOrSource;
import me.fixeddev.commandflow.bukkit.part.PlayerPart;
import me.fixeddev.commandflow.part.CommandPart;

import java.lang.annotation.Annotation;
import java.util.List;

public class PlayerPartFactory implements PartFactory {
    @Override
    public CommandPart createPart(String name, List<? extends Annotation> modifiers) {
        boolean orSource = false;
        boolean exact = false;

        for (Annotation modifier : modifiers) {
            if (modifier.annotationType() == Exact.class) {
                exact = true;
            }

            if (modifier.annotationType() == PlayerOrSource.class) {
                orSource = true;
            }
        }
        return new PlayerPart(name, exact, orSource);
    }
}
