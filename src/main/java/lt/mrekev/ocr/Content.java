package lt.mrekev.ocr;

public class Content {

    private String nameLine;

    private String dataLine;

    public Content(String nameLine, String dataLine) {
        this.nameLine = nameLine;
        this.dataLine = dataLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    public String getDataLine() {
        return dataLine;
    }
}
