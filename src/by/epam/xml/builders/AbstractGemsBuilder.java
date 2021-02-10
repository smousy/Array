package by.epam.xml.builders;

import by.epam.xml.entity.Gem;
import by.epam.xml.exeption.ParseException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGemsBuilder {
    protected Set<Gem> gems;

    public AbstractGemsBuilder() {
        gems = new HashSet<>();
    }

    public AbstractGemsBuilder(Set<Gem> medicines) {
        this.gems = gems;
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public abstract void buildSetGems(String filename) throws ParseException;
}
