package engineer.filip.data.model.api.fq;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Venue {

  @SerializedName("id")
  @Expose
  public String id;

  @SerializedName("name")
  @Expose
  public String name;

  @SerializedName("url")
  @Expose
  public String url;

  @SerializedName("rating")
  @Expose
  public float rating;

}
