package com.vss.bookcatalog.data.repository;

import com.vss.bookcatalog.data.network.ApiController;
import com.vss.bookcatalog.data.network.BookResponse;

import retrofit2.Call;
import retrofit2.Callback;

public class BookRepository extends ApiController {

    public static void getBookList(Callback<BookResponse> callback) {

        Call<BookResponse> call = getRetrofit().getBookList();
        call.enqueue(callback);
    }
}
