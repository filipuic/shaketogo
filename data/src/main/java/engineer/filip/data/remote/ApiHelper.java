package engineer.filip.data.remote;

import engineer.filip.data.model.api.fq.FqNearbyRequest;
import engineer.filip.data.model.api.fq.FqNearbyResponse;
import io.reactivex.Single;

public interface ApiHelper {

  Single<FqNearbyResponse> getFqNearbyVenues(FqNearbyRequest request);

}
