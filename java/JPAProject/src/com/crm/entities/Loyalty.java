package com.crm.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Loyalties database table.
 * 
 */
@Entity
@Table(name="Loyalties")
public class Loyalty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="LoyaltyStatus")
	private Object loyaltyStatus;

	//bi-directional one-to-one association to User
	@OneToOne(mappedBy="loyalty")
	private User user;

    public Loyalty() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getLoyaltyStatus() {
		return this.loyaltyStatus;
	}

	public void setLoyaltyStatus(Object loyaltyStatus) {
		this.loyaltyStatus = loyaltyStatus;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}