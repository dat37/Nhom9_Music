package vn.name.dat.nhom9_music.Service_API;

public class APIService {
    private static String base_url = "https://gaoranger1.000webhostapp.com/Server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}