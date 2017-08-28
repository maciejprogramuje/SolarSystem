package commaciejprogramuje.facebook.solarsystem;

import java.io.Serializable;

/**
 * Created by m.szymczyk on 2017-08-28.
 */

public class SolarObject implements Serializable{
    private String name;

    public SolarObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
