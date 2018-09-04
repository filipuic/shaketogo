package engineer.filip.data.model.api.fq;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class FqNearbyRequest {

  @Expose
  @SerializedName("ll")
  String latLng;

  @Expose
  @SerializedName("categoryId")
  String categoryId;

  @Expose
  @SerializedName("oauth_token")
  String oauthToken;

  @Expose
  @SerializedName("v")
  String dateVersion;

}
