package com.bookms.bookms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookms.model.Book;


@Repository
public interface BookRepository extends JpaRepository <Book,String> {

}
