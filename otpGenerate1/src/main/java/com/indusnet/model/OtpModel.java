package com.indusnet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="otp")
public class OtpModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private String operationType;
	@Column(nullable=false)
	private String channel;
	@Column(nullable=false)
	private String startTime;
	@Column(nullable=false)
	private Integer duration;
	@Column(nullable=false)
	private Integer digit;
	@Column(unique = true ,nullable=false)
	private String mobile;
}
