package Save.u5_w2_d2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "blog_posts")
public class BlogPost {

    @Id
    @GeneratedValue()
    private UUID id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    // Costruttore vuoto
    public BlogPost() {
    }

    // Costruttore
    public BlogPost(String categoria, String titolo, String cover, String contenuto, int tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }

    // Getter e Setter
    public UUID getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getCover() {
        return cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }
}
