package jp.ac.fgrope.Money.model;
 
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Data
@Entity
@Table(name = "money")
public class MoneyBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
 
	@Column(length = 64, nullable = false)
	private String name;
 
	@Column(length = 16, nullable = false)
	private Integer number;
	
	@Column(nullable = false)
	private Date day;
	
	@Column(nullable = false)
	private String history;

	@Column(nullable = false)
	private String balance;
 
}

/*
 package jp.ac.ohara.address.model;
 

import java.sql.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jp.ac.ohara.address.define.ErrorMessage;
import lombok.Data;

@Data
@Entity
@Table(name="address_books")
@SQLDelete(sql = "UPDATE address_books SET delete_at = NOW() WHERE id=?")
@SQLRestriction(value = "deleted_at IS NULL")

public class AddressBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = ErrorMessage.NOT_NULL)
	private String lastName;
	
	@NotBlank(message = ErrorMessage.NOT_NULL)
	private String firstName;
	
	@NotBlank(message = ErrorMessage.NOT_NULL)
	@Email
	private String mailAddress;
	
	@NotBlank(message = ErrorMessage.NOT_NULL)
	@Size(min=10, max=13)
	@Pattern(regexp = "0//d{3}-?//d{4]", message = ErrorMessage.NOT_NULL)
	private String phoneNumber;
	
	@PastOrPresent(message = ErrorMessage.BIRTH_DATE)
	private String birthDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
}
*/