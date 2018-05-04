package pl.coderslab.models;

public class Status {

    private int id;
    private int stage;

    public Status(int id, int stage) {
        this.id = id;
        this.stage = stage;

        // stages in numeric representation - 1 to 5;
        // 1 - registered
        // 2 - payment registered
        // 3 - in repair
        // 4 - ready to collect
        // 5 - cancelled

    }

    public Status(int stage) {
        this.stage = stage;
    }

    public Status(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}
