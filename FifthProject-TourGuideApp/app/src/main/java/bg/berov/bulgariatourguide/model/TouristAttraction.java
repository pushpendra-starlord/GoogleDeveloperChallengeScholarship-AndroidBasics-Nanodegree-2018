package bg.berov.bulgariatourguide.model;

import android.os.Parcel;
import android.os.Parcelable;

import bg.berov.bulgariatourguide.MainActivity;

public class TouristAttraction implements Parcelable {

    private String label;
    private int imageResource;  //int for stored as drawable image
    private String description;
    private String city;
    private String category; //museum, bar, hotel, gallery...

    public TouristAttraction(String name, int imageResource, String description, String city, String category) {
        this.label = name;
        this.imageResource = imageResource;
        this.description = description;
        this.city = city;
        this.category = category;

        MainActivity.addTouristObject(this); //automatic adds new item in the static content list when the item is created
    }

    public String getLabel() {
        return label;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public String getCategory() {
        return category;
    }


    //Makes the object Parcelable. Auto-generated by a plugin
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeInt(this.imageResource);
        dest.writeString(this.description);
        dest.writeString(this.city);
        dest.writeString(this.category);
    }

    protected TouristAttraction(Parcel in) {
        this.label = in.readString();
        this.imageResource = in.readInt();
        this.description = in.readString();
        this.city = in.readString();
        this.category = in.readString();
    }

    public static final Parcelable.Creator<TouristAttraction> CREATOR = new Parcelable.Creator<TouristAttraction>() {
        @Override
        public TouristAttraction createFromParcel(Parcel source) {
            return new TouristAttraction(source);
        }

        @Override
        public TouristAttraction[] newArray(int size) {
            return new TouristAttraction[size];
        }
    };

}
