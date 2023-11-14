package es.upm.miw.ipstack.service;

import es.upm.miw.ipstack.model.Ipstack;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IpstackRESTAPIService {
@GET("{ip}")
    Call<Ipstack> getIpstackIP(@Path("ip") String ip, @Query("access_key") String access_key);

}
