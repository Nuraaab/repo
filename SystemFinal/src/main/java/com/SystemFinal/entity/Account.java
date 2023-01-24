package com.SystemFinal.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="acco")
public class Account implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
private int id;
	@Column(name="account_number")
private int account_number;
	@Column(name= "balance")
private int balance;
	@Column(name="p_status")
private String p_status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAccount_number() {
	return account_number;
}
public void setAccount_number(int account_number) {
	this.account_number = account_number;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public String getP_status() {
	return p_status;
}
public void setP_status(String p_status) {
	this.p_status = p_status;
}


}
