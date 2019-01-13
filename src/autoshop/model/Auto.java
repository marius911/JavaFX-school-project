package autoshop.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Auto {
  private  StringProperty id_vehicul;
  private  StringProperty model;
  private  StringProperty an;
  private  StringProperty km;
  private  StringProperty combustibil;
  private  StringProperty transmisie;
  private  StringProperty pret;

  //constructor
  public Auto() {
    this.id_vehicul = new SimpleStringProperty();
    this.model = new SimpleStringProperty();
    this.an = new SimpleStringProperty();
    this.km = new SimpleStringProperty();
    this.combustibil = new SimpleStringProperty();
    this.transmisie = new SimpleStringProperty();
    this.pret = new SimpleStringProperty();
  }

  // getters
  public String getId_vehicul() {
    return id_vehicul.get();
  }

  public String getModel() {
    return model.get();
  }

  public String getAn() {
    return an.get();
  }

  public String getKm() {
    return km.get();
  }

  public String getCombustibil() {
    return combustibil.get();
  }

  public String getTransmisie() {
    return transmisie.get();
  }

  public String getPret() {
    return pret.get();
  }

  //setters
  public void setId_vehicul(String value) {
    id_vehicul.set(value);
  }

  public void setModel(String value) {
    model.set(value);
  }

  public void setAn(String value) {
    an.set(value);
  }

  public void setKm(String value) {
    km.set(value);
  }

  public void setCombustibil(String value) {
    combustibil.set(value);
  }

  public void setTransmisie(String value) {
    transmisie.set(value);
  }

  public void setPret(String value) {
    pret.set(value);
  }

  //Property value
  public StringProperty id_vehiculProperty() {
    return id_vehicul;
  }

  public StringProperty modelProperty() {
    return model;
  }

  public StringProperty anProperty() {
    return an;
  }

  public StringProperty kmProperty() {
    return km;
  }

  public StringProperty combustibilProperty() {
    return combustibil;
  }

  public StringProperty transmisieProperty() {
    return transmisie;
  }

  public StringProperty pretProperty() {
    return pret;
  }

}
