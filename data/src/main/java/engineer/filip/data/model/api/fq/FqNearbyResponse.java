package engineer.filip.data.model.api.fq;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class FqNearbyResponse {

  @Expose
  @SerializedName("response")
  private Response response;

  @Data
  public class Response {

    @SerializedName("venues")
    List<Venue> venues;

  }

}
