package lt.mrekev.ocr;

public class Entry {
    private String name;

    private long might;

    private long kills;

    public Entry(String name, long might, long kills) {
        this.name = name;
        this.might = might;
        this.kills = kills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMight() {
        return might;
    }

    public void setMight(long might) {
        this.might = might;
    }

    public long getKills() {
        return kills;
    }

    public void setKills(long kills) {
        this.kills = kills;
    }
}
