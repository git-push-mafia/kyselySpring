package gitpushmafia.projekti.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vastaus {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long vastausId;
  private String vastaus;

  @ManyToOne
  @JoinColumn(name = "kysymysId")
  private Kysymys kysymys;

  public Vastaus() {
  }

  public Vastaus(Long vastausId, String vastaus) {
    this.vastausId = vastausId;
    this.vastaus = vastaus;
  }

  public Long getVastausId() {
    return vastausId;
  }

  public void setVastausId(Long vastausId) {
    this.vastausId = vastausId;
  }

  public String getVastaus() {
    return vastaus;
  }

  public void setVastaus(String vastaus) {
    this.vastaus = vastaus;
  }

  public Kysymys getKysymys() {
    return kysymys;
  }

  public void setKysymys(Kysymys kysymys) {
    this.kysymys = kysymys;
  }

}
