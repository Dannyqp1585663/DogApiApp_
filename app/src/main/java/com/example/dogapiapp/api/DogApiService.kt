package com.example.dogapiapp.api
import com.example.dogapiapp.model.DogApiResponse
import retrofit2.Response
import retrofit2.http.GET
interface DogApiService {
    @GET("api/breeds/image/random") //EndPoint
    suspend fun getRandomDogImage(): Response<DogApiResponse>
}