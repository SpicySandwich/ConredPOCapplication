package com.product.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "review")
public class ProductReviews {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
	private Long reviewid;
	
	 @Size(min = 2, message = "Reviews must not empty")
	@Column(name = "reviews")
	private String reviews;
	
	 @Size(min = 2, message = "Comment must not empty")
	@Column(name = "comment")
	private String comment;
	
	@Email
	@Column(name = "email")
	private String email;

}
