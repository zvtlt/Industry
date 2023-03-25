package eve.wajifeng.industry.data.skins;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "skins")
public class Skins {


    @Id
    @Column(name = "skinID")
    public int skinID;
    public String internalName;
    public int skinMaterialId;

    public Skins() {
    }

    public int getSkinID() {
        return skinID;
    }

    public void setSkinID(int skinID) {
        this.skinID = skinID;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public int getSkinMaterialId() {
        return skinMaterialId;
    }

    public void setSkinMaterialId(int skinMaterialId) {
        this.skinMaterialId = skinMaterialId;
    }
}
