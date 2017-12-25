package domain;


import java.sql.Date;
import java.sql.Timestamp;

public class Cr {
    private String cno;
    private Date date;
    private float sc;
    private float ac;
    private String eno;
    private Timestamp create_at;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }



    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }


    public float getSc() {
        return sc;
    }

    public void setSc(float sc) {
        this.sc = sc;
    }

    public float getAc() {
        return ac;
    }

    public void setAc(float ac) {
        this.ac = ac;
    }

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

}
