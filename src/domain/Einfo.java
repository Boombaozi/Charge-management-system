package domain;


import java.sql.Date;
import java.sql.Timestamp;

public class Einfo {
    private String cno;
    private Date date;
    private String etno;
    private int  eenum;
    private Timestamp create_at ;

    public int getEenum() {
        return eenum;
    }

    public void setEenum(int eenum) {
        this.eenum = eenum;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtno() {
        return etno;
    }

    public void setEtno(String etno) {
        this.etno = etno;
    }


}
