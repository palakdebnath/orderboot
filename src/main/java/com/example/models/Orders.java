package com.example.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "orders")
public class Orders implements Serializable {
private static final long serialVersionUID = -7988799579036225139L;
    
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @GeneratedValue
    @Column (name="orderId")
    private Long orderId;  
    
    /*
    @Id
    @GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "com.us.util.StringSequenceGenerator", parameters = { @Parameter(name = "sequence", value = "MY_SEQUENCE_NAME") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STRING_SEQUENCE_GENERATOR")
    @Column (name="orderId")
    private String orderId;
    */
    
    @Column
    private String orgId;
    
    @Column
    private String assignedWorkerId;
    
    @Column
    private String title;
    
    @Column
    private String description;
    
    @Column
    private String status;
    
    @Column
    private String remark;    
    
    @Column
    private byte[] image1;  
    
    public Orders() {
    }


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public String getOrgId() {
		return orgId;
	}


	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}


	public String getAssignedWorkerId() {
		return assignedWorkerId;
	}


	public void setAssignedWorkerId(String assignedWorkerId) {
		this.assignedWorkerId = assignedWorkerId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public byte[] getImage1() {
		return image1;
	}


	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}


	@Override
    public String toString() {
        return "Order{" +
                "oderId =" + orderId  +
                ", orgId  =" + orgId +
                ", assignedWorkerId  =" + assignedWorkerId +
                ", description  =" + description +
                ", status  =" + status +
                ", remark  =" + remark +
                //", photo  =" + photo +
                "}";
    }
}
