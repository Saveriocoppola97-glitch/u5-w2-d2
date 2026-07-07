package Save.u5_w2_d2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Save.u5_w2_d2.model.Author;
import Save.u5_w2_d2.service.AuthorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @PostMapping
    public Author save(@RequestBody Author body) {
        return authorService.save(body);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable UUID id) {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable UUID id, @RequestBody Author body) {
        return authorService.update(id, body);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        authorService.delete(id);
    }
}