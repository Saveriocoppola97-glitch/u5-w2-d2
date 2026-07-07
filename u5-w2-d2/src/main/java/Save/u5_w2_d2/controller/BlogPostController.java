package Save.u5_w2_d2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Save.u5_w2_d2.model.BlogPost;
import Save.u5_w2_d2.service.BlogPostService;
import org.springframework.http.HttpStatus;
import Save.u5_w2_d2.payload.BlogPostPayload;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;


    @GetMapping
    public List<BlogPost> findAll() {
        return blogPostService.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost save(@RequestBody BlogPostPayload body) {
        return blogPostService.save(body);
    }


    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable UUID id) {
        return blogPostService.findById(id);
    }


    @PutMapping("/{id}")
    public BlogPost update(@PathVariable UUID id, @RequestBody BlogPostPayload body) {
        return blogPostService.update(id, body);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        blogPostService.delete(id);
    }
}