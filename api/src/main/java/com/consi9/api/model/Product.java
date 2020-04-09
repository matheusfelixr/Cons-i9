package com.consi9.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;

	@NotNull
	private Float costValue;

	@NotNull
	private Float saleValue;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registrationDate ;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate ;
	
	@NotNull
	private Boolean cancellation;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cancellationDate;

}
