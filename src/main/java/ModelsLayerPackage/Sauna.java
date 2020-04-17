package ModelsLayerPackage;

import com.example.demo.TimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Sauna {
    private int id_sauna;
    private int occupied;
    //@DateTimeFormat(style = "hh:mm:ss")
    //@JsonDeserialize(using = TimeDeserializer.class)
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss")
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss")

    //@DateTimeFormat(style = "hh:mm")
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
    @DateTimeFormat(style = "hh:mm")
    @JsonDeserialize(using = TimeDeserializer.class)
    private Date session_time;
    private int size_number;

    public Sauna(int id_sauna, int occupied, Date session_time, int size_number) {
        this.id_sauna = id_sauna;
        this.occupied = occupied;
        this.session_time = session_time;
        this.size_number = size_number;
    }

    public Sauna() {

    }

    public int getId_sauna() {
        return id_sauna;
    }

    public void setId_sauna(int id_sauna) {
        this.id_sauna = id_sauna;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public Date getSession_time() {
        return session_time;
    }

    public void setSession_time(Date session_time) {
        this.session_time = session_time;
    }

    public int getSize_number() {
        return size_number;
    }

    public void setSize_number(int size_number) {
        this.size_number = size_number;
    }

    public void incrementSizeNumber() {
        if (size_number < 20) {
            size_number++;
        }
    }
}
