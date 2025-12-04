package gitpushmafia.projekti.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vaihtoehto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vaihtoehtoId;
    private String vaihtoehto;

    @ManyToOne
    @JoinColumn(name = "kysymysId")
    @JsonBackReference
    private Kysymys kysymys;

    public Vaihtoehto() {
    }

    public Vaihtoehto(String vaihtoehto) {
        this.vaihtoehto = vaihtoehto;
    }

    public Long getVaihtoehtoId() {
        return vaihtoehtoId;
    }

    public void setVaihtoehtoId(Long vaihtoehtoId) {
        this.vaihtoehtoId = vaihtoehtoId;
    }

    public String getVaihtoehto() {
        return vaihtoehto;
    }

    public void setVaihtoehto(String vaihtoehto) {
        this.vaihtoehto = vaihtoehto;
    }

    @Override
    public String toString() {
        return "Vaihtoehto [vaihtoehto=" + vaihtoehto + "]";
    }

    public void setKysymys(Kysymys kysymys) {
        this.kysymys = kysymys;
    }

}
