package com.vss.bookcatalog.data.network;

import com.google.gson.annotations.SerializedName;
import com.vss.bookcatalog.data.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {

    @SerializedName("success")
    public Boolean success;

    @SerializedName("count")
    public int count;

    @SerializedName("data")
    public List<Book> bookList = new ArrayList<>();
}
