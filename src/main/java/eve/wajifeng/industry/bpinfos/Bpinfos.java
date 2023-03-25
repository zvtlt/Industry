package eve.wajifeng.industry.bpinfos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bpinfos")
public class Bpinfos {

    @Id
    public Long id;
    public int typeID;
    public int materialID;
    public String typeName;
    public int quantity;
    public double volume;
    public String volumeString;
    public float basePrice;
    public String basePriceString;
    public float multPrice;
    public String multPriceString;
    public String iconFile;

    public Bpinfos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getMultPrice() {
        return multPrice;
    }

    public void setMultPrice(float multPrice) {
        this.multPrice = multPrice;
    }

    public String getIconFile() {
        return iconFile;
    }

    public void setIconFile(String iconFile) {
        this.iconFile = iconFile;
    }

    public String getMultPriceString() {
        return multPriceString;
    }

    public void setMultPriceString(String multPriceString) {
        this.multPriceString = multPriceString;
    }

    public String getBasePriceString() {
        return basePriceString;
    }

    public void setBasePriceString(String basePriceString) {
        this.basePriceString = basePriceString;
    }

    public String getVolumeString() {
        return volumeString;
    }

    public void setVolumeString(String volumeString) {
        this.volumeString = volumeString;
    }
}
