package gitpushmafia.projekti.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.time.LocalDate;


@Entity
public class Kysely {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long kyselyId;
  private String nimi;
  private String kuvaus;
  private LocalDate aloituspvm;
  private LocalDate lopetuspvm;
  
  @OneToMany(mappedBy = "kysely", cascade = CascadeType.ALL)
  private List<Kysymys> kysymykset;


  public Kysely() {

  }

  public Long getKyselyId() {
    return kyselyId;
  }


  public void setKyselyId(Long kyselyId) {
    this.kyselyId = kyselyId;
  }


  public String getNimi() {
    return nimi;
  }


  public void setNimi(String nimi) {
    this.nimi = nimi;
  }


  public String getKuvaus() {
    return kuvaus;
  }


  public void setKuvaus(String kuvaus) {
    this.kuvaus = kuvaus;
  }


  public LocalDate getAloituspvm() {
    return aloituspvm;
  }


  public void setAloituspvm(LocalDate aloituspvm) {
    this.aloituspvm = aloituspvm;
  }


  public LocalDate getLopetuspvm() {
    return lopetuspvm;
  }


  public void setLopetuspvm(LocalDate lopetuspvm) {
    this.lopetuspvm = lopetuspvm;
  }


  public List<Kysymys> getKysymykset() {
    return kysymykset;
  }


  public void setKysymykset(List<Kysymys> kysymykset) {
    this.kysymykset = kysymykset;
  }

}
