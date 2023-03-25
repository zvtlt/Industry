package eve.wajifeng.industry.data.invmarketgroups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "invmarketgroups")
public class Invmarketgroups {


    @Id
    @Column(name = "marketGroupID")
    public int marketGroupID;
    public int parentGroupID;
    public String marketGroupName;
    public String description;
    public int iconID;
    public int hasTypes;

    public Invmarketgroups() {
    }

    public int getMarketGroupID() {
        return marketGroupID;
    }

    public void setMarketGroupID(int marketGroupID) {
        this.marketGroupID = marketGroupID;
    }

    public int getParentGroupID() {
        return parentGroupID;
    }

    public void setParentGroupID(int parentGroupID) {
        this.parentGroupID = parentGroupID;
    }

    public String getMarketGroupName() {
        return marketGroupName;
    }

    public void setMarketGroupName(String marketGroupName) {
        this.marketGroupName = marketGroupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public int getHasTypes() {
        return hasTypes;
    }

    public void setHasTypes(int hasTypes) {
        this.hasTypes = hasTypes;
    }
}