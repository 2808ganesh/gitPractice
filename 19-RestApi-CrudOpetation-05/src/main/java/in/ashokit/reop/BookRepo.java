package in.ashokit.reop;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Book;
@Repository
public interface BookRepo extends JpaRepository<Book, Serializable> {

}
