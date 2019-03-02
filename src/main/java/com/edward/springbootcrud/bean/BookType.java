package com.edward.springbootcrud.bean;


import javax.persistence.*;

@Entity
@Table(name = "tb_booktype")
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;
    @Column
    private String typename;
    @Column
    private Integer days;
    @Column
    private Double fk;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getFk() {
        return fk;
    }

    public void setFk(Double fk) {
        this.fk = fk;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "typeId=" + typeId +
                ", typename='" + typename + '\'' +
                ", days=" + days +
                ", fk=" + fk +
                '}';
    }
}
