package gitpushmafia.projekti.dto;

public class VastausDto {
    private Long kysymysId;
    private String vastaus;

    public VastausDto() {}

    public Long getKysymysId() { return kysymysId; }
    public void setKysymysId(Long kysymysId) { this.kysymysId = kysymysId; }

    public String getVastaus() { return vastaus; }
    public void setVastaus(String vastaus) { this.vastaus = vastaus; }
}

