package com.book.bookms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book {
	
	@Id
	private String isbn;
	
	@Column
	private String title;
	
	@Column
	private String publishedDate;
	
	@Column
	private String totalCopies;
	
	@Column
	private String issuedCopies;
	
	@Column
	private String author;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(String totalCopies) {
		this.totalCopies = totalCopies;
	}

	public String getIssuedCopies() {
		return issuedCopies;
	}

	public void setIssuedCopies(String issuedCopies) {
		this.issuedCopies = issuedCopies;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

}
