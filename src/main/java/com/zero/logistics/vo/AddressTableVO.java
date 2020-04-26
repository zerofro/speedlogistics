package com.zero.logistics.vo;

/**
 * @ClassName AddressTableVO
 * @Description TODO
 * @Author 郑思华
 * @Date 2020/4/26 18:41
 * @Version 1.0
 */
public class AddressTableVO {
    /**
     * 地址编号
     */
    private Integer addressId;
    /**
     * 所属人姓名
     */
    private String ownerName;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系号码
     */
    private String phone;
    /**
     * 寄件地址/收件地址
     */
    private String type;
    /**
     * 所属人微信昵称
     */
    private String wxName;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }
}