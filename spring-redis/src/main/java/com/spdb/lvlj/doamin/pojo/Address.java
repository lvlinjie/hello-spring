package com.spdb.lvlj.doamin.pojo;

import javax.persistence.*;

@Entity
@Table(name = "tp_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "add_info",nullable = false)
    private String addressInfo;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public Address(Long userId, String addressInfo) {
        this.userId = userId;
        this.addressInfo = addressInfo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", addressInfo='" + addressInfo + '\'' +
                '}';
    }
}