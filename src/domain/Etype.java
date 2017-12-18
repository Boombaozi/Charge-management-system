package domain;

import java.sql.Timestamp;

public class Etype {


    private String etno;
    private String etname;

    public String getEtno() {
        return etno;
    }

    public void setEtno(String etno) {
        this.etno = etno;
    }

    public String getEtname() {
        return etname;
    }

    public void setEtname(String etname) {
        this.etname = etname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    private float price;
    private Timestamp create_at;

}
