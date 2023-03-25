package eve.wajifeng.industry.data.ramactivities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ramactivities")
public class Ramactivities {


    @Id
    @Column(name = "activityID")
    public int activityID;
    public String activityName;
    public String iconNo;
    public String description;
    public int published;

    public Ramactivities() {
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getIconNo() {
        return iconNo;
    }

    public void setIconNo(String iconNo) {
        this.iconNo = iconNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }
}