package eve.wajifeng.industry.data.industryblueprints;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "industryblueprints")
public class Industryblueprints {


    @Id
    @Column(name = "typeID")
    public int typeID;
    public int maxProductionLimit;

    public Industryblueprints() {
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getMaxProductionLimit() {
        return maxProductionLimit;
    }

    public void setMaxProductionLimit(int maxProductionLimit) {
        this.maxProductionLimit = maxProductionLimit;
    }
}