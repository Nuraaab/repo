/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entityCheck;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author SWL
 */
public class Account implements Serializable{
    
	@SerializedName("id")
private int id;
	@SerializedName("account_number")
private int account_number;
	@SerializedName("balance")
private int balance;
	@SerializedName("p_status")
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
