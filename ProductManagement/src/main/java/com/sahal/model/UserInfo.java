package com.sahal.model;

import java.time.LocalDate;

import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long number; // Use a suitable data type for phone numbers
    private LocalDate installedDate;
    private String address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", number=" + number + ", installedDate=" + installedDate
				+ ", address=" + address + "]";
	}
	public LocalDate getInstalledDate() {
		return installedDate;
	}
	public void setInstalledDate(LocalDate installedDate) {
		this.installedDate = installedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}



