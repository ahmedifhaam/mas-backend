package com.xelvias.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ENTRY")
public class Entry implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name= "fabric",nullable = false)
    String fabric;

    @Column(name = "component",nullable = false)
    String component;

    @Column(name = "size",nullable = false)
    String size;

    @Column(name = "val1",nullable = false)
    double val1;

    @Column(name = "val2",nullable = false)
    double val2;


    @Column(name = "val3",nullable = false)
    double val3;

    @Column(name = "val4",nullable = false)
    double val4;

    @Column(name = "val5",nullable = false)
    double val5;

    @Column(name = "val6",nullable = false)
    double val6;

    @Column(name = "val7",nullable = false)
    double val7;

    @Column(name = "val8",nullable = false)
    double val8;

    @Column(name = "val9",nullable = false)
    double val9;

    @Column(name = "val10",nullable = false)
    double val10;

    @Column(name = "val11",nullable = false)
    double val11;

    @Column(name = "val12",nullable = false)
    double val12;

    @Column(name = "val13",nullable = false)
    double val13;

    @Column(name = "val14",nullable = false)
    double val14;

    @Column(name = "val15",nullable = false)
    double val15;

    @Column(name = "val16",nullable = false)
    double val16;

    @Column(name = "val17",nullable = false)
    double val17;

    @Column(name = "val18",nullable = false)
    double val18;

    @Column(name = "val19",nullable = false)
    double val19;

    @Column(name = "val20",nullable = false)
    double val20;

    @Column(name = "val21",nullable = false)
    double val21;

    @Column(name = "val22",nullable = false)
    double val22;

    @Column(name = "val23",nullable = false)
    double val23;

    @Column(name = "val24",nullable = false)
    double val24;

    @Column(name = "val25",nullable = false)
    double val25;

    @Column(name = "val26",nullable = false)
    double val26;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getVal1() {
        return val1;
    }

    public void setVal1(double val1) {
        this.val1 = val1;
    }

    public double getVal2() {
        return val2;
    }

    public void setVal2(double val2) {
        this.val2 = val2;
    }

    public double getVal3() {
        return val3;
    }

    public void setVal3(double val3) {
        this.val3 = val3;
    }

    public double getVal4() {
        return val4;
    }

    public void setVal4(double val4) {
        this.val4 = val4;
    }

    public double getVal5() {
        return val5;
    }

    public void setVal5(double val5) {
        this.val5 = val5;
    }

    public double getVal6() {
        return val6;
    }

    public void setVal6(double val6) {
        this.val6 = val6;
    }

    public double getVal7() {
        return val7;
    }

    public void setVal7(double val7) {
        this.val7 = val7;
    }

    public double getVal8() {
        return val8;
    }

    public void setVal8(double val8) {
        this.val8 = val8;
    }

    public double getVal9() {
        return val9;
    }

    public void setVal9(double val9) {
        this.val9 = val9;
    }

    public double getVal10() {
        return val10;
    }

    public void setVal10(double val10) {
        this.val10 = val10;
    }

    public double getVal11() {
        return val11;
    }

    public void setVal11(double val11) {
        this.val11 = val11;
    }

    public double getVal12() {
        return val12;
    }

    public void setVal12(double val12) {
        this.val12 = val12;
    }

    public double getVal13() {
        return val13;
    }

    public void setVal13(double val13) {
        this.val13 = val13;
    }

    public double getVal14() {
        return val14;
    }

    public void setVal14(double val14) {
        this.val14 = val14;
    }

    public double getVal15() {
        return val15;
    }

    public void setVal15(double val15) {
        this.val15 = val15;
    }

    public double getVal16() {
        return val16;
    }

    public void setVal16(double val16) {
        this.val16 = val16;
    }

    public double getVal17() {
        return val17;
    }

    public void setVal17(double val17) {
        this.val17 = val17;
    }

    public double getVal18() {
        return val18;
    }

    public void setVal18(double val18) {
        this.val18 = val18;
    }

    public double getVal19() {
        return val19;
    }

    public void setVal19(double val19) {
        this.val19 = val19;
    }

    public double getVal20() {
        return val20;
    }

    public void setVal20(double val20) {
        this.val20 = val20;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getVal21() {
        return val21;
    }

    public void setVal21(double val21) {
        this.val21 = val21;
    }

    public double getVal22() {
        return val22;
    }

    public void setVal22(double val22) {
        this.val22 = val22;
    }

    public double getVal23() {
        return val23;
    }

    public void setVal23(double val23) {
        this.val23 = val23;
    }

    public double getVal24() {
        return val24;
    }

    public void setVal24(double val24) {
        this.val24 = val24;
    }

    public double getVal25() {
        return val25;
    }

    public void setVal25(double val25) {
        this.val25 = val25;
    }

    public double getVal26() {
        return val26;
    }

    public void setVal26(double val26) {
        this.val26 = val26;
    }
}
