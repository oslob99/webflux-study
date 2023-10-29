package webflux.study.chapter3;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class SpringMvcBranchOfficeController {

    private Map<Long, Book> bookMap;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{book-id}")
    public ResponseEntity<Book> getBook(@PathVariable ("book-id") long bookId) throws InterruptedException {

        Thread.sleep(5000);

        Book book = bookMap.get(bookId);

        return ResponseEntity.ok(book);

    }

}
