package eve.wajifeng.industry.data.invmetagroups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "invmetagroups")
public class Invmetagroups {


    @Id
    @Column(name = "metaGroupID")
    public int metaGroupID;
    public String metaGroupName;
    public String description;
    public int iconID;

    public Invmetagroups() {
    }

    public int getMetaGroupID() {
        return metaGroupID;
    }

    public void setMetaGroupID(int metaGroupID) {
        this.metaGroupID = metaGroupID;
    }

    public String getMetaGroupName() {
        return metaGroupName;
    }

    public void setMetaGroupName(String metaGroupName) {
        this.metaGroupName = metaGroupName;
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
}