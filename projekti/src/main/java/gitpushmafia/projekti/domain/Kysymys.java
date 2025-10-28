package gitpushmafia.projekti.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;

@Entity
public class Kysymys {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kysymysId;
    private String kysymys;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
    private List<Kysely> kysymykset;

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
    
}