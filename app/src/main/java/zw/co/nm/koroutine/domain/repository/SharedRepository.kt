package zw.co.nm.koroutine.domain.repository

import zw.co.nm.koroutine.models.GetCharacterByIdResponse
import zw.co.nm.koroutine.networking.NetworkLayer

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {

        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        return if (request.isSuccessful) {
            request.body()!!
        } else null
    }

}
