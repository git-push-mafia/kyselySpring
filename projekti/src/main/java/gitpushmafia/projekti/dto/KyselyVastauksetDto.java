package gitpushmafia.projekti.dto;

import java.util.List;

public class KyselyVastauksetDto {
    private Long kyselyId;
    private List<VastausDto> vastaukset;

    public KyselyVastauksetDto() {}

    public Long getKyselyId() { return kyselyId; }
    public void setKyselyId(Long kyselyId) { this.kyselyId = kyselyId; }

    public List<VastausDto> getVastaukset() { return vastaukset; }
    public void setVastaukset(List<VastausDto> vastaukset) { this.vastaukset = vastaukset; }
}
