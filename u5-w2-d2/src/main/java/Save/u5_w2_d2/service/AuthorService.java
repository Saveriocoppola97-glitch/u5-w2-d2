package Save.u5_w2_d2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Save.u5_w2_d2.model.Author;
import Save.u5_w2_d2.repository.AuthorRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author body) {
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        return authorRepository.save(body);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(UUID id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
    }

    public Author update(UUID id, Author body) {
        Author found = this.findById(id);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        // Rigeneriamo l'avatar se nome o cognome cambiano
        found.setAvatar("https://ui-avatars.com/api/?name=" + found.getNome() + "+" + found.getCognome());
        return authorRepository.save(found);
    }

    public void delete(UUID id) {
        Author found = this.findById(id);
        authorRepository.delete(found);
    }
}