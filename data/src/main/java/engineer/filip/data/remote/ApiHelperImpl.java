package engineer.filip.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import engineer.filip.data.model.api.fq.FqNearbyRequest;
import engineer.filip.data.model.api.fq.FqNearbyResponse;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHelperImpl implements ApiHelper {

  @Inject
  public ApiHelperImpl() {
  }

  @Override
  public Single<FqNearbyResponse> getFqNearbyVenues(FqNearbyRequest request) {
    return Rx2AndroidNetworking.get(ApiEndpoints.ENDPOINT_FQ_NEARBY)
        .addPathParameter(request)
        .build()
        .getObjectSingle(FqNearbyResponse.class);
  }

}
