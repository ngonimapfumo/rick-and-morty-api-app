package zw.co.nm.koroutine.networking

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import zw.co.nm.koroutine.models.GetCharacterByIdResponse

interface APIService {


    @GET("character/{character-id}")
    suspend fun getCharacterById(@Path("character-id") characterId: Int):Response<GetCharacterByIdResponse>
}