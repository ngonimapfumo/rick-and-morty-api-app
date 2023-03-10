package zw.co.nm.koroutine.networking

import retrofit2.Response
import zw.co.nm.koroutine.models.GetCharacterByIdResponse

class APIClient(private val apiService: APIService) {
    suspend fun getCharacterById(characterId: Int): Response<GetCharacterByIdResponse> {
        return apiService.getCharacterById(characterId)
    }

}