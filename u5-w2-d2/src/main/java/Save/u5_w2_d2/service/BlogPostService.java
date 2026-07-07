package Save.u5_w2_d2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Save.u5_w2_d2.model.BlogPost;
import Save.u5_w2_d2.repository.BlogPostRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    // Metodo per salvare un post aggiungendo la logica della cover
    public BlogPost save(BlogPost body) {
        body.setCover("https://picsum.photos/200/300");
        return blogPostRepository.save(body);
    }

    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }


    public BlogPost findById(UUID id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post non trovato"));
    }

    public BlogPost update(UUID id, BlogPost body) {
        BlogPost found = this.findById(id);
        found.setTitolo(body.getTitolo());
        found.setContenuto(body.getContenuto());
        found.setCategoria(body.getCategoria());
        return blogPostRepository.save(found);
    }

    public void delete(UUID id) {
        BlogPost found = this.findById(id);
        blogPostRepository.delete(found);
    }
}
