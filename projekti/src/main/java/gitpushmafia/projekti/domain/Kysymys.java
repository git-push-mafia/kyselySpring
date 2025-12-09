package gitpushmafia.projekti.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Kysymys {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kysymysId;
    private String kysymys;
    private String vastaustyyppi;

    @ManyToOne
    @JoinColumn(name = "kyselyId")
    @JsonBackReference
    private Kysely kysely;

    @OneToMany(mappedBy = "kysymys", cascade = CascadeType.ALL)
    private List<Vastaus> vastaukset;

    @OneToMany(mappedBy = "kysymys", cascade = CascadeType.ALL)
    private List<Vaihtoehto> vaihtoehdot;

    public Kysymys() {

    }

    public Kysymys(String kysymys, Kysely kysely, String vastaustyyppi) {
        this.kysymys = kysymys;
        this.kysely = kysely;
        this.vastaustyyppi = vastaustyyppi;
    }

    public Long getKysymysId() {
        return kysymysId;
    }

    public void setKysymysId(Long kysymysId) {
        this.kysymysId = kysymysId;
    }

    public String getKysymys() {
        return kysymys;
    }

    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

    public Kysely getKysely() {
        return kysely;
    }

    public void setKysely(Kysely kysely) {
        this.kysely = kysely;
    }

    public String getVastaustyyppi() {
        return vastaustyyppi;
    }

    public void setVastaustyyppi(String vastaustyyppi) {
        this.vastaustyyppi = vastaustyyppi;
    }

    public List<Vaihtoehto> getVaihtoehdot() {
        return vaihtoehdot;
    }

    public void setVaihtoehdot(List<Vaihtoehto> vaihtoehdot) {
        this.vaihtoehdot = vaihtoehdot;
    }

    @Override
    public String toString() {
        return "Kysymys [kysymysId=" + kysymysId + ", kysymys=" + kysymys + "]";
    }

}