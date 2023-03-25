package eve.wajifeng.industry.data.invmetatypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "invmetatypes")
public class Invmetatypes {


    @Id
    @Column(name = "typeID")
    public int typeID;
    public int parentTypeID;
    public int metaGroupID;

    public Invmetatypes() {
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getParentTypeID() {
        return parentTypeID;
    }

    public void setParentTypeID(int parentTypeID) {
        this.parentTypeID = parentTypeID;
    }

    public int getMetaGroupID() {
        return metaGroupID;
    }

    public void setMetaGroupID(int metaGroupID) {
        this.metaGroupID = metaGroupID;
    }
}