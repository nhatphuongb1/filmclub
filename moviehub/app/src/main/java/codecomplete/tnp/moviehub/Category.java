package codecomplete.tnp.moviehub;

import android.os.Bundle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nameVi")
    @Expose
    private String nameVi;


    @SerializedName("nameEng")
    @Expose
    private String nameEng;

    @SerializedName("icon")
    @Expose
    private String icon;
    public Category() {
        this.id = "";
        this.nameVi = "";
        this.nameEng = "";
        this.icon = "";
    }
    public Category(String id, String nameVi, String nameEng, String icon) {
        this.id = id;
        this.nameVi = nameVi;
        this.nameEng = nameEng;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("nameEng", nameEng);
        bundle.putString("nameVi", nameVi);
        bundle.putString("icon", icon);
        return bundle;
    }

    public void setCategoryFromBundle(Bundle bundle) {
        setNameEng(bundle.getString("nameEng"));
        setId(bundle.getString("id"));
        setNameVi(bundle.getString("nameVi"));
        setIcon(bundle.getString("icon"));
    }
}
