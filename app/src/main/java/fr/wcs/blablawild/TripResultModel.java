package fr.wcs.blablawild;
import java.util.Date;

public class TripResultModel {
    private String name;
    private Date dateDeparture;
    private int price;

    public TripResultModel(String prenom,Date dateDepart,int prix){
        this.name=prenom;
        this.dateDeparture=dateDepart;
        this.price=prix;
    }
    public String getName(){return name;}
    public Date getDateDeparture(){return dateDeparture;}
    public int getPrice(){return price;}
}
