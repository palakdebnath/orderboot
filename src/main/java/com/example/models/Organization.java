package com.example.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization implements Serializable {
	private static final long serialVersionUID = -7988799579036225138L;

	@Id
	@Column (name="orgId")
	private String orgId ;
	
	@Column
	private String name;	
	
	@Column
	private String address;
	
	@Column
	private String zipCode;
	
	public String getOrgId() {
		return orgId;
	}
	
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
    public String toString() {
        return "Organization {" +
                " orgId=" + orgId +
                ", name=" + name +
                ", address=" + address +
                ", zipCode=" + zipCode +
                "}";
    }
}
