package com.rtgs.db.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity

@Table(name="ADMIN")

public class AdminDTO  {


	@NotEmpty
	@Email
     private String adminId;
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[$#@%]).{5,10})")
     private String password;
     private String name;
     private String emailId;
     private Long mobNumber;

    public AdminDTO() {
    	
    	
    	adminId = "Enter Id here";
		password="eneter password here";
    	
    }

	
    public AdminDTO(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }
    public AdminDTO(String adminId, String password, String name, String emailId, Long mobNumber) {
       this.adminId = adminId;
       this.password = password;
       this.name = name;
       this.emailId = emailId;
       this.mobNumber = mobNumber;
    }
   
     @Id 
   
    @Column(name="ADMIN_ID", unique=true, nullable=false, length=20)
    public String getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    
    @Column(name="PASSWORD", nullable=false, length=20)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="NAME", length=25)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="EMAIL_ID", length=35)
    public String getEmailId() {
        return this.emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    
    @Column(name="MOB_NUMBER", precision=12, scale=0)
    public Long getMobNumber() {
        return this.mobNumber;
    }
    
    public void setMobNumber(Long mobNumber) {
        this.mobNumber = mobNumber;
    }




}


