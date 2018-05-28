package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specification")
public class Specification {
    public Specification() {
    }
    @Id
    @Column(name = "id",unique = true, nullable = false)
    private int id;

    @Column(name = "processor")
    private String processor;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "ram")
    private String ram;

    @Column(name = "hdd")
    private String hdd;

    @Column(name="video_card")
    private String videoCard;

    @Column(name = "color")
    private String color;

    @Column(name = "camera")
    private String camera;

    public Specification(int id, String processor, String screenSize, String ram, String hdd, String videoCard, String color, String camera) {
        this.id = id;
        this.processor = processor;
        this.screenSize = screenSize;
        this.ram = ram;
        this.hdd = hdd;
        this.videoCard = videoCard;
        this.color = color;
        this.camera = camera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "id=" + id +
                ", processor='" + processor + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", videoCard='" + videoCard + '\'' +
                ", color='" + color + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}
