package kz.muminov.midtermrestaraunt.entity;

public class Position {
    private Long id;
    private String name;

    public Position(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Position(String name){
        this.name = name;
    }

    public Position() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}