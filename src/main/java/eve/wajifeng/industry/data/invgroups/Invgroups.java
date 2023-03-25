package eve.wajifeng.industry.data.invgroups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invgroups")
public class Invgroups  {


    @Id
    @Column(name = "groupID")
    public int groupID;
    public int categoryID;
    public String groupName;
    public int iconID;
    public int useBasePrice;
    public int anchored;
    public int anchorable;
    public int fittableNonSingleton;
    public int published;

    public Invgroups() {
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public int getUseBasePrice() {
        return useBasePrice;
    }

    public void setUseBasePrice(int useBasePrice) {
        this.useBasePrice = useBasePrice;
    }

    public int getAnchored() {
        return anchored;
    }

    public void setAnchored(int anchored) {
        this.anchored = anchored;
    }

    public int getAnchorable() {
        return anchorable;
    }

    public void setAnchorable(int anchorable) {
        this.anchorable = anchorable;
    }

    public int getFittableNonSingleton() {
        return fittableNonSingleton;
    }

    public void setFittableNonSingleton(int fittableNonSingleton) {
        this.fittableNonSingleton = fittableNonSingleton;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }
}