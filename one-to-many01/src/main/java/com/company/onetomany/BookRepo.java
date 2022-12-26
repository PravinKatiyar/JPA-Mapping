package com.company.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    Book findByIsbn(String isbn);
    
    
   // @Query("SELECT new com.pravinkatiyar.onetoone.BookDTO(title, author) from books where id= ?1")
    
    @Query(value="Select * from books where id=?1",nativeQuery = true)
    Book findTitleAndAuthorById(Integer bookId);
}
