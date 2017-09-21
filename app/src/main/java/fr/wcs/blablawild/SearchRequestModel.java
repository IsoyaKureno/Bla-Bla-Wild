package fr.wcs.blablawild;
import android.os.Parcel;
import android.os.Parcelable;

public class SearchRequestModel implements Parcelable{
    private String villeDepart;
    private String villeArrivee;
    private String dateTrajet;
    public SearchRequestModel(String d,String a,String t) {
        super();
        this.villeDepart = d;
        this.villeArrivee = a;
        this.dateTrajet = t;
    }

    public SearchRequestModel(Parcel in) {
        this.villeDepart = in.readString();
        this.villeArrivee = in.readString();
        this.dateTrajet = in.readString();
    }
    @Override public int describeContents() {return 0;}
    @Override public void writeToParcel(Parcel out, int flags) {
        out.writeString(villeDepart);
        out.writeString(villeArrivee);
        out.writeString(dateTrajet);
    }
    public static final Parcelable.Creator<SearchRequestModel>CREATOR
            = new Parcelable.Creator<SearchRequestModel>() {
        @Override public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }
        @Override public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };

    public String getVilleDepart() {return villeDepart;}
    public String getVilleArrivee() {return villeArrivee;}
    public String getDateTrajet() {return dateTrajet;}
    public static Parcelable.Creator<SearchRequestModel> getCreator(){return CREATOR;}
}
