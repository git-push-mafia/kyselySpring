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


@Entity
public class Kysymys {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kysymysId;
    private String kysymys;

    @ManyToOne
    @JoinColumn(name = "kyselyId")
    private Kysely kysely;

    @OneToMany(mappedBy = "kysymys", cascade = CascadeType.ALL)
    private List<Vastaus> vastaukset;

    public Kysymys(){
        
    }

    public Kysymys(Long kysymysId, String kysymys) {
        this.kysymysId = kysymysId;
        this.kysymys = kysymys;
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

    @Override
    public String toString() {
        return "Kysymys [kysymysId=" + kysymysId + ", kysymys=" + kysymys + "]";
    }

    public void setKysely(Kysely kysely) {
        this.kysely = kysely;
    }
    
}