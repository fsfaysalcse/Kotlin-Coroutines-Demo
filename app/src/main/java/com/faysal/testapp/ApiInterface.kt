package com.faysal.testapp

import com.faysal.testapp.models.Post
import com.faysal.testapp.models.Todo
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPosts () : Response<Post>

    @GET("todos")
    suspend fun getTodos () : Response<Todo>

}