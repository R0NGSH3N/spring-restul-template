package com.r0ngsh3n.restful.template.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEM")
@Embeddable
public class Item {

    @javax.persistence.Id
    @GeneratedValue
    Long Id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal unitPrice;
    @Column(name = "provider")
    private String provider;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


}
